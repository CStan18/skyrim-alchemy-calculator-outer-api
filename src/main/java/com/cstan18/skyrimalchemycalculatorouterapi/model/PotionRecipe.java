package com.cstan18.skyrimalchemycalculatorouterapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class PotionRecipe {
    private Long ingredient1Id;
    private Long ingredient2Id;
    private List<String> commonEffects;
    private double value;

}
