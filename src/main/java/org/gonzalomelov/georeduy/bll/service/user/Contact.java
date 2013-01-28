package org.gonzalomelov.georeduy.bll.service.user;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.user.ContactServices;
import org.gonzalomelov.georeduy.dal.model.User;

@Stateless(name="ContactServices")
public class Contact implements ContactServices {

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

}
