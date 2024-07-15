package com.pragma.hexagonal_archetype.entry_points.rest.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long document;
    private String name;
    private String mail;
    private String address;
}
