package com.scotiabank.apipet.services;

import com.scotiabank.apipet.services.dto.PetCreateDTO;
import com.scotiabank.apipet.services.dto.PetDTO;
import reactor.core.publisher.Mono;

public interface IPetService {

    public Mono<PetDTO> findPetById(int idPet);
    public Mono<PetCreateDTO> createPet(PetDTO petDTO);
}
