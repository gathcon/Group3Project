//package acceptanceTests;
//
//import static org.junit.Assert.*;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.Ignore;
//
//import persistence.PersistenceUtil;
//import entityCreator.EntityType;
//import queries.*;
//import reader.Loader;
//
//public class AcceptanceTest {
//	
//	Loader loader;
//	String fromDirectory;
//	boolean tablesAreNotEmpty, thereIsAnErrorLog;
//	int[] rowsInSheets;
//
//	@Before
//	public void setUp() throws Exception {
//		loader = new Loader();
//		fromDirectory = "TestData.xls";
//	}
//
//	@Test
//	public void acceptanceTestLoadingOfImportedFilesToDatabase() {
//		loader.loadFile(fromDirectory);
//		rowsInSheets = loader.getRowsInTables();
//		
//		QueryBase_Data bd = new QueryBase_Data();
//		int basedatasize = bd.findAllRows().size();
//		
//		
//		QueryEvent_Cause ec = new QueryEvent_Cause();
//		int eventcausesize = ec.findAllRows().size();
//		System.out.println("Event cause size: "  + eventcausesize);
//		QueryFailure qf = new QueryFailure();
//		int queryfailuresize = qf.findAllRows().size();
//		System.out.println("failure size: "  + queryfailuresize);
//		
//		QueryOperator qo = new QueryOperator();
//		int queryoperatorsize = qo.findAllRows().size();
//		System.out.println("query operator size: "  + queryoperatorsize);
//		
//		QueryUser_Equipment eq = new QueryUser_Equipment();
//		int queryuserequipment = eq.findAllRows().size();
//		System.out.println("query user equipment "  + queryuserequipment);
//		
//		assertEquals(rowsInSheets[0], basedatasize);
//		assertEquals(rowsInSheets[1]-1, eventcausesize);
//		assertEquals(rowsInSheets[2]-1, queryfailuresize);
//		assertEquals(rowsInSheets[3]-1, queryuserequipment);
//		assertEquals(rowsInSheets[4]-1, queryoperatorsize);
//		
//		
//		
//	}
//	
//	@Ignore
//	@Test
//	public void acceptanceTestLoadingOfDataProducesErrorLog() {
//		loader.loadFile(fromDirectory);
//		thereIsAnErrorLog = true;
//		assertTrue(thereIsAnErrorLog);
//	}
//	
//	@AfterClass
//	public static void cleanup() {
//		PersistenceUtil.removeAll(EntityType.BASEDATA);
//		PersistenceUtil.removeAll(EntityType.EVENTCAUSE);
//		PersistenceUtil.removeAll(EntityType.FAILURE);
//		PersistenceUtil.removeAll(EntityType.OPERATOR);
//		PersistenceUtil.removeAll(EntityType.USEREQUIPMENT);
//	}
//
//
//}
