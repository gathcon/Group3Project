package tableTests;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import config.Base_DataConfig;
import config.EntityCreator;
import config.Event_CauseConfig;
import config.FailureConfig;
import config.OperatorConfig;
import config.User_EquipmentConfig;
import model.Base_Data;
import model.Event_Cause;
import model.Failure;
import model.MySqlTable;
import model.Operator;
import model.User_Equipment;

public class TestBaseDataConfig extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		FailureConfig failureConfig = new FailureConfig();
		User_EquipmentConfig userEquipmentConfig = new User_EquipmentConfig();
		Event_CauseConfig eventCauseConfig = new Event_CauseConfig();
		OperatorConfig operatorConfig = new OperatorConfig();
		Base_DataConfig baseDataConfig = new Base_DataConfig();
		
		Failure f = EntityCreator.getFailure(10, "Test Description");
		User_Equipment ue = EntityCreator.getUser_Equipment(991, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		Event_Cause ec = EntityCreator.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		Operator o = EntityCreator.getOperator(201, 4, "Ireland", "TDC-DK");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 11, 17, 15);
		Date dateTime = new Date();
		dateTime.setTime(cal.getTimeInMillis());
		BigInteger hier3Id = new BigInteger("4809532081614990336");
		BigInteger hier32Id = new BigInteger("8226896360947470336");
		BigInteger hier321Id = new BigInteger("1150444940909479936");
		BigInteger imsi = new BigInteger("344930000000011");
		String neVersion = "11B";
		
		failureConfig.createRow(f);
		userEquipmentConfig.createRow(ue);
		eventCauseConfig.createRow(ec);
		operatorConfig.createRow(o);
		
		Base_Data expected = EntityCreator.getBase_Data(4, dateTime, 1000, hier3Id, hier32Id, hier321Id, imsi, neVersion, 
				f, ue, ec, o);
		
		baseDataConfig.createRow(expected);
		
		Base_Data result = (Base_Data) baseDataConfig.getRowById(expected.getDataId());
		baseDataConfig.deleteRow(expected);
		
		failureConfig.deleteRow(f);
		userEquipmentConfig.deleteRow(ue);
		eventCauseConfig.deleteRow(ec);
		operatorConfig.deleteRow(o);
		
		assertNotNull(result);
		assertEquals(expected.getCellId(), result.getCellId());
	}


	@Override
	public void testList() {
		
		FailureConfig failureConfig = new FailureConfig();
		User_EquipmentConfig userEquipmentConfig = new User_EquipmentConfig();
		Event_CauseConfig eventCauseConfig = new Event_CauseConfig();
		OperatorConfig operatorConfig = new OperatorConfig();
		Base_DataConfig baseDataConfig = new Base_DataConfig();
		
		Failure f = EntityCreator.getFailure(15, "Test Description");
		Failure f2 = EntityCreator.getFailure(11, "Test Description");
		User_Equipment ue = EntityCreator.getUser_Equipment(995, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		User_Equipment ue2 = EntityCreator.getUser_Equipment(992, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		Event_Cause ec = EntityCreator.getEvent_Cause(0, 4098, "RRC CONN SETUP-SUCCESS");
		Event_Cause ec2 = EntityCreator.getEvent_Cause(1, 4098, "RRC CONN SETUP-SUCCESS");
		Operator o = EntityCreator.getOperator(203, 4, "Ireland", "TDC-DK");
		Operator o2 = EntityCreator.getOperator(202, 4, "Ireland", "TDC-DK");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 11, 17, 15);
		Date dateTime = new Date();
		dateTime.setTime(cal.getTimeInMillis());
		BigInteger hier3Id = new BigInteger("4809532081614990336");
		BigInteger hier32Id = new BigInteger("8226896360947470336");
		BigInteger hier321Id = new BigInteger("1150444940909479936");
		BigInteger imsi = new BigInteger("344930000000011");
		String neVersion = "11B";
		
		failureConfig.createRow(f);
		failureConfig.createRow(f2);
		userEquipmentConfig.createRow(ue);
		userEquipmentConfig.createRow(ue2);
		eventCauseConfig.createRow(ec);
		eventCauseConfig.createRow(ec2);
		operatorConfig.createRow(o);
		operatorConfig.createRow(o2);
		
		Base_Data row = EntityCreator.getBase_Data(4, dateTime, 1000, hier3Id, hier32Id, hier321Id, imsi, neVersion, f, ue, ec, o);
		Base_Data row2 = EntityCreator.getBase_Data(4, dateTime, 1001, hier3Id, hier32Id, hier321Id, imsi, neVersion, f2, ue2, ec2, o2);
		
		baseDataConfig.createRow(row);
		baseDataConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		
		List<MySqlTable> result = baseDataConfig.viewRow();
			
		baseDataConfig.deleteRow(row);
		baseDataConfig.deleteRow(row2);
		
		failureConfig.deleteRow(f);
		failureConfig.deleteRow(f2);
		userEquipmentConfig.deleteRow(ue);
		userEquipmentConfig.deleteRow(ue2);
		eventCauseConfig.deleteRow(ec);
		eventCauseConfig.deleteRow(ec2);
		operatorConfig.deleteRow(o);
		operatorConfig.deleteRow(o2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
		
	}

}
