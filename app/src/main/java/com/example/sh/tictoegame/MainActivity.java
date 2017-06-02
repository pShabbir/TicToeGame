package com.example.sh.tictoegame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BuClick(View view) {
        Button bt = (Button)view;
        bt.setBackgroundColor(Color.RED);
        int CELLID = 0;
        switch ((bt.getId())){
            case R.id.bt1:
                CELLID = 1;
                break;
            case R.id.bt2:
                CELLID = 2;
                break;
            case R.id.bt3:
                CELLID = 3;
                break;
            case R.id.bt4:
                CELLID = 4;
                break;
            case R.id.bt5:
                CELLID = 5;
                break;
            case R.id.bt6:
                CELLID = 6;
                break;
            case R.id.bt7:
                CELLID = 7;
                break;
            case R.id.bt8:
                CELLID = 8;
                break;
            case R.id.bt9:
                CELLID = 9;
                break;
        }
        playGame(CELLID , bt);

    }
    int ActivePlayer  = 1; // 1- player 1 , 2- player 2
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();



    void playGame(int CELLID, Button bt)
    {
        if(ActivePlayer == 1){
            bt.setText("X");
            bt.setBackgroundColor(Color.RED);
            player1.add(CELLID);
            bt.setClickable(false);
           ActivePlayer = 2;
            autoPlay();
        }else  if(ActivePlayer == 2){
            bt.setText("Y");
            bt.setBackgroundColor(Color.BLUE);
            player2.add(CELLID);
            bt.setClickable(false);
            ActivePlayer = 1;
        }
        checkWinner();

        Log.d("Cell ID",String.valueOf(CELLID));
    }
    void autoPlay( ){
        ArrayList<Integer> computer = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(!((player1.contains(i))||(player2.contains(i)))){
                computer.add(i);
            }
        }

        Random rand = new Random();
        int n=0;

       if(!computer.isEmpty())
             n = rand.nextInt(computer.size()-0) + 0;
        int CELLID  = computer.get(n);
        Button bt;
        switch (CELLID){
            case 1:
                bt = (Button)findViewById(R.id.bt1);
                break;
            case 2:
                bt = (Button)findViewById(R.id.bt2);
                break;
            case 3:
                bt = (Button)findViewById(R.id.bt3);
                break;
            case 4:
                bt = (Button)findViewById(R.id.bt4);
                break;
            case 5:
                bt = (Button)findViewById(R.id.bt5);
                break;
            case 6:
                bt = (Button)findViewById(R.id.bt6);
                break;
            case 7:
                bt = (Button)findViewById(R.id.bt7);
                break;
            case 8:
                bt = (Button)findViewById(R.id.bt8);
                break;
            case 9:
                bt = (Button)findViewById(R.id.bt9);
                break;
                default:
                    bt=(Button)findViewById(R.id.bt1);
        }
        playGame(CELLID,bt);

    }
    void checkWinner(){
        int winner = -1;

        //Row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1;
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2;
        //Row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1;
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2;
        //Row 1
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1;
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2;
        //Column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1;
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2;
        //Column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1;
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2;
        //Column 1
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1;
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2;
        //Diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1;
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2;
        //Diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(6))
            winner = 1;
        if(player2.contains(3) && player2.contains(5) && player2.contains(6))
            winner = 2;

        //Check for draw
        if(winner == -1 && player1.size() == 3 && player2.size()==3){
            Toast.makeText(this,"Match is a draw",Toast.LENGTH_LONG).show();
        }

        declareWinner(winner);
    }
    void declareWinner(int Winner){
        if(Winner == 1){
            Toast.makeText(this,"Player 1 Won",Toast.LENGTH_LONG).show();
            gameReset();
        }else if(Winner ==2){
            Toast.makeText(this,"Player 2 Won",Toast.LENGTH_LONG).show();
            gameReset();
        }
    }
    void gameReset(){
        Intent i = getIntent();
        finish();
        startActivity(i);
    }
}
