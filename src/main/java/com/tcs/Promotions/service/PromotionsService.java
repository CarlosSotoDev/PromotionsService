package com.tcs.Promotions.service;

import com.tcs.Promotions.client.FlightClient;
import com.tcs.Promotions.client.HotelClient;
import com.tcs.Promotions.dto.FlightDTO;
import com.tcs.Promotions.dto.HotelDTO;
import com.tcs.Promotions.dto.PromotionsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionsService {
    private final HotelClient hotelClient;
    private final FlightClient flightClient;

    public PromotionsService(HotelClient hotelClient, FlightClient flightClient) {
        this.hotelClient = hotelClient;
        this.flightClient = flightClient;
    }


    //Methods
    public PromotionsDTO createPromotion(){
        List<HotelDTO> hotels = hotelClient.getAllHotels();

        List<FlightDTO> flights = flightClient.getAllFlights();

        return new PromotionsDTO(hotels, flights);
    }


}
