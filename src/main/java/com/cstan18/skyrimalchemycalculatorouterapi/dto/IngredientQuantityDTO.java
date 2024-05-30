package com.cstan18.skyrimalchemycalculatorouterapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientQuantityDTO {

    private Long ingredientId;
    private int quantity;
}
