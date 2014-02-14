package persistence;

import java.util.List;

import model.MySqlTable;

public interface ITableQueries {
	
	public List<MySqlTable> findAllRows();
	
	public <T> MySqlTable findRowById(T id);
}
