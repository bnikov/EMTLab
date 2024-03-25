package com.example.emtlab.MRSC.Repository;

import com.example.emtlab.MRSC.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
