package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
