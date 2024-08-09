package com.pragma.clean_architecture.driven_adapters.feign.api;

import com.pragma.clean_architecture.driven_adapters.feign.mapper.JokeMapper;
import com.pragma.clean_architecture.model.JokeModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChuckNorrisApiPortImplTest {

    @Mock
    private ChuckNorrisApi chuckNorrisApi;

    @Mock
    private JokeMapper jokeMapper;

    @InjectMocks
    private ChuckNorrisApiPortImpl chuckNorrisApiPort;

    @Test
    void getRandomCategory_shouldReturnRandomCategoryFromApi() {
        // Arrange
        List<String> categories = List.of("category1", "category2", "category3");
        when(chuckNorrisApi.getCategories()).thenReturn(categories);

        // Act
        String randomCategory = chuckNorrisApiPort.getRandomCategory();

        // Assert
        assertTrue(categories.contains(randomCategory));
    }

    @Test
    void getJoke_shouldReturnJokeForGivenCategory() {
        // Arrange
        String category = "category";
        JokeModel expectedJoke = new JokeModel();
        when(chuckNorrisApi.getRandomJoke(category)).thenReturn(null);
        when(jokeMapper.mapToModel(null)).thenReturn(expectedJoke);

        // Act
        JokeModel actualJoke = chuckNorrisApiPort.getJoke(category);

        // Assert
        assertEquals(expectedJoke, actualJoke);
    }
}
