package com.example.appprogrammingproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Recommend extends Activity {

    TextView study, stress, love, friend;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.recommend);

        study=findViewById(R.id.study);
        stress=findViewById(R.id.stress);
        love=findViewById(R.id.love);
        friend=findViewById(R.id.friend);



    }
}
