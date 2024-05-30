package com.cstan18.skyrimalchemycalculatorouterapi.dto.request;

import com.cstan18.skyrimalchemycalculatorouterapi.dto.IngredientQuantityDTO;

import java.util.List;

public class IngredientQuantityRequest {
    private List<IngredientQuantityDTO> ingredients;

    // Getters and Setters
    public List<IngredientQuantityDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientQuantityDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
