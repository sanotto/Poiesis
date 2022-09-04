package com.utils.nixartech.utils.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

import com.nixartech.utils.FileSysUtils;

public class FSUtilsTest {

	@Test
	public void testNormalicePath() {
		String path = "/Users/username";
		String actual = FileSysUtils.normalizePath(path);
		
		if (FileSysUtils.slash.equals("\\")) {
			assertEquals("\\Users\\username", actual);
		}
		else  {
			assertEquals("/Users/username", actual);
		}
	}

	@Test
	public void testGetPathElements() {
		String [] part =FileSysUtils.getPathElements("/users/username/myfile.ext");
		String actual = part[0];
		
		if (FileSysUtils.slash.equals("\\")) {
			assertEquals("\\users\\username", actual);
		}
		else  {
			assertEquals("/users/username", actual);
		}				
	}
	@Test
	public void testCreateDirs() throws IOException {
		String path = FileSysUtils.tmp+"/adir/anotherdir";
		FileSysUtils.ensurePath(path);
		boolean exists = FileSysUtils.fileIsReadable(path);
		assertTrue(exists);
		FileSysUtils.removeDirectoryTree(path);
		boolean existent = FileSysUtils.fileIsReadable(path);
		assertFalse(existent);
	}
	
	@Test
	public void testGetFileFromResourcesAsList() throws IOException {
		LinkedList<String> l = FileSysUtils.getFileFromResourcesAsList("com/nixartech/icmd/resources/hooks");
	}
}
