package inputTests;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.junit.Before;
import org.junit.Test;

import entityCreator.EntityType;
import reader.Loader;
import validation.BaseDataValidator;

public class TestLoader {
	
	Loader loader;
	HSSFWorkbook workBook;
    HSSFCell cell, cell1,cell2;
    BaseDataValidator validator;
	
	@Before
	public void setUp() throws IOException{
	    loader = new Loader();
	    workBook = new HSSFWorkbook(new FileInputStream("ericsson.xls"));
	    validator = new BaseDataValidator(workBook);
	}

	@Test
	public void testCreateEntitiesForPassInNullSheet() {
		loader.createEntitiesFor(null, EntityType.BASEDATA);
	}
	
	@Test
	public void testCreateEntitiesPassInNullWorkBook() {
		loader.createEntities(null);
	}	
	
	@Test
	public void testCreateEntitiesForPassInGoodSheet(){
		loader.createEntitiesFor(workBook.getSheet("Base Data"),EntityType.BASEDATA);
	}

	@Test
	public void testCreateEntitiesForPassInModifiedSheet(){
		// get sheet base data
		HSSFSheet sheet = workBook.getSheet("Base Data");
		HSSFRow row1 = sheet.getRow(1);
		HSSFRow row2 = sheet.getRow(2);
		sheet.removeRow(row1);
		sheet.removeRow(row2);
		// remove some rows
		// pass in 
		loader.createEntitiesFor(sheet,EntityType.BASEDATA);
	}
	
	@Test
	public void loadingFromBadFileLocation(){
		loader.loadFile("hello.xls");
	}
	
	@Test
	public void loadingFromGoodFileLocation(){
		loader.loadFile("ericsson.xls");
	}
}
