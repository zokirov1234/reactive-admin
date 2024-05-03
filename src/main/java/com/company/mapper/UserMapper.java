package com.company.mapper;


import com.company.model.dto.UserDTO;
import com.company.model.entity.UserEntity;
import com.company.model.form.UserForm;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO UserToUserDTO(UserEntity user);


    UserEntity UserFormToUserEntity(UserForm userForm);

}
