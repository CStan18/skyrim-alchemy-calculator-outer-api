package com.cstan18.skyrimalchemycalculatorouterapi.dto.request;

import com.cstan18.skyrimalchemycalculatorouterapi.dto.IngredientQuantityDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class IngredientQuantityRequest {
    private List<IngredientQuantityDTO> ingredients;

}
