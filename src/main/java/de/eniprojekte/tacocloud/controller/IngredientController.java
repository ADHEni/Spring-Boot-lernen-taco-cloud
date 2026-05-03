package de.eniprojekte.tacocloud.controller;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.interfaces.IngredientRepository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/ingredients", produces = "application/json")
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {

        this.ingredientRepository = ingredientRepository;

    }


    @GetMapping
    public Iterable<Ingredient> findAll() {

        return ingredientRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed("ROLE_ADMIN")
    public Ingredient save(@RequestBody Ingredient ingredient) {

        return ingredientRepository.save(ingredient);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {

        ingredientRepository.deleteById(id);

    }


}
