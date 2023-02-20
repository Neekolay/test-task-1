package org.keepcode;

import org.keepcode.model.Country;
import org.keepcode.model.PhoneNumber;
import org.keepcode.service.CountryService;
import org.keepcode.service.PhoneNumberService;

import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var numbersByCountry = new HashMap<Country, List<PhoneNumber>>();

        var countryService = CountryService.getInstance();
        var phoneNumberService = PhoneNumberService.getInstance();

        System.out.println("Getting countries list...");
        var countries = countryService.findCountries();
        for (Country country : countries) {
            System.out.println("Getting numbers for " + country.getName() + "...");
            numbersByCountry.put(country, phoneNumberService.findPhoneNumbers(country.getId()));
        }
        System.out.println("Result:");
        numbersByCountry.forEach((key, value) ->
                System.out.println(key.getName() + ": " +
                        value.stream().map(PhoneNumber::getNumber).toList()));
    }
}