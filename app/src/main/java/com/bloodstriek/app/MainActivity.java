package com.bloodstriek.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(40, 40, 40, 40);
        layout.setBackgroundColor(Color.BLACK);

        TextView title = new TextView(this);
        title.setText("BLOOD STRIEK");
        title.setTextColor(Color.RED);
        title.setTextSize(36);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        Button start = new Button(this);
        start.setText("START GAME");

        Button settings = new Button(this);
        settings.setText("SETTINGS");

        Button exit = new Button(this);
        exit.setText("EXIT");

        layout.addView(title);
        layout.addView(start);
        layout.addView(settings);
        layout.addView(exit);

        setContentView(layout);
    }
            }
