package com.test.PageObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class UtilityClass {
	
	WebDriver driver;
	static String line ="";
	
	static BufferedReader br = null;
	String file="data.config";
	
	public static String getConfigValue(String name) throws IOException{
		
		Map<String, String> config = new HashMap <String, String>();
		br = new BufferedReader(new FileReader (new File("C:/Users/vishaljauhari/workspace/git/resources/data.config")));
		while((line=br.readLine())!=null){		
			config.put(line.split("=")[0], line.split("=")[1]);
		}
		
		br.close();
		return config.get(name);
		
		
	}
	

}
