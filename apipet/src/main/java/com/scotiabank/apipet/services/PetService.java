package com.scotiabank.apipet.services;

import com.scotiabank.apipet.mappers.PetDTOToPetCreateDTO;
import com.scotiabank.apipet.services.dto.PetCreateDTO;
import com.scotiabank.apipet.services.dto.PetDTO;
import com.scotiabank.apipet.utils.GeneralFunctions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Service
public class PetService implements IPetService {

    private final WebClient webClient;
    private final PetDTOToPetCreateDTO petDTOToPetCreateDTO;

    public PetService(WebClient webClient, PetDTOToPetCreateDTO petDTOToPetCreateDTO) {
        this.webClient = webClient;
        this.petDTOToPetCreateDTO = petDTOToPetCreateDTO;
    }

    @Override
    public Mono<PetDTO> findPetById(int idPet) {
        return webClient.get()
                .uri("/pet/" + idPet)
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        clientResponse -> Mono.empty())
                .bodyToMono(PetDTO.class)
                .doOnNext(response -> {
                    GeneralFunctions.desrealizeObjectForPrint(response,
                            "Respuesta de la consulta de Pet");
                })
                .timeout(Duration.ofMillis(10_000));
    }

    @Override
    public Mono<PetCreateDTO> createPet(PetDTO petDTO) {
            PetCreateDTO petCreateDTO = petDTOToPetCreateDTO.map(petDTO);
            return webClient.post().uri("/pet")
                    .body(Mono.just(petDTO), PetDTO.class)
                    .retrieve()
                    .bodyToMono(PetCreateDTO.class)
                    .map(response -> petCreateDTO)
                    .doOnNext(response -> {
                        GeneralFunctions.desrealizeObjectForPrint(response,
                                "Respuesta de la creación de Pets");
                    })
                    .timeout(Duration.ofMillis(10_000));
    }

}
