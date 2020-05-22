package com.simple.list.repositories;

import com.simple.list.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
}
