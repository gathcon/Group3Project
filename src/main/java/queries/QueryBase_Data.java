package queries;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Base_Data;
import model.MySqlTable;

public class QueryBase_Data implements Serializable, ITableQueries {
	
	private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public List<MySqlTable> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<MySqlTable> base_Data = (List<MySqlTable>) em.createNamedQuery("Base_Data.findAll").getResultList();
		em.close();
		
		return base_Data;
	}

	public <T> Base_Data findRowById(T dataId) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Base_Data> Base_Data = (List<Base_Data>) em.createNamedQuery("Base_Data.findById").
		setParameter("dataId", dataId).getResultList();
		em.close();
		if (Base_Data.size() == 0)
			return null;
		else 
			return Base_Data.get(0);
	}

}
