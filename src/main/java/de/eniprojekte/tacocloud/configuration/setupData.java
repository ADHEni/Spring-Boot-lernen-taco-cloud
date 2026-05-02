package de.eniprojekte.tacocloud.configuration;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.data.Ingredient.Type;
import de.eniprojekte.tacocloud.data.Taco;
import de.eniprojekte.tacocloud.interfaces.IngredientRepository;
import de.eniprojekte.tacocloud.interfaces.TacoRepository;
import de.eniprojekte.tacocloud.interfaces.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
public class setupData {


    @Bean
    public CommandLineRunner dataLoader (IngredientRepository ingredientRepository, UserRepository userRepository,
                                         PasswordEncoder passwordEncoder, TacoRepository tacoRepository) {
        return args -> {

            Ingredient flourTortilla = new Ingredient(
                    "FLTO", "Flour Tortilla", Type.WRAP);
            Ingredient cornTortilla = new Ingredient(
                    "COTO", "Corn Tortilla", Type.WRAP);
            Ingredient groundBeef = new Ingredient(
                    "GRBF", "Ground Beef", Type.PROTEIN);
            Ingredient carnitas = new Ingredient(
                    "CARN", "Carnitas", Type.PROTEIN);
            Ingredient tomatoes = new Ingredient(
                    "TMTO", "Diced Tomatoes", Type.VEGGIES);
            Ingredient lettuce = new Ingredient(
                    "LETC", "Lettuce", Type.VEGGIES);
            Ingredient cheddar = new Ingredient(
                    "CHED", "Cheddar", Type.CHEESE);
            Ingredient jack = new Ingredient(
                    "JACK", "Monterrey Jack", Type.CHEESE);
            Ingredient salsa = new Ingredient(
                    "SLSA", "Salsa", Type.SAUCE);
            Ingredient sourCream = new Ingredient(
                    "SRCR", "Sour Cream", Type.SAUCE);

            if(ingredientRepository.count() > 0){

                System.out.println("Datensatz schon vorhanden");

            }else{

                ingredientRepository.save(flourTortilla);
                ingredientRepository.save(cornTortilla);
                ingredientRepository.save(groundBeef);
                ingredientRepository.save(carnitas);
                ingredientRepository.save(tomatoes);
                ingredientRepository.save(lettuce);
                ingredientRepository.save(cheddar);
                ingredientRepository.save(jack);
                ingredientRepository.save(salsa);
                ingredientRepository.save(sourCream);
            }

            if(tacoRepository.count() > 0){

                return;

            }

            Taco taco1 = new Taco();
            taco1.setName("Bravius Maximus");
            taco1.setIngredients(Arrays.asList(flourTortilla, cornTortilla, groundBeef));
            tacoRepository.save(taco1);

            Taco taco2 = new Taco();
            taco2.setName("Banana Maximus");
            taco2.setIngredients(Arrays.asList(flourTortilla, cornTortilla, jack));
            tacoRepository.save(taco2);

        };



    }



}
