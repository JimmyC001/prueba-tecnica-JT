package com.jt.prueba.museum.application.method;

import com.jt.prueba.museum.domain.Museum;
import com.jt.prueba.museum.domain.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MuseumMethod {
    private final MuseumService service;
    @Autowired
    MuseumMethod(MuseumService service){
        this.service = service;
    }
    public List<Museum> getFromCityAndStartingChar(String city, String c){
        return service.getFromCityAndStartingChar(city, c);
    }
}
