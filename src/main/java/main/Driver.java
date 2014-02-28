package main;

import reader.Loader;
import java.io.IOException;
public class Driver
{
    Loader loader;
    public Driver() throws IOException {
    
    	loader = new Loader();
    	loader.loadFile("TestData.xls");
        
    }
    
    public static void main(String[] args) throws IOException {
        new Driver();
    }

}
