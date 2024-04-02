package com.example.board.dto.response.User;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseCode;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class GetUserResponseDto extends ResponseDto{
    private String email;
    private String nickname;
    private String profileImage;


    private GetUserResponseDto(String email, String nickname, String profileImage) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = email;
        this.nickname = nickname;
        this.profileImage = profileImage;
    

    public static ResponseEntity<GetUserResponseDto> success(String email)
    }
}
