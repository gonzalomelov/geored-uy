package org.gonzalomelov.georeduy.bll.service.superadmin;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.superadmin.EventManagementServices;
import org.gonzalomelov.georeduy.dal.model.Event;

@Stateless(name="EventManagementServices")
public class EventManagement implements EventManagementServices {

	@Override
	public Event createEvent(Long siteOfInterestId, Event event)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEvent(Long siteOfInterestId, Long idEvent)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event updateEvent(Long siteOfInterestId, Event event)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event findEventById(Long siteOfInterestId, Long idEvent)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findAllEventsOfASiteOfInterest(Long siteOfInterestId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addThematicCategoryToEvent(Long siteOfInterestId, Long idEvent,
			Long thematicCategoryId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeThematicCategoryFromEvent(Long siteOfInterestId,
			Long idEvent, Long thematicCategoryId) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
