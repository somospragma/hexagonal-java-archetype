package com.pragma.archetype.use_case;

import com.pragma.archetype.driven_port.repository.UserRepositoryPort;
import com.pragma.archetype.model.UserModel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserUseCase{

    private UserRepositoryPort userRepositoryPort;

    public List<UserModel> getAllUsers() {
        return userRepositoryPort.getAllUsers();
    }

    public UserModel saveUser(UserModel user) {
        return userRepositoryPort.saveUser(user);
    }
}
