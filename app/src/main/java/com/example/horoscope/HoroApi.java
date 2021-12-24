package com.example.horoscope;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class HoroApi {
    private String sign;
    private String day;

    public HoroApi(String sign, String day) {
        this.sign = sign;
        this.day = day;
    }

    public ModelAnswer getHoro() throws IOException {
        //String url = "https://aztro.sameerkumar.website/?sign=" + sign + "&day" + day;
        String url = "https://aztro.sameerkumar.website/?sign=" + "taurus" + "&day" + "today";
        HttpURLConnection connection;

        URL u = new URL(url);
        connection = (HttpURLConnection) u.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(10000);
         connection.connect();

        int code = connection.getResponseCode();

        ArrayList<String> lines = new ArrayList<>();
        if (code == 200) {
            Scanner scan = new Scanner(connection.getInputStream());
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
        }
        StringBuilder str_b = new StringBuilder();
        for (String readline : lines) {
            str_b.append(readline);
        }

        Gson gson = new Gson();
        ModelAnswer answer = gson.fromJson(str_b.toString(), ModelAnswer.class);

        return answer;

    }
}

