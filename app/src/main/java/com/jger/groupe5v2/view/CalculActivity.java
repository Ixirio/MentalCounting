package com.jger.groupe5v2.view;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jger.groupe5v2.R;
import com.jger.groupe5v2.model.TypeOperationEnum;

public class CalculActivity extends AppCompatActivity {
    Integer reponse = 0;
    Integer resultat = 0;
    TypeOperationEnum typeOperation = null;
    TextView textViewCalcul;
    TextView textViewReponse;
    TextView textViewVies;
    TextView textViewScore;
    Integer BORNE_HAUTE = 9999;
    Integer BORNE_BASSE = -9999;
    Integer score = 0;
    String textScore = "0";
    String scoreIntent;
    String textVies = "3";
    Integer vies = 3;
    Boolean isNegative = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        textViewCalcul = findViewById(R.id.textviewCalcul);
        textViewReponse = findViewById(R.id.textviewReponse);
        textViewVies = findViewById(R.id.textViewVies);
        textViewScore = findViewById(R.id.textViewScore);
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(view -> ajouterNombre(1));
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(view -> ajouterNombre(2));
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(view -> ajouterNombre(3));
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(view -> ajouterNombre(4));
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(view -> ajouterNombre(5));
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(view -> ajouterNombre(6));
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(view -> ajouterNombre(7));
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(view -> ajouterNombre(8));
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(view -> ajouterNombre(9));
        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(view -> ajouterNombre(0));
        Button buttonNegative = findViewById(R.id.button_negative);
        buttonNegative.setOnClickListener((view -> setNegative()));
        Button buttonEffacer = findViewById(R.id.button_effacer);
        buttonEffacer.setOnClickListener((view -> videTextViewReponse()));
        Button buttonOk = findViewById(R.id.button_ok);
        buttonOk.setOnClickListener((view -> isItCorrect(reponse,resultat)));
        textVies=getString(R.string.toolbar_vies) + " : " + vies.toString();
        textViewVies.setText(textVies);
        textScore=getString(R.string.toolbar_score) + " : " + score.toString();
        textViewScore.setText(textScore);
        calculAleatoire();

    }
    //Fonction qui permet d'ajouter un "-" devant le nomnbre.
    //Si le nombre est égal à 0, on utilise un booléen pour savoir si il s'agit d'un
    //"zéro négatif" ou d'un "zéro positif" pour savoir si quand l'utilisateur entrera une valeur
    //elle sera positive ou négative
    public void setNegative(){
        if(reponse==0){
            isNegative=!isNegative;
        }
        reponse= - reponse;
        majText();
    }
    //Fonction permettant d'ajouter un nombre.
    public void ajouterNombre(Integer valeur) {
        if (typeOperation == null) {
            if (10 * reponse + valeur > BORNE_HAUTE) {
                Toast.makeText(this, getString(R.string.ERROR_VALEUR_TROP_GRANDE), Toast.LENGTH_LONG).show();
            } else if (10 * reponse - valeur < BORNE_BASSE) {
                Toast.makeText(this, getString(R.string.ERROR_VALEUR_TROP_PETITE), Toast.LENGTH_LONG).show();
            }else {
                if(reponse>0){
                    reponse = 10 * reponse + valeur;
                }
                else if(reponse<0) {
                    reponse = 10 * reponse - valeur;
                }
                //On utilise ici le booléen créé plus tôt pour savoir si la valeur sera négative
                // ou positive
                else if(reponse==0){
                    if(isNegative){
                        reponse -= valeur;
                    }
                    else {
                        reponse+=valeur;
                    }
                }
            }
        }
        majText();
    }
    //Fonction qui génère un calcul aléatoire
    public void calculAleatoire(){

        int value1 = randomInt();
        int value2 = randomInt();

        char operator = randomOperator();

        resultat = calcul(value1, value2, operator);
        String CalculAAfficher = Integer.toString(value1) + operator + Integer.toString(value2) ;
        textViewCalcul.setText(CalculAAfficher);
    }
    //Génère un entier au hasard
    private int randomInt(){
        Random r = new Random();
        return r.nextInt(100);
    }
    //Choisit un opérateur au hasard
    private char randomOperator(){
        Random r = new Random();
        String operator = "*-+";
        return operator.charAt(r.nextInt(operator.length()));
    }
    //Fonction qui permet de donner la valeur que l'utilisateur devra trouver
    private int calcul(int v1, int v2, char operator){

        int res = 0;

        if(operator == '*'){
            res = v1 * v2;
        } else if(operator == '-'){
            res = v1 - v2;
        } else if(operator == '+'){
            res = v1 + v2;
        }
        return res;
    }

    //Fonction qui gère ce qui se passe quand l'utilisateur valide son résultat
    public void isItCorrect(int resUser, int resComputer) {
        //Si le résultat est bon, le score augmente
        if (resUser == resComputer && vies!=0) {
            score++;
            videTextViewReponse();
            calculAleatoire();
            isNegative=false;
            textScore=getString(R.string.toolbar_score) + " : " + score.toString();
            textViewScore.setText(textScore);
            majText();
        }
        //Si le résultat est faux mais qu'il reste des vies à l'utilisateur, il perd une vie
        else if(vies>1) {
            vies--;
            videTextViewReponse();
            calculAleatoire();
            isNegative=false;
            textVies=getString(R.string.toolbar_vies) + " : " + vies.toString();
            textViewVies.setText(textVies);
            majText();

        }
        else{
            //Si l'utilisateur a utilisé la flèche de retour pour tricher, et entrer le
            //bon résultat, il aura donc zéro vies mais un résultat correct,
            //un toast s'affichera pour lui indiquer qu'il triche
            if(resUser == resComputer){
                Toast.makeText(this, getString(R.string.TRICHE), Toast.LENGTH_LONG).show();
            }
            //L'utilisateur perd la partie, et arrive sur la page pour entrer son score
            vies=0;
            textVies=vies.toString();
            textVies=getString(R.string.toolbar_vies) + " : " + vies.toString();
            textViewVies.setText(textVies);
            majText();
            scoreIntent=score.toString();
            afficherFinDePartie();
        }
    }

    private void majText() {
        String textAAfficher = "";
        if (typeOperation == null) {
            textAAfficher = reponse.toString();
        }
        textViewReponse.setText(textAAfficher);
    }
    //Réinitialise les variables
    private void videTextViewReponse() {
        TextView textViewReponse = findViewById(R.id.textviewReponse);
        textViewReponse.setText("");
        reponse = 0;
        isNegative = false;
        typeOperation = null;
    }
    //Envoie l'utilisateur sur la page pour entrer son score
    private void afficherFinDePartie() {
        Intent intent = new Intent(this, AddScoreActivity.class);
        intent.putExtra("score",scoreIntent);
        startActivity(intent);
    }
}