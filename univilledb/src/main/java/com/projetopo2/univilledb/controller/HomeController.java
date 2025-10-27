package com.projetopo2.univilledb.controller;

import com.projetopo2.univilledb.service.MidiaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private final MidiaService midiaService;

    public HomeController(MidiaService midiaService) {
        this.midiaService = midiaService;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/movies_all")
    public ModelAndView moviesAll() {
        var midias = midiaService.listarTodos();

        var modelAndView = new ModelAndView("movies_all");
        modelAndView.addObject("midias", midias);
        return modelAndView;
    }

    @GetMapping("/movies")
    public ModelAndView listarFilmes() {
        var midias = midiaService.listarFilmes();

        var modelAndView = new ModelAndView("movies_all");
        modelAndView.addObject("midias", midias);
        return modelAndView;
    }

    @GetMapping("/series")
    public ModelAndView listarSeries() {
        var midias = midiaService.listarSeries();

        var modelAndView = new ModelAndView("movies_all");
        modelAndView.addObject("midias", midias);
        return modelAndView;
    }

    @GetMapping("/top_movie")
    public ModelAndView topFilme() {
        var midias = midiaService.topFilme();

        var modelAndView = new ModelAndView("movies_all");
        modelAndView.addObject("midias", midias);
        return modelAndView;
    }

    @GetMapping("/top_series")
    public ModelAndView topSerie() {
        var midias = midiaService.topSerie();

        var modelAndView = new ModelAndView("movies_all");
        modelAndView.addObject("midias", midias);
        return modelAndView;
    }

    @GetMapping("/create_movie")
    public String createMovie() {
        return "create_movie";
    }

    @GetMapping("/edit_movie")
    public String editMovie() {
        return "edit_movie";
    }

    @GetMapping("/delete_movie")
    public String deleteMovie() {
        return "delete_movie";
    }
}