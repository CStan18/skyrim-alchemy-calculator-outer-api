package com.cstan18.skyrimalchemycalculatorouterapi.model;

import lombok.Data;

import java.util.List;

@Data
public class PotionRecipe {

    private List<Ingredient> ingredientList;

    public PotionRecipe(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
