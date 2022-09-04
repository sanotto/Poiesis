package com.nixartech.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;

public class FileSysUtils {
	
	/**
	 * Current file separator
	 */
	static public final String slash = System.getProperty("file.separator");
	
	/**
	 * system temp Dir
	 */
	static public final String tmp = System.getProperty("java.io.tmpdir");
	
	/**
	 * Retrieves if a file exists and is readable
	 * @param path
	 * @return
	 */
	public static boolean fileIsReadable(String path) {
		File fileHandler = new File(path);
		boolean isReadable = Files.isReadable(fileHandler.toPath());
 		
		return isReadable;
	}
	
	/**
	 * Set the slashes in a string denoting a path as the op sys one
	 * 
	 * @param path
	 * @return
	 */
	public static String normalizePath(String path) {
		String normalized = path;
		normalized =  path.replace("\\",	slash);
		return normalized.replace("/",	slash);
	}
	
	/**
	 * Ensure all directories in path exists create them if not
	 * 
	 * @param path
	 */
	public static void ensurePath(String path) {
		String normalizedPath = normalizePath(path);
		File dirs = new File(normalizedPath);
		if (!dirs.exists()) {
			dirs.mkdirs();
		}
	}
	/**
	 * Remove directory and it's descendants
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void removeDirectoryTree(String path) throws IOException {
		Path pathToBeDeleted = Paths.get(path);
		 
	    Files.walk(pathToBeDeleted)
	      .sorted(Comparator.reverseOrder())
	      .map(Path::toFile)
	      .forEach(File::delete);
	}
	
	/** 
	 * Reads a file and return it as a LinkedList of strings
	 * 
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public static LinkedList<String> readAllLines(String path) throws IOException {
		LinkedList<String> lines = new LinkedList<String>();
		String filename = normalizePath(path);
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line= reader.readLine();
		while(line != null) {			
			lines.add(line);
			line= reader.readLine();
		}
		
		reader.close();
		return lines;
	}
	
	 
 	/**
	 * Saves nodes in a LinkedList of strings into a file
	 * 
	 * @param lines
	 * @param path
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void putAllLines(LinkedList<String> lines, String path) throws FileNotFoundException, UnsupportedEncodingException {
		String filename = normalizePath(path);
		PrintWriter writer = new PrintWriter(filename,"UTF-8");
		for(String line: lines) {
			writer.write(line+"\n");
		}
		writer.close();				
	}	
	
	/**
	 * Returns a String array with the path divided in base[0], filename[1], and ext[2]
	 * @param path
	 * @return String array
	 */
	public static String[] getPathElements(String path) {
		String normalizedPath = normalizePath(path);
		
		int sep = normalizedPath.lastIndexOf(slash);		 
	    int dot = normalizedPath.lastIndexOf(".");
	    
	    String[] parts= new String[3];
		parts[2]=normalizedPath.substring(dot + 1);			  
		parts[1]=normalizedPath.substring(sep + 1, dot);
		parts[0]=normalizedPath.substring(0, sep);
			  
		return parts;
	}
	
	/**
	 * Retrieve path's base path
	 * @param path
	 * @return
	 */
	public static String pathBasePath(String path) {
		return getPathElements(path)[0];
	}
	
	/**
	 * Retrieve path's filename
	 * @param path
	 * @return
	 */
	public static String pathFilename(String path) {
		return getPathElements(path)[1];
	}
	
	/**
	 * Retrieve path's extension
	 * @param path
	 * @return
	 */
	public static String pathExtension(String path) {
		return getPathElements(path)[2];
	}

	/**
	 * Delete a file 
	 * 
	 * @param file
	 * @return
	 */
	public static boolean delete(String file) {
		File f= new File(file);            
		return f.delete();
		
	}
	

    public static LinkedList<String> getFileFromResourcesAsList(String resource) throws IOException {
        
        // this is the path within the jar file
        InputStream input = FileSysUtils.class.getResourceAsStream( resource);
        if (input == null) {
            // this is how we load file within editor (eg eclipse)
            input = FileSysUtils.class.getClassLoader().getResourceAsStream(resource);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        
        LinkedList<String> lines = new LinkedList<String>();
        String line = null;
         
        while ((line = br.readLine()) != null) {            
            lines.add(line);
        }
        br.close();
        return lines;
    }
    
    /**
     * Writes string to file
     * 
     * @param dataString
     * @param path 
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     */
	public static void putStringToFile(String dataString, String path) throws FileNotFoundException, UnsupportedEncodingException {
		
		String filename = normalizePath(path);
		PrintWriter writer = new PrintWriter(filename,"UTF-8");
		writer.write(dataString);		
		writer.close();
		
	}
    
}
