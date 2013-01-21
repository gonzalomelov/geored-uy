package org.gonzalomelov.georeduy.dal.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.dal.model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author gonza
 *
 */
@RunWith(Arquillian.class) 
public class PersonDAOTest {
	@Deployment 
	public static Archive<?> createDeployment(){
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class,"PersonDAOTest.jar")
        	.addPackage(org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO.class.getPackage())
        	.addPackage(org.gonzalomelov.georeduy.dal.dao.jpa.JPAPersonDAO.class.getPackage())
        	.addPackage(org.gonzalomelov.georeduy.dal.dao.GenericDAO.class.getPackage())
        	.addPackage(org.gonzalomelov.georeduy.dal.dao.AbstractDAO.class.getPackage())
        	.addPackage(org.gonzalomelov.georeduy.dal.model.Person.class.getPackage())
        	.addPackage(org.gonzalomelov.georeduy.dal.model.User.class.getPackage())
        	.addPackages(true,"com.vividsolutions.jts")
            .addAsManifestResource("test-persistence.xml", "persistence.xml")
            .addAsManifestResource("test-geored-uy-ds.xml", "test-geored-uy-ds.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        
        return jar;
	}
	
	@Inject
	private PersonDAO personDAO;
	
	@Inject
	private UserTransaction ut;
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @verifica Insercion validando los distintos campos a null, etc..
	 */
	@Test
	public void insertPersonsOfDiferentTypes() throws Exception {
		ut.begin();
		em.joinTransaction();
		personDAO.insert(new User("gonzalomelov1@gmail.com", "U8060T", "Gonzalo", "Melo"));
		ut.commit();
		
		Assert.assertTrue(personDAO.findAll().size() == 1);
		
		Person p = personDAO.findByEmailAndPassword("gonzalomelov@gmail.com", "U8060T");
		
		Assert.assertTrue(p.getEmail().equals("gonzalomelov@gmail.com"));
		Assert.assertTrue(p.getPassword().equals("U8060T"));
	}

}
