package org.keepcode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Utils {

    private static final String BASE_URL = "https://onlinesim.ru/api/";

    public static String getJSONFromAPI(final String urlString) {
        String responseBody;
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + urlString))
                    .header("accept", "application/json")
                    .GET()
                    .build();

            responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Could not perform request");
            throw new RuntimeException(e.getMessage(), e);

        }
        return responseBody;
    }
}
