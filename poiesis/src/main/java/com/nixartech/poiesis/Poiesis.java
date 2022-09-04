package com.nixartech.poiesis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nixartech.poiesis.subcommands.About;
import com.nixartech.poiesis.subcommands.CrtApp;
import com.nixartech.poiesis.subcommands.DplApp;
import com.nixartech.poiesis.subcommands.GenCde;
import com.nixartech.utils.I18n;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;

@Command(
	name = "poiesis", 
	version = "Poiesis 1.0", 
	mixinStandardHelpOptions = true,
	subcommands = {
		About.class,
		CrtApp.class,
		GenCde.class,
		DplApp.class,
	}) 
public class Poiesis implements Runnable { 
    
    private static I18n i18n;
	
    public void run() { 
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
	System.out.println("Poiesis....");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Poiesis()).execute(args); 
        System.exit(exitCode); 
    }
    
    static public void abort(String message, String ... args) {
	message = getI18n().text(message,args);
	String msg = Ansi.AUTO.string("@|bold,red "+message+"|@");
	System.out.println(msg);
	System.exit(1);
}



/**
 * Show a i18n message
 * @param string
 */
public static void say(String message, String ... args) {
	message = getI18n().text(message, args);
	System.out.println(message);
}

/**
 * Ask for a value and return it as string
 * 
 * @param message
 * @param args
 * @return String value
 * @throws IOException 
 */
public static String ask(String message, String ... args) throws IOException {
	message = getI18n().text(message, args);
	System.out.println(message);

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	return reader.readLine();
}

/**
 * Print a message without i18n translation
 * 
 * @param message
 * @param args
 */
public static void print(String message, String ... args) {
	
	System.out.println(message);
}

public static I18n getI18n() {
	return i18n;
}

public static void setI18n(I18n i18n) {
	Poiesis.i18n = i18n;
}
}