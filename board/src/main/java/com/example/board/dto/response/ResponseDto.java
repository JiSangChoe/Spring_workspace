package com.example.board.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    private String code;
    private String message;

    // 성공에 대한 반환
    public static ResponseEntity<ResponseDto> success() {
        ResponseDto body = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    // 유효성 검사 실패
    public static ResponseEntity<ResponseDto> validationFailed() {
        ResponseDto body = new ResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // 중복된 이메일
    public static ResponseEntity<ResponseDto> duplicateEmail() {
        ResponseDto body = new ResponseDto(ResponseCode.DUPLICATE_EMAIL, ResponseMessage.DUPLICATE_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    } 
    
    // 중복된 닉네임
    public static ResponseEntity<ResponseDto> duplicateNickname() {
        ResponseDto body = new ResponseDto(ResponseCode.DUPLICATE_NICKNAME, ResponseMessage.DUPLICATE_NICKNAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }  
    
    // 중복된 휴대전화번호
    public static ResponseEntity<ResponseDto> duplicateTelephoneNumber() {
        ResponseDto body = new ResponseDto(ResponseCode.DUPLICATE_TEL_NUMBER, ResponseMessage.DUPLICATE_TEL_NUMBER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }  

    // 모든 API에서 이렇게 만듬 데이터베이스 실패에대한 코드 그래서 DTO에 넣었다!..
    public static ResponseEntity<ResponseDto> databaseError() {
        ResponseDto body = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    // code: "NU", message: "This user does not exist." 에 대한 공통 처리
    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto body = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    // 존재하지 않는 게시물
    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto body = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
