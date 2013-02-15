package org.gonzalomelov.georeduy.bll.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.bll.interfaces.LocationServices;
import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Stateless(name="locationServices")
public class LocationManagement implements LocationServices {

	@Inject
	private CompanyDAO companyDAO;
	
	@Override
	public Location addLocation(Long companyId, String name, Double coordX, Double coordY) throws Exception {
		try {
			Company company = companyDAO.findByPrimaryKey(companyId);
			if (company == null){
				throw new Exception("Company doesn't exists");
			}
			
			Location location = new Location();
			location.setName(name);
//			GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FIXED), 4326);
//			System.out.print("GeometryFactory");
//			Geometry geom = (Geometry) geometryFactory.createPoint(new Coordinate(coordX, coordY));
//			System.out.print("createPoint");
//			location.setGeom(geom);			
//			System.out.print("setGeom");
//			location.setCompany(company);
//			System.out.print("setCompany");
			
			//First interpret the WKT string to a point
            WKTReader fromText = new WKTReader();
            Geometry geom = null;
            try {
                geom = fromText.read("POINT(10 5)");
            } catch (ParseException e) {
                throw new RuntimeException("Not a WKT string:" + "SRID=4326;POINT(-56.2564083434446 -34.8982159791812)");
            }
            if (!geom.getGeometryType().equals("Point")) {
                throw new RuntimeException("Geometry must be a point. Got a " + geom.getGeometryType());
            }
			System.out.print("createPoint");
			location.setGeom((Point)geom);			
			System.out.print("setGeom");
			location.setCompany(company);
			System.out.print("setCompany");			
			
			company.getLocations().put(location.getName(), location);
			System.out.print("put");
			company = companyDAO.update(company);
			System.out.print("update");
			
			return company.getLocations().get(location.getName());
		}
		catch (Exception exc) {
			throw exc;
		}
	}

	@Override
	public void removeLocation(Long companyId, Long locationId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location updateLocation(Long companyId, Location location) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location findLocationById(Long companyId, Long locationId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> findAllLocationsFromCompany(Long companyId) throws Exception {
		try {
			Company company = companyDAO.findByPrimaryKey(companyId);
			if (company == null){
				throw new Exception("Company doesn't exists");
			}
			return (List<Location>) company.getLocations().values();
		}
		catch (Exception exc) {
			throw exc;
		}
	}

	@Override
	public List<Location> findAllClosestLocationsFromUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> findAllClosestOffersFromUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buyOffer(Long companyId, Long locationId, Long offerId,
			Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evaluateOffer(Long companyId, Long locationId, Long offerId,
			Long userId, OfferEvaluation evaluation) {
		// TODO Auto-generated method stub
		
	}

}
