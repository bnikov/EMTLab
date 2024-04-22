package com.example.emtlab.MRSC.Service.Impl;

import com.example.emtlab.Enumerations.Category;
import com.example.emtlab.Exceptions.NoMoreRoomsException;
import com.example.emtlab.MRSC.Model.Accommodation;
import com.example.emtlab.MRSC.Model.Host;
import com.example.emtlab.MRSC.Repository.AccommodationRepository;
import com.example.emtlab.MRSC.Repository.HostRepository;
import com.example.emtlab.MRSC.Service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> create(String name, Category category, Long hostId, Integer numRooms) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(name);
        accommodation.setCategory(category);

        Host host = hostRepository.findById(hostId)
                .orElseThrow(RuntimeException::new);

        accommodation.setHost(host);
        accommodation.setNumRooms(numRooms);
        accommodation.setRented(false);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> edit(Long id, String name, Category category, Long hostId, Integer numRooms) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        accommodation.setName(name);
        accommodation.setCategory(category);

        Host host = hostRepository.findById(hostId)
                .orElseThrow(RuntimeException::new);

        accommodation.setHost(host);
        accommodation.setNumRooms(numRooms);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> rent(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        boolean rented = accommodation.isRented();
        accommodation.setRented(!rented);

        // ne znam sto se bara

//
//        if (numRooms > 0) {
//            numRooms -= 1;
//        } else {
//            throw new NoMoreRoomsException();
//        }
//
//        accommodation.setNumRooms(numRooms);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}
