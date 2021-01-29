package com.romainplt.dndapp.model;

public class Equipment {
    private String type;
    private int AC;
    private Characteristics[] characteristicsEffects;
    private int healthEffect;
    private Attack[] attackEffects;
    private Money[] price;
    private Skills[] skillsEffect;
    private int weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public Characteristics[] getCharacteristicsEffects() {
        return characteristicsEffects;
    }

    public void setCharacteristicsEffects(Characteristics[] characteristicsEffects) {
        this.characteristicsEffects = characteristicsEffects;
    }

    public int getHealthEffect() {
        return healthEffect;
    }

    public void setHealthEffect(int healthEffect) {
        this.healthEffect = healthEffect;
    }

    public Attack[] getAttackEffects() {
        return attackEffects;
    }

    public void setAttackEffects(Attack[] attackEffects) {
        this.attackEffects = attackEffects;
    }

    public Money[] getPrice() {
        return price;
    }

    public void setPrice(Money[] price) {
        this.price = price;
    }

    public Skills[] getSkillsEffect() {
        return skillsEffect;
    }

    public void setSkillsEffect(Skills[] skillsEffect) {
        this.skillsEffect = skillsEffect;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
