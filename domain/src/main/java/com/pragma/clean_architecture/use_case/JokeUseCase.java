package com.pragma.clean_architecture.use_case;

import com.pragma.clean_architecture.driven_port.api.ChuckNorrisApiPort;
import com.pragma.clean_architecture.model.JokeModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JokeUseCase {

    private ChuckNorrisApiPort chuckNorrisApiPort;

    public JokeModel getRandomJoke(){
        return chuckNorrisApiPort.getJoke(chuckNorrisApiPort.getRandomCategory());
    }
}
