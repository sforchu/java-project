package com.safaew.home_service.repository;

import com.safaew.home_service.entity.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeRepository extends JpaRepository<HomeEntity, String> {

    //Optional<HomeEntity> findAllById (String homeId);
}
