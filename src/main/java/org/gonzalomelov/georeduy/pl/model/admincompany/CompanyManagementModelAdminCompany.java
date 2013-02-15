package org.gonzalomelov.georeduy.pl.model.admincompany;

import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Image;

public class CompanyManagementModelAdminCompany {
	private Company company;
	
	private Image image = new Image();
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
