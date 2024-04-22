package com.example.emtlab.MRSC.Controller;

import com.example.emtlab.MRSC.Model.Country;
import com.example.emtlab.MRSC.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/all")
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> createCountry(@RequestParam String name, @RequestParam String continent) {
        return countryService.create(name, continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestParam String name, @RequestParam String continent) {
        return countryService.edit(id, name, continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
    }
}
