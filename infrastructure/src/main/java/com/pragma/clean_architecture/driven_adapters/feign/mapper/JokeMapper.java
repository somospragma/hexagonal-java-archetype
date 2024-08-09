package com.pragma.clean_architecture.driven_adapters.feign.mapper;


import com.pragma.clean_architecture.model.JokeModel;
import com.pragma.clean_architecture.driven_adapters.feign.dto.JokeDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface JokeMapper {

    JokeModel mapToModel(JokeDto jokeDto);

    JokeDto mapToDto(JokeModel jokeModel);
}
