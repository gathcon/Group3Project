package tableTests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.FailureConfig;
import model.Failure;

public class TestBaseDataTable {
	
	@Test
	public void testBaseDataTable() {
		FailureConfig failureConfig = new FailureConfig();
		
		int id = 10;
		String description = "This is a test description";
		
		failureConfig.createFailure(id, description);
		Failure failure = failureConfig.getFailureById(id);
		failureConfig.deleteFailure(id);
		
		assertNotNull(failure);
		assertEquals(description, failure.getDescription());
	}

}
