package com.example.tanner.wellia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alex on 5/21/2016.
 */
public class dataParse {

    public JSONArray parseData() throws IOException, JSONException {
        String json_obj = new dataProcessLayer().get_data();

        JSONObject pObject = new JSONObject(json_obj);
        JSONArray pArray = pObject.getJSONArray("data");

/*
        ArrayList<JSONObject> finalObject = new ArrayList<JSONObject>();
        for(int i=0; i<pArray.length(); i++) {

            finalObject.add(pArray.getJSONObject(i));

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

            // can use finalObject.get(i) to access the data within each JSONObject
        }
*/


        return pArray;
    }
}
