package com.example.desafio.service;



import com.example.desafio.domain.dtos.PokemonDTO;
import com.example.desafio.model.Pokemon;
import com.example.desafio.model.Team;

import java.util.List;

public interface PokemonService {

    List<PokemonDTO> getAllPokemons();

    PokemonDTO getPokemonByName(String name);

    Long getPokemonIdByName(String name);

    List<Pokemon> convertPokemonDTOsToEntities(List<PokemonDTO> pokemonDTOs);

    Team saveTeam(Team team);
}
