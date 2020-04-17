package com.roro.appliDnD.model;

public class Elfe extends PersoRace {

    public Elfe (){
        super("Elfe");
    }

    @Override
    public int getBonusCharisme() {
        return 1;
    }

    @Override
    public int getBonusIntelligence() {
        return 1;
    }

    @Override
    public int getBonusConstitution() {
        return -1;
    }

    @Override
    public int getBonusSagesse() {
        return 1;
    }

    @Override
    public int getBonusForce() {
        return -1;
    }

    @Override
    public String getText() {
        return "Elves are a magical people of otherworldly grace, " +
                "living in the world but not entirely part of it." +
                " They live in places of ethereal beauty, in the midst of ancient " +
                "forests or in silvery spires glittering with faerie light, where" +
                " soft music drifts through the air and gentle fragrances waft on the breeze. " +
                "Elves love nature and magic, art and artistry, music and poetry, and the good things of the world.";
    }
}
