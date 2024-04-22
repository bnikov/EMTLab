package com.example.emtlab.Request;

import com.example.emtlab.Enumerations.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EditAccommodationRequest {
    Long id;
    String name;
    Category category;
    Long hostId;
    Integer numRooms;
}
