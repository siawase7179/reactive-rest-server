package com.reactive.reactiverestserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReactiveRestServerApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testRequsetAuth() {
		String clientId = "clientId";
        String clientPassword = "clientPassword";

        webTestClient.post()
                .uri("/v1/auth")
                .header("X-Client-Id", clientId)
                .header("X-Client-Password", clientPassword)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
	}

}
