package org.keepcode.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.keepcode.Utils;
import org.keepcode.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    public static final String API_URL = "getFreeCountryList";

    public static volatile CountryService countryService;

    private CountryService() {
    }

    public static CountryService getInstance() {
        if (countryService == null) {
            synchronized (CountryService.class) {
                if (countryService == null) {
                    countryService = new CountryService();
                }
            }
        }
        return countryService;
    }

    public List<Country> findCountries() {
        List<Country> countries = new ArrayList<>();

        String response = Utils.getJSONFromAPI(API_URL);

        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray jsonCountries = jsonResponse.getJSONArray("countries");
            for (int i = 0; i < jsonCountries.length(); i++) {
                JSONObject jsonCountry = jsonCountries.getJSONObject(i);
                Country country = new Country(jsonCountry);
                countries.add(country);
            }
        } catch (JSONException e) {
            System.out.println("Could not parse the response");
            throw new JSONException(e.getMessage(), e);
        }
        return countries;
    }
}
