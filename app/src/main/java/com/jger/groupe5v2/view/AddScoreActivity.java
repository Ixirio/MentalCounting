package com.jger.groupe5v2.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.jger.groupe5v2.controller.CalculBaseHelper;
import com.jger.groupe5v2.controller.CalculDao;
import com.jger.groupe5v2.controller.CalculService;


import androidx.appcompat.app.AppCompatActivity;

import com.jger.groupe5v2.R;
import com.jger.groupe5v2.model.ScoreUser;

public class AddScoreActivity extends AppCompatActivity {
    EditText editName;
    String name;
    String score;
    CalculService calculService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        calculService = new CalculService(new CalculDao(new CalculBaseHelper(this)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_score);
        editName  = (EditText) findViewById(R.id.Enter_name_edit);
        Button buttonSubmit = findViewById(R.id.Add_score_button);
        buttonSubmit.setOnClickListener(view -> recupNomUser());
        Intent intent = getIntent();
        score = intent.getStringExtra("score");
    }

    // Récupère le nom entré, l'envoie dans la base de donnée avec le score (pas implémenté),
    // et amène l'utilisateur sur la page des highscores
    public void recupNomUser(){
        name = editName.getText().toString();
        ScoreUser scoreUser = new ScoreUser(name, score);
        calculService.storeInDB(scoreUser); // normalement ca stocke le score dans la base (normalement)
        Intent intent = new Intent(this, ViewHighScores.class);
        startActivity(intent);
    }

}