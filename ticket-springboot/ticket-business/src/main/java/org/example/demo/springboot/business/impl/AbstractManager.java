package org.example.demo.springboot.business.impl;


import org.example.demo.springboot.consumer.contract.factory.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManager {

	@Autowired
	private DaoFactory daoFact;

	public void setDaoFact(DaoFactory daoFact) {
		this.daoFact = daoFact;
	}

	protected DaoFactory getDaoFact() {
		return daoFact;
	}

}
