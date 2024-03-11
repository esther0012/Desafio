package com.example.desafio.controller;

import com.example.desafio.domain.dtos.PokemonDTO;
import com.example.desafio.domain.dtos.TeamDTO;
import com.example.desafio.model.Pokemon;
import com.example.desafio.model.Team;
import com.example.desafio.repository.PokemonRepository;
import com.example.desafio.repository.TeamRepository;
import com.example.desafio.service.PokemonService;
import com.example.desafio.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<String> createTeam(@RequestBody TeamDTO teamRequestDTO) {
        if (teamRequestDTO.getOwner() == null) {
            return ResponseEntity.badRequest().body("Proprietário e equipe devem ser fornecidos.");
        }

        Team team = new Team();
        team.setOwner(teamRequestDTO.getOwner());
        Team savedTeam = teamRepository.save(team);
        List<Pokemon> pokemonEntities = new ArrayList<>();

        for (String pokemonName : teamRequestDTO.getTeam()) {
            PokemonDTO pokemonDTO = pokemonService.getPokemonByName(pokemonName);
            if (pokemonDTO != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setName(pokemonDTO.getName());
                pokemon.setHeight(pokemonDTO.getHeight());
                pokemon.setWeight(pokemonDTO.getWeight());

                pokemon.setTeam(savedTeam);
                pokemon = pokemonRepository.save(pokemon);

                pokemonEntities.add(pokemon);
            } else {
                return ResponseEntity.badRequest().body("Pokemon not found: " + pokemonName);
            }
        }
        savedTeam.setPokemons(pokemonEntities);
        teamRepository.save(savedTeam);

        return ResponseEntity.status(HttpStatus.CREATED).body("Time criado com sucesso! Seu id é: " + savedTeam.getId());
    }

    @GetMapping()
    public ResponseEntity<Map<Long, TeamDTO>> getAllTeamsWithPokemons() {
        Map<Long, TeamDTO> teamsWithPokemons = teamService.getAllTeamsWithPokemons();
        return ResponseEntity.ok(teamsWithPokemons);
    }


    @GetMapping("/{owner}")
    public ResponseEntity<TeamDTO> getTeamsByOwner(@PathVariable String owner) {
        List<TeamDTO> teamsDTO = teamService.getTeamByOwner(owner);
        if (!teamsDTO.isEmpty()) {
            TeamDTO teamDTO = teamsDTO.get(0);
            return ResponseEntity.ok(teamDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
