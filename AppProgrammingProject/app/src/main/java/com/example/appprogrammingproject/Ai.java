package com.example.appprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Ai extends AppCompatActivity {

    Button choose;
    RadioButton face, place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);

        choose = findViewById(R.id.choose);
        face = findViewById(R.id.face);
        place = findViewById(R.id.place);



        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (face.isChecked()) {  //얼굴 상 알아보기 클릭
                    Intent st = new Intent(getApplicationContext(), Face.class);
                    startActivity(st);
                }
                else if (place.isChecked()){
                    Intent st = new Intent(getApplicationContext(), Place.class);
                    startActivity(st);
                }

            }
        });
    }
}
