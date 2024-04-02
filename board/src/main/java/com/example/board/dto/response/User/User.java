package com.example.board.dto.response.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String code;
    private String message;
    private String email;
    private String nickname;
    private String profileImage;
}
