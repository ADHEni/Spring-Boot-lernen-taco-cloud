package de.eniprojekte.tacocloud.data;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Date orderPlacedAt;

    @NotEmpty
    private String deliveryName;

    @NotEmpty
    private String deliveryStreet;

    @NotEmpty
    private String deliveryCity;

    @NotEmpty
    private String deliveryState;

    @NotEmpty
    private String deliveryZip;

    @NotEmpty
    @CreditCardNumber(message = "Not a valid Craditcard Number!")
    private String ccNumber;

    @NotEmpty
    @Pattern(regexp = "^(0[1-9]|1[0-2])/([2-9][1-9])$", message = "MM/YY")
    private String ccExpiration;

    @NotEmpty
    @Digits(integer = 3, fraction = 0 , message = "Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){

        tacos.add(taco);

    }


}

