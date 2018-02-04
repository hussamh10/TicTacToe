package com.hussamh10.tictactoe.view;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.hussamh10.tictactoe.game.Board;
import com.hussamh10.tictactoe.game.Move;
import com.hussamh10.tictactoe.R;

public class Game extends AppCompatActivity {

    private static Board board = new Board();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        printBoard();
        setListeners();

        AdView mAdView = (AdView) findViewById(R.id.ad_game);

        AdRequest request = new AdRequest.Builder()
                .addTestDevice("66e010dce36d0c6d")
                .build();

        mAdView.loadAd(request );
    }

    private void setListeners(){
        int imgs [] = new int[9];
        imgs[0] = R.id.mark1;
        imgs[1] = R.id.mark2;
        imgs[2] = R.id.mark3;
        imgs[3] = R.id.mark4;
        imgs[4] = R.id.mark5;
        imgs[5] = R.id.mark6;
        imgs[6] = R.id.mark7;
        imgs[7] = R.id.mark8;
        imgs[8] = R.id.mark9;

        Move mv [] = new Move[9];

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mv[k] = new Move(i, j);
                k++;
            }
        }

        for (int i = 0; i < 9; i++) {
            ImageView img= (ImageView) findViewById(imgs[i]);
            img.setTag(mv[i]);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Move mv = (Move) v.getTag();
                    Game.board.makeMove(mv.r, mv.c);
                    printBoard();
                }
            });
        }
    }

    private void printWinner(){
        ImageView img = (ImageView) findViewById(R.id.img_banner);
        img.setVisibility(View.VISIBLE);
    }

    private void printMark(int l, int mark){
        int imgs [] = new int[9];
        imgs[0] = R.id.mark1;
        imgs[1] = R.id.mark2;
        imgs[2] = R.id.mark3;
        imgs[3] = R.id.mark4;
        imgs[4] = R.id.mark5;
        imgs[5] = R.id.mark6;
        imgs[6] = R.id.mark7;
        imgs[7] = R.id.mark8;
        imgs[8] = R.id.mark9;

        ImageView img = (ImageView) findViewById(imgs[l]);

        if (mark == 1) {
            img.setBackground(getDrawable(R.drawable.x));
        }
        if (mark == 2) {
            img.setBackground(getDrawable(R.drawable.o));
        }

        if (board.hasWon() > 0){
            Toast.makeText(this, "You Lost", Toast.LENGTH_SHORT).show();
            printWinner();
        }
    }

    private void printBoard(){
        int b [][] = board.getBoard();
        int k = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] != 0){
                    printMark(k, b[i][j]);
                }
                k++;
            }
        }
    }
}
