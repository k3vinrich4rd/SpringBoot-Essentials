package academy.devdojo.springboot2essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "student_register") usado para definir um nome a tabela
//Mas se esse nome não for definido a tabela terá o nome da classe
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
