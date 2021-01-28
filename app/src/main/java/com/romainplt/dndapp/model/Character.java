package com.romainplt.dndapp.model;

import android.graphics.Color;

public class Character {

    private String name;
    private String player;
    private Race race;
    private Classe classe;
    private God god;
    private int armorClass;
    private int healthPoint;
    private Spell[] spells;
    private int level;
    private int xp;
    private Description[] description; //Hair skin eyes color, height and weight, age, sex, aligment
    private Background background;
    private Characteristics[] characteristics;
    private Skills[] skills;
    private Equipment[] equipment;
    private SavingThrows[] savingThrows;
    private Attack[] attacks;
    private Money[] money;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public God getGod() {
        return god;
    }

    public void setGod(God god) {
        this.god = god;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public Spell[] getSpells() {
        return spells;
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Description[] getDescription() {
        return description;
    }

    public void setDescription(Description[] description) {
        this.description = description;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Characteristics[] getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics[] characteristics) {
        this.characteristics = characteristics;
    }

    public Skills[] getSkills() {
        return skills;
    }

    public void setSkills(Skills[] skills) {
        this.skills = skills;
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment[] equipment) {
        this.equipment = equipment;
    }

    public SavingThrows[] getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrows[] savingThrows) {
        this.savingThrows = savingThrows;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }
}
