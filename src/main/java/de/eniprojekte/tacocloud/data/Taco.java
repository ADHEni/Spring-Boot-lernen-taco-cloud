package de.eniprojekte.tacocloud.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "TACO")
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CREATED_AT")
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, max = 50, message = "Mindest 5 Buchstaben")
    @Column(name = "TACO_NAME")
    private String name;

    @NotNull
    @Size(min = 1, message = "Es muss mindestens ein Inhalt gewählt werden!")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {

        this.ingredients.add(ingredient);

    }



}