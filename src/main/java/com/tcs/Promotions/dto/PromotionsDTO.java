package com.tcs.Promotions.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PromotionsDTO {
    private HotelDTO hotel;
    private FlightDTO flight;
    private BigDecimal totalPrice3Nights;
    private BigDecimal totalPrice5Nights;

    public PromotionsDTO(HotelDTO hotel, FlightDTO flight, BigDecimal totalPrice3Nights, BigDecimal totalPrice5Nights) {
        this.hotel = hotel;
        this.flight = flight;
        this.totalPrice3Nights = totalPrice3Nights;
        this.totalPrice5Nights = totalPrice5Nights;
    }

}
