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
public interface EffectRepository extends JpaRepository<Effect, Long> {

    Effect findById(long id);
    Effect findByName(String name);

    @Query("SELECT i from Ingredient i JOIN i.effects e WHERE e = :effect")
    List<Ingredient> findAssociatedIngredients(@Param("effect")Effect effect);

}
