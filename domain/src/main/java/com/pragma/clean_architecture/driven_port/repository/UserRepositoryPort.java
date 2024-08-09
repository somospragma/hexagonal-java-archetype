package com.pragma.clean_architecture.driven_port.repository;

import com.pragma.clean_architecture.model.UserModel;

import java.util.List;

public interface UserRepositoryPort {

    List<UserModel> getAllUsers();
    UserModel saveUser(UserModel userModel);
}
