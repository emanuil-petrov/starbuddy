package com.starrail.starbuddy.model;

public enum ArtifactTypes {
    HEAD,
    HANDS,
    BODY,
    FEET,
    SPHERE,
    ROPE;

    public String getFormattedName() {
        String name = name().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
