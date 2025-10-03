package com.bytex.customercaresystem.controller;

import com.bytex.customercaresystem.model.PurchaseOrder;
import com.bytex.customercaresystem.model.Supplier;
import com.bytex.customercaresystem.model.User;
import com.bytex.customercaresystem.service.PurchaseOrderService;
import com.bytex.customercaresystem.service.SupplierService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.bytex.customercaresystem.model.Part;
import com.bytex.customercaresystem.model.SupplierPart;

@Controller
@RequestMapping("/warehousemanager")
public class WarehouseManagerController {

    private final PurchaseOrderService purchaseOrderService;
    private final SupplierService supplierService;
    private final com.bytex.customercaresystem.service.StockRequestService stockRequestService;
    private final com.bytex.customercaresystem.service.PartService partService;
    private final com.bytex.customercaresystem.repository.SupplierPartRepository supplierPartRepository;


    @Autowired
    public WarehouseManagerController(PurchaseOrderService purchaseOrderService, SupplierService supplierService, com.bytex.customercaresystem.service.StockRequestService stockRequestService, com.bytex.customercaresystem.service.PartService partService, com.bytex.customercaresystem.repository.SupplierPartRepository supplierPartRepository) {
        this.purchaseOrderService = purchaseOrderService;
        this.supplierService = supplierService;
        this.stockRequestService = stockRequestService;
        this.partService = partService;
        this.supplierPartRepository = supplierPartRepository;
    }

    private boolean isNotWarehouseManager(HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"WAREHOUSE_MANAGER".equals(user.getRole().getRoleName())) {
            redirectAttributes.addFlashAttribute("error", "Access Denied");
            return true;
        }
        return false;
    }

    @GetMapping("/dashboard")
    public String warehouseDashboard(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        model.addAttribute("purchaseOrders", purchaseOrderService.getAllPurchaseOrders());
        model.addAttribute("stockRequests", stockRequestService.getAllStockRequests().stream()
                .filter(sr -> sr.getStatus() == com.bytex.customercaresystem.model.StockRequest.StockRequestStatus.PENDING)
                .collect(java.util.stream.Collectors.toList()));
        return "warehousemanager/dashboard";
    }

    @PostMapping("/stock-requests/{id}/fulfill")
    public String fulfillStockRequest(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        try {
            stockRequestService.fulfillStockRequest(id);
            redirectAttributes.addFlashAttribute("success", "Stock request fulfilled successfully.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Could not fulfill request: " + e.getMessage());
        }
        return "redirect:/warehousemanager/dashboard";
    }

    @GetMapping("/purchase-orders/new")
    public String showCreateOrderForm(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        model.addAttribute("purchaseOrder", new PurchaseOrder());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "warehousemanager/purchaseorder_form";
    }

    @PostMapping("/purchase-orders/save")
    public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, HttpSession session, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        User user = (User) session.getAttribute("user");
        purchaseOrder.setCreatedBy(user);

        if (purchaseOrder.getOrderId() == null) {
            purchaseOrderService.createPurchaseOrder(purchaseOrder);
            redirectAttributes.addFlashAttribute("success", "Purchase order created successfully.");
        } else {
            purchaseOrderService.updatePurchaseOrder(purchaseOrder.getOrderId(), purchaseOrder);
            redirectAttributes.addFlashAttribute("success", "Purchase order updated successfully.");
        }
        return "redirect:/warehousemanager/dashboard";
    }

    @GetMapping("/suppliers")
    public String viewSuppliers(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "warehousemanager/suppliers";
    }

    @GetMapping("/suppliers/new")
    public String showAddSupplierForm(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        model.addAttribute("supplier", new Supplier());
        model.addAttribute("allParts", partService.getAllParts());
        return "warehousemanager/supplier_form";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String showEditSupplierForm(@PathVariable Long id, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        Supplier supplier = supplierService.getSupplierById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        List<Long> suppliedPartIds = supplier.getSuppliedParts().stream()
                .map(sp -> sp.getPart().getPartId())
                .collect(java.util.stream.Collectors.toList());

        model.addAttribute("supplier", supplier);
        model.addAttribute("allParts", partService.getAllParts());
        model.addAttribute("suppliedPartIds", suppliedPartIds);
        return "warehousemanager/supplier_form";
    }

    @PostMapping("/suppliers/save")
    public String saveSupplier(@ModelAttribute Supplier supplier, @RequestParam(required = false) List<Long> partIds, HttpSession session, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        Supplier savedSupplier;
        if (supplier.getSupplierId() == null) {
            savedSupplier = supplierService.createSupplier(supplier);
            redirectAttributes.addFlashAttribute("success", "Supplier added successfully.");
        } else {
            savedSupplier = supplierService.updateSupplier(supplier.getSupplierId(), supplier);
            redirectAttributes.addFlashAttribute("success", "Supplier updated successfully.");
        }

        // Clear existing parts and add new ones
        supplierPartRepository.deleteAll(supplierPartRepository.findBySupplier(savedSupplier));
        if (partIds != null) {
            for (Long partId : partIds) {
                Part part = partService.getPartById(partId).orElseThrow(() -> new RuntimeException("Part not found"));
                supplierPartRepository.save(new SupplierPart(savedSupplier, part));
            }
        }

        return "redirect:/warehousemanager/suppliers";
    }

    @PostMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        if (isNotWarehouseManager(session, redirectAttributes)) return "redirect:/login";

        try {
            supplierService.deleteSupplier(id);
            redirectAttributes.addFlashAttribute("success", "Supplier deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Could not delete supplier. It might be associated with existing purchase orders.");
        }
        return "redirect:/warehousemanager/suppliers";
    }

    @GetMapping("/api/suppliers/{id}/parts")
    @ResponseBody
    public java.util.List<com.bytex.customercaresystem.model.Part> getPartsBySupplier(@PathVariable Long id) {
        return supplierService.findPartsBySupplier(id);
    }
}