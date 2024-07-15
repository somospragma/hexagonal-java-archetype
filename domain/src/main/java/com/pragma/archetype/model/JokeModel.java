package com.pragma.archetype.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JokeModel {

    private List<String> categories;
    private String createdAt;
    private String iconUrl;
    private String id;
    private String updatedAt;
    private String url;
    private String value;
}
