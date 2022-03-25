package com.jger.groupe5v2.controller;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper {

    public CalculBaseHelper(Context context) {
        super(context, "historique", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS scoreboard (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDao.clePseudo + " INTEGER NOT NULL," +
                CalculDao.cleScore + " INTEGER NOT NULL," +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}