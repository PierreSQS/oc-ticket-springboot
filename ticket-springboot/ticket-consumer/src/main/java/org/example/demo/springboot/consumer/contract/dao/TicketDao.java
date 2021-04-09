package org.example.demo.springboot.consumer.contract.dao;

import org.example.demo.springboot.model.bean.ticket.Ticket;
import org.example.demo.springboot.model.bean.ticket.TicketStatut;
import org.example.demo.springboot.model.recherche.ticket.RechercheTicket;

import java.util.List;



public interface TicketDao {

	List<Ticket> search(RechercheTicket pRechercheTicket);

	Ticket getTicket(Long pNumero);

	List<TicketStatut> getTicketStatut();

}
