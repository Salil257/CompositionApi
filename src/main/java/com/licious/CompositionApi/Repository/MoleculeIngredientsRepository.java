package com.licious.CompositionApi.Repository;

import com.licious.CompositionApi.Model.MoleculeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoleculeIngredientsRepository extends JpaRepository<MoleculeIngredient,Integer> {


}
