package com.jger.groupe5v2.view;

import androidx.appcompat.app.AppCompatActivity;
import com.jger.groupe5v2.R;
import com.jger.groupe5v2.controller.CalculService;

import android.os.Bundle;


public class ViewHighScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_high_scores);

    }

    public void AfficheFiveBest(){

        // On est censés afficher les 5 meilleurs scores, mais on arrive pas à récupérer les données de la base '^^



    }
}