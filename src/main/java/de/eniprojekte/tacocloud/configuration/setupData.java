package de.eniprojekte.tacocloud.configuration;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.data.Ingredient.Type;
import de.eniprojekte.tacocloud.interfaces.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class setupData {


    @Bean
    public CommandLineRunner dataLoader (IngredientRepository ingredientRepository) {
        return args -> {


            if(ingredientRepository.count() > 0){

                System.out.println("Datensatz schon vorhanden");
                return;
            }

            ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

        };



    }



}
