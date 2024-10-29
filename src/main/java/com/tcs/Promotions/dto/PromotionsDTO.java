package com.tcs.Promotions.dto;

import lombok.Data;

import java.util.List;

@Data
public class PromotionsDTO {
    private List<HotelDTO> hotels;
    private List<FlightDTO> flights;

    public PromotionsDTO(List<HotelDTO> hotels, List<FlightDTO> flights) {
        this.hotels = hotels;
        this.flights = flights;
    }

}
