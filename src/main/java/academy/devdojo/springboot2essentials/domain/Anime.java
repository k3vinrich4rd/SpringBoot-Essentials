package academy.devdojo.springboot2essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@Table(name = "student_register") usado para definir um nome a tabela
//Mas se esse nome não for definido a tabela terá o nome da classe
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@JsonProperty("casa") //caso o campo tivesse um nome diferente do que o informado
    private String name;
}
