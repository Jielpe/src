package dao;

import java.util.List;

import metier.Pays;

public interface IPaysDAO extends IDAO {

	public void commit();
	public void closeAll();
	
	public void savePays(Pays p); 
	public void remove (Pays p);
	public List<Object> getAll();
	public Object getFromId(int id);
	public List<Object> getWhere(String whereClause);
}
