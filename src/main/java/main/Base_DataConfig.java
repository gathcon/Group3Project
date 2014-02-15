package main;

import java.math.BigInteger;
import java.sql.Date;

import model.Base_Data;
import model.Event_Cause;
import model.Failure;
import model.Operator;
import model.User_Equipment;
import persistence.PersistenceUtil;

public class Base_DataConfig {
	
	public Base_DataConfig(){
	}
	
	public void createRow(int dataId, int cellId, Date dateTime, 
			int duration, BigInteger hier3Id, BigInteger hier32Id, 
			BigInteger hier321Id, BigInteger imsi, String neVersion, 
			Failure failure, User_Equipment userEquipment, 
			Event_Cause eventCause, Operator operator){
		
		Base_Data baseData = new Base_Data();
		baseData.setDataId(dataId);
		baseData.setCellId(cellId);
		baseData.setDateTime(dateTime);
		baseData.setDuration(duration);
		baseData.setHier3Id(hier3Id);
		baseData.setHier32Id(hier32Id);
		baseData.setHier321Id(hier321Id);
		baseData.setImsi(imsi);
		baseData.setNeVersion(neVersion);
		baseData.setFailure(failure);
		baseData.setUserEquipment(userEquipment);
		baseData.setEventCause(eventCause);
		baseData.setOperator(operator);
		
		PersistenceUtil.persist(baseData);
		System.out.println("Base_Data registered");
	}
	
	public void deleteRow(int dataId){
		Base_Data baseData = getRowById(dataId);
		PersistenceUtil.remove(baseData);
		System.out.println("Base_Data deleted");
	}
	
	public Base_Data getRowById(int dataId){
		Base_Data data = PersistenceUtil.findBase_DataById(dataId);
		return data;
	}

}
