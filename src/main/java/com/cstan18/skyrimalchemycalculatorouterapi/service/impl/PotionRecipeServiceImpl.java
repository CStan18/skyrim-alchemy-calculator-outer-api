package com.cstan18.skyrimalchemycalculatorouterapi.service.impl;

import com.cstan18.skyrimalchemycalculatorouterapi.model.Effect;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import com.cstan18.skyrimalchemycalculatorouterapi.repository.EffectRepository;
import com.cstan18.skyrimalchemycalculatorouterapi.repository.IngredientRepository;
import com.cstan18.skyrimalchemycalculatorouterapi.service.PotionRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotionRecipeServiceImpl implements PotionRecipeService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    EffectRepository effectRepository;

    @Override
    public Ingredient getIngredientById() {
        return ingredientRepository.findById(1);
    }

    @Override
    public Effect getEffectById() { return effectRepository.findById(1); }
}
