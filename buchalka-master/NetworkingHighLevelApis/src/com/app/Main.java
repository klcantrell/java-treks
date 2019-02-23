package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        try {
            // not an absolute path, evidently
            //URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os-android#samsung");

            // http = known scheme --> absolute path
            //URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os-android#samsung");

            // base URI - couple this with other URI components to create a URL
//            URI baseUri = new URI("http://username:password@mynewserver.com:5000");

            // relative URI - won't turn into URL by itself (URL needs an absolute URI)
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=samsung");
//
//            URI resolvedUri1 = baseUri.resolve(uri1);
//            URI resolvedUri2 = baseUri.resolve(uri2);
//            URI resolvedUri3 = baseUri.resolve(uri3);

//            URL url1 = resolvedUri1.toURL();
//            System.out.println("URL1 = " + url1);
//            URL url2 = resolvedUri2.toURL();
//            System.out.println("URL2 = " + url2);
//            URL url3 = resolvedUri3.toURL();
//            System.out.println("URL3 = " + url3);
//
//            URI relativizedUri = baseUri.relativize(resolvedUri1);
//            System.out.println("Relative URI = " + relativizedUri);
//
            URL url = new URL("http://example.org");
//            URI uri = url.toURI();
//
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());

            // use an inputstream to read contents from a URL resource
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(url.openStream())
//            );
//
//            String line = "";
//
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line != null ? line : "");
//            }
//
//            inputStream.close();

            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream())
            );

            String line = "";

            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line != null ? line : "");
            }

            inputStream.close();

//        } catch (URISyntaxException e) {
//            System.out.println("URI bad Syntax: " + e.getIndex());
//        } catch (MalformedURLException e) {
//            System.out.println("URL Malformed: " + e.getMessage());
        } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}











