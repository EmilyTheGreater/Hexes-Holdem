package com.example.hexesholdem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class Victory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victory_layout);
        if (GlobalDataStore.win) {
            TextView victory_msg = (TextView) findViewById(R.id.victoryStatus);
            String msg = "You won!";
            victory_msg.setText(msg);
            ImageView victory_img = (ImageView) findViewById(R.id.display);
            victory_img.setImageResource(R.drawable.kingthrone);
        }
    }

    public void mainMenu(View view) { finish(); }
}