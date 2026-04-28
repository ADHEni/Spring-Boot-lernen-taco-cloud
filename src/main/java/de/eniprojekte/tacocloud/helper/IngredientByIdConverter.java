package de.eniprojekte.tacocloud.helper;


import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.interfaces.IngredientRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository jdbcIngredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository jdbcIngredientRepository) {

        this.jdbcIngredientRepository = jdbcIngredientRepository;

    }


    @Override
    public Ingredient convert(String id) {

        return jdbcIngredientRepository.findById(id).orElse(null);
    }

}
