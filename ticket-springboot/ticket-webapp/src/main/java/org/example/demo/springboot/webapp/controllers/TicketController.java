package org.example.demo.springboot.webapp.controllers;


import org.example.demo.springboot.business.contract.TicketManager;
import org.example.demo.springboot.model.bean.ticket.Ticket;
import org.example.demo.springboot.model.exception.NotFoundException;
import org.example.demo.springboot.model.recherche.ticket.RechercheTicket;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Ressource REST pour les {@link Ticket}.
 *
 * @author lgu
 */
@RestController
@RequestMapping("/tickets")
public class TicketController extends AbstractResource {


    /**
     * Renvoie le {@link Ticket} de numéro {@code pNumero}
     *
     * @param pNumero numéro du {@link Ticket}
     * @return Le {@link Ticket}
     * @throws NotFoundException Si le {@link Ticket} n'a pas été trouvé
     */

    @GetMapping("{pNumero}")
    public Ticket get(@PathVariable Long pNumero) throws NotFoundException {
        TicketManager vTicketManager = getManagerFactory().getTicketManager();
        return vTicketManager.getTicket(pNumero);
    }

    /**
     * Recherche et renvoie les {@link Ticket} correspondant aux critères.
     *
     * @param pProjetId identifiant du {@link org.example.demo.springboot.model.bean.projet.Projet}
     * @return List
     */
    @GetMapping("search")
    public List<Ticket> search(@RequestParam Integer pProjetId, @RequestParam Integer pAuteurId) {
        TicketManager vTicketManager = getManagerFactory().getTicketManager();
        return vTicketManager.getListTicket(new RechercheTicket()
                                                              .setProjetId(pProjetId)
                                                              .setAuteurId(pAuteurId));
    }
}
