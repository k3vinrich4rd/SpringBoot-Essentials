package academy.devdojo.springboot2essentials.domain;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anime {

    private Long id;
    private String name;

}
