package br.edu.univas;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlightAdapterImpl implements FlightAdapter {
	
	private FlightDAO flightDAO;
	private List<Flight> flights = new ArrayList<Flight>();
	
	public FlightAdapterImpl(FlightDAO flightDAO) {
		this.flightDAO = flightDAO;
	}
	

	@Override
	public List<Flight> getAll() {
			
		for(Flight flight : flightDAO.getAll()) {
			
			Flight tempFlight = new Flight();
			
			tempFlight.setFrom(flight.getFrom());
			tempFlight.setTo(flight.getTo());
			tempFlight.setCompany(flight.getCompany());
			tempFlight.setDeparture(convertToTimeLosAngeles(flight.getDeparture()));
			tempFlight.setArrival(convertToTimeLosAngeles(flight.getArrival()));	
			
			flights.add(tempFlight);
		}
		return flights;
	}
	
	
	private ZonedDateTime convertToTimeLosAngeles(ZonedDateTime time) {
        ZoneId utcZoneID = ZoneId.of("America/Los_Angeles");
        LocalDateTime ldt = time.toLocalDateTime();
        return ldt.atZone(utcZoneID);
	}

	
}
