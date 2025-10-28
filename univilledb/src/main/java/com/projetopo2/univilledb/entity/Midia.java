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
    private String duracao;
    private String criador;
    private String genero;
    private String subGenero;
    private String capaUrl;

    public Midia(String titulo, float nota, String tipo, String duracao, String criador, String genero, String subGenero, String capaUrl) {
        this.titulo = titulo;
        this.nota = nota;
        this.tipo = tipo;
        this.duracao = duracao;
        this.criador = criador;
        this.genero = genero;
        this.subGenero = subGenero;
        this.capaUrl = capaUrl;
    }

    public Midia() {
    }
}
