package com.example.desafio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_POKEMON", sequenceName = "SQ_POKEMON", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_POKEMON")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "HEIGHT")
    private Integer height;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
