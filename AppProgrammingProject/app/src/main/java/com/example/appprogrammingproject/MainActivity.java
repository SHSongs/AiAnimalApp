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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        ai = findViewById(R.id.ai);
        choose = findViewById(R.id.choose);
        sTest = findViewById(R.id.sTest);
        cu = findViewById(R.id.cu);
        menu=findViewById(R.id.menu);
        






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
