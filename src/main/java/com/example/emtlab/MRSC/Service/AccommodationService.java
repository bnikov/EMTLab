package com.example.emtlab.MRSC.Service;

import com.example.emtlab.Enumerations.Category;
import com.example.emtlab.MRSC.Model.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> create(String name, Category category, Long hostId, Integer numRooms);

    Optional<Accommodation> edit(Long id, String name, Category category, Long hostId, Integer numRooms);

    Optional<Accommodation> rent(Long id);

    void deleteById(Long id);
}
