package com.service.impl;

import com.google.gson.GsonBuilder;
import com.google.inject.internal.util.Iterables;
import com.google.inject.internal.util.Lists;
import com.model.Country;
import com.service.CountryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public HashMap<String, TreeMap<Double, String>> top10ByContinent() throws IOException, InterruptedException {
        List<Country> list = getAllCountries();

        HashMap<String, TreeMap<Double, String>> countries = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Country country = list.get(i);

            if (countries.containsKey(country.getRegion())) {
                countries.get(country.getRegion()).put(country.getPopulation(), country.getName());
            } else {
                TreeMap<Double, String> c = new TreeMap<>();
                c.put(country.getPopulation(), country.getName());

                countries.put(country.getRegion(), c);

            }
        }
        countries.remove("");

        //only  10 countries with biggest population
        HashMap<String, TreeMap<Double, String>> countriesLast10 = new HashMap<>();

        for (Map.Entry<String, TreeMap<Double, String>> values : countries.entrySet()) {
            countriesLast10.put(values.getKey(), new TreeMap<Double, String>());

            TreeMap<Double, String> top10 = values.getValue();
            int count = 0;
            for (Map.Entry<Double, String> pairs : top10.descendingMap().entrySet()) {
                if (++count > 10) {
                    break;
                }

                countriesLast10.get(values.getKey()).put(pairs.getKey(), pairs.getValue());
            }
        }
        return countriesLast10;
    }


    @Override
    public List<Country> getAllCountries() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://restcountries.eu/rest/v2/all?fields=name;region;subregion;population"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        List<Country> list = Arrays.asList(new GsonBuilder().create().fromJson(response.body(), Country[].class));

        return list;
    }
}
