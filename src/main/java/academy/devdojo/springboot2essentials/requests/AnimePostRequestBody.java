package academy.devdojo.springboot2essentials.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimePostRequestBody {
    private String name;
}
