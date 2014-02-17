package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Operator;
import model.MySqlTable;

public class QueryOperator implements Serializable, ITableQueries {
	
private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public List<MySqlTable> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<MySqlTable> operators = (List<MySqlTable>) em.createNamedQuery("Operator.findAll").getResultList();
		em.close();
		
		return operators;
	}

	public <T> Operator findRowById(T operatorPK) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Operator> operators = (List<Operator>) em.createNamedQuery("Operator.findById").
		setParameter("id", operatorPK).getResultList();
		em.close();
		if (operators.size() == 0)
			return null;
		else 
			return operators.get(0);
	}
}