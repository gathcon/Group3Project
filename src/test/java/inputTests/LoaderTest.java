package inputTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import persistence.PersistenceUtil;
import entityCreator.EntityType;
import reader.Loader;
import validation.BaseDataValidator;

public class LoaderTest {
	
	Loader loader;
	HSSFWorkbook workBook;
    HSSFCell cell, cell1,cell2;
    BaseDataValidator validator;
	
	@Before
	public void setUp() throws IOException{
	    loader = new Loader();
	    workBook = new HSSFWorkbook(new FileInputStream("TestData.xls"));
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
	
	@Ignore
	@Test
	public void testCreateEntitiesForPassInGoodSheet(){
		loader.createEntitiesFor(workBook.getSheet("Base Data"),EntityType.BASEDATA);
	}

	@Ignore
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
	
	@AfterClass
	public static void cleanup() {
		PersistenceUtil.removeAll(EntityType.BASEDATA);
		PersistenceUtil.removeAll(EntityType.EVENTCAUSE);
		PersistenceUtil.removeAll(EntityType.FAILURE);
		PersistenceUtil.removeAll(EntityType.OPERATOR);
		PersistenceUtil.removeAll(EntityType.USEREQUIPMENT);
	}
}
