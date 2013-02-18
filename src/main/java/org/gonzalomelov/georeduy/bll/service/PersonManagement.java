package org.gonzalomelov.georeduy.bll.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.bll.interfaces.PersonServices;
import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.NotificationType;
import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.dal.model.User;

@Stateless(name="personServices")
public class PersonManagement implements PersonServices {
	@Inject
	private PersonDAO personDAO;
	
	@Inject
	private CompanyDAO companyDAO;
	
	@Override
	public Person registerPerson(Person person) throws Exception {
		try {
        	return personDAO.insert(person);
        }
        catch(Exception e){
        	return null;
        }
        finally {
        	
        }
	}

	@Override
	public boolean validatePerson(Person person) {
		return personDAO.findByEmailAndPassword(person.getEmail(), person.getPassword()) != null;
	}
	
	@Override
	public Person login(Person person) throws Exception {
		
		Person p = personDAO.findByEmailAndPassword(person.getEmail(), person.getPassword());
		
		if(p == null){
			throw new Exception("Not Registered User");
		}
		
		if(p.getIsLogged()){
			throw new Exception("Already Logged User");
		}
		
		p.setIsLogged(true);
		personDAO.update(p);
		
		return p;
	}

	@Override
	public void logout(Person person) throws Exception {
		Person p = personDAO.findByPrimaryKey(person.getId());
		
		if(p == null){
			throw new Exception("Not Registered User");
		}
		
		if(!p.getIsLogged()){
			throw new Exception("User Not Logged In");
		}
		
		p.setIsLogged(false);
		personDAO.update(p);
	}

	@Override
	public List<User> findAllRegisteredUsers(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addContact(Long userId, Long contactId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContact(Long userId, Long contactId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllLoggedInUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initConversationWithContact(Long userId, Long contactId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessageToContact(Long userId, Long contactId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNotificationTypeToUser(Long userId,
			NotificationType notificationType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNotificationTypeFromUser(Long userId,
			NotificationType notificationType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addThematicCategoryToUser(Long userId, Long thematicCategoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeThematicCategoryFromUser(Long userId,
			Long thematicCategoryId) {
		// TODO Auto-generated method stub
		
	}

}
