package com.bytex.customercaresystem.service;

import com.bytex.customercaresystem.model.OrderItem;
import com.bytex.customercaresystem.model.Part;
import com.bytex.customercaresystem.model.PurchaseOrder;
import com.bytex.customercaresystem.repository.PartRepository;
import com.bytex.customercaresystem.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PartRepository partRepository;
    private final com.bytex.customercaresystem.repository.WarehouseStockRepository warehouseStockRepository;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, PartRepository partRepository, com.bytex.customercaresystem.repository.WarehouseStockRepository warehouseStockRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.partRepository = partRepository;
        this.warehouseStockRepository = warehouseStockRepository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrder.setOrderDate(LocalDateTime.now());
        purchaseOrder.setStatus(PurchaseOrder.OrderStatus.PENDING);

        // Set the purchase order on each item and calculate total
        BigDecimal totalAmount = BigDecimal.ZERO;
        if (purchaseOrder.getOrderItems() != null) {
            for (OrderItem item : purchaseOrder.getOrderItems()) {
                item.setPurchaseOrder(purchaseOrder);
                BigDecimal itemTotal = item.getUnitPrice().multiply(new BigDecimal(item.getQuantity()));
                totalAmount = totalAmount.add(itemTotal);
            }
        }
        purchaseOrder.setTotalAmount(totalAmount);

        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public Optional<PurchaseOrder> getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrderDetails) {
        PurchaseOrder existingOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found with id: " + id));

        existingOrder.setSupplier(purchaseOrderDetails.getSupplier());
        existingOrder.setExpectedDelivery(purchaseOrderDetails.getExpectedDelivery());

        // Handle stock update on delivery
        if (purchaseOrderDetails.getStatus() == PurchaseOrder.OrderStatus.DELIVERED &&
            existingOrder.getStatus() != PurchaseOrder.OrderStatus.DELIVERED) {

            existingOrder.setActualDelivery(LocalDateTime.now());

            for (OrderItem item : existingOrder.getOrderItems()) {
                com.bytex.customercaresystem.model.WarehouseStock stock = warehouseStockRepository.findById(item.getPart().getPartId())
                        .orElse(new com.bytex.customercaresystem.model.WarehouseStock(item.getPart(), 0));
                stock.setQuantity(stock.getQuantity() + item.getQuantity());
                warehouseStockRepository.save(stock);
            }
        }
        existingOrder.setStatus(purchaseOrderDetails.getStatus());

        return purchaseOrderRepository.save(existingOrder);
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        if (!purchaseOrderRepository.existsById(id)) {
            throw new RuntimeException("Purchase Order not found with id: " + id);
        }
        purchaseOrderRepository.deleteById(id);
    }
}