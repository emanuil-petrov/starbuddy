package com.starrail.starbuddy.model;

import java.util.List;

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
            default -> throw new UnsupportedOperationException("Unexpected value: " + name());
        };
    }

    public List<Double> getPossibleSubStatValues() {
        return switch (name()) {
            case "HP" -> List.of(33.0, 38.0, 42.0);
            case "ATK", "DEF" -> List.of(16.0, 19.0, 21.0);
            case "HP_PERCENT", "ATK_PERCENT" -> List.of(0.034, 0.038, 0.044);
            case "DEF_PERCENT" -> List.of(0.043, 0.048, 0.054);
            case "CRIT_RATE" -> List.of(0.025, 0.029, 0.032);
            case "CRIT_DMG", "BREAK_EFFECT" -> List.of(0.051, 0.058, 0.065);
            case "EFFECT_HIT_RATE", "EFFECT_RES" -> List.of(0.034, 0.038, 0.043);
            case "SPD" -> List.of(2.0, 2.3, 2.6);
            default -> throw new UnsupportedOperationException("Unexpected value: " + name());
        };
    }

}
