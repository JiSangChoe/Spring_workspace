package com.example.board.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.board.dto.response.ResponseDto;

@RestControllerAdvice
public class ValidationExceptionHandler {
    
    // 오류코드를 안보여주고 개발자가 정한 예외상황을 통제할 수 있음
    @ExceptionHandler(value={HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseDto> validationExceptionHandler(Exception exception) {exception.printStackTrace();
        return ResponseDto.validationFailed();
    }

}
