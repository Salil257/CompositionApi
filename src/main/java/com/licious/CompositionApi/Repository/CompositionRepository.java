package com.licious.CompositionApi.Repository;

import com.licious.CompositionApi.Model.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends JpaRepository<Composition , Long > {
    @Query(value="select * from composition where name=?1",
            nativeQuery = true)
    Composition findByName(String name);
}
