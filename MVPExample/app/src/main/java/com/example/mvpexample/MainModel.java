package com.example.mvpexample;

import android.util.Log;

public class MainModel implements MainContract.Model{

    private final static String TAG = "MainModel";

    @Override
    public String loadMessage() {
        Log.d(TAG,"loadMessage()");

        //filling data from a database or network

        return "Я сообщение от MailModel";
    }
}
