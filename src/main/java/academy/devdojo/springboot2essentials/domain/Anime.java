package academy.devdojo.springboot2essentials.domain;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anime {

    private UUID id;
    private String name;

}
