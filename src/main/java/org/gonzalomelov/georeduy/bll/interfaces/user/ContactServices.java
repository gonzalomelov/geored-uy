package org.gonzalomelov.georeduy.bll.interfaces.user;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.User;

public interface ContactServices {
	
	public List<User> findAllRegisteredUsers(Long userId);
	public void addContact(Long userId, Long contactId);
	public void removeContact(Long userId, Long contactId);
	public List<User> findAllLoggedInUsers();
	public void initConversationWithContact(Long userId, Long contactId);
	public void sendMessageToContact(Long userId, Long contactId, String message);
	
}
