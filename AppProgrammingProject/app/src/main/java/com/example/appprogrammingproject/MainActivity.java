package com.example.appprogrammingproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button btn, choose, menu;
    RadioButton sTest, chu, resultCompare, ai;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Loading.class);
        startActivity(intent);
    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId())
        {
            case R.id.preResult1:
                Intent pre=new Intent(this,preResult.class);
                startActivity(pre);
                Toast.makeText(getApplicationContext(),"이전 결과 보기",Toast.LENGTH_SHORT).show();


        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        ai = findViewById(R.id.ai);
        choose = findViewById(R.id.choose);
        sTest = findViewById(R.id.sTest);
        chu = findViewById(R.id.chu);
        menu=findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,menu);

                MenuInflater inflater=popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.show();;
            }
        });


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (sTest.isChecked()) {  //심리테스트<xml1>
                        Intent st = new Intent(getApplicationContext(), Stest.class);
                        startActivity(st);
                    } else if (ai.isChecked()) {  //얼굴 상 알아보기 클릭
                        Intent ai = new Intent(getApplicationContext(), Ai.class);
                        startActivity(ai);

                    } else if (chu.isChecked()) { //심리테스트 결과를 통한 추천 목록
                        //성격, 심리테스트를 한번도 실행하지 않았다면 성격, 심리테스트 권유 창 뜨기(dialog)
                        Intent chu = new Intent(getApplicationContext(), Recommend.class);
                        startActivity(chu);
                    }
            }
        });



    }
}
