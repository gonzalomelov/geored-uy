package org.gonzalomelov.georeduy.bll.interfaces.user;

import org.gonzalomelov.georeduy.dal.model.NotificationType;
import org.gonzalomelov.georeduy.dal.model.User;

public interface ConfigurationServices {
	
	public void registerUser(User user);
	public void loginUser(String email, String password);
	public void addThematicCategoryToUser(Long userId, Long thematicCategoryId);
	public void removeThematicCategoryFromUser(Long userId, Long thematicCategoryId);
	public void addNotificationTypeToUser(Long userId, NotificationType notificationType);
	public void removeNotificationTypeFromUser(Long userId, NotificationType notificationType);
}
