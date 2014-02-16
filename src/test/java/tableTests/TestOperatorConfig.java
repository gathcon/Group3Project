package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.OperatorConfig;
import model.Operator;
import model.MySqlTable;
import model.OperatorPK;

public class TestOperatorConfig extends AbstractTestConfig {

	public void testCreateDeleteRow() {
		
		OperatorConfig operatorConfig = new OperatorConfig();
		
		int mcc = 201;
		int mnc = 4;
		
		OperatorPK id = new OperatorPK(mcc, mnc);
		String country = "Ireland";
		String operatorName = "TDC-DK";
		
		Operator row = new Operator();
		row.setId(id);
		row.setCountry(country);
		row.setOperatorName(operatorName);
		
		operatorConfig.createRow(row);
		Operator Operator = (Operator) operatorConfig.getRowById(id);
		operatorConfig.deleteRow(row);
		
		assertNotNull(Operator);
		assertEquals(country, Operator.getCountry());
		assertEquals(operatorName, Operator.getOperatorName());
		
	}

	public void testList() {
		
		OperatorConfig OperatorConfig = new OperatorConfig();
		
		int mcc = 201;
		int mnc = 4;
		
		OperatorPK id = new OperatorPK(mcc, mnc);
		String country = "Ireland";
		String operatorName = "TDC-DK";
		
		Operator row = new Operator();
		row.setId(id);
		row.setCountry(country);
		row.setOperatorName(operatorName);
		
		int mcc2 = 202;
		int mnc2 = 4;
		
		OperatorPK id2 = new OperatorPK(mcc2, mnc2);
		String country2 = "England";
		String operatorName2 = "TDC-UK";
		
		Operator row2 = new Operator();
		row2.setId(id2);
		row2.setCountry(country2);
		row2.setOperatorName(operatorName2);
		
		OperatorConfig.createRow(row);
		OperatorConfig.createRow(row2);
		
		List<MySqlTable> expected = new ArrayList<MySqlTable>();
		expected.add(row);
		expected.add(row2);
		List<MySqlTable> rows = OperatorConfig.viewRow();
		
		OperatorConfig.deleteRow(row);
		OperatorConfig.deleteRow(row2);
		
		assertNotNull(rows);
		assertEquals(expected.size(), rows.size());
		
	}

}
