package com.pragma.clean_architecture.driven_adapters.feign.api;

import com.pragma.clean_architecture.driven_port.api.ChuckNorrisApiPort;
import com.pragma.clean_architecture.model.JokeModel;
import com.pragma.clean_architecture.driven_adapters.feign.mapper.JokeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Component
public class ChuckNorrisApiPortImpl implements ChuckNorrisApiPort {

    private ChuckNorrisApi chuckNorrisApi;
    private JokeMapper jokeMapper;

    @Override
    public String getRandomCategory() {
        List<String> categories = chuckNorrisApi.getCategories();
        return categories.get(new Random().nextInt(categories.size()));
    }

    @Override
    public JokeModel getJoke(String category) {
        return jokeMapper.mapToModel(chuckNorrisApi.getRandomJoke(category));
    }
}
