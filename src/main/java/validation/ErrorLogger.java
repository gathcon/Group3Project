package validation;


import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell; 
import org.apache.poi.hssf.usermodel.HSSFRow; 


public class ErrorLogger implements Serializable
{
	private Vector cellVectorHolder;
	
	public ErrorLogger()
	{
		cellVectorHolder = new Vector();
	}
	
	public void addToLogVector(HSSFRow row)
	{
		try
		{
			Iterator cellIter = row.cellIterator();
			Vector cellStoreVector=new Vector();
			
			while (cellIter.hasNext())
			{
				HSSFCell myCell = (HSSFCell) cellIter.next();
				cellStoreVector.addElement(myCell);
			}
			cellVectorHolder.addElement(cellStoreVector);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void writeToFile() 
	{
		Scanner fileName = new Scanner(System.in);
		PrintWriter file;
		String name;
		Vector cellStoreVector;
		
		try
		{
			System.out.println("Please enter the name of the file: ");
			name = fileName.nextLine();
			file = new PrintWriter(name);
			for (int i = 0; i < cellVectorHolder.size(); i++)
			{
				cellStoreVector = (Vector) cellVectorHolder.elementAt(i);
				file.println();
				for (int j = 0; j < cellStoreVector.size(); j++)
				{
					HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(j);
					String stringCellValue = myCell.toString();
					file.print(stringCellValue + "\t\t");
				}
				file.println();
			}
			file.close();
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}