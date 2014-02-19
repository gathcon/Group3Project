package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import config.FailureConfig;
import entityCreator.EntityCreator;
import model.Failure;
import model.MySqlTable;

public class TestFailureConfig extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		FailureConfig failureConfig = new FailureConfig();
		
		Failure expected = EntityCreator.getFailure(10, "Test Description");
		
		failureConfig.createRow(expected);
		Failure result = (Failure) failureConfig.getRowById(expected.getFailureId());
		failureConfig.deleteRow(expected);
		
		assertNotNull(result);
		assertEquals(expected.getDescription(), result.getDescription());
		
	}

	@Override
	public void testList() {
		
		FailureConfig failureConfig = new FailureConfig();
		
		MySqlTable row = EntityCreator.getFailure(10, "Description 1");
		MySqlTable row2 = EntityCreator.getFailure(11, "Description 2");
		
		failureConfig.createRow(row);
		failureConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		
		List<MySqlTable> result = failureConfig.viewRow();
		
		failureConfig.deleteRow(row);
		failureConfig.deleteRow(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
	}

}
