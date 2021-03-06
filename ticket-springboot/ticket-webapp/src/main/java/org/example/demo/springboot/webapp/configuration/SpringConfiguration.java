package org.example.demo.springboot.webapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "org.example.demo.springboot")
@ImportResource(locations = "classpath:/org/example/demo/springboot/webapp/webappContext.xml")
public class SpringConfiguration {
	
	 @Bean(name="dataSourceTicket")
     public DataSource getDataSource(){
	 	DriverManagerDataSource ds = new DriverManagerDataSource();
		 ds.setUrl("jdbc:postgresql://localhost:5432/db_ticket");
		 ds.setUsername("ticket");
		 ds.setPassword("ticket");
		 return ds;
         
	 }

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("dataSourceTicket") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getNamedParamJdbcTemplate( @Qualifier("dataSourceTicket") DataSource dataSource ) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
