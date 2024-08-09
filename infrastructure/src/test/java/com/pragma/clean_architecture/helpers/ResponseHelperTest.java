package com.pragma.clean_architecture.helpers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ResponseHelperTest {

    @Test
    void successResponse_shouldReturnResponseEntityWithBodyAndOkStatus() {
        // Arrange
        String body = "Test Body";

        // Act
        ResponseEntity<String> responseEntity = ResponseHelper.successResponse(body);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(body, responseEntity.getBody());
    }
}
