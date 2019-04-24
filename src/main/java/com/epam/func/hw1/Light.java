package com.epam.func.hw1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Light {

    private Color color;
    private int duration;

    public Light(Color color, int duration) {
        this.color = color;
        this.duration = duration;
    }
}
