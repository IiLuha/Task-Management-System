package com.itdev.dto.create_edit;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@FieldNameConstants
public class UserCreateEditDto {

    @Size(max = 255)
    @Email
    String email;

    @Size(max = 255)
    @NotBlank
    String rawPassword;
}
