package dao;

import java.util.List;


public interface IDAO {
	
	public void commit();
	public void closeAll();
	
	public void saveObject(Object o); // Ersatz batard de méthode insert
	public void remove (Object o);
	public List<Object> getAll();
	public Object getFromId(int id);
	public List<Object> getWhere(String whereClause);

}
