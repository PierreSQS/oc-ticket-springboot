package org.example.demo.springboot.consumer.rowmapper;

import java.sql.ResultSet;


import org.example.demo.springboot.model.bean.projet.Projet;
import org.example.demo.springboot.model.bean.ticket.Evolution;
import org.example.demo.springboot.model.bean.ticket.Ticket;
import org.springframework.jdbc.core.RowMapper;

public class TicketRM {

	// This class shouldn't be instantiated
	private TicketRM() {
	}

	public static final RowMapper<Ticket> ROWMAPPERTICKET = (ResultSet rs, int rowNum) -> {
    	Projet proj = new Projet();
	    Ticket vTicket = new Evolution(rs.getLong("numero"));
    	vTicket.setTitre(rs.getString("titre"));
    	vTicket.setDate(rs.getDate("date"));
    	vTicket.setDescription(rs.getString("description"));
    	proj.setId(rs.getInt("proj_id"));
    	proj.setNom(rs.getString("proj_nom"));
    	vTicket.setProjet(proj);
    	return vTicket;
    };        
    
}
