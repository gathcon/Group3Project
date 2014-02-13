package Main;

import java.util.List;
import Persistence.PersistenceUtil;
import Entity.Operator;

public class OperatorConfig {
	
	public static void main(String[] args){
		OperatorConfig config = new OperatorConfig();
	}

	public OperatorConfig(){
		createOperator(240, 2, "Sweden", "TDC-DK");
	}

	public void viewOperator(){
		List<Operator> operators = PersistenceUtil.findAllOperators();
		for(Operator o:operators){
			System.out.println("Operator "+o.getId()+ " exists.");
		}
	}
	
	public void createOperator(int mcc, int mnc, String country, String operator_name){			
		Operator operator = new Operator(mcc, mnc, country, operator_name);
		PersistenceUtil.persist(operator);
		System.out.println("Operator registered");
	}			
}
