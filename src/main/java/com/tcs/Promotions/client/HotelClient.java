package com.tcs.Promotions.client;

import com.tcs.Promotions.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotelservice")
public interface HotelClient {

    @GetMapping("/api/v1/hotels")
    List<HotelDTO> getAllHotels();

    @GetMapping("/api/v1/hotels/{id}")
    HotelDTO getHotelById(@PathVariable("id") int id); // Método para obtener un hotel por su ID
}