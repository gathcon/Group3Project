package tableTests;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.sql.Date;

import org.junit.Test;

import main.Base_DataConfig;
import main.FailureConfig;
import model.Base_Data;
import model.Event_Cause;
import model.Failure;
import model.Operator;
import model.User_Equipment;

public class TestBaseDataTable {
	
	@Test
	public void testBaseDataTable() {
//		BaseDataConfig baseDataConfig = new BaseDataConfig();
//		
//		int dataId = 10;
//		int cellId = 4;
//		Date dateTime = new Date();//11/1/13 17:15;
//		int duration = 1000;
//		BigInteger hier3Id = new BigInteger("4809532081614990336");
//		BigInteger hier32Id = new BigInteger("8226896360947470336");
//		BigInteger hier321Id = new BigInteger("1150444940909479936");
//		BigInteger imsi = new BigInteger("344930000000011");
//		String neVersion = "11B";
//		Failure failure = 1;
//		
//		User_Equipment userEquipment = 21060800;
//		Event_Cause eventCause = 0;4098;
//		Operator operator = 930;
//		
//		baseDataConfig.createRow(dataId, cellId, dateTime, duration, 
//				hier3Id, hier32Id, hier321Id, imsi, neVersion, 
//				failure, userEquipment, eventCause, operator);
//		Base_Data baseData = baseDataConfig.getRowById(dataId);
//		baseDataConfig.deleteRow(dataId);
//		
//		assertNotNull(baseData);
//		assertEquals(description, baseData.getDateTime());
	}

}
