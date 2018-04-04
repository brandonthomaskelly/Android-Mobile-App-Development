package com.example.brandonkelly.kellypa4;

/**
 * Created by brandonkelly on 10/18/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    int turn = 0; // Turn incrementer
    String player_1; // Player 1 name
    String player_2; // Player 2 name
    TicTacToeBoard tic = new TicTacToeBoard(3); // Create 3x3 board
    boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        Intent intent = getIntent();

        if (intent != null) {
            player_1 = intent.getStringExtra("player1_name"); // Gets names
            player_2 = intent.getStringExtra("player2_name");
        }

        ImageView i = (ImageView) findViewById(R.id.player_icon);
        i.setImageResource(R.drawable.watermelon);

        TextView t = (TextView) findViewById(R.id.player_name);
        t.setText(player_1 + "'s turn.");

    }

    /**
     *  TicTacToeBoard class items are called to play the tic tac toe
     *
     * @param View view
     * @return
     */
    public void clickSquare(View view) {
        if(!active) {
            ImageView default_image = (ImageView) findViewById(R.id.player_icon);
            TextView txt = (TextView) findViewById(R.id.player_name);

            char symb = ' ';
            if (turn % 2 == 0)
                symb = 'x';
            else
                symb = 'o';

            int row = 0;
            int col = 0;

            ImageButton pick = (ImageButton) view;
            // Switch cases for squares
            switch (pick.getId()) {
                case R.id.row0col0:
                    row = 0;
                    col = 0;
                    break;

                case R.id.row0col1:
                    row = 0;
                    col = 1;
                    break;

                case R.id.row0col2:
                    row = 0;
                    col = 2;
                    break;

                case R.id.row1col0:
                    row = 1;
                    col = 0;
                    break;

                case R.id.row1col1:
                    row = 1;
                    col = 1;
                    break;

                case R.id.row1col2:
                    row = 1;
                    col = 2;
                    break;

                case R.id.row2col0:
                    row = 2;
                    col = 0;
                    break;

                case R.id.row2col1:
                    row = 2;
                    col = 1;
                    break;

                case R.id.row2col2:
                    row = 2;
                    col = 2;
                    break;

                default:
                    Log.d("Error", "Something went wrong.");
                    break;
            }

            try {
                if (tic.makeMove(new Coordinates(row, col), symb)) {
                    turn++;
                    if (symb == 'x') {
                        pick.setImageResource(R.drawable.watermelon);
                        txt.setText(player_2 + "'s turn.");
                    }
                    default_image.setImageResource(R.drawable.noodles);
                    if (symb == 'o') {
                        pick.setImageResource(R.drawable.noodles);
                        txt.setText(player_1 + "'s turn.");
                        default_image.setImageResource(R.drawable.watermelon);
                    }
                }
                else{
                    Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
            }

            active = tic.isWinner(symb);

            if (active) {
                TextView textViewOb = (TextView) findViewById(R.id.player_name);
                if (tic.getScratch() == 3 * 3)
                    textViewOb.setText("Draw game");
                else {
                    if (symb == 'x') {
                        textViewOb.setText("Congrats, " + player_1 + " you won!");
                        default_image.setImageResource(R.drawable.watermelon);

                    }
                    if (symb == 'o') {
                        textViewOb.setText("Congrats, " + player_2 + " you won!");
                        default_image.setImageResource(R.drawable.noodles);
                    }
                }
                Button a = (Button) findViewById(R.id.again);
                a.setVisibility(View.VISIBLE);

            }
        }

    }

    /**
     * Quit game to WelcomeActivity
     *
     * @param View view
     * @return
     */
    public void quitGame(View view){
        Intent intent = new Intent(this,
                WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Creates intent to make a new game
     *
     * @param View view
     * @return
     */
    public void playAgain(View view){
        Intent intent = new Intent(this,
                GameActivity.class);

        intent.putExtra("player1_name", player_1);
        intent.putExtra("player2_name", player_2);
        startActivity(intent);
    }

}