package com.starrail.starbuddy.model.entities;

import com.starrail.starbuddy.model.CharacterNames;
import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private CharacterNames name;

    @Column
    private String imageName;

    public CharacterNames getName() {
        return name;
    }

    public void setName(CharacterNames name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
