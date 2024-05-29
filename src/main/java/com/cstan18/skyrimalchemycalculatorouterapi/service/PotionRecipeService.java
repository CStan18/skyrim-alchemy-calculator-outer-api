package com.cstan18.skyrimalchemycalculatorouterapi.service;

import com.cstan18.skyrimalchemycalculatorouterapi.model.Effect;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import org.springframework.stereotype.Service;

public interface PotionRecipeService {

    Ingredient getIngredientById();

    Effect getEffectById();

}
