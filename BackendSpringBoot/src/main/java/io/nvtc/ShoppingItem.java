package io.nvtc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShoppingItem {

    @Id
    private String name;
    private Integer amount;

    public ShoppingItem() {
    }

    public ShoppingItem(String name) {
        this.name = name;
        this.amount = 1;
    }

    public ShoppingItem(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
}
