package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.FailureConfig;
import model.Failure;
import model.MySqlTable;

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
	
	@Test
	public void testQueryFailure() {
		
		FailureConfig failureConfig = new FailureConfig();
		
		int id = 10;
		String description = "This is a test description";
		
		MySqlTable row = new Failure();
		((Failure) row).setFailureId(id);
		((Failure) row).setDescription(description);
		
		int id2 = 11;
		String description2 = "This is another test description";
		
		MySqlTable row2 = new Failure();
		((Failure) row2).setFailureId(id2);
		((Failure) row2).setDescription(description2);
		
		failureConfig.createRow(row);
		failureConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		List<MySqlTable> rows = failureConfig.viewRow();
		
		failureConfig.deleteRow(row);
		failureConfig.deleteRow(row2);
		
		assertNotNull(rows);
		assertEquals(expected, rows);
	}

}
