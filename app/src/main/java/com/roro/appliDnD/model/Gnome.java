package com.roro.appliDnD.model;

public class Gnome  extends PersoRace {

    public Gnome(){
        super("Gnome");
    }

    @Override
    public int getBonusIntelligence() {
        return 2;
    }

    @Override
    public int getBonusSagesse() {
        return 1;
    }

    @Override
    public int getBonusConstitution() {
        return -1;
    }

    @Override
    public int getBonusForce() {
        return -1;
    }

    @Override
    public String getText() {
        return "A constant hum of busy activity pervades the warrens " +
                "and neighborhoods where gnomes form their close-knit " +
                "communities. Louder sounds punctuate the hum: a crunch " +
                "of grinding gears here, a minor explosion there, a yelp " +
                "of surprise or triumph, and especially bursts of laughter. " +
                "Gnomes take delight in life, enjoying every moment of invention, " +
                "exploration, investigation, creation, and play.";
    }
}
