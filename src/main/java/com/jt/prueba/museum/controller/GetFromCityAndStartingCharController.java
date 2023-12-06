package com.jt.prueba.museum.controller;

import com.jt.prueba.museum.application.method.MuseumMethod;
import com.jt.prueba.museum.domain.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("museum")
public class GetFromCityAndStartingCharController {
    private final MuseumMethod method;
    @Autowired
    GetFromCityAndStartingCharController(MuseumMethod method){
        this.method = method;
    }
    @GetMapping("{city}")
    public ResponseEntity<List<Museum>> fetch(@PathVariable("city") String city, @RequestParam(name = "startsWith", defaultValue = "a") String startsWith){
        if(city == null || startsWith == null)
            return ResponseEntity.badRequest().build();
        List<Museum> museums = method.getFromCityAndStartingChar(city, startsWith);
        return ResponseEntity.ok(museums);
    }
}
