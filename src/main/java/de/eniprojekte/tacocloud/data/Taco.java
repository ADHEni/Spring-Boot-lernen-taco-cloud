package de.eniprojekte.tacocloud.data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Data
@Table("TACO")
public class Taco {

    @Id
    private Long id;
    @Column("CREATED_AT")
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, max = 50, message = "Mindest 5 Buchstaben")
    @Column("TACO_NAME")
    private String name;

    @NotNull
    @Size(min = 1, message = "Es muss mindestens ein Inhalt gewählt werden!")
    @MappedCollection(idColumn = "TACO_ID", keyColumn = "TACO_KEY")
    private List<Ingredient_Ref> ingredients;





}
