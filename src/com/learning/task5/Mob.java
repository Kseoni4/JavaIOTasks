package com.learning.task5;

public class Mob extends Creature {

    private int atk;

    private int def;

    public Mob(int hp, String name, int atk, int def) {
        super(hp, name);
        this.atk = atk;
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
}
