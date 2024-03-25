package com.example.emtlab.MRSC.Controller;

import com.example.emtlab.Enumerations.Category;
import com.example.emtlab.MRSC.Model.Accommodation;
import com.example.emtlab.MRSC.Service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return accommodationService.findById(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/all")
    public List<Accommodation> findAll() {
        return accommodationService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> addAccommodation(@RequestParam String name, @RequestParam Category category, @RequestParam Long hostId, @RequestParam Integer numRooms) {
        return accommodationService.create(name, category, hostId, numRooms)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Accommodation> editAccommodation(@PathVariable Long id, @RequestParam String name, @RequestParam Category category, @RequestParam Long hostId, @RequestParam Integer numRooms) {
        return accommodationService.edit(id, name, category, hostId, numRooms)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<Accommodation> rentAccommodation(@PathVariable Long id) {
        return accommodationService.rent(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        accommodationService.deleteById(id);
    }
}
