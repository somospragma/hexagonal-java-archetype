package com.pragma.archetype.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    private Long document;
    private String name;
    private String mail;
    private String address;
}
