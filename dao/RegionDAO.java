package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import metier.Pays;
import metier.Region;
import metier.Ville;

public class RegionDAO implements IRegionDAO{
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	private static VilleDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * @return l'instance unique du DAO
	 */
	public static VilleDAO getInstance() {
		if (instance == null) {
			instance = new VilleDAO();
		}
		return instance;
	}


	public void commit() {
		tx.commit();
		tx.begin();
	}

	public void closeAll() {
		em.close();
		emf.close();
	}

	public Region getRegion(String nom_region, Pays pays) {
		Region r = new Region(nom_region, pays);
		em.persist(r);
		return r;
	}

	public void remove(Object o) {
		em.remove(o);
		
	}

	public List<Object> getAll() {
		return em.createQuery("select r from Region r order by r.nom asc").getResultList();
	}

	public Object getFromId(int id) {
		return em.find(Region.class, id);
	}

	public List<Object> getWhere(String whereClause) {
		return em.createQuery("select r from Region r where "+ whereClause +" order by r.nom asc").getResultList();
	}

	public String tableToString(){
		StringBuffer result = new StringBuffer();
		result.append("[ETAT DE LA TABLE REGION]\n");
		for (Object p : em.createQuery("select r from Region r order by r.nom asc").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}

