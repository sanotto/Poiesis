package com.nixartech.utils;

import java.io.File;
import java.nio.file.Files;

public class LicenseManager {

	
	public static void checkValidLicense(String appName ) throws Exception {
			
		String user_dir = System.getProperty("user.dir");
		String sep = java.nio.file.FileSystems.getDefault().getSeparator();
 		String licenseFileName = user_dir+sep+"."+appName+"_license";
 		File licenseFileHandler = new File(licenseFileName);
 		
 		boolean isReadable = Files.isReadable(licenseFileHandler.toPath());
 		
		if (isReadable) {

		}
	   
		//throw new Exception("license not found");
	}


}
