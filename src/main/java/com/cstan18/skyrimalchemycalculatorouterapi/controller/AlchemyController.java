package com.cstan18.skyrimalchemycalculatorouterapi.controller;

import com.cstan18.skyrimalchemycalculatorouterapi.dto.request.IngredientQuantityRequest;
import com.cstan18.skyrimalchemycalculatorouterapi.dto.response.IngredientQuantityResponse;
import com.cstan18.skyrimalchemycalculatorouterapi.service.PotionRecipeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@NoArgsConstructor
public class AlchemyController {

    @Autowired
    PotionRecipeService potionRecipeService;
  
    private static final Logger logger = LoggerFactory.getLogger(AlchemyController.class);

    @PostMapping(value = "/createRecipes")
    public ResponseEntity<IngredientQuantityResponse> createRecipes(@RequestBody IngredientQuantityRequest request) {
        IngredientQuantityResponse response = new IngredientQuantityResponse(potionRecipeService.createRecipes(request));
        return ResponseEntity.ok(response);
    }

}
