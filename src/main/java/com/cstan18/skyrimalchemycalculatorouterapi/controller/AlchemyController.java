package com.cstan18.skyrimalchemycalculatorouterapi.controller;

import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import com.cstan18.skyrimalchemycalculatorouterapi.service.PotionRecipeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@NoArgsConstructor
public class AlchemyController {

    @Autowired
    PotionRecipeService potionRecipeService;
  
    private static final Logger logger = LoggerFactory.getLogger(AlchemyController.class);

    @GetMapping(value = "/test")
    public String swaggerUiTestEndpoint() {
        logger.info("/test endpoint called");
        return "Success";
    }

    @PostMapping(value = "/getIngredientById")
    public ResponseEntity<Ingredient> getIngredientById() {
        return ResponseEntity.ok(potionRecipeService.getIngredientById());
    }

}
