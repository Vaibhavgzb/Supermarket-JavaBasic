package com.project.items;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadItem {
	
	/**
	 * This Method is used to Read and Print All Items
	 * 
	 * @throws IOException
	 */
	public void readItem() throws IOException {

		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		
		try {
			File file = new File("marketItems.txt");
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			
			String lineRead;
			
			System.out.println("ID    NAME   QUANTITY   DATE");
			System.out.println("---   -----   -------   ----\n");
			
			if (file.length() == 0) {
				System.out.println("Sorry ! Item is not Available in Store\n");
			} else {
				while ((lineRead = bufferReader.readLine()) != null) {
					System.out.println(lineRead);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			bufferReader.close();
			fileReader.close();
		}
	}


}
