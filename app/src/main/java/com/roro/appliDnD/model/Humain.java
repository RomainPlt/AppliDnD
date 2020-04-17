package com.roro.appliDnD.model;

public class Humain extends PersoRace {

    public Humain() {
        super("Humain");
    }

    @Override
    public int getBonusForce() {
        return 2;
    }

    @Override
    public int getBonusSagesse(){
        return -1;
    }

    @Override
    public int getBonusIntelligence() {
        return 1;
    }

    @Override
    public String getText() {
        return "In the reckonings of most worlds, humans are the youngest of the common races, " +
                "late to arrive on the world scene and short-lived in comparison to dwarves, " +
                "elves, and dragons. Perhaps it is because of their shorter lives that they " +
                "strive to achieve as much as they can in the years they are given. Or maybe " +
                "they feel they have something to prove to the elder races, and that’s why they " +
                "build their mighty empires on the foundation of conquest and trade. Whatever drives " +
                "them, humans are the innovators, the achievers, and the pioneers of the worlds.";

    }
}


