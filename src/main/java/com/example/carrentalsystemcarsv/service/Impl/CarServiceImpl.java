package com.example.carrentalsystemcarsv.service.Impl;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;
import com.example.carrentalsystemcarsv.repository.CarRepo;
import com.example.carrentalsystemcarsv.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarDto addCar(CarDto carDto) throws IOException {
        CarEntity carEntity=new CarEntity();
        carEntity.setBrand(carDto.getBrand());
        carEntity.setName(carDto.getName());
        carEntity.setColor(carDto.getColor());
        carEntity.setDescription(carDto.getDescription());
        carEntity.setPrice(carDto.getPrice());
        carEntity.setYear(carDto.getYear());
        carEntity.setType(carDto.getType());
        carEntity.setTransmission(carDto.getTransmission());
        if (carDto.getImage()!=null){
            carEntity.setImage(carDto.getImage().getBytes());
        }
        CarEntity saveEntity = carRepo.save(carEntity);
        if (saveEntity !=null){
            return  modelMapper.map(saveEntity, CarDto.class);
        }
        return null;

    }
}
