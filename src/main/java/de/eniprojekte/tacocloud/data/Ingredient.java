package de.eniprojekte.tacocloud.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Ingredient {

    @Id
    private final String id;

    private final String name;
    private final ingredientType type;

    public enum ingredientType{

        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE

    }

}
