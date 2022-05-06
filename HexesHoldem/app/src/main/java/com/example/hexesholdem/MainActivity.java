package com.example.hexesholdem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameStart.class);
        for (int i = 0; i <=4;i++) {
            GlobalDataStore.player_hand[i] = 100;
        }
        startActivity(intent);
    }

    public void rules(View view) {
        Intent intent = new Intent(this, DisplayRules.class);
        startActivity(intent);
    }
}