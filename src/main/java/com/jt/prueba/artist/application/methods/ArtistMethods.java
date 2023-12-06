package com.jt.prueba.artist.application.methods;

import com.jt.prueba.artist.application.mapper.ArtistMapper;
import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.artist.domain.service.ArtistService;
import com.jt.prueba.artwork.domain.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistMethods {
    private final ArtistService service;
    @Autowired
    ArtistMethods(ArtistService service){
        this.service = service;
    }
    public Artist createArtist(String ide_type, String ide_number, String names, String last_names) {
        return service.createArtist(ArtistMapper.toArtistFromPrimitives(ide_type, ide_number, names, last_names));
    }

    public List<Artwork> getArtworkFromArtistAndCountry(String type, String number, String country){
        Artist artist = service.getArtistFromTypeAndId(type, number);
        if(artist == null)
            return null;
        return service.getArtworkFromArtist(artist.getId(), country);
    }

    public Artist updateArtist(Artist artist, String type, String id){
        if(artist == null)
            return null;
        return service.updateArtist(artist, type, id);
    }
}
