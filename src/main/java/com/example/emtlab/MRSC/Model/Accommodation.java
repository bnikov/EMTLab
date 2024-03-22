package com.example.emtlab.MRSC.Model;

import com.example.emtlab.Enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accommodation")
@Data
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Host host;

    private Integer numRooms;
}
