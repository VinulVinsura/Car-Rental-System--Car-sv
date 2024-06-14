package com.example.carrentalsystemcarsv.service.CustomerService.Impl;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;
import com.example.carrentalsystemcarsv.repository.CarRepo;
import com.example.carrentalsystemcarsv.service.CustomerService.CustomerCarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCarServiceImpl implements CustomerCarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CarDto> getAllCars() {
        List<CarEntity> carEntityList = carRepo.findAll();
        return modelMapper.map(carEntityList,new TypeToken<List<CarDto>>(){}.getType());

    }
}
