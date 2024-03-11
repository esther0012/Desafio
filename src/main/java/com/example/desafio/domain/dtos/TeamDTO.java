package com.example.desafio.domain.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeamDTO {

    private Long id;
    private List<String> team = new ArrayList<>();
    private String owner;
    private List<PokemonDTO> pokemons;

}

