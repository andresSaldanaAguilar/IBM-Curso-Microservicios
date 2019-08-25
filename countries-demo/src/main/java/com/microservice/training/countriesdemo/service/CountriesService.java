package com.microservice.training.countriesdemo.service;

import com.microservice.training.countriesdemo.errorhandling.InvalidContinentException;
import com.microservice.training.countriesdemo.model.Continent;
import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.repository.api.CountryJpaRepository;
import com.microservice.training.countriesdemo.repository.api.ICountriesRepository;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountriesService implements ICountriesService {

  @Autowired
  ICountriesRepository countriesRepository;
  
  @Autowired
  CountryJpaRepository countriesjpaRepository;
  
  public List<CountryEntity> findCountriesByContinentName(String continentName) {
	  return countriesjpaRepository.findByContinent(continentName);
  }
  
  public List<Country> findCountriesByContinentId(Integer continentId) {
    Continent continent = Continent.continentById(continentId);
    switch (continent) {
      case EUROPE:
        return countriesRepository.findAllEuropeCountries();
      case ASIA:
        return countriesRepository.findAllAsiaCountries();
      case AFRICA:
        return countriesRepository.findAllAfricaCountries();
      case NORTH_AMERICA:
        return countriesRepository.findAllNorthAmericaCountries();
      default:
        throw new InvalidContinentException("Continent id: " + continentId + " does not exist.");
    }
  }
  
  //Tambien es capaz de hacer un update
  public CountryEntity saveCountry(CountryEntity country) {
	  return countriesjpaRepository.save(country);
  }
  
  public String deleteCountry(String name) {
	  countriesjpaRepository.deleteByName(name);
	  return "Delete Succesful";
  }

	public CountryEntity findCountryByCountryId(Integer countryId) {
		return countriesjpaRepository.findById(countryId).get();
	}


}
