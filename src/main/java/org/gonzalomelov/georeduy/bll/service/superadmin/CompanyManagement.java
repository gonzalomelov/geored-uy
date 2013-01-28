package org.gonzalomelov.georeduy.bll.service.superadmin;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.gonzalomelov.georeduy.bll.interfaces.superadmin.CompanyManagementServices;
import org.gonzalomelov.georeduy.bll.service.user.Utils;
import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyManagementSuperAdminModel;


@Stateless(name="companyManagementSuperAdminServices")
public class CompanyManagement implements CompanyManagementServices {
	@Inject
	private CompanyDAO companyDAO;
	
	@Inject
	private PersonDAO personDAO;
	
	private void sendEmail(String email, String password){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("gonzalomelov","$_U-8_0-6_0-T_$");
					}
				});
		
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gonzalomelov@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("gonzalomelov@gmail.com"));
			message.setSubject("Register your Company");
			message.setText("Dear " + email + "," +
					"\n\n Login into http://localhost:8080/geored-uy with the password " + password + "and set your company information"+
					"\n\n\n\n"+
					"Cheers,\n geored-uy team");
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Company createCompany(CompanyManagementSuperAdminModel companyManagementSuperAdminModel) throws Exception {
		
		String companyName = companyManagementSuperAdminModel.getCompany().getName();
		//company.name already registered
		if(companyDAO.findByName(companyName) != null) {
			throw new Exception("Company name already registered");
		}
		
		String adminCompanyEmail = companyManagementSuperAdminModel.getAdminCompanyEmail();
		//adminCompanyEmail already registered
		if(personDAO.findByEmail(adminCompanyEmail) != null) {
			throw new Exception("Email already registered");
		}
		
		try {
			String adminCompanyPassword = Utils.generatePassword();
			AdminCompany adminCompany = new AdminCompany(adminCompanyEmail, adminCompanyPassword,"","");
			
			adminCompany = (AdminCompany) personDAO.insert(adminCompany);
			
			Company company = companyManagementSuperAdminModel.getCompany();
			
			company.setAdminCompany(adminCompany);
			adminCompany.getCompanies().put(company.getName(), company);
			
			company = companyDAO.insert(company);
			
//			Thread sendMailThread = new Thread(new Runnable(){
//				public void run(){
//					CompanyManagement.sendEmail();
//				}
//			}, "sendMailThread");
//		
//			sendMailThread.start();
		
			this.sendEmail(adminCompanyEmail, adminCompanyPassword);
			
			return company;
		}
		catch (Exception e){
			throw e;
		}
	}
	
	@Override
	public void deleteCompany(Long companyId){
		try {
			companyDAO.delete(companyId);
		}
		catch (Exception e){
			
		}
		finally {
			
		}
		
	}
	
	@Override
	public List<Company> findAllCompanies() throws Exception {
		
		try {
			return companyDAO.findAll();
		}
		catch (Exception e){
			throw e;
		}
		finally {
			
		}
	}
	
	@Override
	public Company findCompanyByName(String name){
		
		try {
			return companyDAO.findByName(name);
		}
		catch (Exception e){
			return null;
		}
		finally {
			
		}
	}
	
}