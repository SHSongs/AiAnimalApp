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

public class Love extends Activity {

    Button one, two, three, four;
    long now = System.currentTimeMillis();
    Date dateTime = new Date(now);
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String getTime = simpleDate.format(dateTime);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.love);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


        //버튼을 눌렀을때 dialog 띄운 후에 심리테스트 진행
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] item = new String[]{"\uD83C\uDF4E 사과", "\uD83C\uDF4C 바나나", "\uD83C\uDF47 포도", "\uD83C\uDF53 딸기"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Love.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Love.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83C\uDFB0 과일을 선물받은 당신! 무슨 과일을 먼저 맛보시겠어요?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("\uD83C\uDF4E 사과를 선택한 당신!");
                            result.setMessage("친구에서 연인으로 발전하는 경우가 많다고 해요! 연인이 되어서도 친구처럼" +
                                    "편안하게 지낼 수 있는 편안한 연애를 추구하는 타입이에요.");

                        } else if (i == 1) {


                            result.setTitle("\uD83C\uDF4C 바나나를 선택한 당신!");
                            result.setMessage("로맨틱한 사랑을 꿈꾸는 낭만적인 성격이면서도 매우 꼼꼼한 면이 있는 타입이에요." +
                                    "특히 현실과 이상에 대한 계획을 구체적으로 세우면서 연애를 하는 편이랍니다!");


                        } else if (i == 2) {

                            result.setTitle("\uD83C\uDF47 포도를 선택한 당신!");
                            result.setMessage("상대방의 마음을 얻을 때까지 반복해서 도전하는 타입이에요. 특히 사랑 앞에서는" +
                                    "조건을 따지지 않고 열정적으로 사랑하는 특징이 있어요!");


                        } else if (i == 3) {

                            result.setTitle("\uD83C\uDF53 딸기를 선택한 당신!");
                            result.setMessage("조건을 따지지 않는 순수한 연애를 하는 스타일로 연인 앞에서 순수한 아이처럼" +
                                    "행동하는 편이에요. 막상 내면에는 성숙한 모습을 갖고 있는 경우도 많답니다.");


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

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] item = new String[]{"\uD83D\uDD7A\uD83C\uDFFC 신나게 탬버린을 들고 춤춘다", "\uD83C\uDF99️ 앞에 나서서 노래를 부른다", "\uD83E\uDDEE 열심히 노래의 번호를 검색한다", "\uD83D\uDC4F 열심히 박수를 쳐준다"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Love.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Love.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83D\uDCDF 별로 친하지 않은 친구와 노래방을 갔다. 그런 자리에서 당신의 행동은?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("\uD83D\uDD7A\uD83C\uDFFC 신나게 탬버린을 들고 춤춘다");
                            result.setMessage("당신은 상당한 수준의 프로라고 할 수 있어요. 삼각, 사각 관계로 연애 폭탄을 맞아도 나름대로 해결책이 있네요. " +
                                    "조금 더 연애 패턴을 발전시킨다면 분명히 멋진 사랑에 성공할 거예요.\n" +
                                    "하지만 마지막에 방심해서 실연할 수도 있으니 처음 화끈했던 것처럼 끝까지 힘 조절이 필요합니다.");


                        } else if (i == 1) {


                            result.setTitle("\uD83C\uDF99️ 앞에 나서서 노래를 부른다");
                            result.setMessage("당신은 연애엔 빵점이에요..!" +
                                    "법칙에 얽매이는 건 질색인 당신." +
                                    "물론 자신에게 솔직하고 자유분방한 건 멋지지만 상대에게는 상처를 안겨줄 수 있어요." +
                                    "내 마음을 표현하기 전에 '그 사람이라면 어떨까?'라고 입장을 바꿔 생각해보고 행동한다면," +
                                    "지금보다 연애 성공률이 훨씬 높을 거예요.");


                        } else if (i == 2) {

                            result.setTitle("\uD83E\uDDEE 노래방 책을 뒤지며 열심히 번호를 찍어댄다");
                            result.setMessage("당신은 연애에 있어서 최고의 매너남 / 매너녀입니다." +
                                    "주변 상황을 판단하는 능력이 뛰어난 당신." +
                                    "하지만 모든 사람에게 친절하고 싹싹한 당신의 모습이 연인에겐 달갑지 않겠죠?" +
                                    "당신의 연인에겐 더욱 특별한 배려를 잊지 마세요! 때로는 틀에 얽매이지 말고 " +
                                    "자유롭게 사랑을 표현하는 게 당신을 향한 연인의 애정도를 높여줄 겁니다.");


                        } else if (i == 3) {

                            result.setTitle("\uD83D\uDC4F 의자에 앉아서 열심히 손뼉을 친다");
                            result.setMessage("당신은 지금부터 연애 학습을 착실히 쌓아야 해요." +
                                    "아직까지 자신만의 기준에서 벗어나지 못하고 있기 때문에 연애가 힘들게 느껴지는 거죠." +
                                    "상대방을 내 기준에 맞추려는 버릇이 아직도 남아있는 당신." +
                                    "일단 양보하는 자세를 배우고 실패 원인이 뭔지를 파악한 뒤에 연애를 시작한다면" +
                                    "당신에게도 정열적인 사랑이 찾아온답니다.");


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

                final String[] item = new String[]{"\uD83D\uDC12 꼬마 원숭이", "\uD83D\uDC31 길고양이", "\uD83D\uDC30 토끼", "\uD83D\uDC3B 곰"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Love.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Love.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83C\uDF33 숲 속에서 길을 잃어버렸네요, 어떤 동물에게 길 안내를 부탁할까요?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("\uD83D\uDC12 꼬마원숭이를 선택하셨네요!");
                            result.setMessage("당신은 결혼을 했다고 해도 가정에 얽매이는 것을 좋아하지 않는답니다!" +
                                    "항상 독신 감각이나 연애 감정을 지키고 싶어 하는 당신." +
                                    "부부지간이라도 서로의 프라이버시를 존중하고 자유롭게 각자의 삶을 즐기기를 원하고 있네요");


                        } else if (i == 1) {


                            result.setTitle("\uD83D\uDC31 길고양이를 선택하셨네요!");
                            result.setMessage("일적인 부분에서 서로 간섭을 하지 않고" +
                                    "존중해 주는 것이 이상적이라고 생각하는 당신." +
                                    "서로 하고 싶은 일이나 취미 생활은 존중하면서" +
                                    "막상 가정으로 돌아오면 서로에게 충실하기를 원하고 있으며" +
                                    "기념일이나 특별한 날은 꼭 챙기는 로맨틱한 결혼 생활을 꿈꾸고 있네요" +
                                    "서로의 개인적인 부분은 존중하면서도 사랑은 지키는" +
                                    "아주 현명하고 똑똑한 결혼 생활을 할 수 있겠네요.");


                        } else if (i == 2) {

                            result.setTitle("\uD83D\uDC30 토끼를 선택하셨네요!");
                            result.setMessage("당신의 이상적인 결혼 생활은 지극히 좋은 아내/좋은 남편이 되는 거예요" +
                                    "안정된 가정을 꾸리고 싶어 하는 타입이랍니다" +
                                    "결혼을 했다면 가족의 행복이 가장 중요하다고 생각하는 당신." +
                                    "아내는 아내로서, 남편은 남편으로서 최선을 다해서 가정을 이끌어 가겠네요" +
                                    "거기다 경제적으로도 풍족한 행복한 가정을 당신은 꿈꾸고 있어요.");


                        } else if (i == 3) {

                            result.setTitle("\uD83D\uDC3B 곰을 선택하셨네요!");
                            result.setMessage("당신이 생각하는 가정이란 무조건 편하고 여유로워야 해요" +
                                    "그렇기 때문에 당신이 바깥에서 힘들고 지쳐 있다가도" +
                                    "집에 돌아온다면 자신을 감싸주고 피로를 풀어줘야 한다고 생각하지요" +
                                    "최대한 편한 옷차림으로 지낼 수 있고" +
                                    "불편할 것이 하나도 없는 안락한 가정을 당신은 꿈꾸고 있답니다!");

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

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] item = new String[]{"\uD83E\uDD5D 과일", "\uD83C\uDF61 떡", "\uD83D\uDCFF 구슬", "\uD83D\uDCB0 돈", "\uD83D\uDC8D 반지"};

                final AlertDialog.Builder result = new AlertDialog.Builder(Love.this);

                final AlertDialog.Builder a = new AlertDialog.Builder(Love.this);

                result.setPositiveButton("홈으로 돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });

                result.setNegativeButton("계속 하기", null);

                a.setTitle("\uD83D\uDEF8 눈 앞에 잡고싶은 물건이 여러개 있다. 제일 먼저 무엇을 잡을까?").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        if (i == 0) {

                            result.setTitle("\uD83E\uDD5D 과일");
                            result.setMessage("생각이 많고 진지해보이는 연상이 이상형이네요!");


                        } else if (i == 1) {


                            result.setTitle("\uD83C\uDF61 떡");
                            result.setMessage("말을 잘하고 매너가 좋은 사람이 이상형이네요!");


                        } else if (i == 2) {

                            result.setTitle("\uD83D\uDCFF 구슬");
                            result.setMessage("열정적이고 사랑을 퍼주는 사람이 이상형이네요!");


                        } else if (i == 3) {

                            result.setTitle("\uD83D\uDCB0 돈");
                            result.setMessage("부드러운 인상과 따뜻한 내면을 가진 사람이 이상형이네요!");


                        } else if (i == 4) {

                            result.setTitle("\uD83D\uDC8D 반지");
                            result.setMessage("자신을 보호해줄 수 있는 연하가 이상형이네요!");


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
}
