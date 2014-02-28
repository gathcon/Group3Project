package queries;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Event_Cause;
import model.TableRow;

public class QueryEvent_Cause implements Serializable, ITableQueries {
	
	private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public List<TableRow> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<TableRow> event_Causes = (List<TableRow>) em.createNamedQuery("Event_Cause.findAll").getResultList();
		em.close();
		
		return event_Causes;
	}

	public <T> Event_Cause findRowById(T event_CausePK) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Event_Cause> event_Causes = (List<Event_Cause>) em.createNamedQuery("Event_Cause.findById").
		setParameter("id", event_CausePK).getResultList();
		em.close();
		if (event_Causes.size() == 0)
			return null;
		else 
			return event_Causes.get(0);
	}
}