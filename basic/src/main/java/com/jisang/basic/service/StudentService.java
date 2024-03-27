package com.jisang.basic.service;

import org.springframework.http.ResponseEntity;

import com.jisang.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
