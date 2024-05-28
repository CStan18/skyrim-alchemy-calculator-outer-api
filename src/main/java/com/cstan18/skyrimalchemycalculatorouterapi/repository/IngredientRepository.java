package com.cstan18.skyrimalchemycalculatorouterapi.repository;

import com.cstan18.skyrimalchemycalculatorouterapi.model.Effect;
import com.cstan18.skyrimalchemycalculatorouterapi.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // use Optional to avoid null pointer
    Ingredient findById(long id);

    Ingredient findByName(String name);

    // Custom query to find ingredients by an effect
    @Query("SELECT i from Ingredient i JOIN i.effects e WHERE e = :effect")
    List<Ingredient> findByEffect(@Param("effect") Effect effect);
}
