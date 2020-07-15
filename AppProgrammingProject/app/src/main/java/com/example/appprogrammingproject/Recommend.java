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
                                    stress.setText(stress.getText() + "\n성격에 맞는 음악 : 컨트리 음악\n");
                                    break;
                            }
                            break;
                    }
                    break;




                case 2://심리테스트 사랑을 선택했을 때
                    switch (n.getId()) {
                        case 0://공부 심리테스트 중 처음 심리테스트 선택

                            love.setTextSize(27);

                            switch (n.getSelectitem()) {
                                case 0:
                                    love.setText(love.getText() + "\n나의 연얘 스타일: 친구같은 편한 연애\n");
                                    break;
                                case 1:
                                    love.setText(love.getText() + "\n나의 연얘 스타일 : 현실적이고 계획적인 연애\n");
                                    break;
                                case 2:
                                    love.setText(love.getText() + "\n나의 연얘 스타일 : 열정적이고 헌신적인 연애\n");
                                    break;
                                case 3:
                                    love.setText(love.getText() + "\n나의 연얘 스타일 : 자신의 취향에 맞는 새로운 분야를 찾아서 인생의 무료함을 없애보세요.\n");
                                    break;
                                case 4:
                                    love.setText(love.getText() + "\n나의 연얘 스타일 : 순수하지만 성숙한 연애\n");
                                    break;

                            }
                            break;

                        case 1:
                            switch (n.getSelectitem()) {
                                case 0:
                                    love.setText(love.getText() + "\n알맞은 데이트 장소: 콘서트\n");
                                    break;
                                case 1:
                                    love.setText(love.getText() + "\n알맞은 데이트 장소: 벚꽃 놀이\n");
                                    break;
                                case 2:
                                    love.setText(love.getText() + "\n알맞은 데이트 장소: 카페\n");
                                    break;
                                case 3:
                                    love.setText(love.getText() + "\n알맞은 데이트 장소: 만화방\n");
                                    break;
                            }

                            break;

                        case 2:
                            switch (n.getSelectitem()) {
                                case 0:
                                    love.setText(love.getText() + "\n애인과 같이 보면 좋을 영화 : 로맨스 영화\n");
                                    break;
                                case 1:
                                    love.setText(love.getText() + "\n애인과 같이 보면 좋을 영화 : 공포 영화\n");
                                    break;
                                case 2:
                                    love.setText(love.getText() + "\n애인과 같이 보면 좋을 영화 : 코미디 영화\n");
                                    break;
                                case 3:
                                    love.setText(love.getText() + "\n애인과 같이 보면 좋을 영화 : 옴니버스 영화\n");
                                    break;
                            }
                            break;

                        case 3:
                            switch (n.getSelectitem()) {
                                case 0:
                                    love.setText(love.getText() + "\n당신의 이상형 : 진지하고 꼼꼼한 연상\n");
                                    break;
                                case 1:
                                    love.setText(love.getText() + "\n당신의 이상형 : 말을 잘하고 매너가 좋은 사람\n");
                                    break;
                                case 2:
                                    love.setText(love.getText() + "\n당신의 이상형 : 열정적으로 사랑을 퍼주는 사람\n");
                                    break;
                                case 3:
                                    love.setText(love.getText() + "\n당신의 이상형 : 자상하고 따뜻한 내면을 가진 사람\n");
                                    break;
                                case 4:
                                    love.setText(love.getText() + "\n당신의 이상형 : 자신을 보호해주고 감싸주는 연하\n");
                                    break;
                            }
                            break;
                    }
                    break;






                case 3://심리테스트 인간관계를 선택했을 때
                    switch (n.getId()) {
                        case 0://공부 심리테스트 중 처음 심리테스트 선택

                            friend.setTextSize(27);

                            switch (n.getSelectitem()) {
                                case 0:
                                    friend.setText(friend.getText() + "\n친구를 사귀는 팁 : 친해지고 싶은 친구가 있다면 확실한 마음을 표현해주세요.\n");
                                    break;
                                case 1:
                                    friend.setText(friend.getText() + "\n친구를 사귀는 팁 : 싫은 내색을 겉으로 드러내지 않고 냉정한 태도를 줄이세요.\n");
                                    break;
                                case 2:
                                    friend.setText(friend.getText() + "\n친구를 사귀는 팁 : 용기를 내서 친구에게 다가가 보세요.\n");
                                    break;

                            }
                            break;

                        case 1:
                            switch (n.getSelectitem()) {
                                case 0:
                                    friend.setText(friend.getText() + "\n당신이 잡아야 할 사람의 특징 : 사소한 것 하나까지도 신경 써주는 사람\n");
                                    break;
                                case 1:
                                    friend.setText(friend.getText() + "\n당신이 잡아야 할 사람의 특징 : 당신의 숨겨진 면까지 발견해주는 사람\n");
                                    break;
                                case 2:
                                    friend.setText(friend.getText() + "\n당신이 잡아야 할 사람의 특징 : 당신과 함께 모든 취미 활동을 함께 해줄 사람\n");
                                    break;
                            }

                            break;

                        case 2:
                            switch (n.getSelectitem()) {
                                case 0:
                                    friend.setText(friend.getText() + "\n친구를 유지할 수 있는 팁 : 당신의 내면 속의 이야기를 털어놓아 깊숙한 사이를 유지해 보세요.\n");
                                    break;
                                case 1:
                                    friend.setText(friend.getText() + "\n친구를 유지할 수 있는 팁 : 오해가 생기거나 서운한 일이 있다면 쌓아두지 않고 바로 말해보세요!\n");
                                    break;
                                case 2:
                                    friend.setText(friend.getText() + "\n친구를 유지할 수 있는 팁 : 당신이 친구를 아끼는 마음을 친구에게 표현해 보세요.\n");
                                    break;
                                case 3:
                                    friend.setText(friend.getText() + "\n친구를 유지할 수 있는 팁 : 친구가 잘 해낸 일이 있다면, 질투가 아닌 축하한다는 메세지를 전해보세요.\n");
                                    break;
                            }
                            break;


                    }
                    break;

            }


        }

    }
}
