package com.example.emtlab.MRSC.Service.Impl;

import com.example.emtlab.MRSC.Model.Country;
import com.example.emtlab.MRSC.Repository.CountryRepository;
import com.example.emtlab.MRSC.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> create(String name, String continent) {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = countryRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
