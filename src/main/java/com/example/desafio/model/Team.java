package com.example.desafio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "OWNER", unique = true)
    private String owner;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons = new ArrayList<>();
}
