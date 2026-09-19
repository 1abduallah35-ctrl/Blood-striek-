package com.bloodstriek.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout root;

    int white = Color.WHITE;
    int red = Color.rgb(210, 20, 35);
    int dark = Color.rgb(10, 10, 14);
    int gray = Color.rgb(30, 30, 38);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    TextView title(String text, int size) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(white);
        t.setTextSize(size);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setGravity(Gravity.CENTER);
        t.setPadding(10, 20, 10, 20);
        return t;
    }

    Button gameButton(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextColor(white);
        b.setTextSize(17);
        b.setAllCaps(false);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(gray);
        bg.setCornerRadius(30);
        bg.setStroke(2, red);

        b.setBackground(bg);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        65
                );

        p.setMargins(0, 10, 0, 10);
        b.setLayoutParams(p);

        return b;
    }

    void baseScreen() {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(35, 30, 35, 30);
        root.setBackgroundColor(dark);
        setContentView(root);
    }

    void showHome() {
        baseScreen();

        TextView logo = title("BLOOD STRIEK", 36);
        logo.setTextColor(red);
        root.addView(logo);

        TextView subtitle = title("BATTLE • SURVIVE • STRIKE", 14);
        root.addView(subtitle);

        Button start = gameButton("🎮  START GAME");
        Button missions = gameButton("🎯  MISSIONS");
        Button profile = gameButton("👤  PROFILE");
        Button settings = gameButton("⚙  SETTINGS");
        Button exit = gameButton("EXIT");

        root.addView(start);
        root.addView(missions);
        root.addView(profile);
        root.addView(settings);
        root.addView(exit);

        start.setOnClickListener(v ->
                Toast.makeText(this, "GAME STARTING...", Toast.LENGTH_SHORT).show()
        );

        missions.setOnClickListener(v -> showPage("MISSIONS"));

        profile.setOnClickListener(v -> showPage("PROFILE"));

        settings.setOnClickListener(v -> showPage("SETTINGS"));

        exit.setOnClickListener(v -> finish());
    }

    void showPage(String name) {
        baseScreen();

        TextView t = title(name, 32);
        t.setTextColor(red);
        root.addView(t);

        TextView info = title(
                "BLOOD STRIEK\n\nThis section is ready.\nMore game features can be added here.",
                18
        );

        root.addView(info);

        Button back = gameButton("← BACK");

        root.addView(back);

        back.setOnClickListener(v -> showHome());
    }
    }
