package com.licious.CompositionApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoleculeDto {
    private int id;
    private List<Integer> ingredients;
    private Boolean rxRequired;
}
