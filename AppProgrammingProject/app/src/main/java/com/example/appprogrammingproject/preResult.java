package com.example.appprogrammingproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.appprogrammingproject.R;

import androidx.annotation.Nullable;

public class preResult extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.preresult);
    }
}
