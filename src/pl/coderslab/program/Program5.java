package pl.coderslab.program;

import java.util.Scanner;

import pl.coderslab.dao.StatusDao;
import pl.coderslab.dao.User_GroupDao;
import pl.coderslab.entity.Status;
import pl.coderslab.entity.User_Group;

//Program3: tests UserGroup module

public class Program5 {
	
	public static void main(String[] args) {
		
		try {
			
			StatusDao statusdao = new StatusDao();
			boolean program_working=true;
			Scanner scan = new Scanner(System.in);
			
			while (program_working) {
				
				System.out.println("----------------------------");
				System.out.println("Choose one of the following options: ");
				System.out.println("* add - to add new status");
				System.out.println("* view - to view status by giving status id");
				System.out.println("* edit - to edit existing status");
				System.out.println("* delete - to delete existing status");
				System.out.println("* quit - to exit");

				String option = scan.nextLine();
				
				if (option.equals("add")) {
					System.out.println("Enter status name: ");
					String name = scan.nextLine();
					Status status = new Status(null, name);
					statusdao.create(status);
					
					System.out.println("Room correctly added.");
					System.out.println("======================================");
					
				} else if (option.equals("view")){
					
					System.out.println("Enter status id to view details: ");
					int id = Integer.parseInt(scan.nextLine());
					Status status = statusdao.read(id);
					System.out.println("Status details:");
					System.out.println("Id: " + status.getId());
					System.out.println("Name: " + status.getName());
					System.out.println("======================================");
						
				} else if (option.equals("edit")) {
					System.out.println("Enter status id to edit: ");
					int id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter name: ");
					String name = scan.nextLine();
					Status status = new Status(id, name);
					statusdao.update(status);
					
					System.out.println("Status correctly edited.");
					System.out.println("======================================");
					
				} else if (option.equals("delete")) {
					
					System.out.println("Enter status id: ");
					int id = Integer.parseInt(scan.nextLine());
					statusdao.delete(id);
					
					System.out.println("Status deleted.");
					System.out.println("======================================");
					
				} else if (option.equals("quit")) {
					
					program_working=false;
					
				} else {
					System.out.println("Wrong value!");
					System.out.println("======================================");
				}
			}
			scan.close();
			System.out.println("======================================");
			System.out.println("End of program");
			System.out.println("======================================");	
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
