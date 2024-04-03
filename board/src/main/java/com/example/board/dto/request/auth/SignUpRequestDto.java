package com.example.board.dto.request.auth;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String email;

    @NotBlank
    @Range(min=8, max=20)
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10,12}$")
    private String tellNumber;

    @NotBlank
    private String address;

    private String addressDetail;
}
