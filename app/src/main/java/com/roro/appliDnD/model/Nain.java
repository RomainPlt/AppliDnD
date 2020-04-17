package com.roro.appliDnD.model;

public class Nain  extends PersoRace {

    public Nain(){
        super("Nain");
    }

    @Override
    public int getBonusForce() {
        return 2;
    }

    @Override
    public int getBonusConstitution() {
        return 1;
    }

    @Override
    public int getBonusSagesse() {
        return -1;
    }

    @Override
    public int getBonusCharisme() {
        return -1;
    }

    @Override
    public String getText() {
        return "Kingdoms rich in ancient grandeur, halls carved into the roots of mountains, " +
                "the echoing of picks and hammers in deep mines and blazing forges, " +
                "a commitment to clan and tradition, and a burning hatred of goblins " +
                "and orcs—these common threads unite all dwarves.";
    }
}
