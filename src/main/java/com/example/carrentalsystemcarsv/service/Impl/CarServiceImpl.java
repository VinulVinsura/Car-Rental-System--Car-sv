package com.example.carrentalsystemcarsv.service.Impl;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;
import com.example.carrentalsystemcarsv.repository.CarRepo;
import com.example.carrentalsystemcarsv.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
        String fileName=StringUtils.cleanPath(carDto.getImage().getOriginalFilename());
        if (carDto.getImage()!=null){
            carEntity.setImage(fileName);
        }
        CarEntity car = carRepo.save(carEntity);
//Creat a folder path for save Image
        String uploadDir="./car-img/"+car.getId();
        Path uploadPath=Paths.get(uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
       try ( InputStream inputStream=carDto.getImage().getInputStream()) {
           Path filePath=uploadPath.resolve(fileName);
           Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
       }catch (IOException e){
           throw new IOException("Could not save upload File" +fileName);
       }


        return modelMapper.map(car, CarDto.class);

    }
}
