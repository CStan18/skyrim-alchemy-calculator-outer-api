package com.cstan18.skyrimalchemycalculatorouterapi.dto;

public class IngredientQuantityDTO {
    private Long ingredientId;
    private int quantity;

    // Getters and Setters
    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
