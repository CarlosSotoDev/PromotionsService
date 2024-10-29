package com.tcs.Promotions.controller;

import com.tcs.Promotions.dto.PromotionsDTO;
import com.tcs.Promotions.service.PromotionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/promotions")
public class PromotionsController {

    private final PromotionsService promotionsService;

    public PromotionsController(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @GetMapping
    public PromotionsDTO getPromotions() {
        return promotionsService.createPromotion();
    }


}
