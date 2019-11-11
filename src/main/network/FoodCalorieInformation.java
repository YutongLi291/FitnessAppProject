package network;

import java.io.*;


import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.MalformedURLException;
import java.net.URL;

//copied from cpsc210 deliverable 10 webpage
public class FoodCalorieInformation {

    private static final String appId = "1911afbd";
    private static final String apikey = "9020687e5b60151299027fe80f9c35d1";
    private static final String partOneQuery = "https://api.nutritionix.com/v1_1/search/";
    private static final String partTwoQuery = "?results=0%3A1&cal_min=0&cal_max=50000&fields=nf_calories&appId=";
    private static final String partThreeQuery = "&appKey=";
    String search;

    //    static String theURL = partOneQuery + search + partTwoQuery + appId + partThreeQuery + apikey;

    public FoodCalorieInformation(String search) {
        this.search = search;
    }

    public void searchFoodThenGetCalories() throws MalformedURLException, IOException, ParseException {

        BufferedReader br = null;


        try {

            String theURL = partOneQuery + search + partTwoQuery + appId + partThreeQuery + apikey;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }
            getCalorieCount(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    public  void getCalorieCount(StringBuilder sb) throws ParseException {
        String result = sb.toString();

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(result);
        JSONObject jsonObject = (JSONObject) obj;

        Object hits = jsonParser.parse((jsonObject.get("hits")).toString());
        JSONArray hitsArray = (JSONArray) hits;
        Object hitsObject = hitsArray.get(0);
        JSONObject hitsjsonobject = (JSONObject) hitsObject;

        Object fields = hitsjsonobject.get("fields");
        fields = jsonParser.parse(fields.toString());
        JSONObject fieldsObject = (JSONObject) fields;
        Object calorieCount = fieldsObject.get("nf_calories");
        System.out.println("The calorie count is " + calorieCount);
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }
}

