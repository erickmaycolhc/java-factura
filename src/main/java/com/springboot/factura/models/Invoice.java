package com.springboot.factura.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {
    @Autowired  //inyectar las dependecncias    se encargará de buscar y asignar automáticamente los valores
    private Client client;
    @Value("${envoice.description}")
    private String description;
    @Autowired  //inyectar el componente     se encargará de buscar y asignar automáticamente los valores
    private List<Item> items;

    public Client getClient(){
        return client;
    }
    public void setClient(Client client){
        this.client = client;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public List<Item> getItems(){
        return items;
    }
    public void setItems(List<Item> items){
        this.items = items;
    }

    public int getTotal(){
        // int total = 0;
        // for(Item item: items){
        //     total = total + item.getImporte();
        //  }
        //  return total;

        return items.stream().map(item -> item.getImporte()).reduce(0, (sum, importe)-> sum+ importe);

    }

}
