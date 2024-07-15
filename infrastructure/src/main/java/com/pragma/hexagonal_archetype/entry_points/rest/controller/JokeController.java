package com.pragma.hexagonal_archetype.entry_points.rest.controller;

import com.pragma.archetype.use_case.JokeUseCase;
import com.pragma.hexagonal_archetype.driven_adapters.feign.dto.JokeDto;
import com.pragma.hexagonal_archetype.driven_adapters.feign.mapper.JokeMapper;
import com.pragma.hexagonal_archetype.helpers.ResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/joke")
@RequiredArgsConstructor
public class JokeController {

    private final JokeUseCase jokeUseCase;
    private final JokeMapper jokeMapper;

    @GetMapping(path = "/random")
    public ResponseEntity<JokeDto> getAllUsers() {
        return ResponseHelper.successResponse(jokeMapper.mapToDto(jokeUseCase.getRandomJoke()));
    }
}
