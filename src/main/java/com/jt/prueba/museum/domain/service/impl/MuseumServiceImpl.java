package com.jt.prueba.museum.domain.service.impl;

import com.jt.prueba.museum.domain.Museum;
import com.jt.prueba.museum.domain.repository.MuseumRespository;
import com.jt.prueba.museum.domain.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumServiceImpl implements MuseumService {
    private final MuseumRespository repository;
    @Autowired
    MuseumServiceImpl(MuseumRespository repository){
        this.repository = repository;
    }

    @Override
    public List<Museum> getAllMuseums() {
        return repository.findAll();
    }

    @Override
    public List<Museum> getFromCityAndStartingChar(String city, String c) {
        return repository.findByCityAndFirstLetter(city, c);
    }

    @Override
    public Museum createMuseum(Museum museum) {
        return repository.save(museum);
    }

    @Override
    public Museum updateMuseum(Museum museum, Long id) {
        Museum dbMuseum = repository.findById(id).orElse(null);
        if(dbMuseum == null)
            return null;
        dbMuseum.setAddress(museum.getAddress());
        dbMuseum.setName(museum.getName());
        dbMuseum.setCity(museum.getCity());
        dbMuseum.setCountry(museum.getCountry());
        return repository.save(dbMuseum);
    }
}
