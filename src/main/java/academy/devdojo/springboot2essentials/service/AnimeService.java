package academy.devdojo.springboot2essentials.service;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    //private final AnimeRepository animeRepository (Futuro)

    private final List<Anime> animes = List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk"));

    public List<Anime> findById() {
        return animes;
    }

    public Anime findById(Long id) {
        return animes
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not Found"));
    }
}
