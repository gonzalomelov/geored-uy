package org.gonzalomelov.georeduy.pl.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;

import org.gonzalomelov.georeduy.bll.interfaces.ImageServices;

@ManagedBean
@RequestScoped
public class ImageController {
	
	@EJB(name="imageServices")
	private ImageServices imageServices;	
	
	public ImageServices getImageServices() {
		return imageServices;
	}

	public void setImageServices(ImageServices imageServices) {
		this.imageServices = imageServices;
	}

	public void paint(OutputStream out, Object data) throws Exception {
		Long id = (Long) data;
		try {
			BufferedImage bi = ImageIO.read(new ByteArrayInputStream(imageServices.findImageById(id).getImage()));
			ImageIO.write(bi, "png" , out);
		}
		catch (Exception e){
			throw e;
		}
	 }
}
