package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryOperator implements Serializable, ITableQueries {
	
private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_Maven");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	@Override
	public <T> List<T> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<T> operators = (List<T>) em.createNamedQuery("Operator.findAll").getResultList();
		em.close();
		
		return operators;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findRowById(int id) {
		EntityManager em = emf.createEntityManager();
		List<T> operators = (List<T>) em.createNamedQuery("Operator.findById").setParameter("OperatorId", id).getResultList();
		em.close();
		if (operators.size() == 0)
			return null;
		else 
			return (List<T>) operators.get(0);
	}

}
