package main;

import java.util.List;

import model.MySqlTable;

public interface ITableConfigurations {
	
	public List<MySqlTable> viewRow();
	
	public void createRow(MySqlTable myRow);
	
	public void deleteRow(MySqlTable myRow);
	
	public <T> MySqlTable getRowById(T id);
}
