package com.jger.groupe5v2.controller;

import com.jger.groupe5v2.model.ScoreUser;

public class CalculService {
    private CalculDao calculDao;

    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public void storeInDB(ScoreUser scoreUser){
        calculDao.create(scoreUser);
    }


}
