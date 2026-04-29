package de.eniprojekte.tacocloud.data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    @Id
    private Long id;
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, max = 50, message = "Mindest 5 Buchstaben")
    private String name;

    @NotNull
    @Size(min = 1, message = "Es muss mindestens ein Inhalt gewählt werden!")
    private List<Ingredient_Ref> ingredients;





}
