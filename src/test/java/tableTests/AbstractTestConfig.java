package tableTests;

import org.junit.Test;

public abstract class AbstractTestConfig {
	
	@Test
	public abstract void testCreateDeleteRow();
	
	@Test
	public abstract void testList();

}
