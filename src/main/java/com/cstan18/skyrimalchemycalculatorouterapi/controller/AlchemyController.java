package com.cstan18.skyrimalchemycalculatorouterapi.controller;

import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import com.cstan18.skyrimalchemycalculatorouterapi.service.PotionRecipeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/test")
    public String swaggerUiTestEndpoint() {
        return "Success";
    }

    @PostMapping(value = "/getIngredientById")
    public ResponseEntity<Ingredient> getIngredientById() {
        return ResponseEntity.ok(potionRecipeService.getIngredientById());
    }

}
