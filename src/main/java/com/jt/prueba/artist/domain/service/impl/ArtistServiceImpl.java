package com.jt.prueba.artist.domain.service.impl;

import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.artist.domain.repository.ArtistRepository;
import com.jt.prueba.artist.domain.service.ArtistService;
import com.jt.prueba.artwork.domain.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository repository;
    @Autowired
    ArtistServiceImpl(ArtistRepository repository){
        this.repository = repository;
    }
    @Override
    public Artist createArtist(Artist artist) {
        Artist dbArtist = repository.findArtistByIdeTypeAndIdeNumber(artist.getIdeType(), artist.getIdeNumber()).orElse(null);
        if(dbArtist != null)
            return null;
        return repository.save(artist);
    }

    @Override
    public Artist getArtistFromTypeAndId(String type, String id) {
        return repository.findArtistByIdeTypeAndIdeNumber(type, id).orElse(null);
    }

    @Override
    public List<Artwork> getArtworkFromArtist(Long id, String country) {
        Artist dbArtist = repository.findById(id).orElse(null);
        if(dbArtist== null)
            return null;
        List<Artwork> artworkList = repository.getArtworkFromArtist(id, country);
        if(artworkList == null)
            return null;
        return artworkList;
    }
}
