package com.safaew.home_service.controller;

import com.safaew.home_service.dto.HomeRequest;
import com.safaew.home_service.dto.HomeResponse;
import com.safaew.home_service.entity.HomeEntity;
import com.safaew.home_service.repository.HomeRepository;
import com.safaew.home_service.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homes")
public class HomeController {

    @Autowired
    private HomeService homeservice;

    @PostMapping()
    public ResponseEntity<Void> createHome(@RequestBody HomeRequest homeRequest) {
        homeservice.createHome(homeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> updateHome(@PathVariable("id") String id, @RequestBody HomeRequest homeRequest) {
        homeservice.updateHome(id, homeRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping()
    public ResponseEntity<List<HomeResponse>> getAllHomes() {
        List<HomeResponse> homes = homeservice.getAllHomes();
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }


    @GetMapping("/{homeId}")
    public ResponseEntity<HomeResponse> getHome(@PathVariable("homeId") String homeId) {
        HomeResponse home = homeservice.getHome(homeId);
        return new ResponseEntity<>(home, HttpStatus.OK);
    }


}
