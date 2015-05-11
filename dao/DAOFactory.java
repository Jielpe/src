package dao;

public class DAOFactory {

	// Design Pattern Singleton

	protected static DAOFactory instance = null;

	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	// Selon le nom du dao entree en parametre, le dao voulu sera retourne
	public IDAO getDAO(DAO pDAO) {
		IDAO dao = null;
		switch (pDAO) {
		case Ville:
			dao = new VilleDAO();
			break;
		case Region:
			dao = new RegionDAO();
			break;
		case Pays:
			dao = new PaysDAO();
			break;
		// case Operateur:dao = new OperateurDAO();break;
		// case Client:dao = new ClientDAO();break;
		// case Ligne_Facture:dao = new Ligne_FactureDAO();break;
		// case Hotel:dao = new HotelDAO();break;
		// case Reservation:dao = new ReservationDAO();break;
		// case Facture:dao = new FactureDAO();break;
		// case Produit:dao = new ProduitDAO();break;
		}
		return dao;
	}

}
