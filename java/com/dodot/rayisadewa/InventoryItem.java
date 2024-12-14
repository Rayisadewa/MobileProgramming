package com.dodot.rayisadewa;

public class InventoryItem {
    private String name;
    private String description;
    private int quantity;

    public InventoryItem(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }
}
