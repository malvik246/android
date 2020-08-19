package com.leudroid.mylivedata.API;

/**
 * Created by Hp on 02-06-2017.
 */


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpCall {

    public static String GET(String url){

        String result = "";

        try {


            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(url).build();

            try {

                Response response = client.newCall(request).execute();
                result = response.body().string();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

}
