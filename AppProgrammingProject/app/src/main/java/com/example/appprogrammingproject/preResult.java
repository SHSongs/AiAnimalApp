package com.example.appprogrammingproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import com.example.appprogrammingproject.R;

import androidx.annotation.Nullable;

public class preResult extends Activity {

    ListView list ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preresult);

        list=findViewById(R.id.list);
    }
}
