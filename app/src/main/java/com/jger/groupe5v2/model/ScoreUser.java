package com.jger.groupe5v2.model;

public class ScoreUser extends BaseEntity {
    String pseudo;
    String score;

    public ScoreUser(String pseudo, String score) {
        this.pseudo = pseudo;
        this.score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getScore() {
        return score;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
