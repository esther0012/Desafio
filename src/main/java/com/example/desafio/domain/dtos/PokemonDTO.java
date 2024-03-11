package com.example.desafio.domain.dtos;

import lombok.Data;

@Data
public class PokemonDTO {

    private Long id;
    private String name;
    private Integer height;
    private Integer weight;
}
