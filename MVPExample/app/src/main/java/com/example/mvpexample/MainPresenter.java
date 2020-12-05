package com.example.mvpexample;

import android.util.Log;

public class MainPresenter implements MainContract.Presenter{

    private final static String TAG = "MainPresenter";

    // MVP app's components
    private MainContract.Model mModel;
    private MainContract.View mView;

    //Message
    private String message;

    // create instance of Presenter
    private static MainPresenter INSTANCE;

    //Singleton Presenter's instance
    public static MainPresenter newInstance(MainContract.View mView){
        if(INSTANCE == null){
            INSTANCE = new MainPresenter(mView);
        }
        return INSTANCE;
    }

    //Constructor
    private MainPresenter(MainContract.View mView){   //we pass the View instance
        this.mView = mView;
        this.mModel = new MainModel();              //Getting an instance of a Model from a constructor
        Log.d(TAG,"Constructor");
    }

    @Override
    public void onButtonWasClicked() {
        message = mModel.loadMessage();
        mView.showText(message);
        Log.d(TAG,"onButtonWasClicked()");
    }

    @Override
    public void onDestroy() {
        INSTANCE = null;
        //unsubscribe

        Log.d(TAG, "onDestroy()");
    }
}
