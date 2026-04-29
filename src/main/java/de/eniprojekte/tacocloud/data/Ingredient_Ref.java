package de.eniprojekte.tacocloud.data;


import jakarta.persistence.Table;
import lombok.Data;


@Data
@Table(name= "INGREDIENT_REF")
public class Ingredient_Ref {

    private final String ingredient;

}
