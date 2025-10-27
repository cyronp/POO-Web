package com.projetopo2.univilledb.dto;

public record EditarMidiaRequest (Long id, String titulo, Float nota, String tipo, int duracao, String criador, String genero, String subGenero, String capaUrl) { }
