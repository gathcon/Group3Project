package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceUtil;
import queries.QueryFailure;
import entityCreator.EntityCreator;
import model.Failure;
import model.TableRow;

public class FailureConfigTest extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		QueryFailure queryFailure = new QueryFailure();
		
		Failure expected = EntityCreator.getFailure(10, "Test Description");
		
		PersistenceUtil.persist(expected);
		Failure result = (Failure) queryFailure.findRowById(expected.getFailureId());
		PersistenceUtil.remove(expected);
		
		assertNotNull(result);
		assertEquals(expected.getDescription(), result.getDescription());
		
	}

	@Override
	public void testList() {
		
		QueryFailure queryFailure = new QueryFailure();
		
		TableRow row = EntityCreator.getFailure(10, "Description 1");
		TableRow row2 = EntityCreator.getFailure(11, "Description 2");
		
		PersistenceUtil.persist(row);
		PersistenceUtil.persist(row2);
		
		List<TableRow> expected = new ArrayList<TableRow>();
		expected.add(row);
		expected.add(row2);
		
		List<TableRow> result = queryFailure.findAllRows();
		
		PersistenceUtil.remove(row);
		PersistenceUtil.remove(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
	}

}
