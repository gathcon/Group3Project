package main;

import model.MySqlTable;

public interface ITableConfigurations {
	
	public void viewRow();
	
	public void createRow(MySqlTable myRow);
	
	public void deleteRow(MySqlTable myRow);
	
	public <T> MySqlTable getRowById(T id);
}
