package org.example.demo.springboot.consumer.rowmapper;

import java.sql.ResultSet;

import org.example.demo.springboot.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.RowMapper;

public class TicketStatusRM {
	// This class shouldn't be instantiated
	private TicketStatusRM() {
	}

	public static final RowMapper<TicketStatut> ROWMAPPERSTATUT = (ResultSet rs, int rowNum) -> {
    	TicketStatut vStatut = new TicketStatut(rs.getInt("id"));
    	vStatut.setLibelle(rs.getString("libelle"));
    	return vStatut;
    };
    
    
}
