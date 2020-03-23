package com.example.mydice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_main);
        final ImageView diceImg1 = findViewById(R.id.dice1);
        final ImageView diceImg2 = findViewById(R.id.dice2);
        final int[] dice_imgs = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Button roll_btn = findViewById(R.id.roll_btn);

        final MediaPlayer mp=MediaPlayer.create(this, R.raw.dice_sound);


        roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random rndObject = new Random();

                int myRandomNumbers = rndObject.nextInt(6);

                diceImg1.setImageResource(dice_imgs[myRandomNumbers]);

                myRandomNumbers = rndObject.nextInt(6);

                diceImg2.setImageResource(dice_imgs[myRandomNumbers]);


                mp.start();

                YoYo.with(Techniques.Shake)
                        .duration(100)
                        .repeat(5)
                        .playOn(diceImg1);
                YoYo.with(Techniques.Shake)
                        .duration(100)
                        .repeat(5)
                        .playOn(diceImg2);
            }
        });

    }
}
