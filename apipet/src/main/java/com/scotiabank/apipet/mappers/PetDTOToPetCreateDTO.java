package com.scotiabank.apipet.mappers;

import com.scotiabank.apipet.services.dto.PetCreateDTO;
import com.scotiabank.apipet.services.dto.PetDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.util.UUID.randomUUID;

@Component
public class PetDTOToPetCreateDTO implements IMapper<PetDTO, PetCreateDTO> {

    @Override
    public PetCreateDTO map(PetDTO petDTO) {
        PetCreateDTO petCreateDTO = new PetCreateDTO();
        petCreateDTO.setId(petDTO.getId());
        petCreateDTO.setName(petDTO.getName());
        petCreateDTO.setStatus(petDTO.getStatus());
        petCreateDTO.setTransactionId(randomUUID().toString());
        petCreateDTO.setDateCreated(LocalDateTime.now().toString());
        return petCreateDTO;
    }
}
