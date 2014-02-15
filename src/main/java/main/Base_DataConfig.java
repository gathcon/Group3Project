package main;

import java.util.List;

import model.MySqlTable;
import persistence.PersistenceUtil;

public class Base_DataConfig implements ITableConfigurations{
	
	public Base_DataConfig(){
	}
	
	public List<MySqlTable> viewRow() {
		return null;
//		QueryBase_Data queryBase_Data = new QueryBase_Data();
//		List<MySqlTable> data = queryBase_Data.findAllRows();
//		for(MySqlTable b : data){
//			System.out.println("Failure "+((Failure) b).getFailureId()+ " exists.");
//		}
//		return data;
	}

	public <T> MySqlTable getRowById(T id) {
		return null;
		//QueryBase_Data queryBase_Data = new QueryBase_Data();
		//Base_Data data = queryBase_Data.findRowById(id);
		//return data;
	}

	public void createRow(MySqlTable row) {
		PersistenceUtil.persist(row);
		System.out.println("Base_Data registered");
	}

	public void deleteRow(MySqlTable row) {
		PersistenceUtil.remove(row);
		System.out.println("Base_Data deleted");
	}

}
