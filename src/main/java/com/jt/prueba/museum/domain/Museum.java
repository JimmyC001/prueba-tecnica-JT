package com.jt.prueba.museum.domain;

import com.jt.prueba.artwork.domain.Artwork;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "museum_x_artwork")
    private List<Artwork> artworks;
}
