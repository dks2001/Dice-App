package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rollthedice;
    ImageView diceImage1,diceImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        final int[] diceImages = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        rollthedice = findViewById(R.id.rollthedice);
        diceImage1 = findViewById(R.id.imgView1);
        diceImage2  = findViewById(R.id.imgView2);

        rollthedice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int myrand1 = random.nextInt(6);
                int myrand2 = random.nextInt(6);

                mp.start();

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);

                diceImage1.setImageResource(diceImages[myrand1]);
                diceImage2.setImageResource(diceImages[myrand2]);

            }
        });
    }

}