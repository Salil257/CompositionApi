package com.licious.CompositionApi.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "molecule_ingredient")
@Getter
@Setter
public class MoleculeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "molecule_id", referencedColumnName = "id")
    private Molecule molecule;
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="mol_ing", joinColumns=@JoinColumn(name="molecule_id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id"))
    private Set<Ingredient> ingredients;
}
