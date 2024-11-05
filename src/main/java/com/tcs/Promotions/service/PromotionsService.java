package com.tcs.Promotions.service;

import com.tcs.Promotions.client.FlightClient;
import com.tcs.Promotions.client.HotelClient;
import com.tcs.Promotions.dto.FlightDTO;
import com.tcs.Promotions.dto.HotelDTO;
import com.tcs.Promotions.dto.PromotionsDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionsService {
    private final HotelClient hotelClient;
    private final FlightClient flightClient;

    private final List<PromotionsDTO> promotions = new ArrayList<>();

    public PromotionsService(HotelClient hotelClient, FlightClient flightClient) {
        this.hotelClient = hotelClient;
        this.flightClient = flightClient;
    }

    // Método para obtener vuelos filtrados por ciudad
    public List<FlightDTO> getFlightsByCity(String city) {
        List<FlightDTO> allFlights = flightClient.getAllFlights();
        return allFlights.stream()
                .filter(flight -> flight.getDestination().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // Método para obtener destinos únicos
    public List<String> getUniqueDestinations() {
        List<FlightDTO> allFlights = flightClient.getAllFlights();
        return allFlights.stream()
                .map(FlightDTO::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    // Método para crear una promoción con hotel y vuelo seleccionados
    public PromotionsDTO createPromotionWithHotelAndFlight(int hotelId, int flightId) {
        HotelDTO hotel = hotelClient.getHotelById(hotelId);
        FlightDTO flight = flightClient.getFlightById(flightId);

        if (!hotel.getCity().equalsIgnoreCase(flight.getDestination())) {
            throw new IllegalArgumentException("El hotel y el vuelo deben estar en la misma ciudad.");
        }

        BigDecimal priceFor3Nights = hotel.getPricePerNight().multiply(BigDecimal.valueOf(3));
        BigDecimal priceFor5Nights = hotel.getPricePerNight().multiply(BigDecimal.valueOf(5));

        BigDecimal totalPrice3Nights = (priceFor3Nights.add(flight.getPrice())).multiply(BigDecimal.valueOf(0.8));
        BigDecimal totalPrice5Nights = (priceFor5Nights.add(flight.getPrice())).multiply(BigDecimal.valueOf(0.8));

        PromotionsDTO promotion = new PromotionsDTO(hotel, flight, totalPrice3Nights, totalPrice5Nights);
        promotions.add(promotion);
        return promotion;
    }

    // Método para listar todas las promociones creadas
    public List<PromotionsDTO> getAllPromotions() {
        return new ArrayList<>(promotions);
    }
}
