package academy.devdojo.springboot2essentials.service;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    //private final AnimeRepository animeRepository (Futuro)

    private final static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk")));
    }

    public List<Anime> findById() {
        return animes;
    }

    public Anime findById(Long id) {
        return animes
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not Found"));
    }

    public Anime createAnime(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        animes.add(anime);
        return anime;
    }

    public void deleteAnime(Long id) {
        animes.remove(findById(id));

    }

    public void replace(Anime anime) {
        deleteAnime(anime.getId());
        animes.add(anime);
    }
}
