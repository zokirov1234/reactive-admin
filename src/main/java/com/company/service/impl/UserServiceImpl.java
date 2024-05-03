package com.company.service.impl;

import com.company.mapper.UserMapper;
import com.company.model.dto.ResponseDTO;
import com.company.model.dto.UserDTO;
import com.company.model.form.UserForm;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public Mono<?> addUser(UserForm userForm) {



        return userRepository.save(userMapper.UserFormToUserEntity(userForm))
                .doOnSuccess(userEntity -> log.info("User saved -> {}", userEntity.getUsername()))
                .doOnError(ex -> log.error("Error while saving user -> {}",ex.getMessage()))
                .map(userMapper::UserToUserDTO)
                .map(userDTO -> new ResponseDTO(true, 200, "success", userDTO));


        //list
//        return Flux.fromIterable(List.of())
//                .flatMap(o -> )


        //response
//        return userRepository.save(new UserEntity())
//                .filter(userEntity -> userEntity.equals(""))
//                .flatMap(userEntity -> userRepository.save(userEntity.getId()))
//                .doOnSuccess(savedUser -> log.info("User saved -> {}", savedUser))
//                .doOnError(ex -> log.error("Error while saving user -> {}", ex.getMessage()))
//                .map(userEntity -> new ResponseDTO<>())
//                .switchIfEmpty()
//                .onErrorResume(throwable -> {
//                    log.error("Error while saving user -> {}", throwable.getMessage());
//                    return Mono.just(new ResponseDTO<>());
//                });
    }

    @Override
    public Mono<ResponseDTO> updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Mono<ResponseDTO> deleteUser(long id) {
        return null;
    }

    @Override
    public Mono<?> getUser(long id) {
        return null;
    }

    @Override
    public Mono<?> getAllUsers() {

        return userRepository.findAll()
                .map(userMapper::UserToUserDTO)
                .collectList()
                .map(userDTOS -> new ResponseDTO(true, 200, "success", userDTOS));
    }
}
