package com.example.matchingpuzzlegame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    MediaPlayer l1Bgm;
    MediaPlayer goodluck;
    MediaPlayer highscore;
    MediaPlayer wrong2;
    MediaPlayer great;

    Button restart;
    private View decorView;
    TextView tv_tried, tv_correct;
    ImageView iv_1, iv_2, iv_3, iv_4, iv_5, iv_6, iv_7, iv_8, iv_9, iv_10, iv_11, iv_12;

    Integer [] cardsArray = {1,2,3,4,5,6,7,8,9,10,11,12};
    int image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12;

    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    DecimalFormat df = new DecimalFormat("######0.00");
    double score1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        l1Bgm = MediaPlayer.create(MainActivity.this,R.raw.bgm_l1);
        l1Bgm.start();

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setTitle("Quick Guide")
                .setMessage("Please randomly open any two question cards. If the animal pictures under the question cards are same, then they will disappear together; If different, then try to remember them.\n\nOnly you clear all the question cards, you pass this level.")
                .setCancelable(false)
                .setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goodluck = MediaPlayer.create(MainActivity.this,R.raw.but_goodluck);
                        goodluck.start();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        restart = (Button)findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_tried = (TextView)findViewById(R.id.tv_tried);
        tv_correct = (TextView)findViewById(R.id.tv_correct);

        iv_1 = (ImageView) findViewById(R.id.im_1);
        iv_2 = (ImageView) findViewById(R.id.im_2);
        iv_3 = (ImageView) findViewById(R.id.im_3);
        iv_4 = (ImageView) findViewById(R.id.im_4);
        iv_5 = (ImageView) findViewById(R.id.im_5);
        iv_6 = (ImageView) findViewById(R.id.im_6);
        iv_7 = (ImageView) findViewById(R.id.im_7);
        iv_8 = (ImageView) findViewById(R.id.im_8);
        iv_9 = (ImageView) findViewById(R.id.im_9);
        iv_10 = (ImageView) findViewById(R.id.im_10);
        iv_11 = (ImageView) findViewById(R.id.im_11);
        iv_12 = (ImageView) findViewById(R.id.im_12);

        iv_1.setTag("0");
        iv_2.setTag("1");
        iv_3.setTag("2");
        iv_4.setTag("3");
        iv_5.setTag("4");
        iv_6.setTag("5");
        iv_7.setTag("6");
        iv_8.setTag("7");
        iv_9.setTag("8");
        iv_10.setTag("9");
        iv_11.setTag("10");
        iv_12.setTag("11");

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        iv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_1, theCard);
            }
        });

        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_2, theCard);
            }
        });

        iv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_3, theCard);
            }
        });

        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_4, theCard);
            }
        });

        iv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_5, theCard);
            }
        });

        iv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_6, theCard);
            }
        });

        iv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_7, theCard);
            }
        });

        iv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_8, theCard);
            }
        });

        iv_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_9, theCard);
            }
        });

        iv_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_10, theCard);
            }
        });

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);
            }
        });


    }

    private void doStuff(ImageView iv, int card) {
        if (cardsArray[card] == 1) {
            iv.setImageResource(image1);
        } else if (cardsArray[card] == 2) {
            iv.setImageResource(image2);
        } else if (cardsArray[card] == 3) {
            iv.setImageResource(image3);
        } else if (cardsArray[card] == 4) {
            iv.setImageResource(image4);
        } else if (cardsArray[card] == 5) {
            iv.setImageResource(image5);
        } else if (cardsArray[card] == 6) {
            iv.setImageResource(image6);
        } else if (cardsArray[card] == 7) {
            iv.setImageResource(image7);
        } else if (cardsArray[card] == 8) {
            iv.setImageResource(image8);
        } else if (cardsArray[card] == 9) {
            iv.setImageResource(image9);
        } else if (cardsArray[card] == 10) {
            iv.setImageResource(image10);
        } else if (cardsArray[card] == 11) {
            iv.setImageResource(image11);
        } else if (cardsArray[card] == 12) {
            iv.setImageResource(image12);
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 6) {
                firstCard = firstCard - 6;
            }
            cardNumber = 2;
            clickFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 6) {
                secondCard = secondCard - 6;
            }
            cardNumber = 1;
            clickSecond = card;

            iv_1.setEnabled(false);
            iv_2.setEnabled(false);
            iv_3.setEnabled(false);
            iv_4.setEnabled(false);
            iv_5.setEnabled(false);
            iv_6.setEnabled(false);
            iv_7.setEnabled(false);
            iv_8.setEnabled(false);
            iv_9.setEnabled(false);
            iv_10.setEnabled(false);
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },700);

        }

    }

    private void calculate() {
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.sample_anim);
        Animation animation2= AnimationUtils.loadAnimation(MainActivity.this,R.anim.sample_anim2);
        if (firstCard == secondCard) {
            if (clickFirst == 0) {
                iv_1.startAnimation(animation);
                iv_1.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 1) {
                iv_2.startAnimation(animation);
                iv_2.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 2) {
                iv_3.startAnimation(animation);
                iv_3.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 3) {
                iv_4.startAnimation(animation);
                iv_4.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 4) {
                iv_5.startAnimation(animation);
                iv_5.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 5) {
                iv_6.startAnimation(animation);
                iv_6.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 6) {
                iv_7.startAnimation(animation);
                iv_7.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 7) {
                iv_8.startAnimation(animation);
                iv_8.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 8) {
                iv_9.startAnimation(animation);
                iv_9.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 9) {
                iv_10.startAnimation(animation);
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 10) {
                iv_11.startAnimation(animation);
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 11) {
                iv_12.startAnimation(animation);
                iv_12.setVisibility(View.INVISIBLE);
            }

            if (clickSecond == 0) {
                iv_1.startAnimation(animation2);
                iv_1.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 1) {
                iv_2.startAnimation(animation2);
                iv_2.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 2) {
                iv_3.startAnimation(animation2);
                iv_3.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 3) {
                iv_4.startAnimation(animation2);
                iv_4.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 4) {
                iv_5.startAnimation(animation2);
                iv_5.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 5) {
                iv_6.startAnimation(animation2);
                iv_6.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 6) {
                iv_7.startAnimation(animation2);
                iv_7.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 7) {
                iv_8.startAnimation(animation2);
                iv_8.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 8) {
                iv_9.startAnimation(animation2);
                iv_9.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 9) {
                iv_10.startAnimation(animation2);
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 10) {
                iv_11.startAnimation(animation2);
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 11) {
                iv_12.startAnimation(animation2);
                iv_12.setVisibility(View.INVISIBLE);
            }

            great = MediaPlayer.create(MainActivity.this,R.raw.but_great);
            great.start();

            playerPoints++;
            tv_correct.setText("Correct: "+playerPoints);

        } else {
            iv_1.setImageResource(R.drawable.cover);
            iv_2.setImageResource(R.drawable.cover);
            iv_3.setImageResource(R.drawable.cover);
            iv_4.setImageResource(R.drawable.cover);
            iv_5.setImageResource(R.drawable.cover);
            iv_6.setImageResource(R.drawable.cover);
            iv_7.setImageResource(R.drawable.cover);
            iv_8.setImageResource(R.drawable.cover);
            iv_9.setImageResource(R.drawable.cover);
            iv_10.setImageResource(R.drawable.cover);
            iv_11.setImageResource(R.drawable.cover);
            iv_12.setImageResource(R.drawable.cover);

            wrong2 = MediaPlayer.create(MainActivity.this,R.raw.but_wrong2);
            wrong2.start();

        }

        cpuPoints++;
        tv_tried.setText("Tried: "+cpuPoints);

        iv_1.setEnabled(true);
        iv_2.setEnabled(true);
        iv_3.setEnabled(true);
        iv_4.setEnabled(true);
        iv_5.setEnabled(true);
        iv_6.setEnabled(true);
        iv_7.setEnabled(true);
        iv_8.setEnabled(true);
        iv_9.setEnabled(true);
        iv_10.setEnabled(true);
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);

        checkEnd();
    }

    private void checkEnd() {
        if (iv_1.getVisibility() == View.INVISIBLE &&
                iv_2.getVisibility() == View.INVISIBLE &&
                iv_3.getVisibility() == View.INVISIBLE &&
                iv_4.getVisibility() == View.INVISIBLE &&
                iv_5.getVisibility() == View.INVISIBLE &&
                iv_6.getVisibility() == View.INVISIBLE &&
                iv_7.getVisibility() == View.INVISIBLE &&
                iv_8.getVisibility() == View.INVISIBLE &&
                iv_9.getVisibility() == View.INVISIBLE &&
                iv_10.getVisibility() == View.INVISIBLE &&
                iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE) {
            highscore = MediaPlayer.create(MainActivity.this,R.raw.but_highscore);
            highscore.start();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setTitle("Congratulations")
                    .setMessage("Number of paired: "+playerPoints+"\nNumber of attempts: "+cpuPoints+"\nAccuracy: "+ df.format ((double)playerPoints/cpuPoints)+"\nScore: "+ df.format(12 * (double)playerPoints/cpuPoints))
                    .setCancelable(false)
                    .setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivityL2.class);
                            score1 = 12 * (double)playerPoints/cpuPoints;
                            intent.putExtra("Value1",score1);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    private void frontOfCardsResources() {
        image1 = R.drawable.a1;
        image2 = R.drawable.a2;
        image3 = R.drawable.a3;
        image4 = R.drawable.a4;
        image5 = R.drawable.a5;
        image6 = R.drawable.a6;
        image7 = R.drawable.a1;
        image8 = R.drawable.a2;
        image9 = R.drawable.a3;
        image10 = R.drawable.a4;
        image11 = R.drawable.a5;
        image12 = R.drawable.a6;

    }

    @Override
    protected void onPause() {
        super.onPause();
        l1Bgm.release();
        finish();
    }


}