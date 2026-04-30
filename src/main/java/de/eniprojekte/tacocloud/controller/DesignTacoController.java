package de.eniprojekte.tacocloud.controller;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.data.Ingredient.Type;
import de.eniprojekte.tacocloud.data.Taco;
import de.eniprojekte.tacocloud.data.TacoOrder;
import de.eniprojekte.tacocloud.interfaces.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;


    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {

        this.ingredientRepo = ingredientRepo;

    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {


        java.lang.Iterable<Ingredient> ingredients = ingredientRepo.findAll();

        Type[] types = Ingredient.Type.values();

        for(Type type : types) {

            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));

        }


    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder() {

        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){

        return new Taco();

    }


    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processTaco(
            @Valid @ModelAttribute("taco") Taco taco,
            Errors errors,
            @ModelAttribute("tacoOrder") TacoOrder tacoOrder) {

        if (errors.hasErrors()) {
            System.out.println("========== VALIDATION ERRORS ==========");

            errors.getAllErrors().forEach(error -> {
                System.out.println("Object error: " + error);
            });


            return "design";
        }

        tacoOrder.addTaco(taco);


        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredientList, Type type) {

        List<Ingredient> result = new ArrayList<>();

        ingredientList.forEach(x -> {
            if(x.getType().equals(type)){
                result.add(x);}
        });

        return result;

    }


}
