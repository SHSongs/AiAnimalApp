package com.example.appprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button choose;
    RadioButton sTest,chu,resultCompare,face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        face=findViewById(R.id.face);
        choose=findViewById(R.id.choose);
        sTest=findViewById(R.id.sTest);
        chu=findViewById(R.id.chu);
        resultCompare=findViewById(R.id.resultCompare);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sTest.isChecked()){  //심리테스트<xml1>
                    Intent st=new Intent(getApplicationContext(),Stest.class);
                    startActivity(st);
                }
                else if(face.isChecked()){  //얼굴 상 알아보기 클릭

                }
                else if(chu.isChecked()){ //심리테스트 결과를 통한 추천 목록
                    //성격, 심리테스트를 한번도 실행하지 않았다면 성격, 심리테스트 권유 창 뜨기(dialog)
                }

                else if(resultCompare.isChecked()){  //친구와 결과 비교
                    //성격, 심리테스트를 한번도 실행하지 않았다면 성격, 심리테스트 권유 창 뜨기(dialog)
                }

            }
        });

    }
}
