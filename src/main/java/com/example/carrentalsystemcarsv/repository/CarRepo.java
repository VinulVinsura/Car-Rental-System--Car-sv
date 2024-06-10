package com.example.carrentalsystemcarsv.repository;

import com.example.carrentalsystemcarsv.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CarRepo extends JpaRepository<CarEntity,Integer> {
}
