package com.example.diana.code2040challenge;

import android.app.Application;


public class App extends Application{

    private String url = "http://challenge.code2040.org/api/";
    private String token = "1yxife3KZE";

    public String getUrl() {
        return url;
    }

    public String getToken(){
        return token;
    }

}
