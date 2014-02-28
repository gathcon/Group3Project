package validationTests; 

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
import validation.BaseDataValidator;

import java.io.FileInputStream;
import java.io.IOException;


public class BaseDataValidatorTest
{
    HSSFWorkbook workBook;
    HSSFCell cell, cell1,cell2;
    BaseDataValidator validator;
    BaseDataValidator spyValidator;
    HSSFSheet sheet;
    String workbook1;
    String workbook2;
    

    public BaseDataValidatorTest(){
        workbook1 = "TestData.xls";
        workbook2 = "work.xls";
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws IOException{
        
        workBook = new HSSFWorkbook(new FileInputStream("TestData.xls"));
        validator = new BaseDataValidator(workBook);
    }
    
    
    @Test
    public void testSingleColumnCheckGoodCell(){
        cell = workBook.getSheet("Base Data").getRow(1).getCell(2);
        //assertNotNull(cell);
        assertTrue(validator.singleColumnCheck(cell, "Failure Class Table"));
        //assertEquals(2.00, 1.00 + cell.getNumericCellValue(),0.00);
    }
    
    @Test
    public void testSingleColumnCheckNullInBracketsCell(){
        cell = workBook.getSheet("Base Data").getRow(4).getCell(2);
        assertFalse(validator.singleColumnCheck(cell, "Failure Class Table"));
    }   
    
    
    @Test
    public void testSingleColumnNumericCellFromWrongColumn(){
        cell = workBook.getSheet("Base Data").getRow(4).getCell(4);
        assertFalse(validator.singleColumnCheck(cell, "Failure Class Table"));
    }  
    
    @Test
    public void testSingleColumnStringCellFromWrongColumn(){
        cell = workBook.getSheet("Base Data").getRow(4).getCell(9);
        assertFalse(validator.singleColumnCheck(cell, "Failure Class Table"));
    }     
    
    @Test
    public void testSingleColumnNullCell(){
        cell = null;
        assertTrue(validator.singleColumnCheck(cell, "Failure Class Table"));
    } 
    
    
  
    @Test
    public void testSingleColumnWithAWorksheetTitleDifferentToWhatsThere(){
        //will most likely produce a null sheet error without 
        //guarding check for null This is not ideal.
         cell = workBook.getSheet("Base Data").getRow(4).getCell(9);
         assertFalse(validator.singleColumnCheck(cell, ""));
        
    }
    
     
    @Test
    public void testSingleColumnWithAPassedInSheetWithRemovedRows(){
        // DON'T NEED TO WORRY ABOUT MANIPULATING WORKBOOK
        // WILL CALL SETUP BEFORE EACH TEST
        
        // get workbook, get sheet, remove rows from said sheet
        // pass to for loop to see what happens
        sheet = workBook.getSheet("UE Table");
        HSSFRow row = sheet.getRow(72);
        sheet.removeRow(row);
        
        cell = workBook.getSheet("Base Data").getRow(12).getCell(2);
        assertFalse(validator.singleColumnCheck(cell, "UE Table"));
    }   
    
    @Ignore
    @Test
    public void testSingleRemoveAllRows(){
        //sheet = workBook.getSheet("UE Table");
    }
    
    @Ignore
    @Test
    public void testSingleColumnNullSheet(){
        //this statement was alright, the cell statement threw
        //an error because the sheet was null. 
        //i wanted to test a null sheet sheet!= null stops this.
        //how would i do that. by passing in a blank workbook to Validator
        sheet = workBook.getSheet("Sheet1");
        //cell = sheet.getRow(0).getCell(0);
        //is a workbook with no
   
    } 
    
    @Test
    public void testDualColumnCheckWithTwoGoodValues(){
        cell1 = workBook.getSheet("Base Data").getRow(6).getCell(4);
        cell2 = workBook.getSheet("Base Data").getRow(6).getCell(5);
        assertTrue(validator.dualColumnCheck(cell1, cell2, "MCC - MNC Table"));
    } 
    
   @Test
   public void testDualColumnCheckWithFirstColumnBadValue(){
        cell1 = workBook.getSheet("Base Data").getRow(6).getCell(1);
        cell2 = workBook.getSheet("Base Data").getRow(6).getCell(5);
        assertFalse(validator.dualColumnCheck(cell1, cell2, "MCC - MNC Table"));
   }  
   
   @Test
   public void testDualColumnCheckWithSecondColumnBadValue(){
        cell1 = workBook.getSheet("Base Data").getRow(6).getCell(4);
        cell2 = workBook.getSheet("Base Data").getRow(6).getCell(1);
        assertFalse(validator.dualColumnCheck(cell1, cell2, "MCC - MNC Table"));
   } 
   
   @Test
   public void testDualColumnCheckWithTwoBadValue(){
        cell1 = workBook.getSheet("Base Data").getRow(6).getCell(6);
        cell2 = workBook.getSheet("Base Data").getRow(6).getCell(1);
        assertFalse(validator.dualColumnCheck(cell1, cell2, "MCC - MNC Table"));
   }  
   
   @Ignore
   @Test
   public void testDualWithFirstCellNull(){
        cell1 = null;
        cell2 = workBook.getSheet("Base Data").getRow(6).getCell(5);
        assertFalse(validator.dualColumnCheck(cell1, cell2, "MCC - MNC Table"));
    
   }
   
   @Test
   public void testDualWithNullSheet(){
       cell1 = workBook.getSheet("Base Data").getRow(6).getCell(4);
       cell2 = workBook.getSheet("Base Data").getRow(6).getCell(5);
       assertFalse(validator.dualColumnCheck(cell1, cell2, ""));
   }
   
   @Ignore
   @Test
   public void testDualWithSecondCellNull(){
        cell1 = workBook.getSheet("Base Data").getRow(6).getCell(4);
        cell2 = null;
        assertFalse(validator.dualColumnCheck(cell1, cell2, "MCC - MNC Table"));
   }
    
   @Ignore
   @Test
   public void testDualWithSheetValuesAsStrings(){
       //that will most likely throw an error
       //hardcoded the columns to check
       //not sure what other way to do it.
       //pass em' in? 
   }
   
    
   @Ignore
   @Test
   public void testAddtionTwoGoodValues(){
        cell1 = workBook.getSheet("Base Data").getRow(6).getCell(4);
        cell2 = workBook.getSheet("Base Data").getRow(6).getCell(5);
        double one = cell1.getNumericCellValue();
        double two = cell2.getNumericCellValue();
        double three = one + two; 
        assertEquals(870.00, three, 0.00);
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
