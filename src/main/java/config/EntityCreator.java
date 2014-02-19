package config;

import java.math.BigInteger;
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
	
	public static User_Equipment getUser_Equipment(int id, String marketingName, String manufacturer, 
			String accessCapability, String model, String vendorName, String ueType, String os, String inputMode) {
		
		User_Equipment row = new User_Equipment();
		row.setUser_EquipmentId(id);
		row.setMarketingName(marketingName);
		row.setManufacturer(manufacturer);
		row.setAccessCapability(accessCapability);
		row.setModel(model);
		row.setVendorName(vendorName);
		row.setUeType(ueType);
		row.setOs(os);
		row.setInputMode(inputMode);
		
		return row;
		
	}
	
	public static Base_Data getBase_Data(int cellId, Date dateTime, int duration, 
			BigInteger hier3Id, BigInteger hier32Id, BigInteger hier321Id, BigInteger imsi, String neVersion,
			Failure failure, User_Equipment userEquipment, Event_Cause eventCause, Operator operator) {
		
		Base_Data row = new Base_Data();
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
