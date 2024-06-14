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

import java.util.*;
import java.util.stream.Collectors;

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

        // early return if request is empty
        List<PotionRecipe> response = new ArrayList<>();
        // check if list is empty
        if (request.getIngredients().get(0) == null) {
            return response;
        }

        // Convert the user’s input list of ingredients + quantity to a hashmap for quick lookup
        Map<Long, Integer> ingredientMap = request.getIngredients().stream().collect
                (Collectors.toMap(IngredientQuantityDTO::getIngredientId, IngredientQuantityDTO::getQuantity));

        // Precompute compatible ingredients for each ingredient
        Map<Long, Set<Long>> compatibilityMap = precomputeComputeCompatibleIngredients();
        
        // Iterate through each ingredient in the ingredient map
        for (Map.Entry<Long, Integer> entry : ingredientMap.entrySet()) {
            Long ingredientId = entry.getKey();

            // Get the list of compatible ingredients for the current ingredient
            Set<Long> compatibleIngredients = compatibilityMap.getOrDefault(ingredientId, new HashSet<>());

            // Iterate through each compatible ingredient
            for (Long compatibleIngredientId : compatibleIngredients) {
                // Check if the compatible ingredient is in the user's ingredient map and has quantity > 0
                if (ingredientMap.containsKey(compatibleIngredientId) && ingredientMap.get(compatibleIngredientId) > 0) {
                    // Create potion recipe with the current ingredient and compatible ingredient
                    PotionRecipe potionRecipe = makePotion(ingredientId, compatibleIngredientId);

                    // Decrement the quantities of both ingredients used in the potion
                    ingredientMap.put(ingredientId, ingredientMap.get(ingredientId) - 1);
                    ingredientMap.put(compatibleIngredientId, ingredientMap.get(compatibleIngredientId) - 1);

                    // Add the potion recipe to the response list
                    response.add(potionRecipe);

                    // If quantity of the current ingredient or compatible ingredient becomes 0, break out of the loop
                    if (ingredientMap.get(ingredientId) == 0 || ingredientMap.get(compatibleIngredientId) == 0) {
                        break;
                    }
                }
            }
        }

        return response;
    }

    @Override
    public Map<Long, Set<Long>> precomputeComputeCompatibleIngredients() {

        // fetch all ingredients
        List<Ingredient> allIngredients = ingredientRepository.findAll();

        // init compatibility map
        Map<Long, Set<Long>> compatibilityMap = new HashMap<>();

        // populate compatibility map
        for (Ingredient ingredient : allIngredients) {
            Set<Long> compatibleIngredientIds = new HashSet<>();

            for (Effect effect : ingredient.getEffects()) {
                List<Ingredient> associatedIngredients = effectRepository.findAssociatedIngredients(effect);

                for (Ingredient associatedIngredient : associatedIngredients) {
                    if (!associatedIngredient.getId().equals(ingredient.getId())) {
                        compatibleIngredientIds.add(associatedIngredient.getId());
                    }
                }
            }
            compatibilityMap.put(ingredient.getId(), compatibleIngredientIds);
        }
        return compatibilityMap;
    }

    public PotionRecipe makePotion(Long ingredient1Id, Long ingredient2Id) {
        // Fetch the ingredient details from the repository
        Ingredient ingredient1 = ingredientRepository.findById(ingredient1Id).orElseThrow(() -> new RuntimeException("Ingredient not found: " + ingredient1Id));
        Ingredient ingredient2 = ingredientRepository.findById(ingredient2Id).orElseThrow(() -> new RuntimeException("Ingredient not found: " + ingredient2Id));

        // Determine the common effects between the two ingredients
        List<String> commonEffects = ingredient1.getEffects().stream()
                .filter(ingredient2.getEffects()::contains)
                .map(Effect::getName)
                .collect(Collectors.toList());

        // Calculate the value of the potion
        double value = ingredient1.getValue() + ingredient2.getValue();

        // Create and return a new PotionRecipe
        return new PotionRecipe(ingredient1Id, ingredient2Id, commonEffects, value);
    }

}
