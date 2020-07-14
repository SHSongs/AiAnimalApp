package com.example.appprogrammingproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Recommend extends Activity {

    TextView study, stress, love, friend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend);

        study=findViewById(R.id.study);
        stress=findViewById(R.id.stress);
        love=findViewById(R.id.love);
        friend=findViewById(R.id.friend);
    }
}
