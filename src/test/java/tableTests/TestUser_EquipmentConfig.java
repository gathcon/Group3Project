package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.EntityCreator;
import main.User_EquipmentConfig;
import model.User_Equipment;
import model.MySqlTable;

public class TestUser_EquipmentConfig extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		User_EquipmentConfig user_EquipmentConfig = new User_EquipmentConfig();
		
		User_Equipment expected = EntityCreator.getUser_Equipment(990, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test", "test", "test");
		
		user_EquipmentConfig.createRow(expected);
		User_Equipment result = (User_Equipment) user_EquipmentConfig.getRowById(expected.getUser_EquipmentId());
		user_EquipmentConfig.deleteRow(expected);
		
		assertNotNull(result);
		assertEquals(expected.getMarketingName(), result.getMarketingName());
		assertEquals(expected.getManufacturer(), result.getManufacturer());
		assertEquals(expected.getAccessCapability(), result.getAccessCapability());
		assertEquals(expected.getModel(), result.getModel());
		assertEquals(expected.getVendorName(), result.getVendorName());
		assertEquals(expected.getUeType(), result.getUeType());
		assertEquals(expected.getOs(), result.getOs());
		assertEquals(expected.getInputMode(), result.getInputMode());
	}

	@Override
	public void testList() {
		
		User_EquipmentConfig user_EquipmentConfig = new User_EquipmentConfig();
		
		MySqlTable row = EntityCreator.getUser_Equipment(991, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		MySqlTable row2 = EntityCreator.getUser_Equipment(992, "Galaxy", "Samsung", "GSM 1800, GSM 900, GSM 850",
				"Galaxy", "Samsung", "test2", "test2", "test2");
		
		user_EquipmentConfig.createRow(row);
		user_EquipmentConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		
		List<MySqlTable> result = user_EquipmentConfig.viewRow();
		
		user_EquipmentConfig.deleteRow(row);
		user_EquipmentConfig.deleteRow(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
	}

}
