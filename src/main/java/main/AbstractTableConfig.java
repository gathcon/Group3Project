package main;

import java.util.List;

import persistence.PersistenceUtil;
import model.MySqlTable;

public abstract class AbstractTableConfig {
	
	public void createRow(MySqlTable row) {
		PersistenceUtil.persist(row);
	}
	
	public void deleteRow(MySqlTable row) {
		PersistenceUtil.remove(row);
	}
	
	public abstract List<MySqlTable> viewRow();
	
	public abstract <T> MySqlTable getRowById(T id);
}
