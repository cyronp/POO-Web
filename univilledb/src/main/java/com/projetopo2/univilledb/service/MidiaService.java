package com.projetopo2.univilledb.service;

import com.projetopo2.univilledb.dto.AdicionarMidiaRequest;
import com.projetopo2.univilledb.dto.EditarMidiaRequest;
import com.projetopo2.univilledb.entity.Midia;
import com.projetopo2.univilledb.repository.MidiaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MidiaService {

    private final MidiaRepository midiaRepository;

    public MidiaService(MidiaRepository midiaRepository) {this.midiaRepository = midiaRepository;}

    public List<Midia> listarTodos(){return midiaRepository.findAll();}

    public List<Midia> listarFilmes(){return midiaRepository.findAllByTipo("Filme");}

    public List<Midia> listarSeries(){return midiaRepository.findAllByTipo("Serie");}

    public List<Midia> topFilme(){return midiaRepository.findTop1ByTipoOrderByNotaDesc("Filme");}

    public List<Midia> topSerie(){return midiaRepository.findTop1ByTipoOrderByNotaDesc("Serie");}

    public void deletarPeloId(Long id){midiaRepository.deleteById(id);}

    public Midia buscarPeloId(Long id) {
        return midiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mídia com ID " + id + " não encontrada."));
    }

    public Midia editar(EditarMidiaRequest request) {
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.titulo())){
            builder.append("Favor informar o titulo.").append("\n");
        }
        if (request.nota() == null || request.nota() < 0 || request.nota() > 10){
            builder.append("A nota deve estar entre 0 e 10").append("\n");
        }
        if(Strings.isBlank(request.tipo())){
            builder.append("Favor informar o tipo de midia.").append("\n");
        }
        if(Strings.isBlank(request.duracao())){
            builder.append("Favor informar uma duração válida").append("\n");
        }
        if(Strings.isBlank(request.criador())){
            builder.append("Favor informar o criador.").append("\n");
        }
        if(Strings.isBlank(request.genero())){
            builder.append("Favor informar o genero.").append("\n");
        }
        if(Strings.isBlank(request.subGenero())){
            builder.append("Favor informar o subgenero .").append("\n");
        }
        if(Strings.isBlank(request.capaUrl())){
            builder.append("Favor informar a url da capa.").append("\n");
        }
        if (!builder.isEmpty()){
            throw new RuntimeException(builder.toString());
        }
        var old = midiaRepository.findById(request.id()).orElseThrow();
        old.setTitulo(request.titulo());
        old.setNota(request.nota());
        old.setTipo(request.tipo());
        old.setDuracao(request.duracao());
        old.setCriador(request.criador());
        old.setGenero(request.genero());
        old.setSubGenero(request.subGenero());
        old.setCapaUrl(request.capaUrl());
        return midiaRepository.save(old);
    }

    public Midia adicionar(AdicionarMidiaRequest request) {
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.titulo())){
            builder.append("Favor informar o titulo.").append("\n");
        }
        if (request.nota() == null || request.nota() < 0 || request.nota() > 10){
            builder.append("A nota deve estar entre 0 e 10").append("\n");
        }
        if(Strings.isBlank(request.tipo())){
            builder.append("Favor informar o tipo de midia.").append("\n");
        }
        if(Strings.isBlank(request.duracao())){
            builder.append("Favor informar uma duração válida").append("\n");
        }
        if(Strings.isBlank(request.criador())){
            builder.append("Favor informar o criador.").append("\n");
        }
        if(Strings.isBlank(request.genero())){
            builder.append("Favor informar o genero.").append("\n");
        }
        if(Strings.isBlank(request.subGenero())){
            builder.append("Favor informar o subgenero .").append("\n");
        }
        if(Strings.isBlank(request.capaUrl())){
            builder.append("Favor informar a url da capa.").append("\n");
        }
        if (!builder.isEmpty()){
            throw new RuntimeException(builder.toString());
        }
        var midia = new Midia();
        midia.setTitulo(request.titulo());
        midia.setNota(request.nota());
        midia.setTipo(request.tipo());
        midia.setDuracao(request.duracao());
        midia.setCriador(request.criador());
        midia.setGenero(request.genero());
        midia.setSubGenero(request.subGenero());
        midia.setCapaUrl(request.capaUrl());
        return midiaRepository.save(midia);
    }



}
