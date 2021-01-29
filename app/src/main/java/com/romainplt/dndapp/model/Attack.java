package com.romainplt.dndapp.model;

public class Attack {

    private String name;
    private int nbDice;
    private int typeDice;
    private String description;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbDice() {
        return nbDice;
    }

    public void setNbDice(int nbDice) {
        this.nbDice = nbDice;
    }

    public int getTypeDice() {
        return typeDice;
    }

    public void setTypeDice(int typeDice) {
        this.typeDice = typeDice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
