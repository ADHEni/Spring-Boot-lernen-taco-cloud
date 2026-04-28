package de.eniprojekte.tacocloud.data;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table("TACO_ORDER")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Date orderPlacedAt;

    @NotEmpty
    @Column("DELIVERY_NAME")
    private String deliveryName;

    @NotEmpty
    @Column("DELIVERY_STREET")
    private String deliveryStreet;

    @NotEmpty
    @Column("DELIVERY_CITY")
    private String deliveryCity;

    @NotEmpty
    @Column("DELIVERY_STATE")
    private String deliveryState;

    @NotEmpty
    @Column("DELIVERY_ZIP")
    private String deliveryZip;

    @NotEmpty
    @CreditCardNumber(message = "Not a valid Craditcard Number!")
    @Column("CREDIT_CARD_NUMBER")
    private String ccNumber;

    @NotEmpty
    @Pattern(regexp = "^(0[1-9]|1[0-2])/([2-9][1-9])$", message = "MM/YY")
    @Column("CREDIT_CARD_EXPIRATION")
    private String ccExpiration;

    @NotEmpty
    @Digits(integer = 3, fraction = 0 , message = "Invalid CVV")
    @Column("CREDIT_CARD_CVV")
    private String ccCVV;

    @MappedCollection(idColumn = "TACO_ORDER_ID", keyColumn = "TACO_ORDER_KEY")
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){

        tacos.add(taco);

    }


}

