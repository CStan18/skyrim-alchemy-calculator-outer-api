package com.cstan18.skyrimalchemycalculatorouterapi.dto.response;

import com.cstan18.skyrimalchemycalculatorouterapi.model.PotionRecipe;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IngredientQuantityResponse {

    private List<PotionRecipe> potionRecipeList;
}
