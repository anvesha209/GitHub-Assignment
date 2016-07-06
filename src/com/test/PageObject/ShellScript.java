package com.test.PageObject;

import java.io.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShellScript {

	
	File file;
	public FileWriter fw;
	public PrintWriter write;
	WebDriver driver;
	public String sys_user;
	
	public String sys;
	public Process p;
	
	public ShellScript(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-control.js-git-clone-help-field.url-field.js-zeroclipboard-target")
	WebElement cloneurl;
	
	public void createShellFile() throws IOException{
		file = new File("executor.sh");
		file.createNewFile();
	    file.setExecutable(true);
	    file.setWritable(true);
		fw = new FileWriter(file.getAbsoluteFile());
		write = new PrintWriter(fw);		
		sys_user=System.getProperty("user.name");
	    System.out.println(sys_user);
	
	    sys=System.getProperty("os.name");
	    System.out.println(sys);
	}
	
	
	
	public void execute() throws IOException, InterruptedException{
		
		PrintWriter writer;
    	file = new File("executor.bat");
    	file.createNewFile();
        file.setExecutable(true);
        file.setWritable(true);
    	fw = new FileWriter(file.getAbsoluteFile());
    	writer = new PrintWriter(fw);
    	String repname=UtilityClass.getConfigValue("repository");
		String url=cloneurl.getAttribute("value");
		String user=UtilityClass.getConfigValue("usernamescript");
		String pass=UtilityClass.getConfigValue("passwordscript");
    	writer.println("C:");
    	writer.println("cd users");
        writer.println("cd "+sys_user);
        writer.println("cd Desktop");
        writer.println("git clone "+url);
        writer.println("cd "+repname);
        writer.println("type nul > hello");
        writer.println("git add .");
        writer.println("git status");
        writer.println("git commit -m 'First Commit'");
        writer.println("git status");
        writer.println("git push http://"+user+":"+pass+"@github.com/"+user+"/"+repname+".git");
        writer.close();	
       
	
	}
	
	
	
}
