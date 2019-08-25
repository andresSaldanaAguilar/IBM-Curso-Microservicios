package com.microservice.training.countriesdemo.controller;

import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountriesController {

  @Autowired
  ICountriesService countriesService;

  @GetMapping(path = "/api/countries/continent/name/{continentName}")
  public ResponseEntity<List<CountryEntity>> findCountryByContinent(@PathVariable String continentName) {
    return new ResponseEntity<List<CountryEntity>>(
        countriesService.findCountriesByContinentName(continentName), HttpStatus.OK);
  }
  
  @GetMapping(path = "/api/countries/continent/id/{continentId}")
  public ResponseEntity<List<Country>> findCountryByContinent(@PathVariable Integer continentId) {
    return new ResponseEntity<List<Country>>(
        countriesService.findCountriesByContinentId(continentId), HttpStatus.OK);
  }
  
  @PostMapping(path = "/api/countries")
  public ResponseEntity<CountryEntity> saveCountry(@RequestBody CountryEntity country) {
	  return new ResponseEntity<CountryEntity>(
			  countriesService.saveCountry(country), HttpStatus.OK);
  }
  
  @DeleteMapping(path = "/api/countries/{countryName}")
  public ResponseEntity<String> deleteCountry(@PathVariable String countryName) {
    return new ResponseEntity<String>(
        countriesService.deleteCountry(countryName), HttpStatus.OK);
  }
  
  @PutMapping(path = "/api/countries")
  public ResponseEntity<CountryEntity> updateCountry(@RequestBody CountryEntity country) {
	  return new ResponseEntity<CountryEntity>(
			  countriesService.saveCountry(country), HttpStatus.OK);
  }
  
  @GetMapping(path = "/api/countries/id/{countryId}")
  public ResponseEntity<CountryEntity> findCountryByCountryId(@PathVariable Integer countryId) {
    return new ResponseEntity<CountryEntity>(
        countriesService.findCountryByCountryId(countryId), HttpStatus.OK);
  }
  
	  
}
