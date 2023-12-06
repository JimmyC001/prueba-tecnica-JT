package com.jt.prueba.museum.application.method;

import com.jt.prueba.museum.application.dto.MuseumRequest;
import com.jt.prueba.museum.application.mapper.MuseumMapper;
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
    public Museum createMuseum(MuseumRequest request){
        Museum museum = MuseumMapper.fromRequestToMuseum(request);
        if(museum == null)
            return null;
        return service.createMuseum(museum);
    }

    public Museum updateMuseum(MuseumRequest request, Long id){
        Museum museum = MuseumMapper.fromRequestToMuseum(request);
        if(museum == null)
            return null;
        return service.updateMuseum(museum, id);
    }
}
