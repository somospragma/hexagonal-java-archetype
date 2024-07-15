package com.pragma.archetype.driven_port.api;

import com.pragma.archetype.model.JokeModel;

public interface ChuckNorrisApiPort {

    String getRandomCategory();
    JokeModel getJoke(String category);
}
