package com.pragma.hexagonal_archetype.entry_points.rest.mappers;


import com.pragma.hexagonal_archetype.entry_points.rest.dto.UserDto;
import com.pragma.archetype.model.UserModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserDtoMapper {

    UserModel mapToUserModel(UserDto userDto);

    UserDto mapToUserDto(UserModel userDto);

    List<UserModel> mapToListModel(List<UserDto> userDto);

    List<UserDto> mapToListDto(List<UserModel> userModel);
}
