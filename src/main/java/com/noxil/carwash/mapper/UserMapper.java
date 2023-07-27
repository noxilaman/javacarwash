package com.noxil.carwash.mapper;

import com.noxil.carwash.entity.User;
import com.noxil.carwash.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);
}
