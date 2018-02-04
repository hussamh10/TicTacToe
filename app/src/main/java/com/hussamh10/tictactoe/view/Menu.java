package com.hussamh10.tictactoe.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.hussamh10.tictactoe.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button play =(Button) findViewById(R.id.btn_play);
        Typeface roboto = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Thin.ttf");
        play.setTypeface(roboto);
        MobileAds.initialize(this, "ca-app-pub-4795330703429435~6593685943");
        AdView mAdView = (AdView) findViewById(R.id.ad_menu);


        AdRequest request = new AdRequest.Builder()
                .addTestDevice("66e010dce36d0c6d")
                .build();

        mAdView.loadAd(request );

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent opener = new Intent(Menu.this, Game.class);
                Menu.this.startActivity(opener);
            }
        });

    }

}