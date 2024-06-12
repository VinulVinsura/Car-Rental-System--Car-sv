package com.example.carrentalsystemcarsv.controller;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add-car")
    public CarDto addCar(@RequestParam("brand") String brand, @RequestParam("name") String name,
                         @RequestParam("type") String type,
                         @RequestParam("transmission") String transmission,
                         @RequestParam("color") String color,
                         @RequestParam("year") String  year,
                         @RequestParam("description") String description,
                         @RequestParam("price") Integer price,
                         @RequestParam("image") MultipartFile file) throws IOException {

        CarDto carDto=new CarDto();
        carDto.setBrand(brand);
        carDto.setName(name);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setColor(color);
        carDto.setYear(year);
        carDto.setDescription(description);
        carDto.setPrice(price);
        carDto.setImage(file);
        return carService.addCar(carDto);


    }

    @GetMapping("/get-all-cars")
    public List<CarDto> getAllCar(){
        return carService.getAllCar();
    }

    @DeleteMapping("/delete-car/{id}")
    public String deleteCarById(@PathVariable Integer id){
        if (carService.deleteCar(id)){
            return "Car Deleted !";
        }
        return "Car Not Deleted !";
    }


    @GetMapping("/get-carById/{id}")
    public CarDto getCarById(@PathVariable Integer id){
        CarDto carDto = carService.getCarById(id);
        if (carDto !=null){
            return carDto;
        }
        return null;
    }
}
