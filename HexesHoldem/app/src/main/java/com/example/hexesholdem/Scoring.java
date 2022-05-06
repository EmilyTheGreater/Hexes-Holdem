package com.example.hexesholdem;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.security.spec.ECField;

//To Do:
//Pick back up placed Cards
//Cast Hexes

public class Scoring extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoring_layout);

        Button gameEnd = (Button) findViewById(R.id.game_continue);
        gameEnd.setVisibility(View.INVISIBLE);

        ImageView playerSecret1 = (ImageView) findViewById(R.id.playerSecret1);
        ImageView playerSecret2 = (ImageView) findViewById(R.id.playerSecret2);
        ImageView playerSecret3 = (ImageView) findViewById(R.id.playerSecret3);
        ImageView playerSecret4 = (ImageView) findViewById(R.id.playerSecret4);
        ImageView playerSecret5 = (ImageView) findViewById(R.id.playerSecret5);
        ImageView playerSecret6 = (ImageView) findViewById(R.id.playerSecret6);
        ImageView playerSecret7 = (ImageView) findViewById(R.id.playerSecret7);
        ImageView playerSecret8 = (ImageView) findViewById(R.id.playerSecret8);
        ImageView playerSecret9 = (ImageView) findViewById(R.id.playerSecret9);
        ImageView playerSecret10 = (ImageView) findViewById(R.id.playerSecret10);
        ImageView playerSecret11 = (ImageView) findViewById(R.id.playerSecret11);
        ImageView playerSecret12 = (ImageView) findViewById(R.id.playerSecret12);
        ImageView handSelect1 = (ImageView) findViewById(R.id.handSelect1);
        ImageView handSelect2 = (ImageView) findViewById(R.id.handSelect2);
        ImageView handSelect3 = (ImageView) findViewById(R.id.handSelect3);
        ImageView handSelect4 = (ImageView) findViewById(R.id.handSelect4);
        ImageView handSelect5 = (ImageView) findViewById(R.id.handSelect5);
        ImageView aiSecret5 = (ImageView) findViewById(R.id.aiSecret5);
        ImageView aiSecret6 = (ImageView) findViewById(R.id.aiSecret6);
        ImageView aiSecret7 = (ImageView) findViewById(R.id.aiSecret7);
        ImageView aiSecret8 = (ImageView) findViewById(R.id.aiSecret8);
        playerSecret1.setVisibility(View.INVISIBLE);
        playerSecret2.setVisibility(View.INVISIBLE);
        playerSecret3.setVisibility(View.INVISIBLE);
        playerSecret4.setVisibility(View.INVISIBLE);
        playerSecret5.setVisibility(View.INVISIBLE);
        playerSecret6.setVisibility(View.INVISIBLE);
        playerSecret7.setVisibility(View.INVISIBLE);
        playerSecret8.setVisibility(View.INVISIBLE);
        playerSecret9.setVisibility(View.INVISIBLE);
        handSelect1.setVisibility(View.INVISIBLE);
        handSelect2.setVisibility(View.INVISIBLE);
        handSelect3.setVisibility(View.INVISIBLE);
        handSelect4.setVisibility(View.INVISIBLE);
        handSelect5.setVisibility(View.INVISIBLE);
        playerSecret10.setVisibility(View.INVISIBLE);
        playerSecret11.setVisibility(View.INVISIBLE);
        playerSecret12.setVisibility(View.INVISIBLE);
        aiSecret5.setVisibility(View.INVISIBLE);
        aiSecret6.setVisibility(View.INVISIBLE);
        aiSecret7.setVisibility(View.INVISIBLE);
        aiSecret8.setVisibility(View.INVISIBLE);

        ImageView playerHand1 = (ImageView) findViewById(R.id.playerHand1);
        ImageView playerHand2 = (ImageView) findViewById(R.id.playerHand2);
        ImageView playerHand3 = (ImageView) findViewById(R.id.playerHand3);
        ImageView playerHand4 = (ImageView) findViewById(R.id.playerHand4);
        ImageView playerHand5 = (ImageView) findViewById(R.id.playerHand5);
        ImageView playerRiver1 = (ImageView) findViewById(R.id.playerRiver_scoring1);
        ImageView playerRiver2 = (ImageView) findViewById(R.id.playerRiver_scoring2);
        ImageView playerRiver3 = (ImageView) findViewById(R.id.playerRiver_scoring3);
        ImageView playerRiver4 = (ImageView) findViewById(R.id.playerRiver_scoring4);
        ImageView aiRiver1 = (ImageView) findViewById(R.id.aiRiver_scoring1);
        ImageView aiRiver2 = (ImageView) findViewById(R.id.aiRiver_scoring2);
        ImageView aiRiver3 = (ImageView) findViewById(R.id.aiRiver_scoring3);
        ImageView aiRiver4 = (ImageView) findViewById(R.id.aiRiver_scoring4);


        try {
            playerHand1.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[0]));
        } catch(Exception e) {
            playerHand1.setVisibility(View.INVISIBLE);
        }
        try {
            playerHand2.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[1]));
        } catch(Exception e) {
            playerHand2.setVisibility(View.INVISIBLE);
        }
        try {
            playerHand3.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[2]));
        } catch(Exception e) {
            playerHand3.setVisibility(View.INVISIBLE);
        }
        try {
            playerHand4.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[3]));
        } catch(Exception e) {
            playerHand4.setVisibility(View.INVISIBLE);
        }
        try {
            playerHand5.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[4]));
        } catch(Exception e) {
            playerHand5.setVisibility(View.INVISIBLE);
        }
        try {
            playerRiver1.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_river[0]));
        } catch(Exception e) {
            playerRiver1.setVisibility(View.INVISIBLE);
        }
        try {
            playerRiver2.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_river[1]));
        } catch(Exception e) {
            playerRiver2.setVisibility(View.INVISIBLE);
        }
        try {
            playerRiver3.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_river[2]));
        } catch(Exception e) {
            playerRiver3.setVisibility(View.INVISIBLE);
        }
        try {
            playerRiver4.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_river[3]));
        } catch(Exception e) {
            playerRiver4.setVisibility(View.INVISIBLE);
        }
        try {
            aiRiver1.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_river[0]));
        } catch(Exception e) {
            playerRiver1.setVisibility(View.INVISIBLE);
        }
        try {
            aiRiver2.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_river[1]));
        } catch(Exception e) {
            aiRiver2.setVisibility(View.INVISIBLE);
        }
        try {
            aiRiver3.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_river[2]));
        } catch(Exception e) {
            aiRiver3.setVisibility(View.INVISIBLE);
        }
        try {
            aiRiver4.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.ai_river[3]));
        } catch(Exception e) {
            aiRiver4.setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < 8; i++) {
            GlobalDataStore.ai_face_down[i] = 99;
        }
        for (int i = 0; i < 12; i++) {
            GlobalDataStore.player_face_down[i] = 0;
        }
        if (GlobalDataStore.player_first) {
            for (int i = 0; i < 3; i++) {
                GlobalDataStore.ai_face_down[i] = GlobalDataStore.ai_hand[i];
            }
        } else {
            for (int i = 0; i < 4; i++) {
                GlobalDataStore.ai_face_down[i] = GlobalDataStore.ai_hand[i];
            }
        }
    }

    public void victoryScreen() {
        Intent intent = new Intent(this, Victory.class);
        startActivity(intent);
        finish();
    }

    public void placeCardHere(View view) {
        int id = view.getId();
        GlobalDataStore.cards_in_hand = 0;

        //Init required objects
        ImageView playerHand1 = (ImageView) findViewById(R.id.playerHand1);
        ImageView playerHand2 = (ImageView) findViewById(R.id.playerHand2);
        ImageView playerHand3 = (ImageView) findViewById(R.id.playerHand3);
        ImageView playerHand4 = (ImageView) findViewById(R.id.playerHand4);
        ImageView playerHand5 = (ImageView) findViewById(R.id.playerHand5);
        ImageView handSelect1 = (ImageView) findViewById(R.id.handSelect1);
        ImageView handSelect2 = (ImageView) findViewById(R.id.handSelect2);
        ImageView handSelect3 = (ImageView) findViewById(R.id.handSelect3);
        ImageView handSelect4 = (ImageView) findViewById(R.id.handSelect4);
        ImageView handSelect5 = (ImageView) findViewById(R.id.handSelect5);

        //place the card in the right place
        if (GlobalDataStore.selection_state) {
            if ((id == R.id.playerSecret1) || (id == R.id.playerRiver_scoring1)) {
                ImageView secretPlacement = (ImageView) findViewById(R.id.playerSecret1);
                if (secretPlacement.getVisibility() == View.INVISIBLE) {
                    secretPlacement.setVisibility(View.VISIBLE);
                    ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                    handSelect.setVisibility(View.INVISIBLE);
                    GlobalDataStore.player_face_down[0] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                    GlobalDataStore.selection_state = false;
                } else {
                    secretPlacement = (ImageView) findViewById(R.id.playerSecret5);
                    if (secretPlacement.getVisibility() == View.INVISIBLE) {
                        secretPlacement.setVisibility(View.VISIBLE);
                        ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                        handSelect.setVisibility(View.INVISIBLE);
                        GlobalDataStore.player_face_down[4] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                        GlobalDataStore.selection_state = false;
                    } else {
                        secretPlacement = (ImageView) findViewById(R.id.playerSecret9);
                        if (secretPlacement.getVisibility() == View.INVISIBLE) {
                            secretPlacement.setVisibility(View.VISIBLE);
                            ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                            handSelect.setVisibility(View.INVISIBLE);
                            GlobalDataStore.player_face_down[8] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                            GlobalDataStore.selection_state = false;
                        }
                    }
                }
            }
            if ((id == R.id.playerSecret2) || (id == R.id.playerRiver_scoring2)) {
                ImageView secretPlacement = (ImageView) findViewById(R.id.playerSecret2);
                if (secretPlacement.getVisibility() == View.INVISIBLE) {
                    secretPlacement.setVisibility(View.VISIBLE);
                    ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                    handSelect.setVisibility(View.INVISIBLE);
                    GlobalDataStore.player_face_down[1] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                    GlobalDataStore.selection_state = false;
                } else {
                    secretPlacement = (ImageView) findViewById(R.id.playerSecret6);
                    if (secretPlacement.getVisibility() == View.INVISIBLE) {
                        secretPlacement.setVisibility(View.VISIBLE);
                        ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                        handSelect.setVisibility(View.INVISIBLE);
                        GlobalDataStore.player_face_down[5] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                        GlobalDataStore.selection_state = false;
                    } else {
                        secretPlacement = (ImageView) findViewById(R.id.playerSecret10);
                        if (secretPlacement.getVisibility() == View.INVISIBLE) {
                            secretPlacement.setVisibility(View.VISIBLE);
                            ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                            handSelect.setVisibility(View.INVISIBLE);
                            GlobalDataStore.player_face_down[9] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                            GlobalDataStore.selection_state = false;
                        }
                    }
                }
            }
            if ((id == R.id.playerSecret3) || (id == R.id.playerRiver_scoring3)) {
                ImageView secretPlacement = (ImageView) findViewById(R.id.playerSecret3);
                if (secretPlacement.getVisibility() == View.INVISIBLE) {
                    secretPlacement.setVisibility(View.VISIBLE);
                    ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                    handSelect.setVisibility(View.INVISIBLE);
                    GlobalDataStore.player_face_down[2] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                    GlobalDataStore.selection_state = false;
                } else {
                    secretPlacement = (ImageView) findViewById(R.id.playerSecret7);
                    if (secretPlacement.getVisibility() == View.INVISIBLE) {
                        secretPlacement.setVisibility(View.VISIBLE);
                        ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                        handSelect.setVisibility(View.INVISIBLE);
                        GlobalDataStore.player_face_down[6] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                        GlobalDataStore.selection_state = false;
                    } else {
                        secretPlacement = (ImageView) findViewById(R.id.playerSecret11);
                        if (secretPlacement.getVisibility() == View.INVISIBLE) {
                            secretPlacement.setVisibility(View.VISIBLE);
                            ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                            handSelect.setVisibility(View.INVISIBLE);
                            GlobalDataStore.player_face_down[10] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                            GlobalDataStore.selection_state = false;
                        }
                    }
                }
            }
            if ((id == R.id.playerSecret4) || (id == R.id.playerRiver_scoring4)) {
                ImageView secretPlacement = (ImageView) findViewById(R.id.playerSecret4);
                if (secretPlacement.getVisibility() == View.INVISIBLE) {
                    secretPlacement.setVisibility(View.VISIBLE);
                    ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                    handSelect.setVisibility(View.INVISIBLE);
                    GlobalDataStore.player_face_down[3] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                    GlobalDataStore.selection_state = false;
                } else {
                    secretPlacement = (ImageView) findViewById(R.id.playerSecret8);
                    if (secretPlacement.getVisibility() == View.INVISIBLE) {
                        secretPlacement.setVisibility(View.VISIBLE);
                        ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                        handSelect.setVisibility(View.INVISIBLE);
                        GlobalDataStore.player_face_down[7] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                        GlobalDataStore.selection_state = false;
                    } else {
                        secretPlacement = (ImageView) findViewById(R.id.playerSecret12);
                        if (secretPlacement.getVisibility() == View.INVISIBLE) {
                            secretPlacement.setVisibility(View.VISIBLE);
                            ImageView handSelect = handIndex(GlobalDataStore.selected_card);
                            handSelect.setVisibility(View.INVISIBLE);
                            GlobalDataStore.player_face_down[11] = GlobalDataStore.player_hand[GlobalDataStore.selected_card - 1];
                            GlobalDataStore.selection_state = false;
                        }
                    }
                }
            }
        }

        if ((playerHand1.getVisibility() == View.VISIBLE) || (handSelect1.getVisibility() == View.VISIBLE)) {
            GlobalDataStore.cards_in_hand +=1;
        }
        if ((playerHand2.getVisibility() == View.VISIBLE) || (handSelect2.getVisibility() == View.VISIBLE)) {
            GlobalDataStore.cards_in_hand +=1;
        }
        if ((playerHand3.getVisibility() == View.VISIBLE) || (handSelect3.getVisibility() == View.VISIBLE)) {
            GlobalDataStore.cards_in_hand +=1;
        }
        if ((playerHand4.getVisibility() == View.VISIBLE) || (handSelect4.getVisibility() == View.VISIBLE)) {
            GlobalDataStore.cards_in_hand +=1;
        }
        if ((playerHand5.getVisibility() == View.VISIBLE) || (handSelect5.getVisibility() == View.VISIBLE)) {
            GlobalDataStore.cards_in_hand +=1;
        }

        if (GlobalDataStore.cards_in_hand < 2) {
            /*if (cards_in_hand == 1) {
                GlobalDataStore.hex_cast = true;
            }*/
            Button endGame = (Button) findViewById(R.id.game_continue);
            endGame.setVisibility(View.VISIBLE);
        }
    }

    public void selectCard(View view) {
        int id = view.getId();
        if (id == R.id.playerHand1){
            ImageView playerHand = (ImageView) findViewById(R.id.playerHand1);
            if ((playerHand.getVisibility() == View.VISIBLE) && (!GlobalDataStore.selection_state)) {
                playerHand.setVisibility(View.INVISIBLE);
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect1);
                try {
                    handSelect.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[0]));
                    handSelect.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = true;
                    GlobalDataStore.selected_card = 1;
                } catch (Exception e) {
                }
            } else {
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect1);
                if (handSelect.getVisibility() == View.VISIBLE) {
                    handSelect.setVisibility(View.INVISIBLE);
                    playerHand.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = false;
                }
            }
        }
        if (id == R.id.playerHand2) {
            ImageView playerHand = (ImageView) findViewById(R.id.playerHand2);
            if ((playerHand.getVisibility() == View.VISIBLE) && (!GlobalDataStore.selection_state))  {
                playerHand.setVisibility(View.INVISIBLE);
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect2);
                try {
                    handSelect.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[1]));
                    handSelect.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = true;
                    GlobalDataStore.selected_card = 2;
                } catch (Exception e) {
                }
            } else {
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect2);
                if (handSelect.getVisibility() == View.VISIBLE) {
                    handSelect.setVisibility(View.INVISIBLE);
                    playerHand.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = false;
                }
            }
        }
        if (id == R.id.playerHand3) {
            ImageView playerHand = (ImageView) findViewById(R.id.playerHand3);
            if ((playerHand.getVisibility() == View.VISIBLE) && (!GlobalDataStore.selection_state))  {
                playerHand.setVisibility(View.INVISIBLE);
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect3);
                try {
                    handSelect.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[2]));
                    handSelect.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = true;
                    GlobalDataStore.selected_card = 3;

                } catch (Exception e) {
                }
            } else {
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect3);
                if (handSelect.getVisibility() == View.VISIBLE) {
                    handSelect.setVisibility(View.INVISIBLE);
                    playerHand.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = false;
                }
            }
        }
        if (id == R.id.playerHand4) {
            ImageView playerHand = (ImageView) findViewById(R.id.playerHand4);
            if ((playerHand.getVisibility() == View.VISIBLE) && (!GlobalDataStore.selection_state))  {
                playerHand.setVisibility(View.INVISIBLE);
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect4);
                try {
                    handSelect.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[3]));
                    handSelect.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = true;
                    GlobalDataStore.selected_card = 4;
                } catch (Exception e) {
                }
            } else {
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect4);
                if (handSelect.getVisibility() == View.VISIBLE) {
                    handSelect.setVisibility(View.INVISIBLE);
                    playerHand.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = false;
                }
            }
        }
        if (id == R.id.playerHand5) {
            ImageView playerHand = (ImageView) findViewById(R.id.playerHand5);
            if ((playerHand.getVisibility() == View.VISIBLE) && (!GlobalDataStore.selection_state))  {
                playerHand.setVisibility(View.INVISIBLE);
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect5);
                try {
                    handSelect.setImageResource(GlobalDataStore.cardLookup(GlobalDataStore.player_hand[4]));
                    handSelect.setVisibility(View.VISIBLE);
                    GlobalDataStore.selection_state = true;
                    GlobalDataStore.selected_card = 5;
                } catch (Exception e) {
                }
            } else {
                ImageView handSelect = (ImageView) findViewById(R.id.handSelect5);
                handSelect.setVisibility(View.INVISIBLE);
                playerHand.setVisibility(View.VISIBLE);
                GlobalDataStore.selection_state = false;
            }
        }
    }

    public ImageView handIndex(int i) {
        ImageView retHand = (ImageView) findViewById(R.id.handSelect1);
        if (i == 1) {
            retHand =findViewById(R.id.handSelect1);
        }
        if (i == 2) {
            retHand =findViewById(R.id.handSelect2);
        }
        if (i == 3) {
            retHand =findViewById(R.id.handSelect3);
        }
        if (i == 4) {
            retHand =findViewById(R.id.handSelect4);
        }
        if (i == 5) {
            retHand =findViewById(R.id.handSelect5);
        }
        return retHand;
    }

    public void determineWinner(View view) {
        Button endGame = (Button) findViewById(R.id.game_continue);
        if (endGame.getVisibility() == View.VISIBLE) {
            if (GlobalDataStore.cards_in_hand == 0) {
                Boolean playerWin = false;
                int ai_points = 0;
                int player_points = 0;
                //Lane 1 point
                ImageView aiLane = (ImageView) findViewById(R.id.aiRiver_scoring1);
                ImageView playerLane = (ImageView) findViewById(R.id.playerRiver_scoring1);
                ImageView aiSecret = (ImageView) findViewById(R.id.aiSecret1);
                ImageView aiSecret2 = (ImageView) findViewById(R.id.aiSecret5);
                ImageView playerSecret1 = (ImageView) findViewById(R.id.playerSecret1);
                ImageView playerSecret2 = (ImageView) findViewById(R.id.playerSecret5);
                ImageView playerSecret3 = (ImageView) findViewById(R.id.playerSecret9);
                if (winLane(1, aiLane, playerLane, aiSecret, aiSecret2, playerSecret1, playerSecret2, playerSecret3)) {
                    player_points +=1;
                } else {
                    ai_points +=1;
                }

                //Lane 2 point
                aiLane = findViewById(R.id.aiRiver_scoring2);
                playerLane =findViewById(R.id.playerRiver_scoring2);
                aiSecret =findViewById(R.id.aiSecret2);
                aiSecret2 =findViewById(R.id.aiSecret6);
                playerSecret1 = findViewById(R.id.playerSecret2);
                playerSecret2 = findViewById(R.id.playerSecret6);
                playerSecret3 = findViewById(R.id.playerSecret10);
                if (winLane(2, aiLane, playerLane, aiSecret, aiSecret2, playerSecret1, playerSecret2, playerSecret3)) {
                    player_points +=1;
                } else {
                    ai_points +=1;
                }

                //lane 3 point
                aiLane = findViewById(R.id.aiRiver_scoring3);
                playerLane =findViewById(R.id.playerRiver_scoring3);
                aiSecret =findViewById(R.id.aiSecret3);
                aiSecret2 =findViewById(R.id.aiSecret7);
                playerSecret1 = findViewById(R.id.playerSecret3);
                playerSecret2 = findViewById(R.id.playerSecret7);
                playerSecret3 = findViewById(R.id.playerSecret11);
                if (winLane(3, aiLane, playerLane, aiSecret, aiSecret2, playerSecret1, playerSecret2, playerSecret3)) {
                    player_points +=1;
                } else {
                    ai_points +=1;
                }

                //lane 4 point
                aiLane = findViewById(R.id.aiRiver_scoring4);
                playerLane =findViewById(R.id.playerRiver_scoring4);
                aiSecret =findViewById(R.id.aiSecret4);
                aiSecret2 =findViewById(R.id.aiSecret8);
                playerSecret1 = findViewById(R.id.playerSecret4);
                playerSecret2 = findViewById(R.id.playerSecret8);
                playerSecret3 = findViewById(R.id.playerSecret12);
                if (winLane(4, aiLane, playerLane, aiSecret, aiSecret2, playerSecret1, playerSecret2, playerSecret3)) {
                    player_points +=1;
                } else {
                    ai_points +=1;
                }

                if (player_points >= ai_points) {
                    playerWin = true;
                }

                GlobalDataStore.win = playerWin;
                victoryScreen();
            } else {

            }
        }
    }

    public Boolean winLane(int lane, ImageView aiLane, ImageView playerLane, ImageView aiSecret, ImageView aiSecret2, ImageView playerSecret1, ImageView playerSecret2, ImageView playerSecret3) {
        Boolean playerWin = true;
        int[] ai_cards = {0, 0, 0};
        int[] player_cards = {0, 0, 0, 0};
        if (aiSecret.getVisibility() == View.VISIBLE) {
            ai_cards[1] = GlobalDataStore.ai_face_down[lane - 1];
        } else {
            ai_cards[1] = 99;
        }
        if (aiSecret2.getVisibility() == View.VISIBLE) {
            ai_cards[2] = GlobalDataStore.ai_face_down[lane + 3];
        } else {
            ai_cards[2] = 99;
        }
        if (aiLane.getVisibility() == View.VISIBLE) {
            ai_cards[0] = GlobalDataStore.ai_river[lane - 1];
        } else {
            ai_cards[0] = 99;
        }
        if (playerLane.getVisibility() == View.VISIBLE) {
            player_cards[0] = GlobalDataStore.player_river[lane - 1];
        } else {
            player_cards[0] = 99;
        }
        if (playerSecret1.getVisibility() == View.VISIBLE) {
            player_cards[1] = GlobalDataStore.player_face_down[lane - 1];
        } else {
            player_cards[1] = 99;
        }
        if (playerSecret2.getVisibility() == View.VISIBLE) {
            player_cards[2] = GlobalDataStore.player_face_down[lane + 3];
        } else {
            player_cards[2] = 99;
        }
        if (playerSecret3.getVisibility() == View.VISIBLE) {
            player_cards[3] = GlobalDataStore.player_face_down[lane + 7];
        } else {
            player_cards[3] = 99;
        }

        //compare high cards
        int ai_high_card = ai_cards[0];
        for (int i = 0; i < 3; i++) {
            if ((ai_high_card < ai_cards[i]) && (ai_cards[i] != 99)) {
                ai_high_card = ai_cards[i];
            }
        }
        int player_high_card = player_cards[0];
        for (int i = 0; i < 3; i++) {
            if ((player_high_card < player_cards[i]) && (ai_cards[i] != 99)) {
                player_high_card = player_cards[i];
            }
        }
        if (ai_high_card > player_high_card) {
            playerWin = false;
        }

        //find pairs
        int ai_pair = 0;
        for (int i = 0; i < 3; i++) {
            if (ai_cards[i] != 99) {
                char card_type = cardClassifier(ai_cards[i]);
                if (card_type == 's') {
                    for (int j = 0; j < 3; j++) {
                        if (((ai_cards[i] + 14) == ai_cards[j]) || ((ai_cards[i] + 28) == ai_cards[j]) || ((ai_cards[i] + 32) == ai_cards[j])) {
                            ai_pair +=1;
                        }
                    }
                }
                if (card_type == 'p') {
                    for (int j = 0; j < 3; j++) {
                        if (((ai_cards[i] + 14) == ai_cards[j]) || ((ai_cards[i] + 28) == ai_cards[j])) {
                            ai_pair +=1;
                        }
                    }
                }
                if (card_type == 'c') {
                    for (int j = 0; j < 3; j++) {
                        if ((ai_cards[i] + 14) == ai_cards[j]) {
                            ai_pair +=1;
                        }
                    }
                }
            }
        }
        int player_pair = 0;
        for (int i = 0; i < 3; i++) {
            if (player_cards[i] != 99) {
                char card_type = cardClassifier(player_cards[i]);
                if (card_type == 's') {
                    for (int j = 0; j < 3; j++) {
                        if (((player_cards[i] + 14) == player_cards[j]) || ((player_cards[i] + 28) == player_cards[j]) || ((player_cards[i] + 32) == player_cards[j])) {
                            player_pair +=1;
                        }
                    }
                }
                if (card_type == 'p') {
                    for (int j = 0; j < 3; j++) {
                        if (((player_cards[i] + 14) == player_cards[j]) || ((player_cards[i] + 28) == player_cards[j])) {
                            player_pair +=1;
                        }
                    }
                }
                if (card_type == 'c') {
                    for (int j = 0; j < 3; j++) {
                        if ((player_cards[i] + 14) == player_cards[j]) {
                            player_pair +=1;
                        }
                    }
                }
            }
        }
        if (ai_pair > player_pair) {
            playerWin = false;
        }

        return playerWin;
    }

    public char cardClassifier(int card) {
        char type = 's';

        if ((card < 28) && (card > 13)) {
            type = 'p';
        }
        if ((card < 42)&&(card > 27)) {
            type = 'c';
        }if ((card < 56)&&(card > 41)) {
            type = 'w';
        }
        if (card > 55) {
            type = 'm';
        }
        return type;
    }
}