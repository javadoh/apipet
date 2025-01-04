package com.scotiabank.apipet.config;

import com.scotiabank.apipet.exceptions.CustomException;
import com.scotiabank.apipet.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class WebConfig {

    Function<ClientResponse, Mono<ClientResponse>> webclientResponseProcessor =
            clientResponse -> {
                HttpStatusCode responseStatus = clientResponse.statusCode();
                if (responseStatus.is5xxServerError()) {
                    System.out.println("5xx error");
                    return Mono.error(new CustomException("Se ha capturado un error interno al procesar la solicitud", responseStatus));
                }
                return Mono.just(clientResponse);
            };

        @Bean
        public WebClient webClient() {

            return WebClient.builder()
                    .baseUrl(Constants.BASE_PATH)
                    .defaultCookie("cookie-name", "cookie-value")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .filter(ExchangeFilterFunction.ofResponseProcessor(webclientResponseProcessor))
                    .build();

        }
    }
