package com.learning.task7;

import java.io.Serializable;

class Creature implements Serializable {

    private int hp;

    private String name;

    Creature(int hp, String name){
        this.hp = hp;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}
