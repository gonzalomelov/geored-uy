package org.gonzalomelov.georeduy.bll.interfaces;

import org.gonzalomelov.georeduy.dal.model.Image;

public interface ImageServices {
	public Image findImageById(Long id) throws Exception;
}
