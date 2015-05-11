package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Pays;

public class PaysDAO implements IPaysDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	private static PaysDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * @return l'instance unique du DAO
	 */
	public static PaysDAO getInstance() {
		if (instance == null) {
			instance = new PaysDAO();
		}
		return instance;
	}

	/**
	 * Constructeur du DAO
	 * Il initialise le contexte de persistance
	 */
	public PaysDAO() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}
	
	/**
	 * Créer une instance de Pays et l'ajoute au contexte de persistance
	 * @param pNom_pays
	 * @return le pays créé
	 */
	public Pays getPays( String pNom_pays) {
		Pays p = new Pays(pNom_pays);
		em.persist(p);
		return p;
		
	}
	
	
	/**
	 * Synchronise le context de persistance avec la base de donnée.
	 * En fait un commit est effectué et une nouvelle transaction débutée
	 */
	@Override
	public void commit() {
		tx.commit();
		tx.begin();
		
	}

	/**
	 * Ferme la factory d'entity manager et l'entity manager
	 */
	@Override
	public void closeAll() {
		em.close();
		emf.close();
		
	}

	/**
	 * efface un pays
	 * @param p  Le pays
	 */
	@Override
	public void remove(Object o) {
		em.remove(o);
		
	}

	/**
	 * Retourne le contenu de la table
	 */
	@Override
	public List<Object> getAll() {
		
		return em.createQuery("select p from Pays p order by p.nom_pays asc").getResultList();
	}

	/**
	 * Retourne une personne selectionnée par son id
	 * @param id l'id de la personne recherchée
	 * @return la personne
	 */
	@Override
	public Object getFromId(int id) {
		return em.find(Pays.class, id);
	}

	/**
	 * recherche une liste de personnes à partir d'une clause Where
	 * @param whereClause La clause where
	 * @return la liste de personnes
	 */
	@Override
	public List<Object> getWhere(String whereClause) {
		return em.createQuery("select p from Pays p where "+ whereClause +" order by p.nom_pays asc").getResultList();
	}
	 
	/**
	 * Construit un bloc de texte affichant le contenu de la table
	 * @return le contenu de la table
	 */
	@Override
	public String tableToString(){
		StringBuffer result = new StringBuffer();
		result.append("[ETAT DE LA TABLE]\n");
		for (Object p : em.createQuery("select p from Pays p order by p.nom_pays asc").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		
		return result.toString();
	}

}
	
