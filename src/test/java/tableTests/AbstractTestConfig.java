package tableTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.PersistenceUtil;
import entityCreator.EntityType;

public abstract class AbstractTestConfig {
	
	@BeforeClass
	public static void cleanupBefore() {
		PersistenceUtil.removeAll(EntityType.BASEDATA);
		PersistenceUtil.removeAll(EntityType.EVENTCAUSE);
		PersistenceUtil.removeAll(EntityType.FAILURE);
		PersistenceUtil.removeAll(EntityType.OPERATOR);
		PersistenceUtil.removeAll(EntityType.USEREQUIPMENT);
	}
	
	@Test
	public abstract void testCreateDeleteRow();
	
	@Test
	public abstract void testList();
	
	@AfterClass
	public static void cleanup() {
		PersistenceUtil.removeAll(EntityType.BASEDATA);
		PersistenceUtil.removeAll(EntityType.EVENTCAUSE);
		PersistenceUtil.removeAll(EntityType.FAILURE);
		PersistenceUtil.removeAll(EntityType.OPERATOR);
		PersistenceUtil.removeAll(EntityType.USEREQUIPMENT);
	}

}
