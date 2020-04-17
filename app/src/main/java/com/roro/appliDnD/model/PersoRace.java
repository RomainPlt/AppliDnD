package com.roro.appliDnD.model;

import java.io.Serializable;

public abstract class PersoRace implements Serializable {

    protected String name;

    protected String textRace;

    public PersoRace(String raceName) {
        this.name = raceName;
    }

    public int getBonusForce() {
        return 0;
    }

    public int getBonusSagesse() {
        return 0;
    }

    public int getBonusDexterite() {
        return 0;
    }

    public int getBonusConstitution() {
        return 0;
    }

    public int getBonusIntelligence() {
        return 0;
    }

    public int getBonusCharisme() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return textRace;
    }

    public String getBonus(){
        String s = "";
        if (getBonusForce() != 0){
            s += "Force : +(" + getBonusForce() +")\n";
        }
        if (getBonusSagesse() != 0){
            s += "Sagesse : +(" + getBonusSagesse() +")\n";
        }
        if (getBonusDexterite() != 0){
            s += "Dextérité : +(" + getBonusDexterite() +")\n";
        }
        if (getBonusConstitution() != 0){
            s += "Constitution : +(" + getBonusConstitution() +")\n";
        }
        if (getBonusIntelligence() != 0){
            s += "Intelligence : +(" + getBonusIntelligence() +")\n";
        }
        if (getBonusCharisme() != 0){
            s += "Charisme : +(" + getBonusCharisme() +")\n";
        }
        return s;
    }

}
