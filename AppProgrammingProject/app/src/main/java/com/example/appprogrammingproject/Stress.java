package com.example.appprogrammingproject;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;

import com.example.appprogrammingproject.database.DatabaseHelper;
import com.example.appprogrammingproject.database.model.Note;

public class Stress extends Activity {

    Button one, two, three, four;
    int cnt = 0;
    long now = System.currentTimeMillis();
    Date dateTime = new Date(now);
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String getTime = simpleDate.format(dateTime);
    final int[] select = {0};


    private DatabaseHelper db;
    private void createNote( int group, int select) {
        db.insertNote(0, group, select);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress);


        db = new DatabaseHelper(this);

        List<Note> n = db.getAllNotes();

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


        final String datePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/dateFolder";
        final File date = new File(datePath);

        date.mkdir();

        final String resultPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/resultFolder";
        final File result = new File(resultPath);

        result.mkdir();

        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);


        readData();
        //버튼을 눌렀을때 dialog 띄운 후에 심리테스트 진행
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] item = new String[]{"\uD83D\uDC35 원숭이", "\uD83D\uDC11 양", "\uD83D\uDC2E 소",
                        "\uD83D\uDC34 말", "\uD83E\uDD81 사자"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Stress.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Stress.this);


                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);



                a.setTitle("\uD83D\uDC18 어떤 동물과 여행을 함께 해야한다면, 어떤 동물과 함께 하겠습니까?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        select[0] = i;
                        if (i == 0) {

                            result.setTitle("\uD83D\uDC35 원숭이를 선택한 당신!");
                            result.setMessage("사람과의 관계에서 받는 스트레스가 가장 심하군요. 앞뒤가 다른 사람, 항상 무언가를 요구하기만 하는 사람, " +
                                    "자기주장만 하는 사람, 생각 없이 말 막하는 사람 등 아무리 이해하려고 해도 쉽게 이해되지 않는 사람들이 있어요. " +
                                    "오해가 더 쌓이기 전에 마음을 터놓고 깊이 있는 대화가 필요하지만, 쉽지 않아 스트레스를 받고 있네요.");


                        } else if (i == 1) {


                            result.setTitle("\uD83D\uDC11 양을 선택한 당신!");
                            result.setMessage("사랑하는 사람과의 연애에서 오는 스트레스가 있군요. 나와 다른 환경에서 살아온 연인의 행동과 생각, " +
                                    "생활방식 등이 많이 다르다는 것을 알지만, 상대방의 행동이 이해되지 않고 짜증나는 상황들이 많아요. " +
                                    "이런 상황들을 밤새 생각한다면 정신건강에 해롭답니다. 만약 연애를 하지 않고 싱글인 당신이라면 누군가를 만나 연애를 해야 한다는 강박관념이 있어요.");


                        } else if (i == 2) {

                            result.setTitle("\uD83D\uDC2E 소를 선택한 당신!");
                            result.setMessage("일과 성공에 대한 스트레스가 많군요! 공부와 미래에 대한 걱정과 고민이 많아요. 모든 일에 완벽을 기할 필요는 없답니다. " +
                                    "지금 갖고 있는 중압감과 불안에서 벗어날 필요가 있어 보이네요!");


                        } else if (i == 3) {

                            result.setTitle("\uD83D\uDC34 말을 선택한 당신!");
                            result.setMessage("항상 똑같은 일상에 지루함을 느끼는군요. 남들과 같은 일상에 염증을 느끼시나요? " +
                                    "늘 반복되는 하루에 지친 당신은 집중하고 즐길 수 있는 일을 찾고 있어요. " +
                                    "하지만 새로운 관심사는 없고 일상에서 무료함을 느끼면서 스트레스를 받고 있네요!");


                        } else if (i == 4) {

                            result.setTitle("\uD83E\uDD81 사자를 선택한 당신!");
                            result.setMessage("자존심이 무척 강하시군요. 다른 사람이 자신을 무시하는 태도를 보이면 화가 나고, 다른 사람과 비교 당하면 쉽게 상처받기도 합니다. " +
                                    "누군가 내 행동을 지적하는 것 같으면 위축되기도 해요. 자존심에 상처를 받을 때 스트레스를 받고 있네요.");


                        }


                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        createNote( 1, select[0]);

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

                final String[] item = new String[]{"\uD83D\uDC74\uD83C\uDFFB 길을 잃은 노인", "\uD83D\uDE2D 우는 아이", "\uD83D\uDC69\u200D⚕  물건을 떨어트린 간호사", "\uD83E\uDDB5 넘어지려는 사람"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Stress.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Stress.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);



                a.setTitle("\uD83D\uDC81\uD83C\uDFFC 누구를 먼저 도우시겠어요?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        select[0] = i;
                        if (i == 0) {

                            result.setTitle("\uD83D\uDC74\uD83C\uDFFB 길을 잃은 노인을 선택하셨네요!");
                            result.setMessage("당신은 전통적인 매너를 지킵니다. 무슨 일이 일어나더라도 항상" +
                                    "합리성을 가지고 결정을 내리는군요. 늘 결과까지 염두에 두고 생각하는 당신!" +
                                    "당신은 다른사람들이 발견하지 못한 흔하지 않은 분야를 탐구하고 좋아하지 않나요?" +
                                    "그런 모습에 많은 사람들이 존경하고 있네요.");


                        } else if (i == 1) {


                            result.setTitle("\uD83D\uDE2D 우는 아이를 선택하셨네요!");
                            result.setMessage("당신은 대단한 공감능력과 민감한 마음을 가지고있어 종종 상처를 입는군요. 당신은 대개 사람들을 " +
                                    "매우 쉽게 신뢰해서 배반을 당하면 충격을 많이 받는 타입입니다. 확실히 당신의 친구들은 당신에게 \"" +
                                    "어디 가서 당하지 말아라\"라고 말한 적이 있겠군요. 사실 친구들이 그러는건 다 걱정 때문인거\n" +
                                    " 아시죠? 당신을 사랑스럽게 생각한답니다.");


                        } else if (i == 2) {

                            result.setTitle("\uD83D\uDC69\u200D⚕️ 물건을 떨어트린 간호사를 선택했네요!");
                            result.setMessage("당신은 정말 낙천적인 사람이군요! 당신은 다른 사람들이 눈치채지 못하는 아름다움까지" +
                                    "느낄 수 있는 사람입니다. 문제가 있을 때마다 공평한 판단을 내리고 싶어하고요. 삶이 때때로" +
                                    "어려워 질지라도, 당신은 낙관적인 성격을 유지합니다. 그래서 모든 사람들이 당신과 어울리고 싶어 하는군요!");


                        } else if (i == 3) {

                            result.setTitle("\uD83E\uDDB5 넘어지려는 사람을 선택했네요!");
                            result.setMessage("당신없이 즐겁고 재미있는 모임을 가질 순 없을거예요. 다른 사람들은 당신을 " +
                                    "리더로 생각해요. 당신은 본인도 모르게 주변을 끌어당기고 설득하는 법을 알고 있습니다!" +
                                    "목표를 한번 설정하면 멈출 줄 모르는군요! 그런 모습에 많은 사람들이 당신을 따르려고 하네요.");


                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


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

                final String[] item = new String[]{"\uD83D\uDE2A 정면으로", "\uD83D\uDE2B 엎드려서", "⏰ 왼쪽으로", "\uD83D\uDCA4 오른쪽으로"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Stress.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Stress.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);


                a.setTitle("\uD83D\uDECC 당신은 잠들 때 어떤 모습인가요?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                        if (i == 0) {

                            result.setTitle("\uD83D\uDE2A 정면으로");
                            result.setMessage("당신은 사고방식이 독특한 개성있는 매력의 소유자입니다. 소신과 주관이 뚜렷하며 " +
                                    "자신만의 사고방식으로 놀라운 발상을 하네요. 감정적인 면에서 단순하고 천진난만하며 증오나" +
                                    "배신감을 갖게 되어도 금세 잊고 떨쳐내고 있네요.");

                        } else if (i == 1) {


                            result.setTitle("\uD83D\uDE2B 엎드려서");
                            result.setMessage("당신은 사람들 시선에 신경쓰는 편이며 사람을 잃는 것에 대한 두려움이 있어" +
                                    "싸움이 생겨도 항상 중립의 입장을 유지합니다. 겉으로는 쿨해보이고 도도하지만 사실 속으로는 여린사람!");


                        } else if (i == 2) {

                            result.setTitle("⏰ 왼쪽으로");
                            result.setMessage("당신은 매우 상냥하고 주변 사람들에게 잘 베푸는 친절한 사람입니다." +
                                    "차분한 성격으로 어떤 일이 닥쳐도 차분하게 대처합니다. 마음이 여려서 쉽게 감동받고 " +
                                    "눈물도 많은 편이며 주변 사람들은 당신에게 포근함을 느껴 당신을 의지하고 따릅니다.");

                        } else if (i == 3) {

                            result.setTitle("\uD83D\uDCA4 오른쪽으로");
                            result.setMessage("참을성이 많은 당신은 안 좋은 일이 생겨도 마음에 담아 두고 인내하는 편입니다." +
                                    "감수성이 풍부하고 사려깊은 당신은 친구들의 이야기도 자기일처럼 공감하며 들어줍니다.");

                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        result.show();



                    }
                });
                a.setNegativeButton("취소", null);


                a.show();

            }
        });


    }

    private void readData() {

        List<Note> notes = db.getAllNotes();
        for(Note n : notes){
            String date = n.getTimestamp();

            switch (n.getId()) {
                case 0:
                    one.setText("1.\uD83D\uDE1E 스트레스 원인\n(테스트한 날짜: " + date + ")");
                    one.setBackgroundColor(Color.GRAY);
                    one.setTextColor(Color.WHITE);
                    break;
                case 1:

                    break;
                case 2:

                    break;

            }
        }

    }
}
