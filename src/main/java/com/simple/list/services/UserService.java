package com.simple.list.services;

import com.simple.list.entity.UserEntity;
import com.simple.list.exceptions.UnproccessableEntityException;
import com.simple.list.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserEntity findByIdOrElseNull(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void save(UserEntity user) {
        if(nonNull(repository.findByEmail(user.getEmail()))) {
            throw new UnproccessableEntityException("A user with email "
                    + user.getEmail()
                    + " already exists!");
        }
        repository.save(user);
    }
}
