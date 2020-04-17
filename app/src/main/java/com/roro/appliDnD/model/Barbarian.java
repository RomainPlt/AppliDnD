package com.roro.appliDnD.model;

public class Barbarian extends PersoClass {

    public Barbarian(){
        super("Barbarian");
    }

    @Override
    public int getDeVie() {
        return 10;
    }

    @Override
    public int getBonusForce() {
        return 2;
    }

    @Override
    public int getBonusIntelligence() {
        return -1;
    }

    @Override
    public String getText() {
        return "For some, their rage springs from a communion with" +
                "fierce animal spirits. Others draw from a roiling" +
                " reservoir of anger at a world full of pain. For every barbarian," +
                " rage is a power that fuels not just a battle frenzy but also uncanny reflexes, " +
                "resilience, and feats of strength.";
    }
}
