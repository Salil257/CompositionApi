package com.licious.CompositionApi.Controller;

import com.licious.CompositionApi.Model.Composition;
import com.licious.CompositionApi.Model.CompositionIngredient;
import com.licious.CompositionApi.Model.Ingredient;
import com.licious.CompositionApi.Repository.*;
import com.licious.CompositionApi.Service.BatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RequestController {
    @Autowired
    private CompositionRepository com;
    @Autowired
    private IngredientsRepository ing;
    @Autowired
    private MoleculesRepository mole;
    @Autowired
    private CompositionIngredientsRepository comIng;
    @Autowired
    private MoleculeIngredientsRepository molIng;
    @Autowired
    private BatchingService batchingService;



    /*
    API-1
    a composition id/name provides its ingredients with their corresponding strengths and
    units also return the molecule and its corresponding rx_required.
     */
    @GetMapping("/getComIng/{name}")
    public List<CompositionIngredient> getComIngByName(@PathVariable(value = "name") String name) {
        return comIng.findCompositionIngredientByCompositionName(name);
    }
    @GetMapping("/getComIng/{id}")
    public List<CompositionIngredient> getComIngById(@PathVariable(value = "id") Integer id) {
        return comIng.findCompositionIngredientByCompositionId(id);
    }
/*

API2
a composition id/name provides its ingredients with
their corresponding strengths and units also return the molecule and its corresponding rx_required.*/
   /* @GetMapping("/getComIng/")
    public List<CompositionIngredient> findAllByCompositionIngredient(@RequestParam int ingredientId, @RequestParam float Strength, @RequestParam String Unit){
        List<Integer> list = comIng.findAllByIngredientStrengthUnit(ingredientId,Strength,Unit);
        List<CompositionIngredient> lis = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            if(comIng.findById(list.get(i)).isPresent()){
                CompositionIngredient coming;
                coming = comIng.findById(list.get(i)).get();
                lis.add(coming);
            }
        }
        return lis;
    } */
   /* @GetMapping("/getComIng/")
    public List<CompositionIngredient> findAllByCompositionIngredient(@RequestParam List<Integer> ingredientId ,@RequestParam float Strength,@RequestParam String Unit, @RequestParam boolean rxRequired){
        List<Ingredient> ingredientList = ing.findAllById(ingredientId);
        for(int i =0;i<ingredientList.size();i++){
            if(in[i].){
                CompositionIngredient coming;
                coming = comIng.findById(list.get(i)).get();
                lis.add(coming);
            }
        List<CompositionIngredient> list= findAllByCompositionIngredient(ingredientId,Strength,Unit);
        List<CompositionIngredient> lis = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            if(list[i].){
                CompositionIngredient coming;
                coming = comIng.findById(list.get(i)).get();
                lis.add(coming);
            }
        }
        return lis;
    }*/
}
