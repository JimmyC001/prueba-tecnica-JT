package com.jt.prueba.museum.domain;

import com.jt.prueba.artwork.domain.Artwork;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "museum")
public class Museum {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String country;
    @Column(length = 30)
    private String city;
    @Column(length = 30)
    private String address;
    @ManyToMany
    @JoinTable(name = "museum_x_artwork")
    private List<Artwork> artworks;
}
