package com.example.desafio.service;


import com.example.desafio.domain.dtos.PokemonDTO;
import com.example.desafio.exception.PokemonNotFoundException;
import com.example.desafio.model.Pokemon;
import com.example.desafio.model.Team;
import com.example.desafio.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final TeamRepository teamRepository;
    private final RestTemplate restTemplate;
    private final String pokeApiUrl;

    @Autowired
    public PokemonServiceImpl(TeamRepository teamRepository, RestTemplateBuilder restTemplateBuilder, @Value("${pokeapi.url}") String pokeApiUrl) {
        this.teamRepository = teamRepository;
        this.pokeApiUrl = pokeApiUrl;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<PokemonDTO> getAllPokemons() {
        return null;
    }

    @Override
    public Long getPokemonIdByName(String name) {
        return null;
    }

    @Override
    public List<Pokemon> convertPokemonDTOsToEntities(List<PokemonDTO> pokemonDTOs) {
        return null;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public PokemonDTO getPokemonByName(String name) {
        String apiUrl = pokeApiUrl + "/pokemon/" + name;
        try {
            ResponseEntity<PokemonDTO> response = restTemplate.getForEntity(apiUrl, PokemonDTO.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new PokemonNotFoundException("Pokemon not found: " + name);
            }
        } catch (RestClientException e) {
            throw new PokemonNotFoundException("Error while fetching Pokemon data from PokeAPI");
        }
    }

}
