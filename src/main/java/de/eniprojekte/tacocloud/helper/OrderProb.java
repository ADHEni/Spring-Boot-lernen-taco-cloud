package de.eniprojekte.tacocloud.helper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "taco.order")
@Data
public class OrderProb {

    private int pageSize = 20;

}
