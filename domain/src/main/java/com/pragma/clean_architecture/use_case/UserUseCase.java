package com.pragma.clean_architecture.use_case;

import com.pragma.clean_architecture.driven_port.repository.UserRepositoryPort;
import com.pragma.clean_architecture.model.UserModel;
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
