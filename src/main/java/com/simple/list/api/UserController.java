package com.simple.list.api;

import com.simple.list.dto.UserDto;
import com.simple.list.entity.UserEntity;
import com.simple.list.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping(value = Api.USERS)
    public ResponseEntity<Integer> resigter(@Valid @RequestBody UserDto userDto) {
        UserEntity user = UserEntity.builder()
                .createdOn(Instant.now(Clock.systemUTC()))
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password("some password")
                .build();
        service.save(user);
        return ResponseEntity.ok(user.getUserId());
    }
}
