package com.licious.CompositionApi.Service;

import com.licious.CompositionApi.Model.Composition;
import com.licious.CompositionApi.Model.CompositionIngredient;
import com.licious.CompositionApi.Model.Molecule;
import com.licious.CompositionApi.Repository.CompositionIngredientsRepository;
import com.licious.CompositionApi.Repository.CompositionRepository;
import com.licious.CompositionApi.Repository.MoleculesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class BatchingService {

    @Autowired
    private CompositionRepository comRepo;
    @Autowired
    private MoleculesRepository molRepo;

    @Autowired
    private CompositionIngredientsRepository comIngRepo;
    @PersistenceContext
    private EntityManager entityManager;



    public void batchInsertCom(List<Composition> compositions) {
        int totalObjects = compositions.size();
        int batchSize = 5;
        for (int i = 0; i < totalObjects; i = i + batchSize) {
            if (i + batchSize > totalObjects) {
                List<Composition> compositions1 = compositions.subList(i, totalObjects - 1);
                comRepo.saveAll(compositions1);
                break;
            }
            List<Composition> compositions1 = compositions.subList(i, i + batchSize);
            comRepo.saveAll(compositions1);
        }
    }
        public void batchInsertMol(List<Molecule> molecules){
            int totalObjects = molecules.size();
            int batchSize = 5;
            for (int i = 0; i < totalObjects; i = i + batchSize) {
                if (i + batchSize > totalObjects) {
                    List<Molecule> molecules1 = molecules.subList(i, totalObjects - 1);
                    molRepo.saveAll(molecules1);
                    break;
                }
                List<Molecule> molecules1 = molecules.subList(i, i + batchSize);
                molRepo.saveAll(molecules1);
            }
        }

    public void batchInsertComIng(List<CompositionIngredient> compositionIngredients){
        int totalObjects = compositionIngredients.size();
        int batchSize = 5;
        for (int i = 0; i < totalObjects; i = i + batchSize) {
            if (i + batchSize > totalObjects) {
                List<CompositionIngredient> compositionIngredient1 = compositionIngredients.subList(i, totalObjects - 1);
                comIngRepo.saveAll(compositionIngredient1);
                break;
            }
            List<CompositionIngredient> compositionIngredient1 = compositionIngredients.subList(i, i + batchSize);
            comIngRepo.saveAll(compositionIngredient1);
        }
    }
    }
