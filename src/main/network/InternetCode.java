package network;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//copied from cpsc210 deliverable 10 webpage
public class InternetCode {

    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String search = "taco";
            String appId = "1911afbd";
            String apikey = "9020687e5b60151299027fe80f9c35d1";
            String partOneQuery = "https://api.nutritionix.com/v1_1/search/";
            String partTwoQuery = "?results=0%3A1&cal_min=0&cal_max=50000&fields=nf_calories&appId=";
            String partThreeQuery = "&appKey=";
            String theURL = partOneQuery + search + partTwoQuery + appId + partThreeQuery + apikey; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            JSONObject jsonObject= new
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}

