package com.pragma.clean_architecture.use_case;

import com.pragma.clean_architecture.driven_port.repository.UserRepositoryPort;
import com.pragma.clean_architecture.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @InjectMocks
    private UserUseCase userUseCase;

    @Test
    void getAllUsers_shouldReturnAllUsers() {
        // Arrange
        List<UserModel> users = List.of(
            UserModel.builder()
                .document(1L)
                .name("John Doe")
                .mail("john@example.com")
                .address("123 Street")
                .build(),
            UserModel.builder()
                .document(2L)
                .name("Jane Smith")
                .mail("jane@example.com")
                .address("456 Avenue")
                .build()
        );
        when(userRepositoryPort.getAllUsers()).thenReturn(users);

        // Act
        List<UserModel> result = userUseCase.getAllUsers();

        // Assert
        assertEquals(users, result);
    }

    @Test
    void saveUser_shouldSaveUserAndReturnSavedUser() {
        // Arrange
        UserModel user = UserModel.builder()
            .document(1L)
            .name("John Doe")
            .mail("john@example.com")
            .address("123 Street")
            .build();
        when(userRepositoryPort.saveUser(user)).thenReturn(user);

        // Act
        UserModel result = userUseCase.saveUser(user);

        // Assert
        assertEquals(user, result);
    }
}
