package com.pragma.hexagonal_archetype.driven_adapters.jpa.repository;

import com.pragma.hexagonal_archetype.driven_adapters.jpa.mappers.UserEntityMapper;
import com.pragma.archetype.driven_port.repository.UserRepositoryPort;
import com.pragma.archetype.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserRepositoryPortImpl  implements UserRepositoryPort {

    private UserEntityMapper userEntityMapper;
    private UserRepository userRepository;

    @Override
    public List<UserModel> getAllUsers() {
        return userEntityMapper.mapToListModels(userRepository.findAll());
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        return userEntityMapper.mapToModel(userRepository.save(userEntityMapper.mapToEntity(userModel)));
    }
}
