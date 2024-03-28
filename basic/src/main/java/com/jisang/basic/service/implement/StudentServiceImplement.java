package com.jisang.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jisang.basic.dto.request.student.PatchStudentRequestDto;
import com.jisang.basic.dto.request.student.PostStudentRequestDto;
import com.jisang.basic.entity.StudentEntity;
import com.jisang.basic.repository.StudentRepository;
import com.jisang.basic.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {

        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        // 2. 생성한 인스턴스를 repository.save() 메서드로 저장
        StudentEntity studentEntity = new StudentEntity(dto);
        // save() : 저장 및 수정 (덮어쓰기)
        StudentEntity saveEntity = studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공!");
    }

    @Override
    public ResponseEntity<String> patchStudent(PatchStudentRequestDto dto) {

        Integer studentNumber = dto.getStudentNumber();
        String address = dto.getAddress();

        // 원래는 한줄 StudentEntity studentEntity = studentRepository.findById(studentNumber).get();
        // 1. student 클래스로 접근(StudentRepository 사용)
        StudentEntity studentEntity = studentRepository.
        // 2. dto.studentNumber에 해당하는 인스턴스 검색
        findById(studentNumber).get();
        // 3. 검색된 인스턴스의 address 값을 dto.address로 변경
        studentEntity.setAddress(address);
        return null;
    }
    
}
