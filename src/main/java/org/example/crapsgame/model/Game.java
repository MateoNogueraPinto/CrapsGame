package org.example.crapsgame.model;

import org.example.crapsgame.model.exceptions.LostAfterFirstShotException;
import org.example.crapsgame.model.exceptions.LostInFirstShotException;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint() {
        this.point = dice1.getValue() + dice2.getValue();
    }

    public boolean isWin() {
        int value = this.dice1.getValue() + this.dice2.getValue();
        if(shootCount == 1 && (value == 7 || value == 11)) {
            return this.win = true;
        } else if (shootCount > 1 && value == point) {
            return this.lose = true;
        }
        return this.win;
    }

    public boolean isLose() throws LostInFirstShotException, LostAfterFirstShotException {
        int value = this.dice1.getValue() + this.dice2.getValue();
        if(shootCount == 1 && (value == 2 || value == 3 || value == 12)) {
            this.lose = true;
            throw new LostInFirstShotException("Perdiste en el primer tiro :(");
        } else if (shootCount > 1 && value == 7) {
            this.lose = true;
            throw new LostAfterFirstShotException("Perdiste después del primer tiro :(");
        }
        return false;
    }

    public void rollDices() {
        this.dice1.rollDice();
        this.dice2.rollDice();
        shootCount++;
        this.shoot = this.dice1.getValue() + this.dice2.getValue();
    }

    public Dice getDice1() {
        return this.dice1;
    }

    public Dice getDice2() {
        return this.dice2;
    }
}