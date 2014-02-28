package validationTests;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceUtil;
import entityCreator.EntityType;
import reader.Loader;
import validation.DomainTableValidator;

public class DomainValidatorTest {

	
	HSSFWorkbook workBook;
    
    DomainTableValidator validator;
    Loader l;
   
    String workbook1;
    String workbook2;
    
    
    public DomainValidatorTest(){
        workbook1 = "TestData.xls";
        workbook2 = "TestDataSample.xls";
        
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws IOException{
        
        workBook = new HSSFWorkbook(new FileInputStream(workbook2));
        validator = new DomainTableValidator();
        l = new Loader();
        l.readAll(workBook);
        
    }
    
    
    @Test
    public void testNumberOfRowsLeftInBaseData(){
    	int goodRowsAfterValidation = workBook.getSheetAt(0).getPhysicalNumberOfRows();
        assertTrue(goodRowsAfterValidation == 2);
        //1 Good row of data per workbook and the column headers row
        
    }
    
    @Test
    public void testNumberOfRowsLeftInEventCause(){
    	int goodRowsAfterValidation = workBook.getSheetAt(1).getPhysicalNumberOfRows();
        assertTrue(goodRowsAfterValidation == 2);
        //1 Good row of data per workbook and the column headers row
        
    }
    
    @Test
    public void testNumberOfRowsLeftInFailureCause(){
    	int goodRowsAfterValidation = workBook.getSheetAt(2).getPhysicalNumberOfRows();
        assertTrue(goodRowsAfterValidation == 2);
        //1 Good row of data per workbook and the column headers row
      
    }
    
    @Test
    public void testNumberOfRowsLeftInUserEquipment(){
    	 int goodRowsAfterValidation = workBook.getSheetAt(3).getPhysicalNumberOfRows();
        assertTrue(goodRowsAfterValidation == 2);
        //1 Good row of data per workbook and the column headers row
        
    }
    
    @Test
    public void testNumberOfRowsLeftInOperator(){
    	int goodRowsAfterValidation = workBook.getSheetAt(4).getPhysicalNumberOfRows();
    	System.out.println("/n/n/nAfter: " + goodRowsAfterValidation);
        assertTrue(goodRowsAfterValidation == 2);
        //1 Good row of data per workbook and the column headers row
        
    }
    
    @AfterClass
	public static void cleanup() {
		PersistenceUtil.removeAll(EntityType.BASEDATA);
		PersistenceUtil.removeAll(EntityType.EVENTCAUSE);
		PersistenceUtil.removeAll(EntityType.FAILURE);
		PersistenceUtil.removeAll(EntityType.OPERATOR);
		PersistenceUtil.removeAll(EntityType.USEREQUIPMENT);
	}
    
}
