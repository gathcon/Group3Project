package main;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import model.Base_Data;
import model.Event_Cause;
import model.Event_CausePK;
import model.Failure;
import model.Operator;
import model.OperatorPK;
import model.User_Equipment;

public class EntityCreator {
	
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
	
	public static Base_Data getBase_Data(Failure f, User_Equipment ue, Event_Cause ec, Operator o) {
		int dataId = 10;
		int cellId = 4;
		//11/1/13 17:15;
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 11, 17, 15);
		Date dateTime = new Date();
		dateTime.setTime(cal.getTimeInMillis());
		int duration = 1000;
		BigInteger hier3Id = new BigInteger("4809532081614990336");
		BigInteger hier32Id = new BigInteger("8226896360947470336");
		BigInteger hier321Id = new BigInteger("1150444940909479936");
		BigInteger imsi = new BigInteger("344930000000011");
		String neVersion = "11B";
		
		Failure failure = f;
		User_Equipment userEquipment = ue;
		Event_Cause eventCause = ec;
		Operator operator = o;
		
		Base_Data row = new Base_Data();
		row.setDataId(dataId);
		row.setCellId(cellId);
		row.setDateTime(dateTime);
		row.setDuration(duration);
		row.setHier3Id(hier3Id);
		row.setHier32Id(hier32Id);
		row.setHier321Id(hier321Id);
		row.setImsi(imsi);
		row.setNeVersion(neVersion);
		row.setFailure(failure);
		row.setUserEquipment(userEquipment);
		row.setEventCause(eventCause);
		row.setOperator(operator);
				
		return row;
	}

}
