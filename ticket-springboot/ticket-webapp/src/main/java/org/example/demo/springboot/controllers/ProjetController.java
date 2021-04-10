package org.example.demo.springboot.controllers;

import org.example.demo.springboot.business.contract.ProjetManager;
import org.example.demo.springboot.model.bean.projet.Projet;
import org.example.demo.springboot.model.exception.NotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


/**
 * Ressource REST pour les {@link Projet}.
 *
 * @author lgu
 */
@RestController("/projects")
public class ProjetController extends AbstractController {

    /**
     * Renvoie le {@link Projet} d'identifiant {@code pId}
     *
     * @param pId identifiant du {@link Projet}
     * @return Le {@link Projet}
     * @throws NotFoundException Si le {@link Projet} n'a pas été trouvé
     * 
     * Attention! l'appel qui déclenche la méthode ci-dessous est
     * http://localhost:8080/ticket-webapp/projets/4 et non 
     * http://localhost:8080/ticket-webapp/projets/?id=4. 
     * Cet appel déclenche la méthode ci-dessus!!!! 
     */

    @GetMapping("{id}")
    public Projet get(@PathVariable Integer pId) throws NotFoundException {
        ProjetManager vProjetManager = getManagerFactory().getProjetManager();
        return vProjetManager.getProjet(pId);
    }


    /**
     * Renvoie tous les {@link Projet}
     *
     * @return List
     */
    @GetMapping
    public List<Projet> get() {
        ProjetManager vProjetManager = getManagerFactory().getProjetManager();
        return vProjetManager.getListProjet();
    }
}
