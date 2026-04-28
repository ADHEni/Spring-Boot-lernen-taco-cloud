package de.eniprojekte.tacocloud.Repository;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.interfaces.IngredientRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("SELECT id, ingredient_name, ingredient_type FROM Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate
                .query("SELECT id, ingredient_name, ingredient_type FROM Ingredient " +
                        "WHERE id = ? ", this::mapRowToIngredient, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("INSERT INTO Ingredient(id, ingredient_name, ingredient_type) VALUES (?,?.?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());

        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {

        return new Ingredient(rs.getString("id"), rs.getString("ingredient_name"),Ingredient.ingredientType.valueOf(rs.getString("ingredient_type")));


    }

}
