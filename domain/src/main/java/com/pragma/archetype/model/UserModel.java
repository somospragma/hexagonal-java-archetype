package com.pragma.archetype.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
