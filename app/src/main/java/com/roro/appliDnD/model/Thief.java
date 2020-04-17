package com.roro.appliDnD.model;

public class Thief extends PersoClass {

    public Thief(){
        super("Thief");
    }

    @Override
    public int getDeVie() {
        return 6;
    }

    @Override
    public int getBonusDexterite() {
        return 1;
    }

    @Override
    public String getText() {
        return "Rogues rely on skill, stealth, and their foes’ vulnerabilities to get " +
                "the upper hand in any situation. They have a knack for finding the " +
                "solution to just about any problem, demonstrating a resourcefulness " +
                "and versatility that is the cornerstone of any successful adventuring party.";
    }
}
