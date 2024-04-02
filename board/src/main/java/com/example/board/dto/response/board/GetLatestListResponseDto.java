package com.example.board.dto.response.board;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseCode;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.ResponseMessage;
import com.example.board.dto.response.board.item.BoardListItem;

import lombok.Getter;

@Getter
public class GetLatestListResponseDto extends ResponseDto{
    private List<BoardListItem> latestList;

    private GetLatestListResponseDto(List<BoardListItem> latestList){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = latestList;
    }
    // 왜 static을 쓸까 인스턴스를 만드는데
    public static ResponseEntity<GetLatestListResponseDto> success(List<BoardListItem> latestList) {
        GetLatestListResponseDto body = new GetLatestListResponseDto(latestList); 
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    
}
