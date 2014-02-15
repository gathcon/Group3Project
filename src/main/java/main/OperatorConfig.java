package main;

import java.util.List;

import persistence.PersistenceUtil;
import persistence.QueryOperator;
import model.MySqlTable;
import model.Operator;

public class OperatorConfig implements ITableConfigurations{

	public List<MySqlTable> viewRow() {
		QueryOperator queryOperator = new QueryOperator();
		List<MySqlTable> operators = queryOperator.findAllRows();
		for(MySqlTable o:operators){
			System.out.println("Operator "+((Operator) o).getId()+ " exists.");
		}
		return operators;
	}

	public <T> MySqlTable getRowById(T id) {
		QueryOperator queryOperator = new QueryOperator();
		Operator operator = queryOperator.findRowById(id);
		return operator;
	}

	public void createRow(MySqlTable row) {
		PersistenceUtil.persist(row);
		System.out.println("Operator registered");
	}

	public void deleteRow(MySqlTable row) {
		PersistenceUtil.remove(row);
		System.out.println("Operator deleted");
	}
	
}
