package org.gonzalomelov.georeduy.pl.model.admincompany;


public class LocationManagementModelAdminCompany {
	private Long companyId;
	
	private String name;
	
	private Double coordX;
	
	private Double coordY;
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCoordX() {
		return coordX;
	}

	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}

	public Double getCoordY() {
		return coordY;
	}

	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}
	
}
