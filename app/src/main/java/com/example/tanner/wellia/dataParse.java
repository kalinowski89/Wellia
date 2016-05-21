package com.example.tanner.wellia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alex on 5/21/2016.
 */
public class dataParse {

    public JSONArray parseData() throws IOException, JSONException {
        URL url = new URL("http://dyn.tdbtech.co/get_data.php");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        StringBuffer buffer = new StringBuffer();

        String finalJson = buffer.toString();

        JSONObject pObject = new JSONObject(finalJson);
        JSONArray pArray = pObject.getJSONArray("data");

        /*
        JSONObject finalObject = pArray.getJSONObject(0);

        String id = finalObject.getString("PROGRAM_ID");
        String name = finalObject.getString("NAME1");
        String facility_desc = finalObject.getString("NAME2");
        String address = finalObject.getString("STREET1") + " " + finalObject.getString("STREET2");
        String zip = finalObject.getString("ZIP");
        String phone = finalObject.getString("PHONE") + " " + finalObject.getString("INTAKE1") + " " + finalObject.getString("INTAKE2");
        String facility_url = finalObject.getString("URL");
        double latitude = finalObject.getDouble("LAT");
        double longitude = finalObject.getDouble("LNG");
        String facility_type = finalObject.getString("TYPE_FACILITY");
        */

        return pArray;
    }
}
