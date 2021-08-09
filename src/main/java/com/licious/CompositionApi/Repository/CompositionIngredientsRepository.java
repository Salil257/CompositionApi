package com.licious.CompositionApi.Repository;


import com.licious.CompositionApi.Model.Composition;
import com.licious.CompositionApi.Model.CompositionIngredient;
import com.licious.CompositionApi.Model.Ingredient;
import com.licious.CompositionApi.dto.CompositionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CompositionIngredientsRepository extends JpaRepository<CompositionIngredient, Integer> {

    @Query(value="SELECT * FROM composition_ingredient where id=?1")
    List<CompositionIngredient> findCompositionIngredientByCompositionId(Integer id);

    @Query(value="select * from composition_ingredient ci inner join composition c on ci.composition_id = c.id where c.name=?1", nativeQuery = true)
    List<CompositionIngredient> findCompositionIngredientByCompositionName(String name);


    @Query(value="SELECT * FROM composition_ingredient ci inner join  com_ing cij on cij.composition_id = ci.composition_id WHERE ingredient_id=?1 AND strength=?2 AND unit=?3", nativeQuery = true)
    List<CompositionIngredient> findByIngredientAndStrengthAndUnit(int ingredientId, float strength, String unit);
/*
    @Query("SELECT new com.licious.CompositionApi.dto.CompositionDto(i.id, ci.unit, ci.strength, ci,ingredients, i.name ) FROM CompositionIngredient ci JOIN ci.ingredients i")
    public List<CompositionDto> findAllByIngredientStrengthUnit(int ingredientId, float Strength, String Unit);
    @Query(value="select composition.id from composition \n" +
            "   inner join composition_ingredient on composition.id=composition_ingredient.composition_id\n" +
            "   inner join com_ing on composition_ingredient.composition_id=com_ing.composition_id\n" +
            "   inner join molecule on molecule_ingredient.molecule_id=mol_ing.molecule_id\n" +
            "   where (molecule_ingredient.ingredient_id=?1 and strength=?2 and unit=?3 and molecule.rx_required=?4);",
            nativeQuery = true)
    */
}

