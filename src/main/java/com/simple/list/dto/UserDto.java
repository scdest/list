package com.simple.list.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer userId;
    @NotBlank
    @Length(max = 100)
    private String name;

    @NotBlank
    @Email
    @Length(max = 100)
    private String email;
}
