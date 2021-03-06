package org.example.demo.springboot.business.impl;


import java.util.List;


import org.example.demo.springboot.business.contract.TicketManager;
import org.example.demo.springboot.model.bean.ticket.Ticket;
import org.example.demo.springboot.model.bean.ticket.TicketStatut;
import org.example.demo.springboot.model.exception.NotFoundException;
import org.example.demo.springboot.model.recherche.ticket.RechercheTicket;
import org.springframework.stereotype.Component;


/**
 * Manager des beans du package Ticket.
 *
 * @author lgu
 */
@Component
public class TicketManagerImpl extends AbstractManager implements TicketManager {

    /**
     * Cherche et renvoie le {@link Ticket} numéro {@code pNumero}
     *
     * @param pNumero le numéro du Ticket
     * @return Le {@link Ticket}
     * @throws NotFoundException Si le Ticket n'est pas trouvé
     */
    @Override
	public Ticket getTicket(Long pNumero) throws NotFoundException {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pNumero < 1L) {
            throw new NotFoundException("Ticket non trouvé : numero=" + pNumero);
        }
        
        return getDaoFact().getTicketDao().getTicket(pNumero);
    }


    /**
     * Renvoie la liste des {@link Ticket} correspondants aux critères de recherche.
     *
     * @param pRechercheTicket -
     * @return List
     */
    @Override
	public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {
        return getDaoFact().getTicketDao().search(pRechercheTicket);
    }


    /**
     * Renvoie le nombre de {@link Ticket} correspondants aux critères de recherche.
     *
     * @param pRechercheTicket -
     * @return int
     */
    @Override
	public int getCountTicket(RechercheTicket pRechercheTicket) {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        return 42;
    }


	/**
	 * Renvoie la liste de {@link TicketStatut} 
	 *
	 * @return List<TicketStatut>
	 */
	@Override
	public List<TicketStatut> getListTicketStatut() {
	    return getDaoFact().getTicketDao().getTicketStatut();
	}
}
