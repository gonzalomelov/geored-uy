package org.gonzalomelov.georeduy.bll.service.user;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.user.ConfigurationServices;
import org.gonzalomelov.georeduy.dal.model.NotificationType;
import org.gonzalomelov.georeduy.dal.model.User;

@Stateless(name="ConfigurationServices")
public class Configuration implements ConfigurationServices {

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginUser(String email, String password) {
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

}
