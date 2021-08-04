package com.controller;

import com.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping(name = "/countries")
    @ResponseBody
    public ResponseEntity<?> top10PopulationByContinent() throws IOException, InterruptedException {
        HashMap<String, TreeMap<Double, String>> countries = countryService.top10ByContinent();
        return new ResponseEntity(countries, HttpStatus.OK);
    }
}
