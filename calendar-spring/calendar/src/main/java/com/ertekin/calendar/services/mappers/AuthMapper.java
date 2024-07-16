package com.ertekin.calendar.services.mappers;

import com.ertekin.calendar.entities.User;
import com.ertekin.calendar.services.dtos.requests.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE= Mappers.getMapper(AuthMapper.class);

    @Mapping(target="password", ignore = true)

    User userFromRegisterRequest(RegisterRequest registerRequest);
}
