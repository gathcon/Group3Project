package config;

import java.util.List;

import queries.QueryBase_Data;
import model.Base_Data;
import model.MySqlTable;

public class Base_DataConfig extends AbstractTableConfig {
	
	public <T> MySqlTable getRowById(T id) {
		QueryBase_Data queryBase_Data = new QueryBase_Data();
		Base_Data data = queryBase_Data.findRowById(id);
		return data;
	}
	
	public List<MySqlTable> viewRow() {
		QueryBase_Data queryBase_Data = new QueryBase_Data();
		List<MySqlTable> data = queryBase_Data.findAllRows();
		for(MySqlTable b : data){
			System.out.println("Base_Data "+( (Base_Data) b).getDataId()+ " exists.");
		}
		return data;
	}

}
