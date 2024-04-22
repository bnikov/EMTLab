package com.example.emtlab.MRSC.Controller;

import com.example.emtlab.Enumerations.Category;
import com.example.emtlab.MRSC.Model.Accommodation;
import com.example.emtlab.MRSC.Service.AccommodationService;
import com.example.emtlab.Request.AddAccommodationRequest;
import com.example.emtlab.Request.EditAccommodationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accommodation")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
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
    public ResponseEntity<Accommodation> addAccommodation(@RequestBody AddAccommodationRequest req) {
        return accommodationService.create(req.getName(), req.getCategory(), req.getHostId(), req.getNumRooms())
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/edit")
    public ResponseEntity<Accommodation> editAccommodation(@RequestBody EditAccommodationRequest req) {
        return accommodationService.edit(req.getId(), req.getName(), req.getCategory(), req.getHostId(), req.getNumRooms())
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<Accommodation> rentAccommodation(@PathVariable Long id) {
        return accommodationService.rent(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/categoryValues")
    public List<String> categories() {
        return Arrays.stream(Category.values())
                .map(Category::toString)
                .collect(Collectors.toList());
    }


    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        accommodationService.deleteById(id);
    }
}
