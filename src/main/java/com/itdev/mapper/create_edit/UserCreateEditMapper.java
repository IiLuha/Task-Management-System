package com.itdev.mapper.create_edit;

import com.itdev.database.entity.User;
import com.itdev.dto.create_edit.UserCreateEditDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        toObject.setEmail(fromObject.getEmail());
        toObject.setPassword(fromObject.getEmail());
        return toObject;
    }

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        map(object, user);
        return user;
    }
}
