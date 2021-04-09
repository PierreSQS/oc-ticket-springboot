package org.example.demo.springboot.consumer.contract.dao;

import org.example.demo.springboot.model.bean.projet.Projet;

import java.util.List;



public interface ProjetDao {

	List<Projet> getListProjets();

	Projet getProjet(Integer pId);

}
