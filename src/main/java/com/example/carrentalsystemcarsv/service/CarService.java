package com.example.carrentalsystemcarsv.service;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;

import java.io.IOException;

public interface CarService  {

    CarDto addCar(CarDto carDto) throws IOException;
}
