package com.pragma.archetype.use_case;

import com.pragma.archetype.driven_port.api.ChuckNorrisApiPort;
import com.pragma.archetype.model.JokeModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JokeUseCase {

    private ChuckNorrisApiPort chuckNorrisApiPort;

    public JokeModel getRandomJoke(){
        return chuckNorrisApiPort.getJoke(chuckNorrisApiPort.getRandomCategory());
    }
}
