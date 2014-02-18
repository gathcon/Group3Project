package config;

import java.util.List;

import queries.QueryOperator;
import model.MySqlTable;
import model.Operator;

public class OperatorConfig extends AbstractTableConfig{

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
	
}
