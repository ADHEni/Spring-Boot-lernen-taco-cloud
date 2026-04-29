package de.eniprojekte.tacocloud.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;




@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED,force = true)
@Table(name="INGREDIENT")
public class Ingredient {

    @Id
    @Column(name = "ID")
    private final String id;
    @Column(name = "INGREDIENT_NAME")
    private final String name;
    @Column(name = "INGREDIENT_TYPE")
    private final Type type;

    public enum Type{

        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE

    }

}