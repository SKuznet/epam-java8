package com.epam.func.hw1;

import com.epam.func.hw1.util.Light;

import java.io.IOException;

public interface TrafficLighterService {

    Light getCurrentLight(Double num) throws IOException;
}
