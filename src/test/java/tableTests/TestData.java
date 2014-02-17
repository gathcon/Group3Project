package tableTests;

import model.Base_Data;
import model.Event_Cause;
import model.Event_CausePK;
import model.Failure;
import model.Operator;
import model.OperatorPK;
import model.User_Equipment;

public class TestData {
	
	public static Failure getFailure(int id, String description) {
		
		Failure row = new Failure();
		row.setFailureId(id);
		row.setDescription(description);
		
		return row;
		
	}
	
	public static Operator getOperator(int mcc, int mnc, String country, String operatorName) {
		
		OperatorPK id = new OperatorPK(mcc, mnc);
		
		Operator row = new Operator();
		row.setId(id);
		row.setCountry(country);
		row.setOperatorName(operatorName);
		
		return row;
		
	}
	
	public static Event_Cause getEvent_Cause(int causeCode, int id, String description) {
		
		Event_Cause row = new Event_Cause();
		Event_CausePK pkid = new Event_CausePK(causeCode, id);
		row.setId(pkid);
		row.setDescription(description);
		
		return row;
		
	}
	
	public static User_Equipment getUser_Equipment() {
		return null;
		
	}
	
	public static Base_Data getBase_Data() {
		return null;
		
	}

}
