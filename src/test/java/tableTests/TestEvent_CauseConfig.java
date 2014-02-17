package tableTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import main.Event_CauseConfig;
import model.Event_Cause;
import model.MySqlTable;

public class TestEvent_CauseConfig extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		Event_CauseConfig Event_CauseConfig = new Event_CauseConfig();
		
		Event_Cause expected = TestData.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		
		Event_CauseConfig.createRow(expected);
		Event_Cause result = (Event_Cause) Event_CauseConfig.getRowById(expected.getId());
		Event_CauseConfig.deleteRow(expected);
		
		assertNotNull(result);
		assertEquals(expected.getDescription(), result.getDescription());
		
	}

	@Override
	public void testList() {

		Event_CauseConfig event_CauseConfig = new Event_CauseConfig();
		
		Event_Cause row = TestData.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		Event_Cause row2 = TestData.getEvent_Cause(1, 4097, "RRC CONN SETUP-UNSPECIFIED");
		
		event_CauseConfig.createRow(row);
		event_CauseConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		List<MySqlTable> result = event_CauseConfig.viewRow();
		
		event_CauseConfig.deleteRow(row);
		event_CauseConfig.deleteRow(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
		
	}



}
