package com.cstan18.skyrimalchemycalculatorouterapi.service;

import com.cstan18.skyrimalchemycalculatorouterapi.dto.request.IngredientQuantityRequest;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Effect;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import com.cstan18.skyrimalchemycalculatorouterapi.model.PotionRecipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PotionRecipeService {

    Ingredient getIngredientById(Long ingredientId);

    Effect getEffectById(Long effectId);

    List<PotionRecipe> createRecipes(IngredientQuantityRequest request);

    Map<Long, Set<Long>> precomputeComputeCompatibleIngredients();
}
