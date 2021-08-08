package com.licious.CompositionApi.Repository;

import com.licious.CompositionApi.Model.Molecule;
import com.licious.CompositionApi.dto.MoleculeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoleculesRepository extends JpaRepository<Molecule, Integer> {

}
