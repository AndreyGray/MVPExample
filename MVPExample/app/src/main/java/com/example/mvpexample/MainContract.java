package com.example.mvpexample;

public interface MainContract {

    interface Model{
        String loadMessage();
    }

    interface View{
        void showText(String message);
    }

    interface Presenter{
        void onButtonWasClicked();
        void onDestroy();
    }
}
