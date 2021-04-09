package org.example.demo.springboot.business.impl;


import java.util.List;


import org.example.demo.springboot.business.contract.ProjetManager;
import org.example.demo.springboot.model.bean.projet.Projet;
import org.example.demo.springboot.model.exception.NotFoundException;
import org.springframework.stereotype.Component;


/**
 * Manager des beans du package Projet.
 *
 * @author lgu
 */

@Component
public class ProjetManagerImpl extends AbstractManager implements ProjetManager {

    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    @Override
	public Projet getProjet(Integer pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        
       return getDaoFact().getProjetDao().getProjet(pId);
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    @Override
	public List<Projet> getListProjet() {
        return getDaoFact().getProjetDao().getListProjets();
        
    }
}
