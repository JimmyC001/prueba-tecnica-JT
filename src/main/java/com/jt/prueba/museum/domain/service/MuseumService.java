package com.jt.prueba.museum.domain.service;

import com.jt.prueba.museum.domain.Museum;

import java.util.List;

public interface MuseumService {
    List<Museum> getAllMuseums();
    List<Museum> getFromCityAndStartingChar(String city, String c);
    Museum createMuseum(Museum museum);
    Museum updateMuseum(Museum museum, Long id);
}
