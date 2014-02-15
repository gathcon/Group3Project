package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User_Equipment;
import model.MySqlTable;

public class QueryUser_Equipment implements Serializable, ITableQueries {
	
private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public List<MySqlTable> findAllRows() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<MySqlTable> user_Equipments = (List<MySqlTable>) em.createNamedQuery("User_Equipment.findAll").getResultList();
		em.close();
		
		return user_Equipments;
	}

	public <T> User_Equipment findRowById(T id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<User_Equipment> user_Equipments = (List<User_Equipment>) em.createNamedQuery("User_Equipment.findById").
				setParameter("userEquipmentId", id).getResultList();
		em.close();
		if (user_Equipments.size() == 0)
			return null;
		else 
			return user_Equipments.get(0);
	}	
}