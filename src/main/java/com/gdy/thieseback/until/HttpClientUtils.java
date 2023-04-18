package com.gdy.thieseback.until;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClientUtils {
    /**
     * @param uri
     * @return String
     * @description get请求方式
     * @author: long.he01
     */
    /**
     * @param uri
     * @return String
     * @description get请求方式
     * @author: long.he01
     */
    public static String doGet(String uri) {

        StringBuilder result = new StringBuilder();
        try {
            StringBuilder res = new StringBuilder();
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                res.append(line).append("\n");
            }
            in.close();
            return res.toString();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
