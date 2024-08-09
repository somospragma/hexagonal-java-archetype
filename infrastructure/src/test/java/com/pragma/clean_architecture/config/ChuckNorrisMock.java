package com.pragma.clean_architecture.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.file.Files;

public class ChuckNorrisMock extends WireMockServer {

    public ChuckNorrisMock(int port) {
        super(port);
    }

    public void startMockServer() throws IOException {
        this.start();
        stubFor(
                WireMock.get(WireMock.urlPathMatching("/jokes/categories"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(new String(Files.readAllBytes(new ClassPathResource("mock/categories.json").getFile().toPath())))
                        )
        );
    }
}
