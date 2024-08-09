package com.pragma.clean_architecture.driven_port.api;

import com.pragma.clean_architecture.model.JokeModel;

public interface ChuckNorrisApiPort {

    String getRandomCategory();
    JokeModel getJoke(String category);
}
