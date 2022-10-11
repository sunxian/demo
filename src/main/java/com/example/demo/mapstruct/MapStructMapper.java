package com.example.demo.mapstruct;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author sunxian
 * @version 2022-10-10 15:42
 */
@Mapper
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    @Mappings({
            @Mapping(target = "uid",source = "id"),
            @Mapping(target = "uname",source = "name")
    })
    UserDto toUserDto(User user);
}
