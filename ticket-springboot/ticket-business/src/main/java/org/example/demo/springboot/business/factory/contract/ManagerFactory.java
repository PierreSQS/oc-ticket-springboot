package org.example.demo.springboot.business.factory.contract;


import org.example.demo.springboot.business.contract.ProjetManager;
import org.example.demo.springboot.business.contract.TicketManager;

public interface ManagerFactory {

	void setTicketManager(TicketManager ticketManager);

	TicketManager getTicketManager();

	void setProjetManager(ProjetManager projetManager);

	ProjetManager getProjetManager();

}
