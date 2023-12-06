package com.jt.prueba.artist.domain;

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
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 5)
    private String ideType;
    @Column(length = 20)
    private String ideNumber;
    @Column(length = 30)
    private String names;
    @Column(length = 30)
    private String last_names;
    @OneToMany(mappedBy = "artist",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Artwork> artworks;
}