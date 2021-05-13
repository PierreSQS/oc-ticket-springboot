package org.example.demo.springboot.webapp.controllers;


import org.example.demo.springboot.business.factory.contract.ManagerFactory;

public class AbstractResource {
	
	private static ManagerFactory managerFactory;

	protected ManagerFactory getManagerFactory() {
		return managerFactory;
	}

	public static void setManagerFactory(ManagerFactory mgrFactory) {
		managerFactory = mgrFactory;
	}

}
