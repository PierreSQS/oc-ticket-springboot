package org.example.demo.springboot.business.contract;

import org.example.demo.springboot.model.bean.ticket.Ticket;
import org.example.demo.springboot.model.bean.ticket.TicketStatut;
import org.example.demo.springboot.model.exception.NotFoundException;
import org.example.demo.springboot.model.recherche.ticket.RechercheTicket;

import java.util.List;



public interface TicketManager {

	/**
	 * Renvoie le nombre de {@link Ticket} correspondants aux critères de recherche.
	 *
	 * @param pRechercheTicket -
	 * @return int
	 */
	int getCountTicket(RechercheTicket pRechercheTicket);

	/**
	 * Renvoie la liste des {@link Ticket} correspondants aux critères de recherche.
	 *
	 * @param pRechercheTicket -
	 * @return List
	 */
	List<Ticket> getListTicket(RechercheTicket pRechercheTicket);

	/**
	 * Cherche et renvoie le {@link Ticket} numéro {@code pNumero}
	 *
	 * @param pNumero le numéro du Ticket
	 * @return Le {@link Ticket}
	 * @throws NotFoundException Si le Ticket n'est pas trouvé
	 */
	Ticket getTicket(Long pNumero) throws NotFoundException;

	/**
	 * Renvoie la liste de {@link TicketStatut} 
	 *
	 * @return List<TicketStatut>
	 */
	List<TicketStatut> getListTicketStatut();

}
