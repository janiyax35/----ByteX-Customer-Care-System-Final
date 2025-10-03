package com.bytex.customercaresystem.controller;

import com.bytex.customercaresystem.model.User;
import com.bytex.customercaresystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        Optional<User> userOptional = userService.loginUser(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            session.setAttribute("user", user);
            String role = user.getRole().getRoleName();
            switch (role) {
                case "ADMIN":
                    return "redirect:/admin/dashboard";
                case "STAFF":
                    return "redirect:/staff/dashboard";
                case "TECHNICIAN":
                    return "redirect:/technician/dashboard";
                case "PRODUCT_MANAGER":
                    return "redirect:/productmanager/dashboard";
                case "WAREHOUSE_MANAGER":
                    return "redirect:/warehousemanager/dashboard";
                case "CUSTOMER":
                    return "redirect:/customer/dashboard";
                default:
                    return "redirect:/login?error=Invalid Role";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("success", "Registration successful! Please log in.");
            return "redirect:/login";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", sessionUser);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("user") User user, HttpSession session, RedirectAttributes redirectAttributes) {
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/login";
        }
        try {
            User updatedUser = userService.updateUser(sessionUser.getUserId(), user);
            session.setAttribute("user", updatedUser); // Update session user
            redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/profile";
    }
}