package com.project.supermarket;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.items.*;

/**
 * @author vaibhav
 */
public class SuperMarket  {

	/**
	 * This main method is used to 
	 * Read all Items , Add new Item and 
	 * Remove Existing Item
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		boolean flag = true;
		Scanner input = new Scanner(System.in);


		do {
			try {
				
				//Create a New File
				File file = new File("marketItems.txt");
				if (!file.exists()) {
					file.createNewFile();
				}
				
				ReadItem readItem = new ReadItem();
				AddItem addItem = new AddItem();
				RemoveItem removeItem = new RemoveItem();
				
				System.out.println("\n==========================\n");
				System.out.println("1. List All Items. \n2. Add New Item. \n3. Remove Existing Item. \n");
				System.out.println("Enter (0) for Exit : ");
				System.out.print("Please Enter Your Choice:  ");
				int choice = input.nextInt();
				
				switch (choice) {
				case 0:
					flag = false;
					break;
				case 1:
					// List All Item
				readItem.readItem();
					break;
				case 2:
					// Add New Item
					addItem.addItem();
					break;
				case 3:
					// Remove Existing Items
//					item.readItem();
					removeItem.removeItem();
					break;
				default:
					// Error
					System.out.println("Wrong Choice");
					break;
				}
			} catch (InputMismatchException exception) {
				System.out.println("Input is MisMatch");
				break;
				
			}
			
		} while (flag != false);
			System.out.println("Program is closed");

	}

}
