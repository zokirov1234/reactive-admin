package com.company.service;

import com.company.model.dto.ResponseDTO;
import com.company.model.dto.UserDTO;
import com.company.model.form.UserForm;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<?> addUser(UserForm userForm);

    Mono<ResponseDTO> updateUser(UserDTO userDTO);

    Mono<ResponseDTO> deleteUser(long id);

    Mono<?> getUser(long id);

    Mono<?> getAllUsers();

}
