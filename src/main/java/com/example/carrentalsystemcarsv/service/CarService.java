package com.example.carrentalsystemcarsv.service;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;

import java.io.IOException;
import java.util.List;

public interface CarService  {

    CarDto addCar(CarDto carDto) throws IOException;
    List<CarDto> getAllCar();
    Boolean deleteCar(Integer id);
    CarDto getCarById(Integer id);
    CarDto updateCar(CarDto carDto);
}
