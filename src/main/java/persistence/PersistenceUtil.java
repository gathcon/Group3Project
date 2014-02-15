package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Base_Data;
import model.Event_Cause;
import model.Event_CausePK;
import model.Failure;
import model.Operator;
import model.OperatorPK;
import model.User_Equipment;

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
	
	public static List<Base_Data> findAllBase_Datas(){
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Base_Data> rows = (List<Base_Data>) em.createNamedQuery("E.findAll").getResultList();
		em.close();
		
		return rows;
		
	}
	
	public static Base_Data findBase_DataById(int id){
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Base_Data> rows = (List<Base_Data>) em.createNamedQuery("E.findById").setParameter("dataId", id).getResultList();
		em.close();
		if (rows.size() == 0)
			return null;
		else 
			return rows.get(0);
	}
	
	public static List<User_Equipment> findAllUser_Equipments(){
		EntityManager em = emf.createEntityManager();
		List<User_Equipment> user_equipments = (List<User_Equipment>) em.createNamedQuery("User_Equipment.findAll").getResultList();
		em.close();
		
		return user_equipments;	
	}
	
	public static User_Equipment findUser_EquipmentById(int user_equipment_id){
		
		EntityManager em = emf.createEntityManager();
		List<User_Equipment> user_equipments = (List<User_Equipment>) em.createNamedQuery
				("User_Equipment.findByUser_EquipmentId").setParameter("userEquipmentId", user_equipment_id).getResultList();
		em.close();
		
		if (user_equipments.size() == 0)
			return null;
		else 
			return user_equipments.get(0);
	}
	
	public static List<Operator> findAllOperators(){
		EntityManager em = emf.createEntityManager();
		List<Operator> operators = (List<Operator>) em.createNamedQuery("Operator.findAll").getResultList();
		em.close();
		
		return operators;	
	}
	
	public static Operator findOperatorById(OperatorPK operatorPK){
		
		EntityManager em = emf.createEntityManager();
		List<Operator> operators = (List<Operator>) em.createNamedQuery("Operator.findByOperatorId").
				setParameter("id", operatorPK).getResultList();
		em.close();
		
		if (operators.size() == 0)
			return null;
		else 
			return operators.get(0);
	}
	
	public static List<Event_Cause> findAllEvent_Causes(){
		EntityManager em = emf.createEntityManager();
		List<Event_Cause> event_causes = (List<Event_Cause>) em.createNamedQuery("Event_Cause.findAll").getResultList();
		em.close();
		
		return event_causes;	
	}
	
	public static Event_Cause findEvent_CauseById(Event_CausePK event_causePK){
		
		EntityManager em = emf.createEntityManager();
		List<Event_Cause> event_causes = (List<Event_Cause>) em.createNamedQuery("Event_Cause.findByEvent_CauseId").
				setParameter("id", event_causePK).getResultList();
		em.close();
		
		if (event_causes.size() == 0)
			return null;
		else 
			return event_causes.get(0);
	}
}