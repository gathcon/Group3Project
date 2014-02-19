package validation;
/**
 * Write a description of class ReadIt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadIt
{
   HSSFWorkbook workBook;
    HSSFCell cell;
    HSSFSheet sheet;
    BaseDataValidator validator;
    BaseDataTableReader reader;
    ErrorLogger l;
    HSSFRow row;
    Loader loader;
    public ReadIt() throws IOException {
//        workBook = new HSSFWorkbook(new FileInputStream("ericsson.xls"));
//        sheet = workBook.getSheet("Base Data");
//        l = new ErrorLogger();
//        reader = new BaseDataTableReader(workBook, l);
//        
//        reader.readSingleColumn(sheet, "failure", 2);
//      
    	loader = new Loader();
    	loader.loadFile("TestData.xls");
    	
        
        
    }
    
    public static void main(String[] args) throws IOException {
        new ReadIt();
    }

}
