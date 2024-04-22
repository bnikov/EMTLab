package com.example.emtlab.MRSC.Service;

import com.example.emtlab.MRSC.Model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {

    List<Host> findAll();

    Optional<Host> findById(Long id);

    Optional<Host> create(String name, String surname, Long countryId);

    Optional<Host> edit(Long id, String name, String surname, Long countryId);

    void deleteById(Long id);
}
