package tableTests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.FailureConfig;
import model.Failure;

public class TestFailureTable {
	
	@Test
	public void testFailureTable() {
		FailureConfig failureConfig = new FailureConfig();
		
		int id = 10;
		String description = "This is a test description";
		
		Failure row = new Failure();
		row.setFailureId(id);
		row.setDescription(description);
		
		failureConfig.createRow(row);
		Failure failure = (Failure) failureConfig.getRowById(id);
		failureConfig.deleteRow(row);
		
		assertNotNull(failure);
		assertEquals(description, failure.getDescription());
	}

}
