//package academy.devdojo.springboot2essentials.client;
//
//import academy.devdojo.springboot2essentials.domain.Anime;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Log4j2
//public class SpringClient {
//    public static void main(String[] args) {
//        //Retorna todos os dados contidos no ResponseEntity
//        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/7 ", Anime.class);
//        log.info(entity);
//
//        //Retorna todos os dados contidos no Object
//        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/7 ", Anime.class);
//        log.info(object);
//
//        //Retorna todos os dados contidos no Object (Outra forma de implementação)
//        //Dessa maneira funciona, pois o spring faz a associação de id de forma automática
//        //Permitindo passar mais de um id
//        Anime object1 = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 7);
//        log.info(object1);
//
//        //Maneira antiga de ver objetos de uma lista (como se fosse um client no caso)
//        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
//        log.info(Arrays.toString(animes));
//
//        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Anime>>() {
//                });
//        log.info(exchange.getBody());
//
////        //RestTemplate, POST
////        Anime kingdom = Anime.builder().name("kingdom").build();
////        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", kingdom, Anime.class);
////        log.info("saved anime {}", kingdomSaved);
//
////        Anime samuraiChamplo = Anime.builder().name("kingdom").build();
////        ResponseEntity<Anime> samuraiChamploSaved = new RestTemplate().exchange("http://localhost:8080/animes/",
////                HttpMethod.POST,
////                new HttpEntity<>(samuraiChamplo),
////                Anime.class);
////        log.info("saved anime {}", samuraiChamploSaved);
//
//
//
////        //RestTemplate, PUT
//
////        Anime animeToBeUpdate = samuraiChamploSaved.getBody();
////        animeToBeUpdate.setName("Samurai Champloo 2");
////
////        ResponseEntity < Anime > samuraiChamploUpdate = new RestTemplate().exchange("http://localhost:8080/animes/",
////////                HttpMethod.PUT,
////////                new HttpEntity<>(animeToBeUpdate, createJsonHeader()),,
////////                Void.class);
////
////////        log.info("saved anime {}", samuraiChamploSaved);
//
//
//
//
////        //RestTemplate, DELETE
//
////        ResponseEntity <Void> samuraiChamplooDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
////////                HttpMethod.DELETE,
////////                new HttpEntity<>(animeToBeUpdate, createJsonHeader()),,
////////                Void.class);
////
////////        log.info(samuraiChamplooDeleted);
//    }
//
//
//    //Passando o Headers na requisição
////    private static HttpHeaders createJsonHeader() {
////        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
////        return httpHeaders;
////    }
//
//    //RestTemplate, PUT
//    Anime animeToBeUpdate = samuraiChamploSaved.getBody();
//
//}
