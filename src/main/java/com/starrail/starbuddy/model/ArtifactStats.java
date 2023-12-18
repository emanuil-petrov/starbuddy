package com.starrail.starbuddy.model;

public enum ArtifactStats {
    HP,
    ATK,
    DEF,
    SPD,
    HP_PERCENT,
    ATK_PERCENT,
    DEF_PERCENT,
    CRIT_RATE,
    CRIT_DMG,
    EFFECT_HIT_RATE,
    EFFECT_RES,
    BREAK_EFFECT;

    public String getFormattedName() {
        return switch (name()) {
            case "HP", "ATK", "DEF", "SPD" -> name();
            case "HP_PERCENT" -> "HP%";
            case "ATK_PERCENT" -> "ATK%";
            case "DEF_PERCENT" -> "DEF%";
            case "CRIT_RATE" -> "CRIT Rate";
            case "CRIT_DMG" -> "CRIT DMG";
            case "EFFECT_HIT_RATE" -> "Effect Hit Rate";
            case "EFFECT_RES" -> "Effect RES";
            case "BREAK_EFFECT" -> "Break Effect";
            default -> "";
        };
    }
}
