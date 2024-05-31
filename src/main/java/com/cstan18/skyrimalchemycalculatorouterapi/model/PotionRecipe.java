package com.cstan18.skyrimalchemycalculatorouterapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PotionRecipe {

    private List<Ingredient> ingredientList;

}
