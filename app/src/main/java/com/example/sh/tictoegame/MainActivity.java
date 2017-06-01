package com.example.sh.tictoegame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

    void playGame(int CELLID, Button bt){
        Log.d("Cell ID",String.valueOf(CELLID));
    }
}
