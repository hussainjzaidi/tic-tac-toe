package com.example.tictactoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TicTacToe mGame;
    private Button[][] mButtons;
    private Button resetGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGame = new TicTacToe();
        mButtons = new Button[TicTacToe.gameRows][TicTacToe.gameCols];
        resetGame = (Button) findViewById(R.id.game_reset);
        for (int i = 0; i < TicTacToe.gameRows; i++) {
            for (int j = 0; j < TicTacToe.gameCols; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                mButtons[i][j] = findViewById(resID);
                mButtons[i][j].setOnClickListener(this);
            }
        }
        resetGame.setOnClickListener(this);
    }
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.game_reset) {
            mGame.newGame();
        }
        for (int i = 0; i < TicTacToe.gameRows; i++) {
            for (int j = 0; j < TicTacToe.gameCols; j++) {
                if (view.getId() == mButtons[i][j].getId()) {
                    mGame.buttonPressed(i, j);
                }
            }
        }
        for (int i = 0; i < TicTacToe.gameRows; i++) {
            for ( int j = 0; j < TicTacToe.gameCols; j++) {
                    mButtons[i][j].setText(mGame.setButton(i, j));
            }
        }
    }
}
