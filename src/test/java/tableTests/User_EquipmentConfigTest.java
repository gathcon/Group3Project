package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceUtil;
import queries.QueryUser_Equipment;
import entityCreator.EntityCreator;
import model.User_Equipment;
import model.TableRow;

public class User_EquipmentConfigTest extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		QueryUser_Equipment queryUserEquipment = new QueryUser_Equipment();
		
		User_Equipment expected = EntityCreator.getUser_Equipment(990, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test", "test", "test");
		
		PersistenceUtil.persist(expected);
		User_Equipment result = (User_Equipment) queryUserEquipment.findRowById(expected.getUser_EquipmentId());
		PersistenceUtil.remove(expected);
		
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
		
		QueryUser_Equipment queryUserEquipment = new QueryUser_Equipment();
		
		TableRow row = EntityCreator.getUser_Equipment(991, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		TableRow row2 = EntityCreator.getUser_Equipment(992, "Galaxy", "Samsung", "GSM 1800, GSM 900, GSM 850",
				"Galaxy", "Samsung", "test2", "test2", "test2");
		
		PersistenceUtil.persist(row);
		PersistenceUtil.persist(row2);
		
		List<TableRow> expected = new ArrayList<TableRow>();
		expected.add(row);
		expected.add(row2);
		
		List<TableRow> result = queryUserEquipment.findAllRows();
		
		PersistenceUtil.remove(row);
		PersistenceUtil.remove(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
	}

}
