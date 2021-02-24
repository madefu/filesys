package com.mdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class CleanFSTool {
	
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		File f = new File("D:\\LongFor\\code");
		findMatchingFiles(Arrays.asList(f.listFiles()));
	}

	private static FileSystem FS = FileSystems.getDefault();
	
	//清除同一目录下的重复文件
	static void findMatchingFiles(List<File> files) throws FileNotFoundException, IOException
	{
	    HashMap<String, String> hashmap = new HashMap<String, String>(2048);
	    for(File file : files)
	    {
	    	if(file.isDirectory()) {
	    		//递归
	    		findMatchingFiles(Arrays.asList(file.listFiles()));
	    		continue;
	    	}
	    	
	    	String filepath = file.getAbsolutePath();
	    	
	    	FileInputStream f = new FileInputStream(filepath);
	    	if(f.read()<0) {
	    		System.out.printf("空文件: %s \n\r",filepath);
	    		f.close();
	    		continue;
	    	}else {
	    		f.close();
	    	}
	    	FileInputStream f2 = new FileInputStream(filepath);
	        String md5 = DigestUtils.md5Hex(f2); // see linked answer
	        f2.close();
	        if(hashmap.containsKey(md5))
	        {
	             String original = hashmap.get(md5);
	             String duplicate = filepath;
	             
	             System.out.printf("%s,[dup]%s,\n\r",original,duplicate);
	             // found a match between original and duplicate
//	             Path p = FS.getPath(duplicate);
//	             System.out.println("deleted "+Files.deleteIfExists(p)+ " : "+duplicate);
	        }
	        else
	        {
	             hashmap.put(md5, filepath);
	        }
	    }
	}
	
}
