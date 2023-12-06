package com.jt.prueba.artist.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}