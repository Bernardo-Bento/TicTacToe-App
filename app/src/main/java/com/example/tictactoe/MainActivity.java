package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private static int currentPlayer;
    private static Button [] playBtn = new Button[9];
    private static String playmark = "X";
    static int winner = 0;
    private int blocked = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creteArray();
        currentPlayer = randomPlayer();
        playerTurn();
    }

    private int randomPlayer(){
        Random r = new Random();
        int upperbound = 2; // random number bound (0 - 1)
        int player = r.nextInt(upperbound);
        while(player!= 1 && player!= 2) {
            r = new Random();
            upperbound = 2; // random number bound (0 - 1)
            player = r.nextInt(upperbound+1);
        }
        return player;
    }

    public void playerTurn(){
        TextView p1 = findViewById(R.id.player1turn);
        TextView p2 = findViewById(R.id.player2turn);
        if(currentPlayer == 1) {
            p1.setBackgroundColor(Color.parseColor("#000000"));
            p2.setBackgroundColor(Color.parseColor("#EAF3F9"));
        }
        if(currentPlayer == 2) {
            p2.setBackgroundColor(Color.parseColor("#000000"));
            p1.setBackgroundColor(Color.parseColor("#EAF3F9"));
        }

    }

    private void creteArray(){
        playBtn[0] = findViewById(R.id.btn1);
        playBtn[1] = findViewById(R.id.btn2);
        playBtn[2] = findViewById(R.id.btn3);
        playBtn[3] = findViewById(R.id.btn4);
        playBtn[4] = findViewById(R.id.btn5);
        playBtn[5] = findViewById(R.id.btn6);
        playBtn[6] = findViewById(R.id.btn7);
        playBtn[7] = findViewById(R.id.btn8);
        playBtn[8] = findViewById(R.id.btn9);
    }

    public void manageButtons(View view) {
        TextView p1 = findViewById(R.id.player1turn);
        TextView p2 = findViewById(R.id.player2turn);
        Button play = findViewById(view.getId());
        if (playerOneWin() == false && playerTwoWin() == false) {
            if (isEmpty(play) == true) {
                if (currentPlayer == 1) {
                    playerTurn();
                    playmark = "X";
                    play.setText(playmark);
                    play.setTextSize(70);
                    play.setTextColor(Color.parseColor("#FF5858"));
                    currentPlayer = 2;
                    playerTurn();
                    playerOneWin();
                    playerTwoWin();
                    draw();
                    return;
                }
                if (currentPlayer == 2) {
                    playerTurn();
                    playmark = "O";
                    play.setText(playmark);
                    play.setTextSize(70);
                    play.setTextColor(Color.parseColor("#43DAFF"));
                    currentPlayer = 1;
                    playerTurn();
                    playerOneWin();
                    playerTwoWin();
                    draw();
                    return;
                }
            }
        }
    }
    public boolean isEmpty(Button button){
        if(button.getText() != "X" && button.getText() != "O")
            return true;

        return false;
    }

    public boolean draw(){
        TextView result = findViewById(R.id.drawText);
        int counter = 0;
        for(int i = 0 ; i < playBtn.length ; i++){
            if(playBtn[i].getText()=="X" || playBtn[i].getText()=="O")
                counter++;
        }
        if(counter == 9 && playerOneWin() == false && playerTwoWin() == false){
            result.setText("Draw");
            result.setBackgroundColor(Color.parseColor("#6E72BB"));
            return true;
        }

        return false;
    }

    public boolean playerOneWin(){
        TextView result = findViewById(R.id.drawText);
        TextView scoreOne = findViewById(R.id.score1);
        int score = Integer.parseInt(scoreOne.getText().toString()) ;

        if( playBtn[0].getText() == "X" && playBtn[1].getText() == "X" && playBtn[2].getText() == "X"){
            playBtn[0].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[1].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[2].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;//columns
        }
        else if(playBtn[3].getText() == "X" && playBtn[4].getText() == "X" && playBtn[5].getText() == "X" ){
            playBtn[3].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[5].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;

        }
        else if(playBtn[6].getText() == "X" && playBtn[7].getText() == "X" && playBtn[8].getText() == "X" ){
            playBtn[6].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[7].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[8].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        else if (playBtn[0].getText() == "X" && playBtn[3].getText() == "X" && playBtn[6].getText() == "X"){
            playBtn[0].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[3].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[6].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;

        }
        else if(playBtn[1].getText() == "X" && playBtn[4].getText() == "X" && playBtn[7].getText() == "X"){
            playBtn[1].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[7].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;

        }
        else if(playBtn[2].getText() == "X" && playBtn[5].getText() == "X" && playBtn[8].getText() == "X") {
            playBtn[2].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[5].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[8].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;
        }

        else if (playBtn[0].getText() == "X" && playBtn[4].getText() == "X" && playBtn[8].getText() == "X" ){
            playBtn[0].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[8].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        else if(playBtn[2].getText() == "X" && playBtn[4].getText() == "X" && playBtn[6].getText() == "X" ){
            playBtn[2].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[6].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 1 won");
            result.setBackgroundColor(Color.parseColor("#FF5858"));
            if(blocked == 0)
                scoreOne.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        return false;

    }
    public boolean playerTwoWin(){
        TextView result = findViewById(R.id.drawText);
        TextView scoreTwo = findViewById(R.id.score2);
        int score = Integer.parseInt(scoreTwo.getText().toString()) ;

        if( playBtn[0].getText() == "O" && playBtn[1].getText() == "O" && playBtn[2].getText() == "O"){
            playBtn[0].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[1].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[2].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        else if(playBtn[3].getText() == "O" && playBtn[4].getText() == "O" && playBtn[5].getText() == "O" ){
            playBtn[3].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[5].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;

        }
        else if(playBtn[6].getText() == "O" && playBtn[7].getText() == "O" && playBtn[8].getText() == "O" ){
            playBtn[6].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[7].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[8].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        else if (playBtn[0].getText() == "O" && playBtn[3].getText() == "O" && playBtn[6].getText() == "O"){
            playBtn[0].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[3].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[6].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;

        }
        else if(playBtn[1].getText() == "O" && playBtn[4].getText() == "O" && playBtn[7].getText() == "O"){
            playBtn[1].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[7].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;

        }
        else if(playBtn[2].getText() == "O" && playBtn[5].getText() == "O" && playBtn[8].getText() == "O") {
            playBtn[2].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[5].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[8].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;
        }

        else if (playBtn[0].getText() == "O" && playBtn[4].getText() == "O" && playBtn[8].getText() == "O" ){
            playBtn[0].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[8].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        else if(playBtn[2].getText() == "O" && playBtn[4].getText() == "O" && playBtn[6].getText() == "O" ){
            playBtn[2].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[4].setBackgroundColor(Color.parseColor("#00FF00"));
            playBtn[6].setBackgroundColor(Color.parseColor("#00FF00"));
            result.setText("Player 2 won");
            result.setBackgroundColor(Color.parseColor("#43DAFF"));
            if(blocked == 0)
                scoreTwo.setText( ""+(score+1));

            blocked = 1;
            return true;
        }
        return false;

    }

    public void resetGame(View view){
        TextView result = findViewById(R.id.drawText);
        for(int i = 0; i < playBtn.length; i++){
            playBtn[i].setText("");
            playBtn[i].setBackgroundColor(Color.parseColor("#EAF3F9"));
        }
        result.setText("");
        blocked = 0;
        currentPlayer = randomPlayer();
        playerTurn();
    }

}