//package com.esther.DesafioSpring.domain.conversor;
//
//import com.esther.DesafioSpring.domain.dtos.PokemonDTO;
//import com.esther.DesafioSpring.domain.dtos.TeamDTO;
//import com.esther.DesafioSpring.model.Pokemon;
//import com.esther.DesafioSpring.model.Team;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ConvertToDTO {
//
//    private final ModelMapper mapper;
//
//    public ConvertToDTO(ModelMapper mapper) {
//        this.mapper = mapper;
//    }
//
//    public PokemonDTO pokemonDTO(Pokemon entidade) {
//        PokemonDTO dto = mapper.map(entidade, PokemonDTO.class);
//        dto.setName(entidade.getName());
//        return dto;
//    }
//
//    public TeamDTO teamDTO(Team team) {
//        return mapper.map(team, TeamDTO.class);
//    }
//}

package com.example.desafio.domain.conversor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertToDTO {

    private final ModelMapper mapper;

    public ConvertToDTO(ModelMapper mapper) {
        this.mapper = mapper;
    }

}
