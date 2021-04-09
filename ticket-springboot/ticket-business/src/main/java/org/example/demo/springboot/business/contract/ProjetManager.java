package org.example.demo.springboot.business.contract;

import org.example.demo.springboot.model.bean.projet.Projet;
import org.example.demo.springboot.model.exception.NotFoundException;

import java.util.List;



public interface ProjetManager {

	/**
	 * Renvoie la liste des {@link Projet}
	 *
	 * @return List
	 */
	List<Projet> getListProjet();

	/**
	 * Renvoie le projet demandé
	 *
	 * @param pId l'identifiant du projet
	 * @return Le {@link Projet}
	 * @throws NotFoundException Si le projet n'est pas trouvé
	 */
	Projet getProjet(Integer pId) throws NotFoundException;

}
