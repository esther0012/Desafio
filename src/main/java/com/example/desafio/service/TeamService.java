package com.example.desafio.service;


import com.example.desafio.domain.dtos.PokemonDTO;
import com.example.desafio.domain.dtos.TeamDTO;
import com.example.desafio.exception.TeamNotFoundException;
import com.example.desafio.model.Team;
import com.example.desafio.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Map<Long, TeamDTO> getAllTeamsWithPokemons() {
        List<Team> teams = teamRepository.findAll();
        Map<Long, TeamDTO> teamsWithPokemons = new HashMap<>();
        for (Team team : teams) {
            TeamDTO teamDTO = convertToDTO(team);
            teamsWithPokemons.put(team.getId(), teamDTO);
        }
        return teamsWithPokemons;
    }

    private TeamDTO convertToDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setOwner(team.getOwner());

        List<PokemonDTO> pokemonDTOs = team.getPokemons().stream()
                .map(pokemon -> {
                    PokemonDTO pokemonDTO = new PokemonDTO();
                    pokemonDTO.setId(pokemon.getId());
                    pokemonDTO.setName(pokemon.getName());
                    pokemonDTO.setHeight(pokemon.getHeight());
                    pokemonDTO.setWeight(pokemon.getWeight());
                    return pokemonDTO;
                })
                .collect(Collectors.toList());

        teamDTO.setPokemons(pokemonDTOs);
        return teamDTO;
    }

    public List<TeamDTO> getTeamByOwner(String owner) {
        List<Team> teams = teamRepository.findByOwner(owner);
        if (!teams.isEmpty()) {
            return teams.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } else {
            throw new TeamNotFoundException("Sem times para: " + owner);
        }
    }

}
