package Main;

import java.util.List;
import Persistence.PersistenceUtil;
import Entity.User_Equipment;

public class User_EquipmentConfig {
	
	public static void main(String[] args){
		User_EquipmentConfig config = new User_EquipmentConfig();
	}

	public User_EquipmentConfig(){
		createUser_Equipment(10100, "G410", "Mitsubishi", "GSM 1800, GSM 900", "G410", "Mitsubishi", "test", "test", "test");
	}

	public void viewUser_Equipment(){
		List<User_Equipment> user_equipments = PersistenceUtil.findAllUser_Equipments();
		for(User_Equipment ue:user_equipments){
			System.out.println("User_Equipment "+ue.getUser_EquipmentId()+ " exists.");
		}
	}
	
	public void createUser_Equipment(int user_equipment_id, String marketing_name, String manufacturer, String access_capability,
										String model, String vendor_name, String ue_type, String os, String input_mode){
		
		User_Equipment user_equipment = new User_Equipment(user_equipment_id, marketing_name, manufacturer, access_capability,
															model, vendor_name, ue_type, os, input_mode);
		PersistenceUtil.persist(user_equipment);
		System.out.println("User_Equipment registered");
	}			
}
