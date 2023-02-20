package org.keepcode.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.keepcode.Utils;
import org.keepcode.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberService {

    public static final String API_URL = "getFreePhoneList?country=";

    public static volatile PhoneNumberService phoneNumberService;

    private PhoneNumberService() {
    }

    public static PhoneNumberService getInstance() {
        if (phoneNumberService == null) {
            synchronized (PhoneNumberService.class) {
                if (phoneNumberService == null) {
                    phoneNumberService = new PhoneNumberService();
                }
            }
        }
        return phoneNumberService;
    }

    public List<PhoneNumber> findPhoneNumbers(final Long countryId) {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

        String response = Utils.getJSONFromAPI(API_URL + countryId);

        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray jsonPhoneNumbers = jsonResponse.getJSONArray("numbers");
            for (int i = 0; i < jsonPhoneNumbers.length(); i++) {
                JSONObject jsonPhoneNumber = jsonPhoneNumbers.getJSONObject(i);
                PhoneNumber phoneNumber = new PhoneNumber(jsonPhoneNumber);
                phoneNumbers.add(phoneNumber);
            }
        } catch (JSONException e) {
            System.out.println("Could not parse the response");
            throw new JSONException(e.getMessage(), e);
        }
        return phoneNumbers;
    }
}
