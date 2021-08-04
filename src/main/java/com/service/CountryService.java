package com.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public interface CountryService {
    List<? extends Object> getAllCountries() throws IOException, InterruptedException;

    HashMap<String, TreeMap<Double, String>> top10ByContinent() throws IOException, InterruptedException;

}
