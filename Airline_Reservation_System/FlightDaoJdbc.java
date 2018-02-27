package com.npu.myproject.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.npu.myproject.dao.FlightDao;
import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.Flight;
import com.npu.myproject.domain.Location;
import com.npu.myproject.forms.Form;

@Repository("flightDaoJdbc")
public class FlightDaoJdbc implements FlightDao {
	@Autowired
	@Qualifier("dataSource")
	private javax.sql.DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private FlightRowMapper flightRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		flightRowMapper = new FlightRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		               .withTableName("flights")
		               .usingGeneratedKeyColumns("id")
		               .usingColumns("AIRLINE", "START_AIRPORT", "START_TIME","END_AIRPORT",
		            		   "END_TIME","STOPS","RETURN_START_AIRPORT","RETURN_START_TIME",
		            		   "RETURN_END_AIRPORT","RETURN_END_TIME","RETURN_STOPS","PRICE");
		
	}
	

	@Override
	public List<Flight> selectFlights(String start_airport,String end_airport) {
		String sql = "SELECT * FROM flights where start_airport=? and end_airport=?";
		List<Flight> flightList = jdbcTemplate.query(sql, flightRowMapper,start_airport,end_airport);
		return flightList;
		
	}

	@Override
	public Flight selectFlightById(Integer id) {
		String sql = "SELECT * FROM flights WHERE id =?";
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		Flight flight =  jdbcTemplate.queryForObject(sql,  flightRowMapper,id);
		return flight;
	}
	@Override
	public void insertFlight(Flight flight){
		SqlParameterSource params = new BeanPropertySqlParameterSource(flight);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    flight.setId(newId.intValue());
	    
	}

}
