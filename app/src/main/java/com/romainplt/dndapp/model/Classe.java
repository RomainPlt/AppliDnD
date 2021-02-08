package com.romainplt.dndapp.model;

public class Classe {

    private String classeName;
    private Characteristics[] adjustment;
    private int healthPointAdjustment;
    private Skills skillsAdjustment;
    private Attack[] attack;
    private Spell[] spells;
    private Equipment[] beginningEquipment;
    private Money[] beginningMoney;

    public String getClasseName() {
        return classeName;
    }

    public void setClasseName(String classeName) {
        this.classeName = classeName;
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

    public Skills getSkillsAdjustment() {
        return skillsAdjustment;
    }

    public void setSkillsAdjustment(Skills skillsAdjustment) {
        this.skillsAdjustment = skillsAdjustment;
    }
    public void whichSkills(Classe classe){
        switch (classe.getClasseName()){
            case "Warrior":
            case "Thief":
            case "Assassin":
            case "Barbarian":
            case "Sorcerer":
            case "Magician":
            case "Priest":
            case "Monk":
            case "Ranger":
            case "Druid":


        }
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

    public Equipment[] getBeginningEquipment() {
        return beginningEquipment;
    }

    public void setBeginningEquipment(Equipment[] beginningEquipment) {
        this.beginningEquipment = beginningEquipment;
    }

    public Money[] getBeginningMoney() {
        return beginningMoney;
    }

    public void setBeginningMoney(Money[] beginningMoney) {
        this.beginningMoney = beginningMoney;
    }
}
