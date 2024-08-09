package com.pragma.clean_architecture.entry_points.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @NonNull
    private Long document;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Mail cannot be blank")
    @Email(message = "Mail should be a valid email address")
    private String mail;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String address;

}
