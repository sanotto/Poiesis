package com.nixartech.utils;

import java.util.ResourceBundle;

public class I18n {
	
	ResourceBundle bundle ;
	
	public I18n(String baseName) {
		bundle = ResourceBundle.getBundle(baseName);
	}
	
	/**
	 * Translate a label
	 * @param message
	 * @param args
	 * @return
	 */
	public String text(String message, String...args) {
		String translated = message;
		try {
			translated = bundle.getString(message.replace(" ","_"));
		}catch (Exception e) {
		 //System.out.println(e.getMessage());	
		}
				
		message = String.format(translated, (Object[]) args);
		return message;
	}
	
}
