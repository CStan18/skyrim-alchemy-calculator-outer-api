package com.cstan18.skyrimalchemycalculatorouterapi.service.impl;

import com.cstan18.skyrimalchemycalculatorouterapi.dto.IngredientQuantityDTO;
import com.cstan18.skyrimalchemycalculatorouterapi.dto.request.IngredientQuantityRequest;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Effect;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import com.cstan18.skyrimalchemycalculatorouterapi.model.PotionRecipe;
import com.cstan18.skyrimalchemycalculatorouterapi.repository.EffectRepository;
import com.cstan18.skyrimalchemycalculatorouterapi.repository.IngredientRepository;
import com.cstan18.skyrimalchemycalculatorouterapi.service.PotionRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PotionRecipeServiceImpl implements PotionRecipeService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    EffectRepository effectRepository;

    @Override
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId).orElse(null);
    }

    @Override
    public Effect getEffectById(Long effectId) {
        return effectRepository.findById(effectId).orElse(null);
    }

    @Override
    public List<PotionRecipe> createRecipes(IngredientQuantityRequest request) {

        List<PotionRecipe> potionRecipeList = new ArrayList<>();
        // check if list is empty
        if (request.getIngredients().get(0) == null) {
            return potionRecipeList;
        }

        List<Ingredient> ingredientList = new ArrayList<>();

        // placeholder recipe creation for testing
        for (IngredientQuantityDTO ingredientQuantity : request.getIngredients()) {
            Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredientQuantity.getIngredientId());
            optionalIngredient.ifPresent(ingredientList::add);
        }

        if (!ingredientList.isEmpty()) {
            PotionRecipe potionRecipe = new PotionRecipe(ingredientList);
            potionRecipeList.add(potionRecipe);
        }

        return potionRecipeList;
    }
}
