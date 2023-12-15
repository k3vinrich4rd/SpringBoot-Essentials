package academy.devdojo.springboot2essentials.service;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeService {
    //private final AnimeRepository animeRepository (Futuro)
    public List<Anime> listAll() {
        return List.of(new Anime(UUID.randomUUID(), "Boku No Hero"), new Anime(UUID.randomUUID(), "Bersek"));
    }
}
