package com.example.hexesholdem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SearchTheDeck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_the_deck);
        ImageView card;
        for (int i = 0; i < 30; i++) {
            card = card_index(i+1);
            try {
                card.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index + i + GlobalDataStore.search_index]));
            } catch (Exception e) {
                card.setVisibility(View.INVISIBLE);
                card.setClickable(false);
            }
        }
    }

    public void nextPage(View view) {
        Button next_page = (Button) findViewById(R.id.nextPage);
        if (GlobalDataStore.search_index == 0) {
            next_page.setText("Previous Page");
            GlobalDataStore.search_index = 30;
        } else {
            next_page.setText("Next Page");
            GlobalDataStore.search_index = 0;
        }
        redisplayCards();
    }

    public void retToGame(View view) {
        finish();
    }

    public void selectCard(View view) {
        int id = view.getId();
        for (int i = 0; i < 30; i++) {
            ImageView temp = card_index(i);
            if (id == temp.getId()) {
                GlobalDataStore.found_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index + i + GlobalDataStore.search_index];
                finish();
            }
        }
    }

    public ImageView card_index(int index) {
        ImageView deckDisplay1 = (ImageView) findViewById(R.id.deckDisplay1);
        ImageView deckDisplay2 = (ImageView) findViewById(R.id.deckDisplay2);
        ImageView deckDisplay3 = (ImageView) findViewById(R.id.deckDisplay3);
        ImageView deckDisplay4 = (ImageView) findViewById(R.id.deckDisplay4);
        ImageView deckDisplay5 = (ImageView) findViewById(R.id.deckDisplay5);
        ImageView deckDisplay6 = (ImageView) findViewById(R.id.deckDisplay6);
        ImageView deckDisplay7 = (ImageView) findViewById(R.id.deckDisplay7);
        ImageView deckDisplay8 = (ImageView) findViewById(R.id.deckDisplay8);
        ImageView deckDisplay9 = (ImageView) findViewById(R.id.deckDisplay9);
        ImageView deckDisplay10 = (ImageView) findViewById(R.id.deckDisplay10);
        ImageView deckDisplay11 = (ImageView) findViewById(R.id.deckDisplay11);
        ImageView deckDisplay12 = (ImageView) findViewById(R.id.deckDisplay12);
        ImageView deckDisplay13 = (ImageView) findViewById(R.id.deckDisplay13);
        ImageView deckDisplay14 = (ImageView) findViewById(R.id.deckDisplay14);
        ImageView deckDisplay15 = (ImageView) findViewById(R.id.deckDisplay15);
        ImageView deckDisplay16 = (ImageView) findViewById(R.id.deckDisplay16);
        ImageView deckDisplay17 = (ImageView) findViewById(R.id.deckDisplay17);
        ImageView deckDisplay18 = (ImageView) findViewById(R.id.deckDisplay18);
        ImageView deckDisplay19 = (ImageView) findViewById(R.id.deckDisplay19);
        ImageView deckDisplay20 = (ImageView) findViewById(R.id.deckDisplay20);
        ImageView deckDisplay21 = (ImageView) findViewById(R.id.deckDisplay21);
        ImageView deckDisplay22 = (ImageView) findViewById(R.id.deckDisplay22);
        ImageView deckDisplay23 = (ImageView) findViewById(R.id.deckDisplay23);
        ImageView deckDisplay24 = (ImageView) findViewById(R.id.deckDisplay24);
        ImageView deckDisplay25 = (ImageView) findViewById(R.id.deckDisplay25);
        ImageView deckDisplay26 = (ImageView) findViewById(R.id.deckDisplay26);
        ImageView deckDisplay27 = (ImageView) findViewById(R.id.deckDisplay27);
        ImageView deckDisplay28 = (ImageView) findViewById(R.id.deckDisplay28);
        ImageView deckDisplay29 = (ImageView) findViewById(R.id.deckDisplay29);
        ImageView deckDisplay30 = (ImageView) findViewById(R.id.deckDisplay30);
        switch (index) {
            case 1:
                return deckDisplay1;
            case 2:
                return deckDisplay2;
            case 3:
                return deckDisplay3;
            case 4:
                return deckDisplay4;
            case 5:
                return deckDisplay5;
            case 6:
                return deckDisplay6;
            case 7:
                return deckDisplay7;
            case 8:
                return deckDisplay8;
            case 9:
                return deckDisplay9;
            case 10:
                return deckDisplay10;
            case 11:
                return deckDisplay11;
            case 12:
                return deckDisplay12;
            case 13:
                return deckDisplay13;
            case 14:
                return deckDisplay14;
            case 15:
                return deckDisplay15;
            case 16:
                return deckDisplay16;
            case 17:
                return deckDisplay17;
            case 18:
                return deckDisplay18;
            case 19:
                return deckDisplay19;
            case 20:
                return deckDisplay20;
            case 21:
                return deckDisplay21;
            case 22:
                return deckDisplay22;
            case 23:
                return deckDisplay23;
            case 24:
                return deckDisplay24;
            case 25:
                return deckDisplay25;
            case 26:
                return deckDisplay26;
            case 27:
                return deckDisplay27;
            case 28:
                return deckDisplay28;
            case 29:
                return deckDisplay29;
            default:
                return deckDisplay30;
        }
    }

    public void redisplayCards() {
        ImageView card;
        for (int i = 0; i < 30; i++) {
            card = card_index(i+1);
            try {
                card.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index + i + GlobalDataStore.search_index]));
            } catch (Exception e) {
                card.setVisibility(View.INVISIBLE);
                card.setClickable(false);
            }
        }
    }
}