package com.project.items;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RemoveItem {
	
	/**
	 * This Methods is Used to Remove Item .
	 * 
	 * @throws IOException
	 */
	public void removeItem() throws IOException {
		
		String id = "";
		String name = "";
		String quantity = "";
		String date = "";
		
		FileWriter fileWriter = null;
		BufferedWriter bufferWriter = null;
		
		Scanner keyboard = new Scanner(System.in);
		
		String filePath = "marketItems.txt";
		System.out.println(" Enter ID you want to remove =");
		String removeTerm = keyboard.next();
		
		String tempFile = "myTempFile.txt";
		
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		
		boolean flag = false;

		try {
			fileWriter = new FileWriter(tempFile, true);
			bufferWriter = new BufferedWriter(fileWriter);
			
			keyboard = new Scanner(new File(filePath));

			// Use Delimiter
			keyboard.useDelimiter("[	\n]");

			while (keyboard.hasNext()) {
				
				id=keyboard.next();
				name = keyboard.next();
				quantity = keyboard.next();
				date = keyboard.next();
				
				if (!id.equalsIgnoreCase(removeTerm)) {
					bufferWriter.write(id + "	" + name + "	" + quantity + "	" + date);
					bufferWriter.write("\n");
				} else {
					flag = true;
					System.out.println("Item is Delete Successfully");
				}
			}
			
			if (flag != true) {
				System.out.println("No such name found");
			}
			
			// Delete Old File marketItems.txt
			oldFile.delete();
			
			File Dump = new File(filePath);
			// Rename Old File To New File
			newFile.renameTo(Dump);
			
		} catch (Exception exception) {
			System.out.println(exception);
		} finally {
			bufferWriter.flush(); 
			keyboard.close();
			bufferWriter.close();
			fileWriter.close();
		}

	}

}
