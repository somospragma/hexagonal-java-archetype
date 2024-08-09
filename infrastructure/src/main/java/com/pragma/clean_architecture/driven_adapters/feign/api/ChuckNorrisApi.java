package com.pragma.clean_architecture.driven_adapters.feign.api;

import com.pragma.clean_architecture.driven_adapters.feign.dto.JokeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ChuckNorrisApi", url = "https://api.chucknorris.io/jokes")
public interface ChuckNorrisApi {

    @GetMapping(path = "/categories",produces = "application/json")
    List<String> getCategories();

    @GetMapping(path = "/random" ,produces = "application/json")
    JokeDto getRandomJoke(@RequestParam("category") String category);
}
