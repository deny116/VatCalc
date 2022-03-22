package com.example.vatcalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VatController {

    private final VatCalculatorService vatCalculatorService;

    public VatController(VatCalculatorService vatCalculatorService) {
        this.vatCalculatorService = vatCalculatorService;
    }

    @PostMapping("/calculate")
    String calculate(double nettoPrice, String category, Model model){
        double vat = vatCalculatorService.calculateVat(nettoPrice, category);
        double bruttoPrice = vatCalculatorService.calculateBruttoPrice(nettoPrice, category);
        model.addAttribute("nettoPrice", nettoPrice);
        model.addAttribute("bruttoPrice", bruttoPrice);
        model.addAttribute("vat", vat);
        return "result";
    }
}
