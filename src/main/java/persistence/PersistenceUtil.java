package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Failure;



public class PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("project"); 	
	
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	
	public static List<Failure> findAllFailures(){
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Failure> failures = (List<Failure>) em.createNamedQuery("Failure.findAll").getResultList();
		em.close();
		
		return failures;
		
	}
	
	public static Failure findFailureById(int failureId){
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Failure> failures = (List<Failure>) em.createNamedQuery("Failure.findById").setParameter("failureId", failureId).getResultList();
		em.close();
		if (failures.size() == 0)
			return null;
		else 
			return failures.get(0);
	}
	
}

