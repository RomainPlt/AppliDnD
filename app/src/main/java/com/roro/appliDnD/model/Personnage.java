package com.roro.appliDnD.model;



import com.roro.appliDnD.model.PersoClass;
import com.roro.appliDnD.model.PersoRace;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Personnage implements Serializable {

    private String name;
    private String sex;
    private int age;
    private PersoClass classe;
    private PersoRace race;
    private int force;
    private int dexterite;
    private int intelligence;
    private int sagesse;
    private int charisme;
    private int constitution;
    private int ptVie;
    private String historic;
    private ArrayList competences;

    public Personnage(String name, int age, String sex, PersoClass classe, PersoRace race) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.classe = classe;
        this.race = race;

        //this.force = (getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6));
        /*if (this.force + race.getBonusForce() + classe.getBonusForce() >= 18){
            this.force = 18;
        } else if (this.force + race.getBonusForce() + classe.getBonusForce() <= 3){
            this.force = 3;
        } else{
            this.force += race.getBonusForce() + classe.getBonusForce();
        }
        //this.sagesse = (getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6));
        if (this.sagesse + race.getBonusSagesse() + classe.getBonusSagesse() >= 18){
            this.sagesse = 18;
        } else if (this.sagesse + race.getBonusSagesse() + classe.getBonusSagesse() <= 3){
            this.sagesse = 3;
        } else {
            this.sagesse += race.getBonusSagesse() + classe.getBonusSagesse();
        }

        //this.dexterite = (getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6));
        if (this.dexterite + race.getBonusDexterite() + classe.getBonusDexterite() >= 18){
            this.dexterite = 18;
        } else if (this.dexterite + race.getBonusDexterite() + classe.getBonusDexterite() <= 3){
            this.dexterite = 3;
        } else {
            this.dexterite += race.getBonusDexterite() + classe.getBonusDexterite();
        }

        //this.constitution = (getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6));
        if (this.constitution + race.getBonusConstitution() + classe.getBonusConstitution() >= 18){
            this.constitution = 18;
        } else if (this.constitution + race.getBonusConstitution() + classe.getBonusConstitution() <= 3){
            this.constitution = 3;
        } else {
            this.constitution += race.getBonusConstitution() + classe.getBonusConstitution();
        }

        //this.intelligence = (getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6));
        if (this.intelligence + race.getBonusIntelligence() + classe.getBonusIntelligence() >= 18){
            this.intelligence = 18;
        } else if (this.intelligence + race.getBonusIntelligence() + classe.getBonusIntelligence() <= 3){
            this.intelligence = 3;
        } else {
            this.intelligence += race.getBonusIntelligence() + classe.getBonusIntelligence();
        }

        //this.charisme = (getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6)+getRandomIntegerBetweenRange(1,6));
        if (this.charisme + race.getBonusCharisme() + classe.getBonusCharisme() >= 18){
            this.charisme = 18;
        } else if (this.charisme + race.getBonusCharisme() + classe.getBonusCharisme() <= 3){
            this.charisme = 3;
        } else {
            this.charisme += race.getBonusCharisme() + classe.getBonusCharisme();
        }*/
    }



    public static int getRandomIntegerBetweenRange(double min, double max){

        int x = (int) ((Math.random()*((max-min)+1))+min);

        return x;

    }

    public int getPtVie(){
        return ptVie;
    }

    public void setPtVie(int ptVie){
        this.ptVie = getRandomIntegerBetweenRange(1, classe.getDeVie());
    }
    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public String getSex() {
        return sex;
    }

    public PersoClass getClasse() {
        return classe;
    }

    public PersoRace getRace() {
        return race;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force){
        this.force = force;
    }

    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intel){
        this.intelligence = intel;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setDexterite(int dexterite){
        this.dexterite = dexterite;
    }

    public int getSagesse() {
        return sagesse;
    }
    public void setSagesse(int sagesse){
        this.sagesse = sagesse;
    }
    public int getCharisme() {
        return charisme;
    }
    public void setCharisme(int charisme){
        this.charisme = charisme;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution){
        this.constitution = constitution;
    }

    public void setClasse(PersoClass classe){
        this.classe = classe;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setSex(String sex){
        this.sex = sex;
    }

    public void setHistoric(String historic){
        this.historic = historic;
    }

    public String getHistoric(){
        return historic;
    }

    public void setCompetences(ArrayList competences){
        this.competences = competences;
    }

    public ArrayList getCompetences(){
        return competences;
    }

}
