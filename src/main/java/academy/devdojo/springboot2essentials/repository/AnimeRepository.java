package academy.devdojo.springboot2essentials.repository;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnimeRepository{
    List<Anime> searchAllAnimes();

    List<Anime> searchAnimesById(UUID id);
}
