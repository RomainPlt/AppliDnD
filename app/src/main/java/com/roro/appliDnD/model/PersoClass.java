package com.roro.appliDnD.model;

import java.io.Serializable;

public abstract class PersoClass implements Serializable {

    public String name;
    protected String textClass;

    public PersoClass(String name){
        this.name = name;
    }

    public int getDeVie(){
        return 0;
    }

    public int getBonusForce(){
        return 0;
    }

    public int getBonusSagesse(){
        return 0;
    }

    public int getBonusDexterite(){
        return 0;
    }

    public int getBonusConstitution(){
        return 0;
    }

    public int getBonusIntelligence(){
        return 0;
    }

    public int getBonusCharisme(){
        return 0;
    }

    public String getName(){
        return name;
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

    public String getText() {
        return textClass;
    }

}
