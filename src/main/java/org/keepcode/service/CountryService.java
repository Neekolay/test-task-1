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
        var countries = new ArrayList<Country>();

        var response = Utils.getJSONFromAPI(API_URL);

        try {
            var jsonResponse = new JSONObject(response);
            var jsonCountries = jsonResponse.getJSONArray("countries");
            for (int i = 0; i < jsonCountries.length(); i++) {
                var jsonCountry = jsonCountries.getJSONObject(i);
                var country = new Country(jsonCountry);
                countries.add(country);
            }
        } catch (JSONException e) {
            System.out.println("Could not parse the response");
            throw new JSONException(e.getMessage(), e);
        }
        return countries;
    }
}
