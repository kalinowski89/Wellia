package com.example.tanner.wellia;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

/**
 * Created by tanner on 5/20/16.
 */
public class dataProcessLayer {
    String json_data="";

    public dataProcessLayer() {


        }
    public String get_data() throws IOException {
        URL url = new URL("http://dyn.tdbtech.co/get_data.php");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        OutputStream out = conn.getOutputStream();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
        String response ="";
        String line="";
        while((line = br.readLine())!=null)
        {
            response+=line;
        }

        return response;
    }






    }

