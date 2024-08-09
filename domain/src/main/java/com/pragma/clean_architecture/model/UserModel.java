package com.pragma.clean_architecture.model;


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
