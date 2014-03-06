package tableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceUtil;
import queries.QueryUser;
import entityCreator.EntityCreator;
import model.User;
import model.TableRow;

public class UserConfigTest extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		QueryUser queryUser = new QueryUser();
		
		User expected = EntityCreator.getUser("Eoin", "password", "Administrator");
		
		PersistenceUtil.persist(expected);
		User result = (User) queryUser.findRowById(expected.getUserName());
		PersistenceUtil.remove(expected);
		
		assertNotNull(result);
		assertEquals(expected.getPassword(), result.getPassword());
		
	}

	@Override
	public void testList() {
		
		QueryUser queryUser = new QueryUser();
		
		TableRow row = EntityCreator.getUser("Conor", "password2", "System Administrator");
		TableRow row2 = EntityCreator.getUser("Tony", "password3", "Customer Service Rep");
		
		PersistenceUtil.persist(row);
		PersistenceUtil.persist(row2);
		
		List<TableRow> expected = new ArrayList<TableRow>();
		expected.add(row);
		expected.add(row2);
		
		List<TableRow> result = queryUser.findAllRows();
		
		PersistenceUtil.remove(row);
		PersistenceUtil.remove(row2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
	}

}
