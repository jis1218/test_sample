package com.insup.testsample.acceptancetest;

import com.insup.testsample.dto.MemberJoinRequest;
import com.insup.testsample.dto.MemberLoginRequest;
import com.insup.testsample.dto.MemberLoginResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {

    static final String EMAIL = "jis1218@joonggonara.co.kr";
    static final String PASSWORD = "12345";

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    void 회원가입() {
        //given
        MemberJoinRequest memberJoinRequest = new MemberJoinRequest(EMAIL, PASSWORD);

        //when
        ExtractableResponse<Response> response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(memberJoinRequest)
            .when()
            .post("/api/member/join")
            .then()
            .log().all()
            .extract();

        //then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    void 로그인() {
        //given
        MemberLoginRequest memberLoginRequest = new MemberLoginRequest(EMAIL, PASSWORD);

        //when
        ExtractableResponse<Response> loginResponse = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(memberLoginRequest)
            .when()
            .post("/api/member/login")
            .then()
            .log().all()
            .extract();

        //then
        assertThat(loginResponse.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(loginResponse.jsonPath().getObject(".", MemberLoginResponse.class).getCount()).isEqualTo(1);
    }

    @Test
    void 회원가입하고_로그인까지_통합테스트() {
        회원가입();
        로그인();
    }
}
