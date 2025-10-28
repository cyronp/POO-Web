package com.projetopo2.univilledb.config;

import com.projetopo2.univilledb.entity.Midia;
import com.projetopo2.univilledb.repository.MidiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final MidiaRepository midiaRepository;

    public DataLoader(MidiaRepository midiaRepository){
        this.midiaRepository = midiaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (midiaRepository.count() == 0) {
            // Séries
            midiaRepository.save(new Midia("The Boys", 8.6F, "Serie", "40 episódios", "Eric Kripke", "Comédia", "Heróis",
                    "https://m.media-amazon.com/images/M/MV5BMWJlN2U5MzItNjU4My00NTM2LWFjOWUtOWFiNjg3ZTMxZDY1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg"));

            midiaRepository.save(new Midia("Breaking Bad", 9.5F, "Serie", "62 episódios", "Vince Gilligan", "Drama", "Crime",
                    "https://m.media-amazon.com/images/M/MV5BMzU5ZGYzNmQtMTdhYy00OGRiLTg0NmQtYjVjNzliZTg1ZGE4XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg"));

            midiaRepository.save(new Midia("Stranger Things", 8.7F, "Serie", "34 episódios", "Duffer Brothers", "Ficção Científica", "Terror",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_jTO6P0NzbqJlGm2dDD25Kc4jaJQcUXBHsg&s"));

            midiaRepository.save(new Midia("Game of Thrones", 9.2F, "Serie", "73 episódios", "David Benioff & D.B. Weiss", "Fantasia", "Aventura",
                    "https://m.media-amazon.com/images/M/MV5BMTNhMDJmNmYtNDQ5OS00ODdlLWE0ZDAtZTgyYTIwNDY3OTU3XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg"));

            midiaRepository.save(new Midia("The Office", 9.0F, "Serie", "201 episódios", "Greg Daniels", "Comédia", "Sitcom",
                    "https://m.media-amazon.com/images/M/MV5BZjQwYzBlYzUtZjhhOS00ZDQ0LWE0NzAtYTk4MjgzZTNkZWEzXkEyXkFqcGc@._V1_.jpg"));

            // Filmes
            midiaRepository.save(new Midia("Inception", 8.8F, "Filme", "148 minutos", "Christopher Nolan", "Ficção Científica", "Suspense",
                    "https://m.media-amazon.com/images/I/912AErFSBHL._AC_UF894,1000_QL80_.jpg"));

            midiaRepository.save(new Midia("The Dark Knight", 9.0F, "Filme", "152 minutos", "Christopher Nolan", "Ação", "Crime",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/The_Dark_Knight_%282008_film%29.jpg/250px-The_Dark_Knight_%282008_film%29.jpg"));

            midiaRepository.save(new Midia("Interstellar", 8.6F, "Filme", "169 minutos", "Christopher Nolan", "Ficção Científica", "Drama",
                    "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg"));

            midiaRepository.save(new Midia("Parasite", 8.6F, "Filme", "132 minutos", "Bong Joon-ho", "Drama", "Suspense",
                    "https://upload.wikimedia.org/wikipedia/en/5/53/Parasite_%282019_film%29.png"));

            midiaRepository.save(new Midia("The Godfather", 9.2F, "Filme", "175 minutos", "Francis Ford Coppola", "Crime", "Drama",
                    "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg"));
        } else {
            System.out.println("Nenhum registro criado.");
        }
    }
}
