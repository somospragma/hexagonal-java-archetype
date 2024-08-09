package com.pragma.clean_architecture.driven_adapters.jpa.repository;

import com.pragma.clean_architecture.driven_adapters.jpa.entity.UserEntity;
import com.pragma.clean_architecture.driven_adapters.jpa.mapper.UserEntityMapper;
import com.pragma.clean_architecture.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryPortImplTest {

    @Mock
    private UserEntityMapper userEntityMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRepositoryPortImpl userRepositoryPort;

    @Test
    void getAllUsers_shouldReturnAllUsersFromRepository() {
        // Arrange
        List<UserEntity> userEntities = List.of(new UserEntity(), new UserEntity());
        when(userRepository.findAll()).thenReturn(userEntities);
        List<UserModel> expectedUserModels = List.of(new UserModel(), new UserModel());
        when(userEntityMapper.mapToListModels(userEntities)).thenReturn(expectedUserModels);

        // Act
        List<UserModel> actualUserModels = userRepositoryPort.getAllUsers();

        // Assert
        assertEquals(expectedUserModels, actualUserModels);
    }

    @Test
    void saveUser_shouldSaveUserToRepositoryAndReturnSavedUser() {
        // Arrange
        UserModel userModel = new UserModel();
        UserEntity userEntity = new UserEntity();
        when(userEntityMapper.mapToEntity(userModel)).thenReturn(userEntity);
        UserEntity savedUserEntity = new UserEntity();
        when(userRepository.save(userEntity)).thenReturn(savedUserEntity);
        UserModel expectedSavedUserModel = new UserModel();
        when(userEntityMapper.mapToModel(savedUserEntity)).thenReturn(expectedSavedUserModel);

        // Act
        UserModel actualSavedUserModel = userRepositoryPort.saveUser(userModel);

        // Assert
        assertEquals(expectedSavedUserModel, actualSavedUserModel);
        verify(userRepository).save(userEntity);
    }
}
