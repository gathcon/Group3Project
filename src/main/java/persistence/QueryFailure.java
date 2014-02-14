package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Failure;
import model.MySqlTable;

public class QueryFailure implements Serializable, ITableQueries {
	
private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_Maven");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	@Override
	public List<MySqlTable> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<MySqlTable> failures = (List<MySqlTable>) em.createNamedQuery("Failure.findAll").getResultList();
		em.close();
		
		return failures;
	}

	@Override
	public <T> MySqlTable findRowById(T id) {
		EntityManager em = emf.createEntityManager();
		List<Failure> failures = (List<Failure>) em.createNamedQuery("Failure.findById").setParameter("failureId", id).getResultList();
		em.close();
		if (failures.size() == 0)
			return null;
		else 
			return failures.get(0);
	}



}
