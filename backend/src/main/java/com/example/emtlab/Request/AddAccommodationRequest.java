package com.example.emtlab.Request;

import com.example.emtlab.Enumerations.Category;
import com.example.emtlab.MRSC.Model.Country;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddAccommodationRequest {
    String name;
    Category category;
    Long hostId;
    Integer numRooms;
}
