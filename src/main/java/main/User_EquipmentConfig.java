package main;

import java.util.List;

import persistence.QueryUser_Equipment;
import model.MySqlTable;
import model.User_Equipment;

public class User_EquipmentConfig extends AbstractTableConfig{

	public User_EquipmentConfig(){
		User_Equipment user_Equipment = new User_Equipment(50002, "G410", "Mitsubishi", "GSM 1800, GSM 900", "G410", "Mitsubishi", "test", "test", "test");
		createRow(user_Equipment);
		User_Equipment deleteUser_Equipment = new User_Equipment(50100, "G410", "Mitsubishi", "GSM 1800, GSM 900", "G410", "Mitsubishi", "test", "test", "test");
		deleteRow(deleteUser_Equipment);
	}

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
