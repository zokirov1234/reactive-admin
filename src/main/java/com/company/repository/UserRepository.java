package com.company.repository;

import com.company.model.entity.UserEntity;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {

    Flux<UserEntity> findByUsername(String username);

    Flux<UserEntity> findAllByFirstNameIgnoreCase(String firstname);

//    Optional<UserEntity> save(UserEntity user);

}
