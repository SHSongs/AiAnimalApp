package com.example.appprogrammingproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.appprogrammingproject.database.DatabaseHelper;
import com.example.appprogrammingproject.database.model.Note;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;

public class Friend extends Activity {

    Button one, two, three, four;
    long now = System.currentTimeMillis();
    Date dateTime = new Date(now);
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String getTime = simpleDate.format(dateTime);
    private DatabaseHelper db;

    private void createNote(int group, int id, int select) {
        db.insertNote(id, group, select);
        readData();
    }

    final int[] select = {0};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);

        db = new DatabaseHelper(this);

        List<Note> n = db.getAllNotes();

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


        readData();

        //버튼을 눌렀을때 dialog 띄운 후에 심리테스트 진행
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] item = new String[]{"\uD83C\uDF4A 베이지나 오렌지색 계열", "\uD83C\uDF3A 핑크 또는 꽃무늬", "\uD83D\uDC0B 블루, 그린 계열"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Friend.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Friend.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83D\uDD6F️ 식탁보를 바꾸려는 당신, 무슨 색으로 바꿀까?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        select[0] = i;//선택한 것을 select에 넣어줌

                        if (i == 0) {

                            result.setTitle("\uD83C\uDF4A 베이지나 오렌지색 계열");
                            result.setMessage("어떤 사람이라도 친구가 될 준비가 되어있네요. 당신은 어떤 사람이라도" +
                                    "상당히 관용적으로 받아들일 수 있는 사람입니다. 하지만 그런 태도가 주위에서 보면" +
                                    "'아무에게나 잘하는 사람'으로 보여질 수도 있으니 확실한 태도가 필요해요!");


                        } else if (i == 1) {

                            result.setTitle("\uD83C\uDF3A 핑크 또는 꽃무늬");
                            result.setMessage("좋고 싫음이 뚜렷하여 사람을 대하는 태도에도 크게 차이가 나는 타입입니다." +
                                    "좋아하는 사람에게는 먼저 다가가 감동을 주지만, 싫어하는 사람에게는 냉정한 태도를 티가나게 취하네요." +
                                    "적어도 싫은 내색을 겉으로 드러내지 않는 태도도 필요할 듯 싶네요.");


                        } else if (i == 2) {

                            result.setTitle("\uD83D\uDC0B 블루, 그린 계열");
                            result.setMessage("스스로 관계를 피해버리는 타입! 당신은 사람을 만나기 두려워하네요." +
                                    "가끔은 용기를 내서 먼저 다가가보세요!");


                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        createNote(3, 0, select[0]);
                        result.show();


                    }
                });
                a.setNegativeButton("취소", null);


                a.show();


            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] item = new String[]{"\uD83D\uDC48 왼쪽 자리", "\uD83C\uDF1F 가운데 자리", "\uD83D\uDC49 오른쪽 자리"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Friend.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Friend.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83C\uDF78 식당에 혼자 간 당신, 어디에 앉으시겠습니까?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        select[0] = i;

                        if (i == 0) {

                            result.setTitle("\uD83D\uDC48 왼쪽자리를 선택하셨네요!");
                            result.setMessage("모든 사람에게 친절을 베푸는 당신의 대인관계는 계속 확장 중!" +
                                    "작은 인연까지 모두 소중하게 여기기 때문에 마주치는 사람에게 상냥한 인사는 기본! " +
                                    "항상 먼저 다가간다는 인상을 주고 있습니다. 상대방 또한 당신에게 호감을 느끼기 때문에 시간이 지날수록 친근감을 갖게 됩니다!" +
                                    "이런 과정을 거쳐 당신의 인맥은 시간이 지날수록 넓어지게 됩니다. 전국 팔도 아니, 전 세계 사람과 모두 친구가 될 수 있는 가능성을 지니고 있네요!!");


                        } else if (i == 1) {


                            result.setTitle("\uD83C\uDF1F 가운데 자리를 선택하셨네요!");
                            result.setMessage("지금 내 사람에게 최선을 다하는 당신의 대인관계는 집중형!" +
                                    "지금까지 내 옆에 있어주고 함께 해 온 사람들에 대한 의리가 매우 깊으며 이 우정과 사랑을 평생 간직하길 원하고 있습니다. " +
                                    "새로운 것보다는 익숙한 것을 더 좋아하는 성향이 있는 편이네요" +
                                    "시간이 지남에 따라 여러 사람을 만나게 되지만, 가식 없는 100% 리얼하게 편한 상대를 만나기는 쉽지 않죠! " +
                                    "한 번 맺은 인연을 평생 간직하는 순정파, 의리파입니다!!");


                        } else if (i == 2) {

                            result.setTitle("\uD83D\uDC49 오른쪽 자린를 선택했네요!");
                            result.setMessage("복잡하게 얽히고 섥히는 것을 싫어하는 당신의 대인관계는 자유형! " +
                                    "가뜩이나 복잡한 세상 인간관계까지 복잡하게 생각하기를 거부하는 자유로운 영혼의 소유자! " +
                                    "집착보다는 현재의 기분과 상황을 우선시하는 성향으로 예측 불가능한 통통 튀는 매력을 가지고 있네요" +
                                    "쿨한 성격 탓에 가식이 없으며 좋고 싫은 것을 표현하는 데 익숙합니다! 오히려 이런 자유로운 분위기에 이끌려 " +
                                    "당신을 찾는 사람들이 주변에 매우 많을 가능성이 높아 보이네요!!");


                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        createNote(3, 1, select[0]);

                        result.show();


                    }
                });
                a.setNegativeButton("취소", null);


                a.show();


            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] item = new String[]{"\uD83D\uDD90 손수건", "\uD83D\uDC96 내가 좋아하는 것", "\uD83E\uDD57 내가 직접 만든 것", "\uD83C\uDF1F 요즘 인기있는 물건"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Friend.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Friend.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83C\uDF81 당신은 친한 친구에게 어떤 선물을 줄건가요?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        select[0] = i;
                        if (i == 0) {

                            result.setTitle("\uD83D\uDD90 손수건");
                            result.setMessage("당신은 친구와 분명한 과계를 맺는 스타일은 아니네요. " +
                                    "주변에 사람이 많기는 하지만 친구라 하기엔 애매한 관계가 많습니다. " +
                                    "진정한 친구가 없다고 느껴 불평하기도 하지만 외로움을 잘 타지 않는 타입이네요.");


                        } else if (i == 1) {

                            result.setTitle("\uD83D\uDC96 내가 좋아하는 것");
                            result.setMessage("당신은 친구를 가려서 사귀는 편이지만 결코 모든 좋은 친구는 아닙니다." +
                                    "세상에 나를 중심으로 움직인다고 생각하여 자신이 마음에 들지 않으면 쉽게 관계를 끊어버립니다. " +
                                    "그렇기 때문에 당신이 원하는 친구관계를 이루는 것은 쉽지 않을 것 같네요. ");


                        } else if (i == 2) {

                            result.setTitle("\uD83E\uDD57 내가 직접 만든 것");
                            result.setMessage("당신은 타인에게 피해를 주지 않으려고 배려심이 깊은 행동들을 보여주네요." +
                                    "기본적으로 당신은 우정을 중요시 여겨 좋은 친구관계를 유지하고 있네요.");


                        } else if (i == 3) {

                            result.setTitle("\uD83C\uDF1F 요즘 인기있는 물건");
                            result.setMessage("당신은 당신을 돋보이게 할 수 있는 친구를 사귀는 편이군요." +
                                    "간혹가다 친구를 질투하기도 하고요. 물론 당연한 현상이지만, 조금 더 " +
                                    "가까이에서 좋은 친구를 사귀어 보는건 어떨까요?");


                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        createNote(3, 2, select[0]);
                        result.show();


                    }
                });
                a.setNegativeButton("취소", null);


                a.show();

            }
        });
    }

    private void readData() {

        List<Note> notes = db.getGroupNotes(3);
        for (Note n : notes) {
            String date = n.getTimestamp();
            int select = n.getSelectitem();
            Button btn = null;

            Intent intent=new Intent(getApplicationContext(),Recommend.class);
            intent.putExtra("select","select");

            switch (n.getId()) {
                case 0:
                    btn = one;
                    one.setText("1. \uD83D\uDE0A 나의 인간관계" + "\n(테스트한 날짜: " + date + ")"); //버튼의 텍스트에 테스트한 날짜를 뒤에 추가.
                    break;
                case 1:
                    btn = two;
                    two.setText("2. \uD83D\uDC6A 내가 속해있는 대인관계 유형 " + "\n(테스트한 날짜: " + date + ")");
                    break;
                case 2:
                    btn = three;
                    three.setText("3. \uD83D\uDE4B 내가 인간관계를 만들어가는 방법" + "\n(테스트한 날짜: " + date + ")");
                    break;

            }

            try {
                btn.setBackgroundColor(Color.GRAY); //이미 끝낸 심리테스트는 배경을 회색과 폰트는 흰색으로 바꿈.
                btn.setTextColor(Color.WHITE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}