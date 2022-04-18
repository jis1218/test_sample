package com.insup.testsample.acceptancetest;

import static org.assertj.core.api.Assertions.assertThat;

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

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AcceptanceTestWithDataSource {
    static final String EMAIL = "hello@world.com";
    static final String PASSWORD = "23456";

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
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
}
