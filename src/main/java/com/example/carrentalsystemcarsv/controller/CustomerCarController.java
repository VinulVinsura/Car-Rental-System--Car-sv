package com.example.carrentalsystemcarsv.controller;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.service.CustomerService.CustomerCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/car/customer")
public class CustomerCarController {

    @Autowired
    private CustomerCarService carService;

    @GetMapping("/get-car")
    List<CarDto> getAllCars(){

        return carService.getAllCars();
    }
}
