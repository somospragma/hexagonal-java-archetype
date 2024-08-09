package com.pragma.clean_architecture.use_case;

import com.pragma.clean_architecture.driven_port.api.ChuckNorrisApiPort;
import com.pragma.clean_architecture.model.JokeModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JokeUseCaseTest {

    @Mock
    private ChuckNorrisApiPort chuckNorrisApiPort;

    @InjectMocks
    private JokeUseCase jokeUseCase;

    @Test
    void getRandomJoke_shouldReturnRandomJoke() {
        // Arrange
        String category = "tech";
        JokeModel joke = JokeModel.builder()
            .id("1")
            .value("Chuck Norris writes code that optimizes itself.")
            .build();
        when(chuckNorrisApiPort.getRandomCategory()).thenReturn(category);
        when(chuckNorrisApiPort.getJoke(category)).thenReturn(joke);

        // Act
        JokeModel result = jokeUseCase.getRandomJoke();

        // Assert
        assertEquals(joke, result);
    }
}
