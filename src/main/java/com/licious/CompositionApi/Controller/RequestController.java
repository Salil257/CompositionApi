package com.licious.CompositionApi.Controller;

import com.licious.CompositionApi.Model.*;
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
import java.util.Set;

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
    @GetMapping("/getComIng/")
    public List<CompositionIngredient> findAllByCompositionIngredient(@RequestParam int ingredientId, @RequestParam float Strength, @RequestParam String Unit){
        return comIng.findByIngredientAndStrengthAndUnit(ingredientId,Strength,Unit);
    }



    @GetMapping("/getComIng/")
    public List<CompositionIngredient> findAllByCompositionIngredient(@RequestParam int ingredientId ,@RequestParam float Strength,@RequestParam String Unit, @RequestParam boolean rxRequired) {
    /*List<CompositionIngredient> list = comIng.findByIngredientAndStrengthAndUnit(ingredientId,Strength,Unit);
    List<CompositionIngredient> finallist;
    for(int i=0;i<list.size();i++){

       CompositionIngredient compositionIngredient = list.get(i);
        Set<Ingredient> ingredientList =compositionIngredient.getIngredients();
        for(int j=0;j<ingredientList.size();j++){
            molIng.findMoleculeByIngredientId(ingredientList[i].getId());
        }

       List<Molecule> molecules = molIng.findMoleculeByIngredientId(ingredientId);
    }

        List<CompositionIngredient> compositionIngredientlist = comIng.findByIngredientAndStrengthAndUnit(ingredientId, Strength, Unit);
        // Initialise list to return :
        List<CompositionIngredient> compositionIngredients = new ArrayList<>();
        /*
         * We have a compositionIngredientlist containing CompositionIngredients found using:
         *       ingredientId
         *
         *       strength
         *       unit
         * To filter out ones with rx == rxRequired, iterate, find molecule and check for rx as follows
         * */
        /*for(CompositionIngredient c : compositionIngredientlist) {
            int ingrId = c.getIngredients().getId();
            // Get list of MoleculeIngredients
            List<MoleculeIngredient> moleculeIngredientList = moleculeIngredientService.getMoleculeIngredientByIngredientId(ingrId);
            // And corresponding moleculeIds
            List<Integer> moleculeIds = new ArrayList<>();
            for (MoleculeIngredient mi : moleculeIngredientList) {
                moleculeIds.add(mi.getMolecule().getId());
            }
            // For each molecule(from moleculeIds), find rxRequired
            List<Boolean> moleculeRxList = new ArrayList<>();
            for (Integer i : moleculeIds){
                moleculeRxList.add(moleculeService.getMoleculeById(i).getRxRequired());
            }
            //iterate through Boolean List moleculeRxList and if all values are == rxRequired, compositionIngredients.add(c);
            int flag = 0;
            for(Boolean rx : moleculeRxList) {
                if(rx == rxRequired)
                    flag = 1;
                else
                    flag = 0;
            }
            //if flag == 1 after end of above loop, means all rx values  == rxRequired
            //therefore add the compositionIngredient to list to return
            if (flag == 1)
                compositionIngredients.add(c);
        }*/
        return null;
    }


}
