package com.licious.CompositionApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "composition_ingredient")
@Getter
@Setter
public class CompositionIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String unit;
    private String strength;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "composition_id", referencedColumnName = "id")
    private Composition composition;
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="com_ing", joinColumns=@JoinColumn(name="composition_id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id"))
    private Set<Ingredient> ingredients;
}
