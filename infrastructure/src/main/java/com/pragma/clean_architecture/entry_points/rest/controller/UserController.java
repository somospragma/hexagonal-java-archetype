package com.pragma.clean_architecture.entry_points.rest.controller;

import com.pragma.clean_architecture.use_case.UserUseCase;
import com.pragma.clean_architecture.entry_points.rest.dto.UserDto;
import com.pragma.clean_architecture.entry_points.rest.mapper.UserDtoMapper;
import com.pragma.clean_architecture.helpers.ResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    private final UserUseCase userUseCase;
    private final UserDtoMapper userDtoMapper;

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseHelper.successResponse(userDtoMapper.mapToListDto(userUseCase.getAllUsers()));
    }

    @PostMapping (path = "/save")
    public ResponseEntity<UserDto> saveUsers(@RequestBody @Valid UserDto user) {
        return  ResponseHelper.successResponse(userDtoMapper.mapToUserDto(userUseCase.saveUser(userDtoMapper.mapToUserModel(user))));
    }
}
