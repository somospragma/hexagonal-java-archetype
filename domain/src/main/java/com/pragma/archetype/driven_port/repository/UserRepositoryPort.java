package com.pragma.archetype.driven_port.repository;

import com.pragma.archetype.model.UserModel;

import java.util.List;

public interface UserRepositoryPort {

    List<UserModel> getAllUsers();
    UserModel saveUser(UserModel userModel);
}
