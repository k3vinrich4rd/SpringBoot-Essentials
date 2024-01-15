package academy.devdojo.springboot2essentials.client;

import academy.devdojo.springboot2essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        //Retorna todos os dados contidos no ResponseEntity
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/7 ", Anime.class);
        log.info(entity);

        //Retorna todos os dados contidos no Object
        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/7 ", Anime.class);
        log.info(object);

        //Retorna todos os dados contidos no Object (Outra forma de implementação)
        //Dessa maneira funciona, pois o spring faz a associação de id de forma automática
        //Permitindo passar mais de um id
        Anime object1 = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 7);
        log.info(object1);

        //Passando múltiplos ids's no parâmetro
        Anime object2 = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 7);
        log.info(object2);

    }
}
