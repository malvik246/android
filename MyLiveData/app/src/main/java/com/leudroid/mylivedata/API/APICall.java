package com.leudroid.mylivedata.API;

import com.google.gson.Gson;
import com.leudroid.mylivedata.POJO.PostBean;

import java.util.ArrayList;

import com.leudroid.mylivedata.POJO.UserBean;
import com.leudroid.mylivedata.POJO.UserPhpBean;

/**
 * Created by Hp on 02-06-2017.
 */

public class APICall {

    //mention all urls here
    public static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";
    public static final String USER_URL = "https://jsonplaceholder.typicode.com/users";

    public ArrayList<PostBean> GetPostData(){

        String result = "";

        ArrayList<PostBean> postBeanArrayList = new ArrayList<>();

        HttpCall httpCall = new HttpCall();
        result = httpCall.GET(POST_URL);

        Gson gson = new Gson();

        PostBean[] postBean = gson.fromJson(result, PostBean[].class);

        for (PostBean p : postBean) {

            postBeanArrayList.add(p);

        }
        return postBeanArrayList;
    }

    public ArrayList<UserBean> GetUserData(){

        String result = "";

        ArrayList<UserBean> userBeanArrayList = new ArrayList<>();

        HttpCall httpCall = new HttpCall();
        result = httpCall.GET(USER_URL);

        Gson gson = new Gson();

        UserBean[] userBeen = gson.fromJson(result, UserBean[].class);

        for (UserBean u : userBeen) {

            userBeanArrayList.add(u);

        }

        return userBeanArrayList;
    }

}
