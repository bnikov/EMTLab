package com.example.emtlab.MRSC.Service.Impl;

import com.example.emtlab.MRSC.Model.Country;
import com.example.emtlab.MRSC.Model.Host;
import com.example.emtlab.MRSC.Repository.HostRepository;
import com.example.emtlab.MRSC.Service.CountryService;
import com.example.emtlab.MRSC.Service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryService countryService;

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> create(String name, String surname, Long countryId) {
        Host host = new Host();
        host.setName(name);
        host.setSurname(surname);

        Country country = countryService.findById(countryId)
                .orElseThrow(RuntimeException::new);

        host.setCountry(country);

        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> edit(Long id, String name, String surname, Long countryId) {
        Host host = hostRepository.findById(id)
                        .orElseThrow(RuntimeException::new);

        host.setName(name);
        host.setSurname(surname);

        Country country = countryService.findById(countryId)
                .orElseThrow(RuntimeException::new);

        host.setCountry(country);

        return Optional.of(hostRepository.save(host));
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
