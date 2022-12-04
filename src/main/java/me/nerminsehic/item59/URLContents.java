package me.nerminsehic.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLContents {
    public static void print(String url) {
        try(InputStream in = new URL(url).openStream()) {
            in.transferTo(System.out);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "https://www.google.com";
        URLContents.print(url);
    }
}
