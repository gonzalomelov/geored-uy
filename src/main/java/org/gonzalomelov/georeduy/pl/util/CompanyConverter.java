package org.gonzalomelov.georeduy.pl.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyServices;
import org.gonzalomelov.georeduy.dal.model.Company;

@FacesConverter(forClass=Company.class)
public class CompanyConverter implements Converter {
	//Functions
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		try {
			Long id = Long.parseLong(value);
			
			InitialContext ic = new InitialContext();
			CompanyServices companyServices = (CompanyServices) ic.lookup("java:global/geored-uy/companyServices");
			Company c = companyServices.findCompanyById(id);
			
			return c;
		}
		catch (Exception e){
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Company c = (Company) obj;  
        return c.getId().toString();  
	}

}
