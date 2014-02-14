package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryEventCause implements Serializable, ITableQueries {
	
private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_Maven");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	@Override
	public <T> List<T> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<T> event_Causes = (List<T>) em.createNamedQuery("Event_Cause.findAll").getResultList();
		em.close();
		
		return event_Causes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findRowById(int id) {
		EntityManager em = emf.createEntityManager();
		List<T> event_Causes = (List<T>) em.createNamedQuery("Event_Cause.findById").setParameter("Event_CauseId", id).getResultList();
		em.close();
		if (event_Causes.size() == 0)
			return null;
		else 
			return (List<T>) event_Causes.get(0);
	}

}
