package de.eniprojekte.tacocloud.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("INGREDIENT")
public class Ingredient implements Persistable<String> {

    @Id
    @Column("ID")
    private final String id;
    @Column("INGREDIENT_NAME")
    private final String name;
    @Column("INGREDIENT_TYPE")
    private final Type type;

    @Override
    public boolean isNew() {
        return true;
    }

    public enum Type{

        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE

    }

}
