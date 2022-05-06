package com.example.hexesholdem;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Switch;

import java.util.Random;

//Implement random turn selection.
//display dice and select the higher value. Take AI turn first.

//For hexes, set another imageview above the original, and make the bottom one invisible and the top
//visible for selection, when needed.

public class GameStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_layout);
        MediaPlayer shuffle = MediaPlayer.create(this, R.raw.shuffle);
        shuffle.start();
        GlobalDataStore.turn_count = 0;
        GlobalDataStore.player_deck_index = 0;
        GlobalDataStore.ai_deck_index = 0;
        GlobalDataStore.win = false;

        ImageButton discard = (ImageButton) findViewById(R.id.discard);
        ImageView hand1 = (ImageView) findViewById(R.id.hand1);
        ImageView hand2 = (ImageView) findViewById(R.id.hand2);
        ImageView hand3 = (ImageView) findViewById(R.id.hand3);
        ImageView hand4 = (ImageView) findViewById(R.id.hand4);
        ImageView hand5 = (ImageView) findViewById(R.id.hand5);
        ImageButton aiRiver1 = (ImageButton) findViewById(R.id.aiRiver1);
        ImageButton aiRiver2 = (ImageButton) findViewById(R.id.aiRiver2);
        ImageButton aiRiver3 = (ImageButton) findViewById(R.id.aiRiver3);
        ImageButton aiRiver4 = (ImageButton) findViewById(R.id.aiRiver4);
        ImageButton playerRiver1 = (ImageButton) findViewById(R.id.playerRiver1);
        ImageButton playerRiver2 = (ImageButton) findViewById(R.id.playerRiver2);
        ImageButton playerRiver3 = (ImageButton) findViewById(R.id.playerRiver3);
        ImageButton playerRiver4 = (ImageButton) findViewById(R.id.playerRiver4);
        ImageView select1 = (ImageView) findViewById(R.id.select1);
        ImageView select2 = (ImageView) findViewById(R.id.select2);
        ImageView select3 = (ImageView) findViewById(R.id.select3);
        ImageView select4 = (ImageView) findViewById(R.id.select4);
        ImageView select5 = (ImageView) findViewById(R.id.select5);
        discard.setVisibility(View.INVISIBLE);
        aiRiver1.setVisibility(View.INVISIBLE);
        aiRiver2.setVisibility(View.INVISIBLE);
        aiRiver3.setVisibility(View.INVISIBLE);
        aiRiver4.setVisibility(View.INVISIBLE);
        playerRiver1.setVisibility(View.INVISIBLE);
        playerRiver2.setVisibility(View.INVISIBLE);
        playerRiver3.setVisibility(View.INVISIBLE);
        playerRiver4.setVisibility(View.INVISIBLE);
        hand1.setVisibility(View.INVISIBLE);
        hand2.setVisibility(View.INVISIBLE);
        hand3.setVisibility(View.INVISIBLE);
        hand4.setVisibility(View.INVISIBLE);
        hand5.setVisibility(View.INVISIBLE);
        select1.setVisibility(View.INVISIBLE);
        select2.setVisibility(View.INVISIBLE);
        select3.setVisibility(View.INVISIBLE);
        select4.setVisibility(View.INVISIBLE);
        select5.setVisibility(View.INVISIBLE);

        //shuffle decks and store in the dataStore on startup
        int[][] shuffled_deck = GameStart.cardShuffle();
        GlobalDataStore.player_deck = shuffled_deck[0];
        GlobalDataStore.ai_deck = shuffled_deck[1];
    }

    public void deckDraw(View view){
        //Because Java is a garbage language that hates pointers, we get this garbage AGAIN:
        ImageButton discard = (ImageButton) findViewById(R.id.discard);
        ImageView hand1 = (ImageView) findViewById(R.id.hand1);
        ImageView hand2 = (ImageView) findViewById(R.id.hand2);
        ImageView hand3 = (ImageView) findViewById(R.id.hand3);
        ImageView hand4 = (ImageView) findViewById(R.id.hand4);
        ImageView hand5 = (ImageView) findViewById(R.id.hand5);

        MediaPlayer draw = MediaPlayer.create(this, R.raw.draw);


        if (hand1.getVisibility() == View.INVISIBLE) {
            //draw.pause();
            //draw.reset();
            draw.start();
            hand1.setVisibility(View.VISIBLE);
            hand1.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
            GlobalDataStore.player_hand[0] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.player_deck_index +=1;

        } else {
            if (hand2.getVisibility() == View.INVISIBLE) {
                //draw.pause();
                //draw.reset();
                draw.start();
                hand2.setVisibility(View.VISIBLE);
                hand2.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
                GlobalDataStore.player_hand[1] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                GlobalDataStore.player_deck_index += 1;
            } else {
                if (hand3.getVisibility() == View.INVISIBLE) {
                    //draw.pause();
                    //draw.reset();
                    draw.start();
                    hand3.setVisibility(View.VISIBLE);
                    hand3.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
                    GlobalDataStore.player_hand[2] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                    GlobalDataStore.player_deck_index += 1;
                } else {
                    if (hand4.getVisibility() == View.INVISIBLE) {
                        //draw.pause();
                        //draw.reset();
                        draw.start();
                        hand4.setVisibility(View.VISIBLE);
                        hand4.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
                        GlobalDataStore.player_hand[3] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                        GlobalDataStore.player_deck_index += 1;
                    } else {
                        if ((hand5.getVisibility() == View.INVISIBLE) && (GlobalDataStore.player_first)) {
                            draw.start();
                            hand5.setVisibility(View.VISIBLE);
                            hand5.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
                            GlobalDataStore.player_hand[4] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                            GlobalDataStore.player_deck_index += 1;
                        }
                    }
                }
            }
        }
    }

    public static int[][] cardShuffle() {
        //Make Array of a Random tarot deck
        String suit = "w";
        int[] shuffled_deck = new int[72];
        //Init the array to an error value to detect placement of cards
        for(int i = 0; i < 72; i++) {
            shuffled_deck[i] = 99;
        }
        Boolean flag;
        Random rngsus = new Random();
        int storage;
        //This is a pseudo-sorting algorithm which assigns the card number in an array
        //It is highly inefficient, but very random.
        for(int i = 0; i < 72; i++) {
            flag = true;
            while (flag) {
                storage = rngsus.nextInt(72);
                if (shuffled_deck[storage] == 99){
                    shuffled_deck[storage] = i;
                    flag = false;
                }
            }
        }

        //Split the tarot deck into two equal decks
        int[] ai_deck = new int[36];
        int[] player_deck = new int[36];
        for(int i = 0; i < 36; i++) {
            player_deck[i] = shuffled_deck[i];
            ai_deck[i] = shuffled_deck[i + 36];
        }
        int[][] return_container = {player_deck, ai_deck};
        return return_container;
    }

    public void endTurn(View view) {
        Boolean turn_pass = false;
        MediaPlayer bell_ring = MediaPlayer.create(this, R.raw.turn_pass);
        //bell_ring.pause();
        //bell_ring.reset();
        bell_ring.start();

        //I hate java so much right now
        ImageButton aiRiver1 = (ImageButton) findViewById(R.id.aiRiver1);
        ImageButton aiRiver2 = (ImageButton) findViewById(R.id.aiRiver2);
        ImageButton aiRiver3 = (ImageButton) findViewById(R.id.aiRiver3);
        ImageButton aiRiver4 = (ImageButton) findViewById(R.id.aiRiver4);
        ImageButton playerRiver1 = (ImageButton) findViewById(R.id.playerRiver1);
        ImageButton playerRiver2 = (ImageButton) findViewById(R.id.playerRiver2);
        ImageButton playerRiver3 = (ImageButton) findViewById(R.id.playerRiver3);
        ImageButton playerRiver4 = (ImageButton) findViewById(R.id.playerRiver4);
        ImageView hand4 = (ImageView) findViewById(R.id.hand4);

        if ((GlobalDataStore.turn_count == 0) && (hand4.getVisibility() == View.VISIBLE)){
            turn_pass = true;
            for (int i = 0; i < 2; i++) {
                GlobalDataStore.discard[GlobalDataStore.discard_index] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index + i];
                GlobalDataStore.discard_index += 1;
            }
            GlobalDataStore.player_deck_index += 3;
            playerRiver1.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
            GlobalDataStore.player_river[0] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.player_deck_index += 1;
            playerRiver2.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
            GlobalDataStore.player_river[1] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.player_deck_index += 1;

            playerRiver1.setVisibility(View.VISIBLE);
            playerRiver2.setVisibility(View.VISIBLE);

            GlobalDataStore.ai_hand[0] = GlobalDataStore.ai_deck[0];
            GlobalDataStore.ai_hand[1] = GlobalDataStore.ai_deck[1];
            GlobalDataStore.ai_hand[2] = GlobalDataStore.ai_deck[2];
            GlobalDataStore.ai_hand[3] = GlobalDataStore.ai_deck[3];
            if (!GlobalDataStore.player_first) {
                GlobalDataStore.ai_hand[4] = GlobalDataStore.ai_deck[4];
                GlobalDataStore.ai_deck_index +=1;
                GlobalDataStore.hex_cast = false;
            } else {
                GlobalDataStore.hex_cast = true;
            }
            GlobalDataStore.ai_deck_index +=4;
            for (int i = 0; i < 2; i++) {
                GlobalDataStore.discard[GlobalDataStore.discard_index] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index + i];
                GlobalDataStore.discard_index +=1;
            }
            GlobalDataStore.ai_deck_index +=3;
            aiRiver1.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index]));
            GlobalDataStore.ai_river[0] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index];
            GlobalDataStore.ai_deck_index +=1;
            aiRiver2.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index]));
            GlobalDataStore.ai_river[1] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index];
            GlobalDataStore.ai_deck_index +=1;
            aiRiver1.setVisibility(View.VISIBLE);
            aiRiver2.setVisibility(View.VISIBLE);
        }

        if (GlobalDataStore.turn_count == 1) {
            GlobalDataStore.hex_cast = true;
            turn_pass = true;
            GlobalDataStore.discard[GlobalDataStore.discard_index] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.discard_index += 1;
            GlobalDataStore.player_deck_index += 1;
            playerRiver3.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
            GlobalDataStore.player_river[2] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.player_deck_index += 1;
            playerRiver3.setVisibility(View.VISIBLE);

            GlobalDataStore.discard[GlobalDataStore.discard_index] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index];
            GlobalDataStore.discard_index += 1;
            GlobalDataStore.ai_deck_index +=1;
            aiRiver3.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index]));
            GlobalDataStore.ai_river[2] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index];
            GlobalDataStore.ai_deck_index +=1;
            aiRiver3.setVisibility(View.VISIBLE);
        }

        if (GlobalDataStore.turn_count == 2) {
            GlobalDataStore.hex_cast = true;
            turn_pass = true;
            GlobalDataStore.discard[GlobalDataStore.discard_index] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.discard_index += 1;
            GlobalDataStore.player_deck_index += 1;
            playerRiver4.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_deck[GlobalDataStore.player_deck_index]));
            GlobalDataStore.player_river[3] = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
            GlobalDataStore.player_deck_index += 1;
            playerRiver4.setVisibility(View.VISIBLE);

            GlobalDataStore.discard[GlobalDataStore.discard_index] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index];
            GlobalDataStore.discard_index += 1;
            GlobalDataStore.ai_deck_index +=1;
            aiRiver4.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index]));
            GlobalDataStore.ai_river[3] = GlobalDataStore.ai_deck[GlobalDataStore.ai_deck_index];
            GlobalDataStore.ai_deck_index +=1;
            aiRiver4.setVisibility(View.VISIBLE);
        }

        if (GlobalDataStore.turn_count == 3) {
            Intent intent = new Intent(this, Scoring.class);
            startActivity(intent);
            finish();
        }

        if (turn_pass) {
            GlobalDataStore.turn_count +=1;
        }
    }

    public void hexCast(View view) {
        //testing
        MediaPlayer bell_ring = MediaPlayer.create(this, R.raw.turn_pass);

        int id = view.getId();
        Boolean clickable = false;
        Boolean cast = false;
        int card = 99;
        int card_position = 99;
        ImageView cardSelected = (ImageView) findViewById(R.id.select1);
        ImageView cardCast = (ImageView) findViewById(R.id.hand1);
        ImageView hand1 = cardCast;
        ImageView hand2 = (ImageView) findViewById(R.id.hand2);
        ImageView hand3 = (ImageView) findViewById(R.id.hand3);
        ImageView hand4 = (ImageView) findViewById(R.id.hand4);
        ImageView hand5 = (ImageView) findViewById(R.id.hand5);
        ImageView select1 = cardSelected;
        ImageView select2 = (ImageView) findViewById(R.id.select2);
        ImageView select3 = (ImageView) findViewById(R.id.select3);
        ImageView select4 = (ImageView) findViewById(R.id.select4);
        ImageView select5 = (ImageView) findViewById(R.id.select5);

        if ((id == R.id.hand1) && ((hand1.getVisibility() == View.VISIBLE) || (select1.getVisibility() == View.VISIBLE))) {
            card = GlobalDataStore.player_hand[0];
            card_position = 0;
            clickable = GlobalDataStore.needsTarget(card);
            cardSelected = select1;
            cardCast = hand1;
            if (GlobalDataStore.hex_cast) {
                cast = true;
            }
        }
        if ((id == R.id.hand2) && ((hand2.getVisibility() == View.VISIBLE) || (select2.getVisibility() == View.VISIBLE))) {
            card = GlobalDataStore.player_hand[1];
            card_position = 1;
            clickable = GlobalDataStore.needsTarget(card);
            cardSelected = select2;
            cardCast = hand2;
            if (GlobalDataStore.hex_cast) {
                cast = true;
            }
        }
        if ((id == R.id.hand3) && (hand3.getVisibility() == View.VISIBLE) || (select3.getVisibility() == View.VISIBLE)) {
            card = GlobalDataStore.player_hand[2];
            card_position = 2;
            clickable = GlobalDataStore.needsTarget(card);
            cardSelected = select3;
            cardCast = hand3;
            if (GlobalDataStore.hex_cast) {
                cast = true;

            }
        }
        if ((id == R.id.hand4) && (hand4.getVisibility() == View.VISIBLE) || (select4.getVisibility() == View.VISIBLE)) {
            card = GlobalDataStore.player_hand[3];
            card_position = 3;
            clickable = GlobalDataStore.needsTarget(card);
            cardSelected = select4;
            cardCast = hand4;
            if (GlobalDataStore.hex_cast) {
                cast = true;
            }
        }
        if ((id == R.id.hand5) && (hand1.getVisibility() == View.VISIBLE) || (select5.getVisibility() == View.VISIBLE)) {
            card = GlobalDataStore.player_hand[4];
            card_position = 4;
            clickable = GlobalDataStore.needsTarget(card);
            cardSelected = select5;
            cardCast = hand5;
            if (GlobalDataStore.hex_cast) {
                cast = true;
            }
        }
        if (clickable && GlobalDataStore.hex_cast) {
            //bell_ring.start();
            if (GlobalDataStore.selection_state) {
                //Reset selection state
                GlobalDataStore.selection_state = false;
                cardSelected.setVisibility(View.INVISIBLE);
                cardCast.setVisibility(View.VISIBLE);
                cardCast.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[card_position]));
            } else {
                //Lift card up
                //set selection state
                //prepare to cast hex
                GlobalDataStore.selection_state = true;
                cardSelected.setVisibility(View.VISIBLE);
                cardCast.setVisibility(View.INVISIBLE);
                cardSelected.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[card_position]));
                GlobalDataStore.selected_card = card_position;
            }
        }
        if ((card > 55) && (!clickable) && (cast)) {
            //cast the hex
            //bell_ring.start();
            int card_temp = card - 56;
            if (card_temp == 16) {
                //The tower
                ImageButton aiRiver1 = (ImageButton) findViewById(R.id.aiRiver1);
                ImageButton aiRiver2 = (ImageButton) findViewById(R.id.aiRiver2);
                ImageButton aiRiver3 = (ImageButton) findViewById(R.id.aiRiver3);
                ImageButton aiRiver4 = (ImageButton) findViewById(R.id.aiRiver4);
                aiRiver1.setVisibility(View.INVISIBLE);
                aiRiver2.setVisibility(View.INVISIBLE);
                aiRiver3.setVisibility(View.INVISIBLE);
                aiRiver4.setVisibility(View.INVISIBLE);
                for (int i=0; i < 4; i++) {
                    GlobalDataStore.ai_river[i] = 99;
                }
            }
            if (((card_temp >= 2) && (card_temp <= 5)) || (card_temp == 9)) {
                //Draw a card
                int new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                GlobalDataStore.player_deck_index +=1;
                GlobalDataStore.player_hand[card_position] = new_card;
                cardCast.setImageResource(GlobalDataStore.cardLookup(new_card));
            }
            if (((card_temp <= 8) && (card_temp >= 6)) || (card_temp == 14)) {
                //Draw 2
                //replace the casted card
                int new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                GlobalDataStore.player_deck_index +=1;
                GlobalDataStore.player_hand[card_position] = new_card;
                cardCast.setImageResource(GlobalDataStore.cardLookup(new_card));
                //Check if space for new card
                //if so, draw another
                if (hand1.getVisibility() == View.INVISIBLE) {
                    new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                    GlobalDataStore.player_deck_index +=1;
                    GlobalDataStore.player_hand[0] = new_card;
                    hand1.setVisibility(View.VISIBLE);
                    hand1.setImageResource(GlobalDataStore.cardLookup(new_card));
                } else {
                    if (hand2.getVisibility() == View.INVISIBLE) {
                        new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                        GlobalDataStore.player_deck_index +=1;
                        GlobalDataStore.player_hand[1] = new_card;
                        hand2.setVisibility(View.VISIBLE);
                        hand2.setImageResource(GlobalDataStore.cardLookup(new_card));
                    } else {
                        if (hand3.getVisibility() == View.INVISIBLE) {
                            new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                            GlobalDataStore.player_deck_index +=1;
                            GlobalDataStore.player_hand[2] = new_card;
                            hand3.setVisibility(View.VISIBLE);
                            hand3.setImageResource(GlobalDataStore.cardLookup(new_card));
                        } else {
                            if (hand4.getVisibility() == View.INVISIBLE) {
                                new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                                GlobalDataStore.player_deck_index +=1;
                                GlobalDataStore.player_hand[3] = new_card;
                                hand4.setVisibility(View.VISIBLE);
                                hand4.setImageResource(GlobalDataStore.cardLookup(new_card));
                            } else {
                                if (hand5.getVisibility() == View.INVISIBLE) {
                                    new_card = GlobalDataStore.player_deck[GlobalDataStore.player_deck_index];
                                    GlobalDataStore.player_deck_index +=1;
                                    GlobalDataStore.player_hand[4] = new_card;
                                    hand5.setVisibility(View.VISIBLE);
                                    hand5.setImageResource(GlobalDataStore.cardLookup(new_card));
                                }
                            }
                        }
                    }
                }
            }
            if ((card_temp == 0) || (card_temp == 1) || (card_temp == 10) || ((card_temp >= 17) && (card_temp <= 19)) || (card_temp == 21)) {
                //Search the deck
                searchDeck();
                bell_ring.start();
                if (GlobalDataStore.found_card != 99) {
                    GlobalDataStore.player_hand[card_position] = GlobalDataStore.found_card;
                    GlobalDataStore.found_card = 99;
                    cardCast.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[card_position]));
                }
            }
            //Reset the casting boolean
            GlobalDataStore.hex_cast = false;
        }
    }

    public void destroyMe(View view) {
        int id = view.getId();
        if (GlobalDataStore.selection_state) {
            GlobalDataStore.player_hand[GlobalDataStore.selected_card] = 99;
            ImageView hand = (ImageView) findViewById(R.id.select1);
            switch (GlobalDataStore.selected_card) {
                case 1:
                    hand = findViewById(R.id.select2);
                    break;
                case 2:
                    hand = findViewById(R.id.select3);
                    break;
                case 3:
                    hand = findViewById(R.id.select4);
                    break;
                case 4:
                    hand = findViewById(R.id.select5);
                    break;
            }
            hand.setVisibility(View.INVISIBLE);
            GlobalDataStore.selection_state = false;
            ImageButton river = (ImageButton) findViewById(R.id.aiRiver1);
            int river_index = 0;
            if (id == R.id.aiRiver2) {
                river = (ImageButton) findViewById(R.id.aiRiver2);
                river_index = 1;
            }
            if (id == R.id.aiRiver3) {
                river = (ImageButton) findViewById(R.id.aiRiver3);
                river_index = 2;
            }
            if (id == R.id.aiRiver4) {
                river = (ImageButton) findViewById(R.id.aiRiver4);
                river_index = 3;
            }
            river.setVisibility(View.INVISIBLE);
            GlobalDataStore.ai_river[river_index] = 99;
        }
    }

    public void searchDeck() {
        Intent intent = new Intent(this, SearchTheDeck.class);
        startActivity(intent);
    }
}