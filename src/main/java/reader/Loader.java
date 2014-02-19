package reader;

import java.io.FileInputStream;
import java.io.IOException;

import logger.ErrorLogger;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import convertedRow.ConvertedRow;
import convertedRow.RowConverter;
import entityCreator.EntityCreator;
import entityCreator.EntityType;

public class Loader {
	
	private DomainTableReader reader;
	private BaseDataTableReader baseReader;
	private ErrorLogger errorLogger;
	
	public Loader(){
		errorLogger = new ErrorLogger();
	}
	
	public void loadFile(String excelWorkBookLocation)  {
		try {
			HSSFWorkbook workBook = getFileFrom(excelWorkBookLocation);
			if(workBook==null){return;}
			readAll(workBook);
			readBaseData(workBook);
			errorLogger.writeToFile();
			//createNumbers(workbook);
			//createEntities(workBook);
		} catch (IOException e) {
			System.out.println("Couldn't find the file at: " + excelWorkBookLocation);
		}
	}

	public HSSFWorkbook getFileFrom(String excelWorkBookLocation) throws IOException  {
		return new HSSFWorkbook(new FileInputStream(excelWorkBookLocation));
	}
	
	public void readAll(HSSFWorkbook workBook) {
		reader = new DomainTableReader(errorLogger);
		for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
			HSSFSheet sheet = workBook.getSheetAt(i);
			reader.read(sheet);
		}			
	}
	
	public void readBaseData(HSSFWorkbook workBook) {
		baseReader = new BaseDataTableReader(workBook, errorLogger);
		baseReader.read();
	}

	public void createEntities(HSSFWorkbook workBook) {
		
		if(workBook==null){return;}
		createEntitiesFor(workBook.getSheet("Failure Class Table"), EntityType.FAILURE);
		createEntitiesFor(workBook.getSheet("Event-Cause Table"), EntityType.EVENTCAUSE);
		createEntitiesFor(workBook.getSheet("UE Table"), EntityType.USEREQUIPMENT);
		createEntitiesFor(workBook.getSheet("MCC - MNC Table"), EntityType.OPERATOR);
		createEntitiesFor(workBook.getSheet("Base Data"), EntityType.BASEDATA);
	}
	
	public void createEntitiesFor(HSSFSheet sheet, EntityType e){
		EntityCreator creator;
		
		if(sheet==null){return;}
		
		for(Row r: sheet){
			HSSFRow row = (HSSFRow) r;
			
			if(row != null){
				creator = new EntityCreator();
				ConvertedRow convertedRow = new ConvertedRow();
				RowConverter converter = new RowConverter();
				convertedRow = converter.convert(row, e); 
				creator.getEntity(convertedRow);			
			} 		
		}		
	}
}
