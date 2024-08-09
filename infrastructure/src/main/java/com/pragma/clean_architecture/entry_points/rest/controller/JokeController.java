package com.pragma.clean_architecture.entry_points.rest.controller;

import com.pragma.clean_architecture.use_case.JokeUseCase;
import com.pragma.clean_architecture.driven_adapters.feign.dto.JokeDto;
import com.pragma.clean_architecture.driven_adapters.feign.mapper.JokeMapper;
import com.pragma.clean_architecture.helpers.ResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(path = "/joke")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class JokeController {

    private final JokeUseCase jokeUseCase;
    private final JokeMapper jokeMapper;

    @GetMapping(path = "/random")
    public ResponseEntity<JokeDto> getAllUsers() {
        return ResponseHelper.successResponse(jokeMapper.mapToDto(jokeUseCase.getRandomJoke()));
    }
}
