package com.project.items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddItem {

	/**
	 * This Method is used to Add Item in Super Market .
	 *
	 * @throws IOException
	 */
	public void addItem() throws IOException {
		
		int id =1 ;
		boolean flag = true;
		
		/*
		 * It is use to Read Last line and
		 * store in id 
		 */
		FileReader fileReader = new FileReader("marketItems.txt");
		 BufferedReader bufferReader = new BufferedReader(fileReader);
		 String lineRead;
		 
		 while ((lineRead = bufferReader.readLine()) != null) {
		
			String split[] = lineRead.split("\n");
			
			String lastLine = split[split.length-1];
			
			char ch = lastLine.charAt(0);
			
			id = Character.getNumericValue(ch);
		 }
		 
		do
		{
			
			String name = "";
			int quantity;
			String date = "";
			
			BufferedWriter bufferWriter = null;
			FileWriter fileWriter = null;
			PrintWriter printItem = null;
			
			Scanner keyboard = new Scanner(System.in);
			
			try {
				File file = new File("marketItems.txt");
				fileWriter = new FileWriter(file, true);
				bufferWriter = new BufferedWriter(fileWriter);
				printItem = new PrintWriter(bufferWriter);
						
				
//				// Calling to Print all Items
//				readItem();
				
				System.out.println(" Enter the Details of Item.......");
				System.out.print(" Enter Name = ");
				name = keyboard.nextLine();
	
				System.out.print(" Enter Quantity = ");
				quantity = keyboard.nextInt();
	
				System.out.print(" Enter Date (dd/mm/yyy) = ");
				date = keyboard.next();


				if(file.length() == 0)
				{
					printItem.print(id++);
					printItem.print("	" + name);
					printItem.print("	" + quantity);
					printItem.print("	" + date);
					
					printItem.println();
		
				}
				else
				{
					
					printItem.print(++id);
					printItem.print("	" + name);
					printItem.print("	" + quantity);
					printItem.print("	" + date);
					
					printItem.println();
					
					
				}
	
				System.out.println("\nAdd Item Successfully ");
				
				flag= false;
				
			} catch (InputMismatchException exception) {
				System.out.println("Input Mismatch Please Try Again! \n");
			} finally {
				bufferWriter.close();
				fileWriter.close();
				bufferReader.close();
			}
			
		} while (flag != false);

	}

}
