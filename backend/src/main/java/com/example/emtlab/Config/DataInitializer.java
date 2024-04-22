package com.example.emtlab.Config;

import com.example.emtlab.Enumerations.Category;
import com.example.emtlab.MRSC.Service.AccommodationService;
import com.example.emtlab.MRSC.Service.CountryService;
import com.example.emtlab.MRSC.Service.HostService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final HostService hostService;
    private final AccommodationService accommodationService;

    public DataInitializer(CountryService countryService, HostService hostService, AccommodationService accommodationService) {
        this.countryService = countryService;
        this.hostService = hostService;
        this.accommodationService = accommodationService;
    }

    Random random = new Random();

    @PostConstruct
    public void fillData()
    {
        if(countryService.findAll().isEmpty())
        {
            for(int i = 0; i < 8; i++)
            {
                countryService.create( "Country" + i, "Europe");
            }
        }

        if(hostService.findAll().isEmpty())
        {
            for(int i = 0; i < 8; i++)
            {
                hostService.create("Name" + i, "Surname" + i, (long)i+1);
            }
        }

        if(accommodationService.findAll().size() < 10)
        {
            for(int i = 0; i < 10; i++)
            {
                accommodationService.create( "Accommodation" + i, Category.values()[random.nextInt(5)], (long) random.nextInt(3) + 1, 10);
            }
        }
    }
}
