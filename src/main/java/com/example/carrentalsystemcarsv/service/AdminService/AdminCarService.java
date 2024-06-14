package com.example.carrentalsystemcarsv.service.AdminService;

import com.example.carrentalsystemcarsv.dto.CarDto;

import java.io.IOException;
import java.util.List;

public interface AdminCarService {

    CarDto addCar(CarDto carDto) throws IOException;
    List<CarDto> getAllCar();
    Boolean deleteCar(Integer id);
    CarDto getCarById(Integer id);
    CarDto updateCar(CarDto carDto);
    List<CarDto> getCarBy(String brand, String type, String color, String transmission);
}
