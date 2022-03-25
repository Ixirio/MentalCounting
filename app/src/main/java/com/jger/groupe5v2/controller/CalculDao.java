package com.jger.groupe5v2.controller;

import android.content.ContentValues;
import android.database.Cursor;

import com.jger.groupe5v2.model.ScoreUser;

public class CalculDao extends BaseDao<ScoreUser> {
    static String clePseudo = "pseudo";
    static String cleScore = "score";
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "scoreboard";
    }

    @Override
    protected void putValues(ContentValues values, ScoreUser entity) {
        values.put(clePseudo,entity.getPseudo());
        values.put(cleScore,entity.getScore());

    }

    @Override
    protected ScoreUser getEntity(Cursor cursor) {
        cursor.moveToFirst();
        Integer indexPseudo = cursor.getColumnIndex(clePseudo);
        Integer indexScore = cursor.getColumnIndex(cleScore);
        ScoreUser scoreUser = new ScoreUser(clePseudo, cleScore);
        scoreUser.setPseudo(cursor.getString(indexPseudo));
        scoreUser.setScore(cursor.getString(indexScore));
        cursor.close();
        return scoreUser;
    }


}