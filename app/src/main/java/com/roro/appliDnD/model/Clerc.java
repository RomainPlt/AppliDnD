package com.roro.appliDnD.model;

public class Clerc extends PersoClass {

    public Clerc(){
        super("Clerc");
    }

    @Override
    public int getDeVie() {
        return 8;
    }


    @Override
    public int getBonusDexterite() {
        return -1;
    }

    @Override
    public int getBonusSagesse() {
        return 2;
    }

    @Override
    public String getText() {
        return "Clerics are intermediaries between the mortal world and the distant" +
                " planes of the gods. As varied as the gods they serve, clerics strive " +
                "to embody the handiwork of their deities. No ordinary priest, a cleric is imbued with divine magic.";
    }
}
