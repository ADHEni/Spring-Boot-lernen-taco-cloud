package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.Ingredient;

import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
