package com.example.mvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private final static String TAG = "MainActivity(View)";

    private MainContract.Presenter mPresenter;

    private Button mButton;

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = MainPresenter.newInstance(this);

        initView();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonWasClicked();
            }
        });


        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    private void initView() {
        mTextView = findViewById(R.id.text_message);
        mButton = findViewById(R.id.button_click_me);
    }

    @Override
    public void showText(String message) {
        mTextView.setText(message);
        Log.d(TAG, "showMessage()");
    }
}