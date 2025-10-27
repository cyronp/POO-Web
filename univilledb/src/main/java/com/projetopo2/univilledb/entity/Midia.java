package com.projetopo2.univilledb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Midia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String titulo;
    private float nota;
    private String tipo;
    private int duracao;
    private String criador;
    private String genero;
    private String subGenero;
    private String capaUrl;
}
