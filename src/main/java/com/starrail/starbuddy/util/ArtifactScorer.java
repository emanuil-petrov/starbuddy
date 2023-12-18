package com.starrail.starbuddy.util;

import java.util.Map;

public class ArtifactScorer {
    private final Map<String, Double> MIN_ROLLS =
            Map.ofEntries(
            Map.entry("HP", 33d),
            Map.entry("ATK", 16d),
            Map.entry("DEF", 16d),
            Map.entry("SPD", 2d),
            Map.entry("HP_PERCENT", 0.34),
            Map.entry("ATK_PERCENT", 0.34),
            Map.entry("DEF_PERCENT", 0.43),
            Map.entry("CRIT_RATE", 0.25),
            Map.entry("CRIT_DMG", 0.51),
            Map.entry("EFFECT_HIT_RATE", 0.34),
            Map.entry("EFFECT_RES", 0.34),
            Map.entry("BREAK_EFFECT", 0.51));






}
