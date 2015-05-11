package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import metier.Region;
import metier.Ville;

public class VilleDAO implements IVilleDAO{
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

	public Ville getVille(String nom_ville, Region region) {
		Ville v = new Ville(nom_ville, region);
		em.persist(v);
		return v;
	}

	public void remove(Object o) {
		em.remove(o);
		
	}

	public List<Object> getAll() {
		return em.createQuery("select v from Ville v order by v.nom asc").getResultList();
	}

	public Object getFromId(int id) {
		return em.find(Ville.class, id);
	}

	public List<Object> getWhere(String whereClause) {
		return em.createQuery("select v from Ville v where "+ whereClause +" order by v.nom asc").getResultList();
	}
	
	public String tableToString(){
		StringBuffer result = new StringBuffer();
		result.append("[ETAT DE LA TABLE VILLE]\n");
		for (Object p : em.createQuery("select v from Ville v order by v.nom asc").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}

}
