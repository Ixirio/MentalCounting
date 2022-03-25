package com.jger.groupe5v2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jger.groupe5v2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonCalculer = findViewById(R.id.button_newgame);
        Button boutonDernierCalcul = findViewById(R.id.bouton_highscores);
        boutonCalculer.setOnClickListener(view -> lancerActivityCalcul());
        boutonDernierCalcul.setOnClickListener(view -> lancerActivityHighScore());

    }
    //Envoie l'utilisateur sur la page pour voir les high scores
    private void lancerActivityHighScore() {
        Intent intent = new Intent(this, ViewHighScores.class);
        startActivity(intent);
    }
    //Envoie l'utilisateur sur la page pour jouer
    private void lancerActivityCalcul() {
        Intent intent = new Intent(this, CalculActivity.class);
        startActivity(intent);
    }
}