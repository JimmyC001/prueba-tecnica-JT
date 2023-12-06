package com.jt.prueba.museum.application.mapper;

import com.jt.prueba.museum.application.dto.MuseumRequest;
import com.jt.prueba.museum.application.dto.MuseumResponse;
import com.jt.prueba.museum.domain.Museum;

public class MuseumMapper {
    public static Museum fromRequestToMuseum(MuseumRequest request){
        if(request == null)
            return null;
        return Museum.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .country(request.getCountry())
            .build();
    }

    public static MuseumResponse fromMuseumToResponse(Museum museum){
        if(museum == null)
            return null;
        return MuseumResponse.builder()
                .name(museum.getName())
                .address(museum.getAddress())
                .city(museum.getCity())
                .country(museum.getCountry())
            .build();
    }
}
