package com.example.appprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.appprogrammingproject.database.DatabaseHelper;
import com.example.appprogrammingproject.database.model.Note;

import java.util.Collections;
import java.util.List;

import androidx.annotation.Nullable;

public class Recommend extends Activity {

    TextView study, stress, love, friend;

    private DatabaseHelper db;

    private void createNote(int group, int id, int select) {
        db.insertNote(id, group, select);
    }

    final int[] select = {0};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend);

        db = new DatabaseHelper(this);

        List<Note> n = db.getAllNotes();

        study = findViewById(R.id.study);
        stress = findViewById(R.id.stress);
        love = findViewById(R.id.love);
        friend = findViewById(R.id.friend);

        String getSelet = getIntent().getStringExtra("select");

        readData();


    }

    private void readData() {

        List<Note> notes = db.getAllNotes();
        for (Note n : notes) {


            switch (n.getGroupitem()) {
                case 0://심리테스트 공부를 선택했을 때
                    switch (n.getId()) {
                        case 0://공부 심리테스트 중 처음 심리테스트 선택

                            study.setTextSize(27);
                            stress.setTextSize(27);
                            love.setTextSize(27);
                            friend.setTextSize(27);

                            switch (n.getSelectitem()) {
                                case 0:
                                    study.setText(study.getText() + "\n공부하기 좋은 장소 : 독서실\n");
                                    break;
                                case 1:
                                    study.setText(study.getText() + "\n공부하기 좋은 장소 : 스터디 그룹 방\n");
                                    break;
                                case 2:
                                    study.setText(study.getText() + "\n공부하기 좋은 장소 : 집\n");
                                    break;
                                case 3:
                                    study.setText(study.getText() + "\n공부하기 좋은 장소 : 카페\n");
                                    break;
                            }
                            break;

                        case 1:
                            switch (n.getSelectitem()) {
                                case 0:
                                    study.setText(study.getText() + "\n공부하는 방법 : 목표 먼저 세우기\n");
                                    break;
                                case 1:
                                    study.setText(study.getText() + "\n공부하는 방법 : 스터디플래너 사용\n");
                                    break;
                                case 2:
                                    study.setText(study.getText() + "\n공부하는 방법 : 포스트잇에 목표 써놓고 동기 부여\n");
                                    break;
                                case 3:
                                    study.setText(study.getText() + "\n공부하는 방법 : 주변에게 공부 도움 요청\n");
                                    break;
                                case 4:
                                    study.setText(study.getText() + "\n공부하는 방법 : 실현가능한 목표 세우기\n");
                                    break;
                            }

                            break;

                        case 2:
                            switch (n.getSelectitem()) {
                                case 0:
                                    study.setText(study.getText() + "\n공부 조언 : 지금처럼 열심히 노력하세요!\n");
                                    break;
                                case 1:
                                    study.setText(study.getText() + "\n공부 조언 : 좋아하는 분야를 먼저 찾아보세요!\n");
                                    break;
                                case 2:
                                    study.setText(study.getText() + "\n공부 조언 : 악기나 노래, 미술 등으로 공부로 받은 스트레스를 풀어보세요!\n");
                                    break;
                                case 3:
                                    study.setText(study.getText() + "\n공부 조언 : 학습 위주로 공부 해보세요!\n");
                                    break;
                            }
                            break;
                    }
                    break;





                case 1://심리테스트 심리를 선택했을 때
                    switch (n.getId()) {
                        case 0://공부 심리테스트 중 처음 심리테스트 선택

                            study.setTextSize(27);

                            switch (n.getSelectitem()) {
                                case 0:
                                    stress.setText(stress.getText() + "\n스트레스를 줄이는 방법 : 오해가 생긴다면 바로 풀어보려고 노력해보세요.\n");
                                    break;
                                case 1:
                                    stress.setText(stress.getText() + "\n스트레스를 줄이는 방법 : 사람은 당연히 서로 다를 수 밖에 없다는 점을 명심하고 이해하세요.\n");
                                    break;
                                case 2:
                                    stress.setText(stress.getText() + "\n스트레스를 줄이는 방법 : 모든 일에 완벽할 수 없다는 점을 기억하세요.\n");
                                    break;
                                case 3:
                                    stress.setText(stress.getText() + "\n스트레스를 줄이는 방법 : 자신의 취향에 맞는 새로운 분야를 찾아서 인생의 무료함을 없애보세요.\n");
                                    break;
                                case 4:
                                    stress.setText(stress.getText() + "\n스트레스를 줄이는 방법 : 모든 사람이 자신을 좋아할 수 없다는 점을 기억하세요.\n");
                                    break;

                            }
                            break;

                        case 1:
                            switch (n.getSelectitem()) {
                                case 0:
                                    stress.setText(stress.getText() + "\n마음을 다스리는 법 : 다른 사람이 발견하지 못한 흔하지 않은 분야를 공부해보세요.\n");
                                    break;
                                case 1:
                                    stress.setText(stress.getText() + "\n마음을 다스리는 법 : 친구들과 함께 대화를 많이 해보세요.\n");
                                    break;
                                case 2:
                                    stress.setText(stress.getText() + "\n마음을 다스리는 법 : 주관적이지 않고 객관적인 판단을 내려보세요.\n");
                                    break;
                                case 3:
                                    stress.setText(stress.getText() + "\n마음을 다스리는 법 : 화가 날 때는 주변사람을 설득하여 문제를 해결해보세요.\n");
                                    break;
                            }

                            break;

                        case 2:
                            switch (n.getSelectitem()) {
                                case 0:
                                    stress.setText(stress.getText() + "\n성격에 맞는 음악 : 팝송\n");
                                    break;
                                case 1:
                                    stress.setText(stress.getText() + "\n성격에 맞는 음악 : 클래식\n");
                                    break;
                                case 2:
                                    stress.setText(stress.getText() + "\n성격에 맞는 음악 : 재즈\n");
                                    break;
                                case 3:
                                    stress.setText(stress.getText() + "\n컨트리 음악\n");
                                    break;
                            }
                            break;
                    }
                    break;




                case 2://심리테스트 사랑을 선택했을 때
                    break;





                case 3://심리테스트 인간관계를 선택했을 때
                    break;

            }


        }

    }
}
