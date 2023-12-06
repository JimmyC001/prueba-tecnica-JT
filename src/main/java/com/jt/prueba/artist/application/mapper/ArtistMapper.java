package com.jt.prueba.artist.application.mapper;

import com.jt.prueba.artist.application.dto.request.ArtistRequest;
import com.jt.prueba.artist.application.dto.response.ArtistResponse;
import com.jt.prueba.artist.domain.Artist;

public class ArtistMapper {
    public static Artist toArtistFromPrimitives(String ide_type, String ide_number, String names, String last_names) {
        return Artist.builder()
                .ideType(ide_type)
                .ideNumber(ide_number)
                .names(names)
                .last_names(last_names)
            .build();
    }
    public static ArtistResponse fromArtistToResponse(Artist artist){
        if(artist == null)
            return null;
        return ArtistResponse.builder()
                .ide_type(artist.getIdeType())
                .ide_number(artist.getIdeNumber())
                .names(artist.getNames())
                .last_names(artist.getLast_names())
                .build();
    }

    public static Artist fromRequestToArtist(ArtistRequest request){
        if(request == null)
            return null;
        return Artist.builder()
                .ideType(request.getIde_type())
                .ideNumber(request.getIde_number())
                .names(request.getNames())
                .last_names(request.getLast_names())
            .build();
    }
}
