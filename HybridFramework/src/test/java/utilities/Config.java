package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	Properties prop;//object created
	
	//constructor for load the complete file
	public Config() {
		
		File src = new File("./Configurations/config.properties");//it refer the properties file from folder
		
		try {
			FileInputStream file=new FileInputStream(src);
			
			prop=new Properties();//instantiated Properties class
			
			prop.load(file);//to load the complete file
		}
		catch(Exception e){
			System.out.println("exception is"+e.getMessage());//for getting message in the case of exception
		}
	}
	
	//methods to get all the variables from the fila 
	public String getApplication() {
		
		String url=prop.getProperty("url");
		return url;
		
	}
	
	public String getusername() {
		
		String username=prop.getProperty("username");
		return username;
		
	}

	public String getpassword() {
	
	String password=prop.getProperty("password");
	return password;
	
	}
}
