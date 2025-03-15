package com.safaew.home_service.service;


import com.safaew.home_service.dto.AccountDTO;
import com.safaew.home_service.dto.HomeRequest;
import com.safaew.home_service.dto.HomeResponse;
import com.safaew.home_service.entity.HomeEntity;
import com.safaew.home_service.exception.ResourceNotFoundException;
import com.safaew.home_service.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    @Value("${app.service.account-service}")
    private String accountServiceUrl;

    @Autowired
    // here we Autowire the HomeRepository cuz it manages the HomeEntity, that way we can easily
    // createHome for example making use of the HomeEntity.
    private HomeRepository homeRepository;

    //the RestTemplate allows us to make service to service call
    @Autowired
    private RestTemplate restTemplate;

    public void createHome(HomeRequest request) {

        HomeEntity homeEntity = new HomeEntity();

        updateHomeEntity(request, homeEntity);

        homeRepository.save(homeEntity);

    }

    public void updateHome(String id, HomeRequest request) {
        Optional<HomeEntity> homeEntityOptional = homeRepository.findById(id);
        if (homeEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Home not found");

        }
        HomeEntity homeEntity = homeEntityOptional.get();
        updateHomeEntity(request, homeEntity);

        homeRepository.save(homeEntity);

    }

    public List<HomeResponse> getAllHomes(){

        ArrayList<HomeResponse> response = new ArrayList<>();
        List<HomeEntity>homes = homeRepository.findAll();
        for (HomeEntity home: homes) {
            HomeResponse homeResponse = getHomeResponse(home);

            response.add(homeResponse);
        }

        return response;
    }


    public HomeResponse getHome (String homeId) {
        Optional<HomeEntity> homeEntityOptional = homeRepository.findById(homeId);
        if(homeEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("home not found");
        }
        HomeEntity homeEntity = homeEntityOptional.get();
//        HomeResponse homeResponse = getHomeResponse(homeEntity);

        return getHomeResponse(homeEntity);

    }

    private HomeResponse getHomeResponse(HomeEntity home) {
        HomeResponse homeResponse = new HomeResponse();

        homeResponse.setId(home.getId());
        homeResponse.setAddress(home.getStreet() + ", " + home.getCity() + ", " + home.getState() + ", " + home.getZipCode() + ", " + home.getCountry());
        homeResponse.setInterestRate(home.getInterestRate());
        homeResponse.setTotalPrice(home.getTotalPrice());
        homeResponse.setMortgageAmount(home.getMortgageAmount());
        homeResponse.setLoanDuration(home.getLoanDuration());

        AccountDTO accountDTO = callAccountService(home.getAccountId());
        homeResponse.setAccount(accountDTO);
        return homeResponse;
    }


    private static void updateHomeEntity(HomeRequest request, HomeEntity homeEntity) {

        homeEntity.setStreet(request.getStreet());
        homeEntity.setCity(request.getCity());
        homeEntity.setZipCode(request.getZipCode());
        homeEntity.setState(request.getState());
        homeEntity.setCountry(request.getCountry());
        homeEntity.setInterestRate(request.getInterestRate());
        homeEntity.setTotalPrice(request.getTotalPrice());
        homeEntity.setMortgageAmount(request.getMortgageAmount());
        homeEntity.setLoanDuration(request.getLoanDuration());
        homeEntity.setAccountId(request.getAccountId());
    }


    private AccountDTO callAccountService(String accountId) {

        ResponseEntity<AccountDTO> account = restTemplate.getForEntity(accountServiceUrl +"/"+accountId, AccountDTO.class);

        return account.getBody();
    }

}
