package de.eniprojekte.tacocloud.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


import org.springframework.data.relational.core.mapping.Column;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED,force = true)
public class Ingredient {

    @Id
    @Column("ID")
    private final String id;
    @Column("INGREDIENT_NAME")
    private final String name;
    @Column("INGREDIENT_TYPE")
    private final Type type;

    public enum Type{

        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE

    }

}
