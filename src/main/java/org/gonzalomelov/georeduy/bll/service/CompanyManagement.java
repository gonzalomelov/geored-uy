package org.gonzalomelov.georeduy.bll.service;

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

import org.gonzalomelov.georeduy.bll.interfaces.CompanyServices;
import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.Company;

@Stateless(name="companyServices")
public class CompanyManagement implements CompanyServices {
	
	@Inject
	private CompanyDAO companyDAO;
	
	@Inject
	private PersonDAO personDAO;
	
	//###############
	//Implementations
	//###############
	
	@Override
	public Company findCompanyById(Long id) throws Exception {
		try {
			return companyDAO.findByPrimaryKey(id);
		}
		catch (Exception e){
			throw e;
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
	}

	@Override
	public Company findCompanyByName(String name) throws Exception {
		try {
			return companyDAO.findByName(name);
		}
		catch (Exception e){
			throw e;
		}
	}

	@Override
	public List<Company> findAllCompaniesByAdminCompanyId(Long adminCompanyId) throws Exception {
		try {
			return companyDAO.findByAdminCompanyId(adminCompanyId);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Company createCompany(Company company, String adminCompanyEmail) throws Exception {
		
		//company.name already registered
		if(companyDAO.findByName(company.getName()) != null) {
			throw new Exception("Company name already registered");
		}
		
		//adminCompanyEmail already registered
		if(personDAO.findByEmail(adminCompanyEmail) != null) {
			throw new Exception("Email already registered");
		}
		
		try {
			//create and insert the adminCompany in the db
			String adminCompanyPassword = UtilsUser.generatePassword();
			AdminCompany adminCompany = new AdminCompany(adminCompanyEmail, adminCompanyPassword,"","");
			adminCompany = (AdminCompany) personDAO.insert(adminCompany);
			company.setAdminCompany(adminCompany);
			adminCompany.getCompanies().put(company.getName(), company);
			company = companyDAO.insert(company);
			
			//Send the email in background
			final String adminEmail = adminCompanyEmail;
			final String adminPassword = adminCompanyPassword;
			Thread sendMailThread = new Thread(new Runnable(){
				public void run(){
					CompanyManagement.sendEmail(adminEmail, adminPassword);
				}
			}, "sendMailThread");
		
			sendMailThread.start();
			
			return company;
		}
		catch (Exception e){
			throw e;
		}
	}

	@Override
	public void deleteCompany(Long companyId) throws Exception {
		try {
			companyDAO.delete(companyId);
		}
		catch (Exception e){
			throw e;
		}
	}

	@Override
	public Company updateCompany(Company company) throws Exception {
//		Image im = company.getLogo();
//		imageDAO.insert(im);
		
		Company updateCompany = companyDAO.findByPrimaryKey(company.getId());
		if (updateCompany == null){
			throw new Exception("Company not registered");
		}
		updateCompany = companyDAO.update(company);
		
		return updateCompany;
	}
	
	//#############
	//Aux Functions
	//#############
	
	private static void sendEmail(String email, String password){
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
					"\n\nLogin into http://localhost:8080/geored-uy with the password '" + password + "' and set your company information."+
					"\n\n\n\n"+
					"Cheers,\ngeored-uy team");
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
