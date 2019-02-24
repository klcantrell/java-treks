package com.app;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
//            URL url = new URL("http://example.org/somepage.html");
              URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=dogs");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "MyUserAgent");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code = " + responseCode);
            connection.setReadTimeout(5000);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}











