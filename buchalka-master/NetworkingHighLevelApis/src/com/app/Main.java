package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");

//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setDoOutput(true);
//            urlConnection.connect();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "MyUserAgent");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code = " + responseCode);
            connection.setReadTimeout(5000);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream())
//            );

//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//
//            headerFields.entrySet().forEach(headerField -> {
//                String key = headerField.getKey();
//                List<String> value = headerField.getValue();
//                System.out.println("--------key = " + key);
//                value.forEach(item -> {
//                    System.out.println("value = " + item);
//                });
//            });

//            String line = "";
//
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line != null ? line : "");
//            }
//
//            inputStream.close();

        } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}











