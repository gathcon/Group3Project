package queries;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;
import model.TableRow;

public class QueryUser implements Serializable, ITableQueries {
	
private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public List<TableRow> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<TableRow> users = (List<TableRow>) em.createNamedQuery("User.findAll").getResultList();
		em.close();
		
		return users;
	}

	public <T> User findRowById(T id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) em.createNamedQuery("User.findById").
				setParameter("userName", id).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}	
}