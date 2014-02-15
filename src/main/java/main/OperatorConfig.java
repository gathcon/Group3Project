package main;

import java.util.List;

import persistence.PersistenceUtil;
import persistence.QueryOperator;
import model.Operator;
import model.OperatorPK;

public class OperatorConfig {
	
	public static void main(String[] args){
		OperatorConfig config = new OperatorConfig();
	}

	public OperatorConfig(){
		createOperator(201, 4, "Ireland", "TDC-DK");
		OperatorPK operatorPK = new OperatorPK(999, 6);
		deleteOperator(operatorPK);
	}

	public void viewOperator(){
		List<Operator> operators = PersistenceUtil.findAllOperators();	//Need to return a list of Operators instead of MySqlTables.
		for(Operator o:operators){
			System.out.println("Operator "+o.getId()+ " exists.");
		}
	}
	
	public void createOperator(int mcc, int mnc, String country, String operator_name){			
		Operator operator = new Operator(mcc, mnc, country, operator_name);
		PersistenceUtil.persist(operator);
		System.out.println("Operator registered");
	}			
	
	public void deleteOperator(OperatorPK operatorPK){
		Operator operator = getOperatorById(operatorPK);
		PersistenceUtil.remove(operator);			//QueryFailure doesn't have delete failure method.
		System.out.println("Operator deleted");
	}
	
	public Operator getOperatorById(OperatorPK operatorPK){
		QueryOperator queryOperator = new QueryOperator();
		Operator operator = queryOperator.findRowById(operatorPK);
		return operator;
	}
}
