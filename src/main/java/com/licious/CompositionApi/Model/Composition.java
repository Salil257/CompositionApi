package com.licious.CompositionApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "composition")
@Getter
@Setter
public class Composition {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String name;
}
