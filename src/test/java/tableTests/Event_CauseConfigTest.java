package tableTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceUtil;
import queries.QueryEvent_Cause;
import entityCreator.EntityCreator;
import model.Event_Cause;
import model.TableRow;

public class Event_CauseConfigTest extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		QueryEvent_Cause queryEventCause = new QueryEvent_Cause();
		
		Event_Cause expected = EntityCreator.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		
		PersistenceUtil.persist(expected);
		Event_Cause result = (Event_Cause) queryEventCause.findRowById(expected.getId());
		PersistenceUtil.remove(expected);		
		assertNotNull(result);
		assertEquals(expected.getDescription(), result.getDescription());
		
	}

	@Override
	public void testList() {

		QueryEvent_Cause queryEventCause = new QueryEvent_Cause();
		
		Event_Cause row = EntityCreator.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		Event_Cause row2 = EntityCreator.getEvent_Cause(1, 4097, "RRC CONN SETUP-UNSPECIFIED");
		
		PersistenceUtil.persist(row);
		PersistenceUtil.persist(row2);
		
		List<TableRow> expected = new ArrayList<TableRow>();
		expected.add(row);
		expected.add(row2);
		List<TableRow> result = queryEventCause.findAllRows();
		
		PersistenceUtil.remove(row);
		PersistenceUtil.remove(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
		
	}

}
