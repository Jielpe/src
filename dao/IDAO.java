package dao;

import java.util.List;


public interface IDAO {
	
	public void commit();
	public void closeAll();
	
	public void remove (Object o);
	public List<Object> getAll();
	public Object getFromId(int id);
	public List<Object> getWhere(String whereClause);
	public String tableToString ();

}
