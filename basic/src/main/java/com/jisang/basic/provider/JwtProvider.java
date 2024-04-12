package com.jisang.basic.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// JWT :
// - Json Web Token, RFC 7519 표준에 정의된 json 형식의 문자열을 포함하고 있는 토큰
// - 인증 및 인가에 사용
// - 암호화가 되어 있어 클라이언트와 서버 간의 안전한 데이터 교환을 할 수 있음
// - 헤더(HEADER), 페이로드(PAYLOAD), 서명(VERIFY SIGNATURE)
// - 헤더 : 토큰의 유형 (일반적으로 jwt)과 암호화 알고리즘이 포함되어 있음
// - 페이로드 : 클라이언트 혹은 서버가 상대방에게 전달할 데이터가 포함되어 있음 (작성자, 접근주체의 정보, 작성 시간, 만료시간 등)
// - 서명 : 헤더와 페이로드를 합쳐서 인코딩하고 지정한 비밀키로 암호화한 데이터
@Component // JwtProvider 클래스에 대한 인스턴스 생성 권한을 스프링한테 넘겨줌
public class JwtProvider {

    // application.properties 에서 비밀키를 암호화해서 여기에다가 선언하고 밑에 비밀키에 넣어줌
    @Value("${jwt.secret-key}")
    private String secretKey;
    
    // JWT 생성
    public String create(String principal) {
        // 만료시간                     현재시간으로 부터 4시간후에 만료됨
        Date expiredDate = Date.from(Instant.now().plus(4, ChronoUnit.HOURS));
        // 비밀키 생성
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        // JWT 생성
        String jwt = Jwts.builder()
            // 서명 (서명에 사용할 비밀키, 서명에 사용할 암호화 알고리즘)
            .signWith(key, SignatureAlgorithm.HS256)
            // 페이로드
            // 작성자
            .setSubject(principal)
            // 생성 시간
            .setIssuedAt(new Date())
            // 만료 시간
            .setExpiration(expiredDate)
            // 위의 내용을 압축(인코딩)
            .compact();

        return jwt;
    } 

    public String validation(String jwt) {

        // jwt 검증 결과로 나타나는 페이로드가 저장될 변수
        Claims claims = null;
        // 비밀키 생성
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        try {
            // 비밀키로 jwt 복호화 작업
            claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        } catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }

}
