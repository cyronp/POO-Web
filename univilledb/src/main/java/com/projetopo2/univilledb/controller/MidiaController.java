package com.projetopo2.univilledb.controller;

import com.projetopo2.univilledb.dto.AdicionarMidiaRequest;
import com.projetopo2.univilledb.dto.EditarMidiaRequest;
import com.projetopo2.univilledb.entity.Midia;
import com.projetopo2.univilledb.service.MidiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/midias")
public class MidiaController {

    private final MidiaService midiaService;

    public MidiaController(MidiaService midiaService) {
        this.midiaService = midiaService;
    }

    @PostMapping
    public ResponseEntity<Midia> adicionarMidia(@RequestBody AdicionarMidiaRequest request) {
        Midia midia = midiaService.adicionar(request);
        return ResponseEntity.ok(midia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Midia> editarMidia(@PathVariable Long id, @RequestBody EditarMidiaRequest request) {
        if (!id.equals(request.id())) {
            return ResponseEntity.badRequest().build();
        }
        Midia midiaAtualizada = midiaService.editar(request);
        return ResponseEntity.ok(midiaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMidia(@PathVariable Long id) {
        midiaService.deletarPeloId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Midia> buscarMidiaPeloId(@PathVariable Long id) {
        try {
            var midia = midiaService.buscarPeloId(id);
            return ResponseEntity.ok(midia);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}