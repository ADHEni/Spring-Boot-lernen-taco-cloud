package de.eniprojekte.tacocloud.data;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("INGREDIENT_REF")
public class Ingredient_Ref {

    @Column("INGREDIENT_ID")
    private final String ingredient;

}
