package com.example.appprogrammingproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

import com.example.appprogrammingproject.database.DatabaseHelper;
import com.example.appprogrammingproject.database.model.Note;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button btn, choose, menu;
    RadioButton sTest, cu, ai;
    ArrayList<Note> notesList = new ArrayList<>();
    private DatabaseHelper db;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Loading.class);
        startActivity(intent);
    }

//    public boolean onCreateOptionMenu(Menu menu){
//        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item){
//
//
//                AlertDialog.Builder al=new AlertDialog.Builder(this);
//                al.setTitle("이 앱을 즐겨주세요!");
//                al.setMessage("\uD83D\uDE0B FUNA는 심리테스트와 AI 측정을 할 수 있습니다. 심리테스트를 한 뒤에는, 심리테스트의 결과를 이용하여 최종적인 추천 결과를 얻을 수 있습니다. 충분한 심리테스트의 결과가 모이지 않으면," +
//                        "최종 결과를 얻을 수 없으니 심리테스트를 즐겁게 즐겨주세요!!");
//
//                al.setPositiveButton("확인", null);
//                al.setNegativeButton("취소",null);
//
//                al.show();
//
//                return true;
//
//
//
//
//
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        ai = findViewById(R.id.ai);
        choose = findViewById(R.id.choose);
        sTest = findViewById(R.id.sTest);
        cu = findViewById(R.id.cu);
        menu=findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,menu);

                MenuInflater inflater=popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.show();
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

                    } else if (cu.isChecked()) { //심리테스트 결과를 통한 추천 목록
                        Intent ch=new Intent(getApplicationContext(),Recommend.class);
                        startActivity(ch);
                    }
            }
        });



    }
}
