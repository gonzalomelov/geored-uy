package org.gonzalomelov.georeduy.bll.interfaces;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.NotificationType;
import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.dal.model.User;

public interface PersonServices {
	//Common
	public Person registerPerson(Person person) throws Exception;
	public boolean validatePerson(Person person);
	public Person login(Person person) throws Exception;;
	public void logout(Person person) throws Exception;;
	
	//Contact
	public List<User> findAllRegisteredUsers(Long userId);
	public void addContact(Long userId, Long contactId);
	public void removeContact(Long userId, Long contactId);
	public List<User> findAllLoggedInUsers();
	
	//Chat
	public void initConversationWithContact(Long userId, Long contactId);
	public void sendMessageToContact(Long userId, Long contactId, String message);
	
	//Notification
	public void addNotificationTypeToUser(Long userId, NotificationType notificationType);
	public void removeNotificationTypeFromUser(Long userId, NotificationType notificationType);
	
	//ThematicCategory
	public void addThematicCategoryToUser(Long userId, Long thematicCategoryId);
	public void removeThematicCategoryFromUser(Long userId, Long thematicCategoryId);
}
