package com.tcs.Promotions.controller;

import com.tcs.Promotions.dto.FlightDTO;
import com.tcs.Promotions.dto.PromotionsDTO;
import com.tcs.Promotions.service.PromotionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionsController {

    private final PromotionsService promotionsService;

    public PromotionsController(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    // Endpoint para obtener todos los vuelos filtrados por ciudad
    @GetMapping("/flights/{city}")
    public List<FlightDTO> getFlightsByCity(@PathVariable String city) {
        return promotionsService.getFlightsByCity(city);
    }

    // Endpoint para obtener destinos únicos de vuelos
    @GetMapping("/flights/destinations")
    public List<String> getUniqueDestinations() {
        return promotionsService.getUniqueDestinations();
    }

    // Endpoint para crear una nueva promoción con hotel y vuelo seleccionados
    @PostMapping("/create")
    public PromotionsDTO createPromotion(@RequestParam int hotelId, @RequestParam int flightId) {
        return promotionsService.createPromotionWithHotelAndFlight(hotelId, flightId);
    }

    // Endpoint para listar todas las promociones existentes
    @GetMapping("/list")
    public List<PromotionsDTO> listPromotions() {
        return promotionsService.getAllPromotions();
    }
}
