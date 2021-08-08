package com.licious.CompositionApi.dto;

import com.licious.CompositionApi.Model.Composition;
import com.licious.CompositionApi.Model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositionDto {
    private int id;
    private String unit;
    private String strength;
    private Set<Ingredient> ingredients;
    private String name;

}
