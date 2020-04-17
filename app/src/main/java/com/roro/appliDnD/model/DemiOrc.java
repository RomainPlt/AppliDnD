package com.roro.appliDnD.model;

public class DemiOrc  extends PersoRace {

    public DemiOrc(){
        super("Demi-Orc");
    }

    @Override
    public int getBonusForce() {
        return 1;
    }

    @Override
    public String getText() {
        return "Whether united under the leadership of a mighty warlock or having fought to a standstill " +
                "after years of conflict, orc and human tribes sometimes form alliances, joining forces " +
                "into a larger horde to the terror of civilized lands nearby. When these alliances are " +
                "sealed by marriages, half-orcs are born. Some half-orcs rise to become proud chiefs of orc tribes," +
                " their human blood giving them an edge over their full-blooded orc rivals. " +
                "Some venture into the world to prove their worth among humans and other more civilized races. " +
                "Many of these become adventurers, achieving greatness for their mighty deeds and notoriety " +
                "for their barbaric customs and savage fury.";
    }
}
