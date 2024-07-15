package com.pragma.hexagonal_archetype.driven_adapters.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JokeDto {

    private List<String> categories;
    private String createdAt;
    private String iconUrl;
    private String id;
    private String updatedAt;
    private String url;
    private String value;
}
