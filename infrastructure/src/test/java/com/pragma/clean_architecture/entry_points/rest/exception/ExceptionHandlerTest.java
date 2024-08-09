package com.pragma.clean_architecture.entry_points.rest.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExceptionHandlerTest {

    private final ExceptionsHandler exceptionsHandler = new ExceptionsHandler();

    @Test
    void handleValidationExceptions_shouldReturnResponseEntityWithFieldErrors() {
        // Arrange
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("object", "field", "Default Message");
        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError));
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);

        // Act
        ResponseEntity<Map<String, List<String>>> responseEntity = exceptionsHandler.handleValidationExceptions(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Map<String, List<String>> body = responseEntity.getBody();
        assertNotNull(body);
        assertTrue(body.containsKey("field"));
        assertEquals("Default Message", body.get("field").get(0));
    }

    @Test
    void handleConstraintViolation_shouldReturnResponseEntityWithConstraintViolations() {
        // Arrange
        Path propertyPath = mock(Path.class);
        when(propertyPath.toString()).thenReturn("field");
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("Violation Message");
        when(violation.getPropertyPath()).thenReturn(propertyPath);
        ConstraintViolationException exception = new ConstraintViolationException(Set.of(violation));

        // Act
        ResponseEntity<Map<String, List<String>>> responseEntity = exceptionsHandler.handleConstraintViolation(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Map<String, List<String>> body = responseEntity.getBody();
        assertNotNull(body);
        assertFalse(body.isEmpty());
        assertEquals("Violation Message", body.get("field").get(0));
    }

    @Test
    void handleInternalServerError_shouldReturnResponseEntityWithErrorDetails() {
        // Arrange 
        Exception exception = new Exception("Error Message");

        // Act
        ResponseEntity<Map<String, String>> responseEntity = exceptionsHandler.handleInternalServerError(exception);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        Map<String, String> body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals("An unexpected error occurred.", body.get("error"));
        assertEquals("Error Message", body.get("message"));
        assertEquals("Please contact support with this error message for further assistance.", body.get("details"));
    }
}
