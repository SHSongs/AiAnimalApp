package com.example.appprogrammingproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;

public class Study extends Activity {

    Button one, two, three, four;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


        //버튼을 눌렀을때 dialog 띄운 후에 심리테스트 진행
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] item = new String[]{"계속 걷는다", "마차", "택시", "친구와 걷는다"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Study.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Study.this);

                a.setTitle("길을 걷고 있는 당신, 뭔가를 탈 수 있다면 선택할 수단을 골라주세요").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("쭉 걸어왔는데, 뭐 계속 걷자!");
                            result.setMessage("당신은 언제나 자신의 문제를 스스로 해결하는 타입입니다. 자립적이라는 말 자주 듣지 않나요? 눈에 띄는 " +
                                    "타입은 아니지만 혼자 궁금한 점을 차분히 해결해 나가는 편으로, 문제 앞에서 능동적인 태도를 보입니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 1) {


                            result.setTitle("귀족처럼 마차를 타고 가자!");
                            result.setMessage("당신은 어떤 문제를 마주해도 겁먹지 않고 적극적으로 풀어나가는 당찬 타입입니다. 혼자서 해결하기 보다는 해결을 위해서라면 어떤 " +
                                    "방법이든 적극적으로 나서고 질문합니다. 따라서 다른 친구들의 궁금증까지 도맡아 해결해주는 고마운 타입입니다. 공부 방법도 선생님, 선배들에게 질문하면서 지식을 얻는 편입니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 2) {

                            result.setTitle("역시 빠르게 갈 땐 택시지!");
                            result.setMessage("당신은 공부에 필요한 정보들을 정리하는 탁월한 능력의 소유자입니다. 공부 방법도 노트 정리 위주로 합니다. 다른 친구들에 비해 노트 필기가 꼼꼼할 텐데요. " +
                                    "하지만 단점이 있다면, 공부를 시작하기 전 책상 정리부터 시작해 공부 시간을 많이 빼앗길 수도 있습니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 3) {

                            result.setTitle("외롭지 않게 친구와 걸어야지!");
                            result.setMessage("당신은 이야기를 좋아하는 수다쟁이 타입입니다. 친구와 함께 문제를 풀거나 설명해 주고 퀴즈를 내면서 공부하는 것을 즐깁니다. " +
                                    "언제나 친구와 함께 하는 것을 좋아하는 당신은 말하는 걸 좋아해서 토론 능력이 남들보다 뛰어납니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        result.show();

                        long now = System.currentTimeMillis();
                        Date date = new Date(now);
                        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String getTime = simpleDate.format(date);


                        one.setText("1. 나의 공부 태도\n(테스트한 날짜 : " + getTime + ")");




                    }
                });
                a.setNegativeButton("취소", null);


                a.show();


            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] item = new String[]{"정사각형", "직사각형", "삼각형", "동그라미", "구불구불한 선"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Study.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Study.this);

                a.setTitle("마음에 드는 도형을 선택해주세요").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("정사각형");
                            result.setMessage("안정적인 환경과 분명한 방향이 제시되었을 때 편안함을 느끼는 사람입니다. 보수적인 성향이 있으며 딱 맞아떨어지고 정돈된 것을 좋아합니다. " +
                                    "아무리 반복적이고 성가신 일이더라도 일이 끝날 때까지 완벽히 해내는 완벽주의자입니다. " +
                                    "그래서 공부나 운동을 할 때도 정확한 계획이 세워져 있어야 안심이 되고 목표를 향해 달려갈 수 있습니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 1) {


                            result.setTitle("직사각형");
                            result.setMessage("정사각형을 좋아하는 사람과 비슷하게 규칙적인 것과 정돈된 것을 좋아합니다. 하지만 일을 할 때 수차례 회의를 거치는 등 " +
                                    "정해진 룰을 벗어나지 않으려고 하는 면이 있습니다. 또한 매우 세심하고 계획적인 사람이라고 할 수 있습니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 2) {

                            result.setTitle("삼각형");
                            result.setMessage("목표지향적인 사람입니다. 운동이나 학업을 하기 전 계획하여 실행합니다. 성취감에 다시 동기부여를 받는 사람이죠. " +
                                    "크고 장기적인 목표에 초점을 맞추는 편입니다. 그래서 때로는 작은 디테일을 놓치는 경우가 있습니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 3) {

                            result.setTitle("동그라미");
                            result.setMessage("사교적이고 의사소통이 원활하며 사글사글한 성격입니다. 이런 사람의 장점은 바로 유통성이 있다는 것이죠. " +
                                    "계획했던 일이 있어도 상황에 따라 조금씩 방향을 수정해 나갑니다. " +
                                    "또한 의사소통을 좋아하기 때문에 계획을 세울 때 주의 사람들의 의견을 많이 듣고 참고하는 경향이 있습니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 4) {
                            result.setTitle("구불구불한 선");
                            result.setMessage("예측할 수 없으며 창의적인 사람입니다. 새로운 일을 할 때 가장 기분이 좋아지며 반복적인 것을 싫어합니다. 어떤 일이 주어지면 가장 " +
                                    "새롭고 창의적인 아이디어를 떠올립니다. 그래서 계획을 세우고 어떤 일을 하기 보다는 즉흥적인 면이 있습니다. " +
                                    "때로는 이러한 계획성이 좋은 결과를 내기도 하지만, 때로는 목표에 도달하지 못할 때가 있어 조심해야 할 필요도 있습니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);
                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        result.show();

                        long now = System.currentTimeMillis();
                        Date date = new Date(now);
                        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String getTime = simpleDate.format(date);


                        two.setText("2. 나의 계획성\n(테스트한 날짜 : " + getTime + ")");


                    }
                });
                a.setNegativeButton("취소", null);


                a.show();


            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] item = new String[]{"동상을 마주본다", "동상에 몸을 기댄다", "동상은 필요없고 나만의 포즈를 취한다", "어깨동무를 한다"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Study.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Study.this);

                a.setTitle("당신은 멋진 동상을 발견했습니다! 어떤 자세로 사진을 찍을 건가요?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("다정하게 동상을 마주보고 포즈를 취한다");
                            result.setMessage("공부에 대한 욕심, 성공에 대한 욕심이 많은 사람입니다. 누군가에게 지기 싫어서 누구보다 열심히 하는 학자 스타일입니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 1) {


                            result.setTitle("동상에 기대는 편안한 포즈를 취한다");
                            result.setMessage("공부에 별로 관심이 없군요! 산만하다는 소리를 많이 듣지만 좋아하는 분야가 생기면 열심히 파는 자유로운 스타일입니다.");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 2) {

                            result.setTitle("동상을 무시하고 자신만의 포즈를 취한다");
                            result.setMessage("공부보다는 예체능에 재능이 더 많군요! 어디로 튈지 모르는 성격으로, 공부에 전념해서 스트레스를 받는 것보단 예체능에 도전해보세요!");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        } else if (i == 3) {

                            result.setTitle("어깨동무를 하고 사진을 찍는다");
                            result.setMessage("공부를 계속해서 하는 스타일은 아니지만, 꽤 만족하는 성적이 나오는 것 같네요. 공부에 대한 거부감이 없어 학습위주로 공부해 보세요!");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        }
                    }


                });

                a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        result.show();

                        long now = System.currentTimeMillis();
                        Date date = new Date(now);
                        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String getTime = simpleDate.format(date);


                        three.setText("3. 나의 공부 스타일\n(테스트한 날짜 : " + getTime + ")");


                    }
                });
                a.setNegativeButton("취소", null);


                a.show();

            }
        });


    }
}
