package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceUtil;
import queries.QueryOperator;
import entityCreator.EntityCreator;
import model.Operator;
import model.TableRow;

public class OperatorConfigTest extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		QueryOperator queryOperator = new QueryOperator();
		
		Operator expected = EntityCreator.getOperator(201, 4, "Ireland", "TDC-DK");
		
		PersistenceUtil.persist(expected);
		Operator result = (Operator) queryOperator.findRowById(expected.getId());
		PersistenceUtil.remove(expected);
		
		assertNotNull(result);
		assertEquals(expected.getCountry(), result.getCountry());
		assertEquals(expected.getOperatorName(), result.getOperatorName());
		
	}

	@Override
	public void testList() {
		
		QueryOperator queryOperator = new QueryOperator();
		
		Operator row = EntityCreator.getOperator(202, 4, "Ireland", "TDC-DK");
		Operator row2 = EntityCreator.getOperator(203, 4, "UK", "TDC-DK");
		
		PersistenceUtil.persist(row);
		PersistenceUtil.persist(row2);
		
		List<TableRow> expected = new ArrayList<TableRow>();
		expected.add(row);
		expected.add(row2);
		List<TableRow> result = queryOperator.findAllRows();
		
		PersistenceUtil.remove(row);
		PersistenceUtil.remove(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
		
	}

}
