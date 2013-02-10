package org.gonzalomelov.georeduy.bll.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.bll.interfaces.ImageServices;
import org.gonzalomelov.georeduy.dal.dao.interfaces.ImageDAO;
import org.gonzalomelov.georeduy.dal.model.Image;

@Stateless(name="imageServices")
public class ImageManagement implements ImageServices {

	@Inject
	private ImageDAO imageDAO;
	
	@Override
	public Image findImageById(Long id) throws Exception {
		return imageDAO.findByPrimaryKey(id);
	}
	

}
