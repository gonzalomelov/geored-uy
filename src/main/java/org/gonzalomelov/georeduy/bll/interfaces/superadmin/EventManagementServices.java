package org.gonzalomelov.georeduy.bll.interfaces.superadmin;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Event;

public interface EventManagementServices {
	
	public Event createEvent(Long siteOfInterestId, Event event) throws Exception;
	public void deleteEvent(Long siteOfInterestId, Long idEvent) throws Exception;
	public Event updateEvent(Long siteOfInterestId, Event event) throws Exception;
	public Event findEventById(Long siteOfInterestId, Long idEvent) throws Exception;
	public List<Event> findAllEventsOfASiteOfInterest(Long siteOfInterestId) throws Exception;
	public void addThematicCategoryToEvent(Long siteOfInterestId, Long idEvent, Long thematicCategoryId) throws Exception;
	public void removeThematicCategoryFromEvent(Long siteOfInterestId, Long idEvent, Long thematicCategoryId) throws Exception;
	
}
