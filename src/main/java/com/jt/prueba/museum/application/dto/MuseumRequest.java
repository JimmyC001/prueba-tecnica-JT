package com.jt.prueba.museum.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MuseumRequest {
    private String name;
    private String address;
    private String city;
    private String country;
}
