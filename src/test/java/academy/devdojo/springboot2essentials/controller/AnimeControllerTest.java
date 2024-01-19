package academy.devdojo.springboot2essentials.controller;

import academy.devdojo.springboot2essentials.domain.Anime;
import academy.devdojo.springboot2essentials.service.AnimeService;
import academy.devdojo.springboot2essentials.utils.AnimeCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class) //Indica utilização de jUnit com Spring
class AnimeControllerTest {


    @InjectMocks //Utilizado quando queremos testar a classe em si
    private AnimeController animeController;

    // Utilizado para simular comportamento das classes que estão presente
    //Na classe que esta sendo testada
    // (pois ele vai simular o comportamento dessas classes
    @Mock
    private AnimeService animeServiceMock;

    @BeforeEach
        //Definindo o comportamento do mock de listAll();
        //Antes de cada um dos testes executados nesta classe (faça):
    void setUp() {

         /* Resumo: Foi criada uma variável que representa uma lista com informações da entidade,
        que contém paginação, depois foi estabelecido uma regra para efetuar a chamada do método
        listAll, sendo: quando esse método (listAll) for chamado
        retorne a variável que contém paginação */
        PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeServiceMock.listAllWithPageable(ArgumentMatchers.any()))
                .thenReturn(animePage);

        /* Resumo: Quando o método listAllNonPageable for chamado
        então retorne uma lista do objeto, representado através do método estático
        createValidAnime */
        BDDMockito.when(animeServiceMock.listAllNonPageable())
                .thenReturn(List.of(AnimeCreator.createValidAnime()));


        /* Resumo: Quando o método findById for chamado
        então retorne um objeto, representado através do método estático
        createValidAnime */
        BDDMockito.when(animeServiceMock.findByIdOrThrowNotFoundException(ArgumentMatchers.anyLong()))
                .thenReturn(AnimeCreator.createValidAnime());


        /* Resumo: Quando o método findByName for chamado
        então retorne uma lista do objeto, representado através do método estático
        createValidAnime */
        BDDMockito.when(animeServiceMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(List.of(AnimeCreator.createValidAnime()));

    }

    @Test
    @DisplayName("returns list of anime inside page object when successful")
    void returnsListOfAnimesInsidePageObjectWhenSuccessful() {

        String expectedName = AnimeCreator.createValidAnime().getName();

        Long expectedLong = AnimeCreator.createValidAnime().getId();

        Page<Anime> animePage = animeController.list(null).getBody();

        Assertions.assertThat(animePage).isNotNull();

        Assertions.assertThat(animePage.toList())
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(animePage.toList()
                        .get(0)
                        .getName())
                .isEqualTo(expectedName);

        Assertions.assertThat(animePage.toList()
                        .get(0)
                        .getId())
                .isEqualTo(expectedLong);

    }

    @Test
    @DisplayName("ListAll returns of anime when successful")
    void listAllReturnsOfAnimesWhenSuccessful() {

        String expectedName = AnimeCreator.createValidAnime().getName();

        Long expectedLong = AnimeCreator.createValidAnime().getId();

        List<Anime> animes = animeController.listAll().getBody();

        Assertions.assertThat(animes).isNotNull();

        Assertions.assertThat(animes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);

        Assertions.assertThat(animes.get(0).getId()).isEqualTo(expectedLong);


    }

    @Test
    @DisplayName("findById returns anime when successful")
    void findByIdReturnsAnimesWhenSuccessful() {

        Long expectedId = AnimeCreator.createValidAnime().getId();

        String expectedName = AnimeCreator.createValidAnime().getName();

        Anime anime = animeController.findById(1L).getBody();

        Assertions.assertThat(anime).isNotNull();

        Assertions.assertThat(anime.getId())
                .isNotNull()
                .isEqualTo(expectedId);

        Assertions.assertThat(anime.getName())
                .isNotNull()
                .isEqualTo(expectedName);

    }

    @Test
    @DisplayName("findByName returns a list of anime when successful")
    void findByNamedReturnsListAnimesWhenSuccessful() {

        String expectedName = AnimeCreator.createValidAnime().getName();

        List<Anime> animes = animeController.findByName("teste").getBody();

        Assertions.assertThat(animes)
                .isNotEmpty()
                .isNotNull()
                .hasSize(1);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }

}