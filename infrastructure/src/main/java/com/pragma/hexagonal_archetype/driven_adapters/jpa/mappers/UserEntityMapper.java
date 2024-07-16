package com.pragma.hexagonal_archetype.driven_adapters.jpa.mappers;

import com.pragma.archetype.model.UserModel;
import com.pragma.hexagonal_archetype.driven_adapters.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserEntityMapper {

    UserEntity mapToEntity(UserModel userModel);

    UserModel mapToModel(UserEntity userEntity);

    List<UserEntity> mapToListEntity(List<UserEntity> userModels);

    List<UserModel> mapToListModels(List<UserEntity> userEntities);

}
