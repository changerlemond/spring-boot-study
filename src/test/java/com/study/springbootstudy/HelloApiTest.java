package com.study.springbootstudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        TestRestTemplate testTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                testTemplate.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(response.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failHelloApi() {
        TestRestTemplate testTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                testTemplate.getForEntity("http://localhost:9090/app/hello?name=", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
