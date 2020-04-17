package com.roro.appliDnD.model;

public class Warrior extends PersoClass {

    public Warrior (){
        super("Warrior");
    }

    @Override
    public int getDeVie() {
        return 10;
    }

    @Override
    public int getBonusForce() {
        return 1;
    }

    @Override
    public String getText() {
        return "All of these heroes are fighters, perhaps the most diverse class" +
                " of characters in the worlds of Dungeons & Dragons. Questing knights," +
                " conquering overlords, royal champions, elite foot soldiers, hardened" +
                " mercenaries, and bandit kings—as fighters, they all share an unparalleled " +
                "mastery with weapons and armor, and a thorough knowledge of the skills of combat." +
                " And they are well acquainted with death, both meting it out and staring it defiantly in the face.";
    }
}
