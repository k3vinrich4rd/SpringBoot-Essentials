package academy.devdojo.springboot2essentials.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimePostRequestBody {

    @NotBlank(message = "The anime name cannot be empty")
    private String name;
}
