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

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;

public class Stress extends Activity {

    Button one, two, three, four;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


        //버튼을 눌렀을때 dialog 띄운 후에 심리테스트 진행
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] item = new String[]{"원숭이", "양", "소", "말", "사자"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Stress.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Stress.this);

                a.setTitle("어떤 동물과 여행을 함께 해야한다면, 어떤 동물과 함께 하겠습니까?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("원숭이를 선택한 당신!");
                            result.setMessage("사람과의 관계에서 받는 스트레스가 가장 심하군요. 앞뒤가 다른 사람, 항상 무언가를 요구하기만 하는 사람, " +
                                    "자기주장만 하는 사람, 생각 없이 말 막하는 사람 등 아무리 이해하려고 해도 쉽게 이해되지 않는 사람들이 있어요. " +
                                    "오해가 더 쌓이기 전에 마음을 터놓고 깊이 있는 대화가 필요하지만, 쉽지 않아 스트레스를 받고 있네요.");


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


                            result.setTitle("양을 선택한 당신!");
                            result.setMessage("사랑하는 사람과의 연애에서 오는 스트레스가 있군요. 나와 다른 환경에서 살아온 연인의 행동과 생각, " +
                                    "생활방식 등이 많이 다르다는 것을 알지만, 상대방의 행동이 이해되지 않고 짜증나는 상황들이 많아요. " +
                                    "이런 상황들을 밤새 생각한다면 정신건강에 해롭답니다. 만약 연애를 하지 않고 싱글인 당신이라면 누군가를 만나 연애를 해야 한다는 강박관념이 있어요.");


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

                            result.setTitle("소를 선택한 당신!");
                            result.setMessage("일과 성공에 대한 스트레스가 많군요! 공부와 미래에 대한 걱정과 고민이 많아요. 모든 일에 완벽을 기할 필요는 없답니다. " +
                                    "지금 갖고 있는 중압감과 불안에서 벗어날 필요가 있어 보이네요!");


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

                            result.setTitle("말을 선택한 당신!");
                            result.setMessage("항상 똑같은 일상에 지루함을 느끼는군요. 남들과 같은 일상에 염증을 느끼시나요? " +
                                    "늘 반복되는 하루에 지친 당신은 집중하고 즐길 수 있는 일을 찾고 있어요. " +
                                    "하지만 새로운 관심사는 없고 일상에서 무료함을 느끼면서 스트레스를 받고 있네요!");


                            result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(main);
                                    finish();
                                }
                            });

                            result.setNegativeButton("계속 하기", null);

                        }else if (i == 4) {

                            result.setTitle("사자를 선택한 당신!");
                            result.setMessage("자존심이 무척 강하시군요. 다른 사람이 자신을 무시하는 태도를 보이면 화가 나고, 다른 사람과 비교 당하면 쉽게 상처받기도 합니다. " +
                                    "누군가 내 행동을 지적하는 것 같으면 위축되기도 해요. 자존심에 상처를 받을 때 스트레스를 받고 있네요.");


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

                final AlertDialog.Builder result = new AlertDialog.Builder(Stress.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Stress.this);

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


                        one.setText("1. 나의 공부 태도\n(테스트한 날짜 : " + getTime + ")");


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

                final AlertDialog.Builder result = new AlertDialog.Builder(Stress.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Stress.this);

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


                        one.setText("1. 나의 공부 태도\n(테스트한 날짜 : " + getTime + ")");


                    }
                });
                a.setNegativeButton("취소", null);


                a.show();

            }
        });


    }
}
