package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.OperatorConfig;
import model.Operator;
import model.MySqlTable;

public class TestOperatorConfig extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		OperatorConfig operatorConfig = new OperatorConfig();
		
		Operator expected = TestData.getOperator(201, 4, "Ireland", "TDC-DK");
		
		operatorConfig.createRow(expected);
		Operator result = (Operator) operatorConfig.getRowById(expected.getId());
		operatorConfig.deleteRow(expected);
		
		assertNotNull(result);
		assertEquals(expected.getCountry(), result.getCountry());
		assertEquals(expected.getOperatorName(), result.getOperatorName());
		
	}

	@Override
	public void testList() {
		
		OperatorConfig OperatorConfig = new OperatorConfig();
		
		Operator row = TestData.getOperator(202, 4, "Ireland", "TDC-DK");
		Operator row2 = TestData.getOperator(203, 4, "UK", "TDC-DK");
		
		OperatorConfig.createRow(row);
		OperatorConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		List<MySqlTable> result = OperatorConfig.viewRow();
		
		OperatorConfig.deleteRow(row);
		OperatorConfig.deleteRow(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
		
	}

}
