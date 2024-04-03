package academy.devdojo.springboot2essentials.repository;

import academy.devdojo.springboot2essentials.domain.Anime;
import academy.devdojo.springboot2essentials.utils.AnimeCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@DataJpaTest

@DisplayName("Test for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists anime when Successful")
    void savePersistAnimeWhenSuccessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        Assertions.assertThat(animeSaved).isNotNull();

        Assertions.assertThat(animeSaved.getId()).isNotNull();

        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());

    }

    @Test
    @DisplayName("Save update anime when Successful")
    void saveUpdateAnimeWhenSuccessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        animeSaved.setName("Overlord");

        Anime animeUpdate = this.animeRepository.save(animeSaved);

        Assertions.assertThat(animeUpdate).isNotNull();

        Assertions.assertThat(animeUpdate.getId()).isNotNull();

        Assertions.assertThat(animeUpdate.getName()).isEqualTo(animeSaved.getName());

    }

    @Test
    @DisplayName("Delete removes animes when Successful")
    void deleteRemovesAnimeWhenSuccessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        this.animeRepository.delete(animeSaved);

        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());

        Assertions.assertThat(animeOptional.isEmpty()).isTrue();

    }

    @Test
    @DisplayName("Find By Name returns list of anime when Successful")
    void findByNameAnimeWhenSuccessful() {

        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        String name = animeSaved.getName();

        List<Anime> animes = this.animeRepository.findByName(name);

        //É possível encadear asserções
        Assertions.assertThat(animes)
                .isNotEmpty()
                .contains(animeSaved);


    }

    @Test
    @DisplayName("Find By Name returns empty lis when no anime is found")
    void FindByNameReturnsEmptyListOfAnimeIsNotFound() {

        List<Anime> animes = this.animeRepository.findByName("xaxa");

        Assertions.assertThat(animes).isEmpty();


    }

    //Testando exceções:
    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void saveThrowConstraintViolationExceptionWhenNameIsEmpty() {
        Anime anime = new Anime();
        Assertions.assertThatThrownBy(() -> this.animeRepository.save(anime))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void saveThrowConstraintViolationExceptionWhenNameIsEmpty2() {
        Anime anime = new Anime();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.animeRepository.save(anime))
                .withMessageContaining("The anime name cannot be empty");
    }

}
