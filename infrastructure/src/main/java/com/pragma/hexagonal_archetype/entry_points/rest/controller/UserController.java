package com.pragma.hexagonal_archetype.entry_points.rest.controller;

import com.pragma.archetype.use_case.UserUseCase;
import com.pragma.hexagonal_archetype.entry_points.rest.dto.UserDto;
import com.pragma.hexagonal_archetype.entry_points.rest.mappers.UserDtoMapper;
import com.pragma.hexagonal_archetype.helpers.ResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
    private final UserDtoMapper userDtoMapper;

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseHelper.successResponse(userDtoMapper.mapToListDto(userUseCase.getAllUsers()));
    }

    @GetMapping(path = "/save")
    public ResponseEntity<UserDto> saveUsers(@RequestBody UserDto user) {
        return  ResponseHelper.successResponse(userDtoMapper.mapToUserDto(userUseCase.saveUser(userDtoMapper.mapToUserModel(user))));
    }
}
