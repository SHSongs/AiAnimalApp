package com.example.appprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Stest extends Activity {

    Button study,love,friend,stress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stest);

        study=findViewById(R.id.study);
        love=findViewById(R.id.love);
        friend=findViewById(R.id.friend);
        stress=findViewById(R.id.stress);

        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sd=new Intent(getApplicationContext(),Study.class);
                startActivity(sd);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lv=new Intent(getApplicationContext(),Love.class);
                startActivity(lv);

            }
        });

        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fi=new Intent(getApplicationContext(),Friend.class);
                startActivity(fi);

            }
        });

        stress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent st=new Intent(getApplicationContext(),Stress.class);
                startActivity(st);

            }
        });
    }
}
