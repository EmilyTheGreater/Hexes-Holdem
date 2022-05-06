package com.example.hexesholdem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class DisplayRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rules);

        TextView rules = (TextView) findViewById(R.id.displayRules);
        String rules_text = "Start the game by figuring out who goes first. The game does this for " +
                "you. Those who go first draw 5 cards but cannot play a Hex the first turn. " +
                "There is a maximum hand size of 5. Then, " +
                "once both players have their hands, place the top three cards of the deck into " +
                "the discard pile. Then reveal the next two cards and place them side by side. " +
                "These are known as Lane Cards. On subsequent turns, start the turn by placing the top " +
                "card into discard, and then place the next card into any of the open lanes. " +
                "Each turn, players may cast up to one Hex per turn. Hexes are the Major Arcana " +
                "cards in a traditional Tarot deck. See the list of Hexes for their effects. " +
                " Once both players have placed 4 lane cards, it's time for scoring.\n\nScoring:\n" +
                "Place your hand underneath the lanes. You can place up to three cards into a single " +
                "lane, or none. Once all cards have been placed by both players, they may each cast " +
                "a single hex. Both of these hexes are cast at the same time. Win most lanes " +
                "to become the victor. Tie, and the player wins by default (vs AI).\n\n" +
                "To determine which player's cards have won that lane, follow this order of " +
                "importance:\nHigh Card\nTwo of a kind\nThree of a kind\nFour of a kind\n\n" +
                "High card order:\nHexes > Wands > Cups > Pentacles > Swords.\n\nFlushes and Straights " +
                "count for nothing in Hexes Hold'em.\n\nHexes:\nDraw a Card:\nThe High Priestess(II), " +
                "The Empress(III), The Emperor(IV), and The Hierophant(V).\nThe Tower:\nThe Tower, when " +
                "cast, destroys all of the opponent's Lane Cards.\nDraw 2 Cards:\nThe Lovers(VI), " +
                "The Chariot(VII), Strength(VII), The Hermit (IX), and Temperance(XIV)\nDestroy a " +
                "Card:\nJustice(XI), The Hanged Man(XII), Death(XIII), The Devil(XV), and Judgement(XX)\n" +
                "Search Your Deck for a Certain Card:\nThe Fool(0), The Magician(I), Wheel of " +
                "Fortune(X), The Star(XVII), The Moon (XVIII), The Sun(XIX), and The World(XXI)";
        rules.setText(rules_text);
        rules.setMovementMethod(new ScrollingMovementMethod());
    }

    public void toMainMenu(View view) {
        finish();
    }
}