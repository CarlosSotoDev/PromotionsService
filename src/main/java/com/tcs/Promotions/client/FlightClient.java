package com.tcs.Promotions.client;

import com.tcs.Promotions.dto.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fligthservice")
public interface FlightClient {

    @GetMapping("/api/v1/flights")
    List<FlightDTO> getAllFlights();

    @GetMapping("/api/v1/flights/{id}")
    FlightDTO getFlightById(@PathVariable("id") int id); // Método para obtener un vuelo por su ID
}