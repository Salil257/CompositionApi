package com.licious.CompositionApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "molecule")
@Getter
@Setter
public class Molecule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private boolean rxRequired;
}
