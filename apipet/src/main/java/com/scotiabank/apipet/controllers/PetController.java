package com.scotiabank.apipet.controllers;

import com.scotiabank.apipet.services.PetService;
import com.scotiabank.apipet.services.dto.PetCreateDTO;
import com.scotiabank.apipet.services.dto.PetDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class PetController {

    final PetService petService;

    PetController(PetService petService) {
        this.petService = petService;
    }
    @GetMapping("/pet/{idPet}")
    public Mono<PetDTO> findPetById(@PathVariable("idPet") int idPet) {
        return petService.findPetById(idPet);
    }

    @PostMapping("/pet")
    public Mono<PetCreateDTO> createPet(@RequestBody PetDTO petDTO) {
        return petService.createPet(petDTO);
    }
}
