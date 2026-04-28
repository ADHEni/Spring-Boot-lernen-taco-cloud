package de.eniprojekte.tacocloud.Repository;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.data.Ingredient_Ref;
import de.eniprojekte.tacocloud.data.Taco;
import de.eniprojekte.tacocloud.data.TacoOrder;
import de.eniprojekte.tacocloud.interfaces.OrderRepository;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;


    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder save(TacoOrder order) {

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(

                "INSERT INTO Taco_Order" +
                        " (delivery_name, delivery_street, delivery_city," +
                        " delivery_state,delivery_zip,  credit_card_number, " +
                        " credit_card_expiration, credit_card_cvv, placed_at) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);
        order.setOrderPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(

                Arrays.asList(

                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getDeliveryState(),
                        order.getDeliveryZip(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCVV(),
                        order.getOrderPlacedAt())
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Taco> tacos = order.getTacos();

        int i = 0;

        for (Taco taco : tacos) {

            saveTaco(orderId, i++, taco);

        }

        return order;
    }

    private long saveTaco(long orderId, int orderKey, Taco taco) {

        taco.setCreatedAt(new Date());

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(

                "INSERT INTO Taco" +
                        "(taco_name, taco_order_id, taco_order_key, " +
                        "created_at) VALUES (?,?,?,?)",
                Types.VARCHAR, Type.LONG, Type.LONG,
                Types.TIMESTAMP
        );

        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(

                        taco.getName(),
                        orderId,
                        orderKey,
                        taco.getCreatedAt()

                )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);

        saveIngredientRefs(tacoId, taco.getIngredients());

        return tacoId;
    }


    private void saveIngredientRefs(long tacoId, List<Ingredient> ingredientsRefs) {

        int key = 0;
        for (Ingredient ingredient : ingredientsRefs) {

            jdbcOperations.update("INSERT INTO Ingredient_Ref (ingredient_id, taco_id, taco_key) VALUES (?,?,?)", ingredient.getId(), tacoId, key++);

        }


    }

}
