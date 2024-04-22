package com.example.emtlab.MRSC.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToMany
    List<Accommodation> accommodationList = new ArrayList<>();

    @ManyToOne
    private Country country;
}
