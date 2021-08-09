package com.licious.CompositionApi.Repository;

import com.licious.CompositionApi.Model.CompositionIngredient;
import com.licious.CompositionApi.Model.Molecule;
import com.licious.CompositionApi.Model.MoleculeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoleculeIngredientsRepository extends JpaRepository<MoleculeIngredient,Integer> {
    @Query(value="select * from composition_ingredient ci inner join composition c on ci.composition_id = c.id where c.name=?1", nativeQuery = true)
    List<Molecule> findMoleculeByIngredientId(int id);
}
