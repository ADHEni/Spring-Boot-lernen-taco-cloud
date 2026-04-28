package de.eniprojekte.tacocloud.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("INGREDIENT")
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
