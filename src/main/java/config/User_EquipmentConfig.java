package config;

import java.util.List;

import queries.QueryUser_Equipment;
import model.MySqlTable;
import model.User_Equipment;

public class User_EquipmentConfig extends AbstractTableConfig{

	public List<MySqlTable> viewRow() {
		QueryUser_Equipment queryUser_Equipment = new QueryUser_Equipment();
		List<MySqlTable> user_equipments = queryUser_Equipment.findAllRows();
		for(MySqlTable ue:user_equipments){
			System.out.println("User_Equipment "+((User_Equipment) ue).getUser_EquipmentId()+ " exists.");
		}
		return user_equipments;
	}
	
	public <T> MySqlTable getRowById(T id) {
		QueryUser_Equipment queryUser_Equipment = new QueryUser_Equipment();
		User_Equipment user_equipment = queryUser_Equipment.findRowById(id);
		return user_equipment;
	}
	
}
