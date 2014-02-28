package inputTests; 

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

import persistence.PersistenceUtil;
import entityCreator.EntityType;
import reader.BaseDataTableReader;
import validation.BaseDataValidator;

import java.io.FileInputStream;
import java.io.IOException;

import logger.ErrorLogger;

public class BaseDataTableReaderTest
{
    HSSFWorkbook workBook;
    HSSFCell cell;
    HSSFSheet sheet;
    BaseDataValidator validator;
    BaseDataTableReader reader;
    ErrorLogger l;
    HSSFRow row;
    
    
    public BaseDataTableReaderTest(){

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */

    @Before
    public void setUp() throws IOException {
        workBook = new HSSFWorkbook(new FileInputStream("TestData.xls"));
        sheet = workBook.getSheet("Base Data");
        l = new ErrorLogger();
        reader = new BaseDataTableReader(workBook, l);
    }
    
    @Test
    public void testReadSingleColumnWithFailureClassColumnData(){
        int numberOfRowsBefore = sheet.getPhysicalNumberOfRows();
        reader.readSingleColumn(sheet, "failure", 2);
        int numberOfRowsAfter = sheet.getPhysicalNumberOfRows();
        assertFalse(numberOfRowsBefore == numberOfRowsAfter);
    }
    
   @Test
    public void testReadTwoColumnWithMCMNCColumnData(){
        int numberOfRowsBefore = sheet.getPhysicalNumberOfRows();
        reader.readTwoColumns(sheet, "mccmnc", 4,5);
        int numberOfRowsAfter = sheet.getPhysicalNumberOfRows();
        assertFalse(numberOfRowsBefore == numberOfRowsAfter);
    }   
    
    @Ignore
    @Test
    public void testReadTwoColumnsWithWrongStringParameter(){
        //dangerous removes all rows from the sheet
        reader.readTwoColumns(sheet, " ", 4,5);
        assertEquals(0, sheet.getPhysicalNumberOfRows());
        
    }
    
    @Test
    public void didRemoveRowsFromSheetActuallyWork(){
    	
    	int numberOfRowsBefore = sheet.getPhysicalNumberOfRows();
    	
    	HSSFRow row1ToDelete = sheet.getRow(2);
    	HSSFRow row2ToDelete = sheet.getRow(3);
    	HSSFRow row3ToDelete = sheet.getRow(4);

    	// get rows from sheet add to arraylist
    	reader.addToRowsToDelete(row1ToDelete);
    	reader.addToRowsToDelete(row2ToDelete);
    	reader.addToRowsToDelete(row3ToDelete);

    	//pass in sheet to removeRowsFromSheetThatAreInArrayList
    	reader.removeRowsFromSheetThatAreInArrayList(sheet);
    	
    	//ASSERT
    	assertFalse(numberOfRowsBefore == sheet.getPhysicalNumberOfRows());
    	
    }
    
    @Test
    public void didClearOperationClearArrayList(){
    	HSSFRow row1ToDelete = sheet.getRow(2);
    	reader.addToRowsToDelete(row1ToDelete);
    	reader.removeRowsFromSheetThatAreInArrayList(sheet);
    	assertTrue(reader.getSizeOfArrayList() == 0);  	
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
