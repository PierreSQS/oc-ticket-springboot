package org.example.demo.springboot.consumer.impl.dao;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.springboot.consumer.contract.dao.TicketDao;
import org.example.demo.springboot.consumer.rowmapper.TicketRM;
import org.example.demo.springboot.consumer.rowmapper.TicketStatusRM;
import org.example.demo.springboot.model.bean.ticket.Ticket;
import org.example.demo.springboot.model.bean.ticket.TicketStatut;
import org.example.demo.springboot.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component("ticketDao")
public class TicketDaoImpl  extends AbstractDao implements TicketDao {
	private static final String SQL_ALL_TICKETS = "SELECT t.numero, t.titre, t.description, t.date, p.id as \"proj_id\", p.nom as \"proj_nom\"\r\n" +
			                                       "FROM public.ticket t, public.projet p\r\n" +
			                                       "WHERE t.projet_id = p.id ";
	
	private static final String SQL_ALL_STATUTS = "SELECT * FROM public.statut";

	
	/** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(TicketDaoImpl.class);
	
	@Override
	public List<Ticket> search(RechercheTicket pRechercheTicket) {
        
		StringBuilder vSQLBuilder = new StringBuilder(SQL_ALL_TICKETS);
		MapSqlParameterSource vParams = new MapSqlParameterSource();       
		LOGGER.info("################################ the Select- Command: "+ SQL_ALL_TICKETS);
        if (pRechercheTicket != null) {
            if (pRechercheTicket.getAuteurId() != null) {
            	vSQLBuilder.append(" AND t.auteur_id = :auteur_id");
                vParams.addValue("auteur_id", pRechercheTicket.getAuteurId());
            }
            if (pRechercheTicket.getProjetId() != null) {
            	vSQLBuilder.append(" AND t.projet_id = :projet_id");
                vParams.addValue("projet_id", pRechercheTicket.getProjetId());
            }
        }        

        List<Ticket> ticketList = getNamedParamJdbcTemplate()
        		.query(vSQLBuilder.toString(), vParams, TicketRM.ROWMAPPERTICKET);
        
        if (ticketList.isEmpty()) {
			LOGGER.info("Tickets inexistants");
		}
        return ticketList;
        
    }

	@Override
	public Ticket getTicket(Long pNumero) {
		
		StringBuilder vSQLBuilder = new StringBuilder(SQL_ALL_TICKETS);
		MapSqlParameterSource vParams = new MapSqlParameterSource();       
		
		vSQLBuilder.append(" AND numero = :numero");
        vParams.addValue("numero", pNumero);         
            
// Pose Problème si pas de resultats!!
// pringframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
//        Ticket vTicket = vJdbcTemplate.queryForObject(vSQLBuilder.toString(), vParams, Ticket.class);
        List<Ticket> vTickets = getNamedParamJdbcTemplate()
        		.query(vSQLBuilder.toString(), vParams, TicketRM.ROWMAPPERTICKET);
        Optional<Ticket> optTicket = vTickets.stream().findFirst();
		return optTicket.orElse(null);
	}

	@Override
	public List<TicketStatut> getTicketStatut() {
        return getJdbcTemplate().query(SQL_ALL_STATUTS, TicketStatusRM.ROWMAPPERSTATUT);
	}

}
