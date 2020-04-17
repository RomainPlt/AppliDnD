package com.roro.appliDnD.model;

public class Mage extends PersoClass{

    public Mage(){
        super("Mage");
    }

    @Override
    public int getDeVie() {
        return 4;
    }

    @Override
    public int getBonusIntelligence() {
        return 1;
    }

    @Override
    public String getText() {
        return "Wizards are supreme magic-users, defined and united as a class " +
                "by the spells they cast. Drawing on the subtle weave of magic " +
                "that permeates the cosmos, wizards cast spells of explosive fire, " +
                "arcing lightning, subtle deception, and brute-force mind control. " +
                "Their magic conjures monsters from other planes of existence, glimpses" +
                " the future, or turns slain foes into zombies. Their mightiest spells " +
                "change one substance into another, call meteors down from the sky, or open portals to other worlds.";
    }
}
