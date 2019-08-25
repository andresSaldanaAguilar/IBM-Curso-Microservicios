package com.microservice.training.countriesdemo.service.api;

import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;

import java.util.List;

public interface ICountriesService {

  List<CountryEntity> findCountriesByContinentName(String continentName);
  
  List<Country> findCountriesByContinentId(Integer continentId);
  
  CountryEntity saveCountry(CountryEntity country);
  
  String deleteCountry(String name);
 
  CountryEntity findCountryByCountryId(Integer countryId);
}
