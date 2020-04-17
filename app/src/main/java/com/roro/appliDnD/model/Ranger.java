package com.roro.appliDnD.model;

public class Ranger extends PersoClass {

    public Ranger(){
        super("Ranger");
    }

    @Override
    public int getDeVie() {
        return 8;
    }

    @Override
    public int getBonusDexterite() {
        return 1;
    }

    @Override
    public int getBonusConstitution() {
        return -1;
    }

    @Override
    public int getBonusIntelligence() {
        return 1;
    }

    @Override
    public String getText() {
        return "Far from the bustle of cities and towns, " +
                "past the hedges that shelter the most distant " +
                "farms from the terrors of the wild, amid the dense-packed" +
                " trees of trackless forests and across wide and empty plains, " +
                "rangers keep their unending watch.";
    }
}
