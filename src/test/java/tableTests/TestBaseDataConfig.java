package tableTests;

import static org.junit.Assert.*;
import main.Base_DataConfig;
import main.EntityCreator;
import main.Event_CauseConfig;
import main.FailureConfig;
import main.OperatorConfig;
import main.User_EquipmentConfig;
import model.Base_Data;
import model.Event_Cause;
import model.Failure;
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
		User_Equipment ue = EntityCreator.getUser_Equipment();
		Event_Cause ec = EntityCreator.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		Operator o = EntityCreator.getOperator(201, 4, "Ireland", "TDC-DK");
		
		Base_Data expected = EntityCreator.getBase_Data(f, null, ec, o);
		
		failureConfig.createRow(f);
		userEquipmentConfig.createRow(ue);
		
		
		baseDataConfig.createRow(expected);
		Base_Data result = (Base_Data) baseDataConfig.getRowById(expected.getDataId());
		baseDataConfig.deleteRow(expected);
		
		assertNotNull(result);
		assertEquals(expected.getCellId(), result.getCellId());
		assertEquals(expected.getDateTime(), result.getDateTime());
	}


	@Override
	public void testList() {
		// TODO Auto-generated method stub
		
	}

}
