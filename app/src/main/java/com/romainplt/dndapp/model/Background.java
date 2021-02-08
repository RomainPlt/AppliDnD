package com.romainplt.dndapp.model;

public class Background {

    private String Name;
    private String description;
    private Skills backgroundSkills;
    private String[] backgroundLanguages;
    private Equipment[] backgroundEquipment;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skills getBackgroundSkills() {
        return backgroundSkills;
    }

    public void setBackgroundSkills(Skills backgroundSkills) {
        this.backgroundSkills = backgroundSkills;
    }

    public String[] getBackgroundLanguages() {
        return backgroundLanguages;
    }

    public void setBackgroundLanguages(String[] backgroundLanguages) {
        this.backgroundLanguages = backgroundLanguages;
    }

    public Equipment[] getBackgroundEquipment() {
        return backgroundEquipment;
    }

    public void setBackgroundEquipment(Equipment[] backgroundEquipment) {
        this.backgroundEquipment = backgroundEquipment;
    }
}
