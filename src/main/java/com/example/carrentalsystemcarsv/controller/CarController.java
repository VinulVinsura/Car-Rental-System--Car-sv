package com.example.carrentalsystemcarsv.controller;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RestController
@RequestMapping("/api/car")
@CrossOrigin

public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add-car")
    public CarDto addCar(@ModelAttribute CarDto carDto) throws IOException {
        System.out.println("1");
        System.out.println(carDto);
        return carService.addCar(carDto);
    }
}
