package com.springboot.factura;

import com.springboot.factura.models.Item;
import com.springboot.factura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean    //componennte
    List<Item> itemsInvoice(){
        Product p1 = new Product("mode", 500);
        Product p2 = new Product("bici",1000);
        List<Item> items = Arrays.asList(new Item(p1,2), new Item(p2, 4));
        return items;
    };
}
