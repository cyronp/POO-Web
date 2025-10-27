package com.projetopo2.univilledb.repository;

import com.projetopo2.univilledb.entity.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MidiaRepository extends JpaRepository<Midia, Long> {

     List<Midia> findAllByTipo(String tipo);

     List<Midia> findTop1ByTipoOrderByNotaDesc(String tipo);
}
