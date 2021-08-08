package com.licious.CompositionApi.Controller;

import com.licious.CompositionApi.Model.*;
import com.licious.CompositionApi.Repository.*;
import com.licious.CompositionApi.Service.BatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HomeController {
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

    @GetMapping("/getMolIng")
    public List<MoleculeIngredient> getMolIng() {
        return molIng.findAll();

    }
    @GetMapping("/getComIng")
    public List<CompositionIngredient> getComIng() {
        return comIng.findAll();
    }

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

    @GetMapping("/getIng")
    public List<Ingredient> getIng() {
        return ing.findAll();
    }
    @GetMapping("/getCom")
    public List<Composition> getCom() {
        return com.findAll();
    }
    @GetMapping("/getMol")
    public List<Molecule> getmol() {
        return mole.findAll();
    }

    @PostMapping("/saveIngredient")
    public String saveIng(@RequestBody Ingredient i ) {
        ing.save(i);
        return "saved";
    }

    @PostMapping("/saveComposition")
    public String saveCom(@RequestBody Composition c ) {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(c);
        batchingService.batchInsertCom(compositions);
        return "saved";
    }
    @PostMapping("/saveMolecule")
    public String saveMol(@RequestBody Molecule m ) {
        List<Molecule> molecules = new ArrayList<>();
        molecules.add(m);
        batchingService.batchInsertMol(molecules);
        return "saved";
    }

    @PostMapping("/saveMolIng")
    public String saveMolIng() {
       MoleculeIngredient mi = new MoleculeIngredient();
        Molecule m1 = new Molecule();
        m1.setName("aspirin+paracetamol");
        mi.setMolecule(m1);

        Ingredient i1= new Ingredient();
        i1.setName("aspirin");
        Ingredient i2= new Ingredient();
        i2.setName("paracetamol");
        Set<Ingredient> list =new HashSet<Ingredient>();
        list.add(i1);
        list.add(i2);
        mi.setIngredients(list);
        molIng.save(mi);
        return "saved";
    }
    @PostMapping("/saveComIng")
    public String saveComIng() {
        CompositionIngredient ci = new CompositionIngredient();
        Composition c = new Composition();
        c.setName("paracetamol (200 MG) + aspirin (5 MGG)");
        ci.setComposition(c);
        ci.setStrength("200, 5");
        ci.setUnit("MG");
        Ingredient i1= new Ingredient();
        i1.setName("paracetamol");
        Ingredient i2= new Ingredient();
        i2.setName("aspirin");
        Set<Ingredient> lis =new HashSet<Ingredient>();
        lis.add(i1);
        lis.add(i2);
        ci.setIngredients(lis);
        comIng.save(ci);
        return "saved";
    }
}
