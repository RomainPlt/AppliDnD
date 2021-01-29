package com.romainplt.dndapp.model;

public class Race {

    private String raceName;
    private Characteristics[] adjustment;
    private int healthPointAdjustment;
    private Skills[] skillsAdjustment;
    private Attack[] attack;
    private Spell[] spells;
    private String[] languages;


    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Characteristics[] getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Characteristics[] adjustment) {
        this.adjustment = adjustment;
    }

    public int getHealthPointAdjustment() {
        return healthPointAdjustment;
    }

    public void setHealthPointAdjustment(int healthPointAdjustment) {
        this.healthPointAdjustment = healthPointAdjustment;
    }

    public Skills[] getSkillsAdjustment() {
        return skillsAdjustment;
    }

    public void setSkillsAdjustment(Skills[] skillsAdjustment) {
        this.skillsAdjustment = skillsAdjustment;
    }

    public Attack[] getAttack() {
        return attack;
    }

    public void setAttack(Attack[] attack) {
        this.attack = attack;
    }

    public Spell[] getSpells() {
        return spells;
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
