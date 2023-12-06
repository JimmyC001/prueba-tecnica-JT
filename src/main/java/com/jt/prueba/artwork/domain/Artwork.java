package com.jt.prueba.artwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.museum.domain.Museum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artwork")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 30)
    private String country;
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Artist.class)
    @JoinColumn(name = "id_artist")
    private Artist artist;
    @ManyToMany(mappedBy = "artworks")
    @JsonIgnore
    private Set<Museum> museums;
}