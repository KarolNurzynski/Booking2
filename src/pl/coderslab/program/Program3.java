package pl.coderslab.program;

import java.util.Scanner;

import pl.coderslab.dao.RoomDao;
import pl.coderslab.dao.User_GroupDao;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.User_Group;

//Program3: tests UserGroup module

public class Program3 {
	
	public static void main(String[] args) {
		
		try {
			
			User_GroupDao user_groupdao = new User_GroupDao();	
			boolean program_working=true;
			Scanner scan = new Scanner(System.in);
			
			while (program_working) {
				
				User_Group[] ugArray = user_groupdao.readAll();
				System.out.println("List of groups:");
				for (User_Group ug : ugArray) {
					System.out.println(ug.getId() + ". " + ug.getName());
				}
				
				System.out.println("----------------------------");
				System.out.println("Choose one of the following options: ");
				System.out.println("* add - to add new group");
				System.out.println("* view - to view group details by giving group id");
				System.out.println("* edit - to edit existing group");
				System.out.println("* delete - to delete existing group");
				System.out.println("* quit - to exit");

				String option = scan.nextLine();
				
				if (option.equals("add")) {
					System.out.println("Enter group name: ");
					String name = scan.nextLine();
					User_Group user_group = new User_Group(null, name);
					user_groupdao.create(user_group);
					
					System.out.println("Room correctly added.");
					System.out.println("======================================");
					
				} else if (option.equals("view")){
					
					System.out.println("Enter group id to view details: ");
					int id = Integer.parseInt(scan.nextLine());
					User_Group user_group = user_groupdao.read(id);
					System.out.println("Group details:");
					System.out.println("Id: " + user_group.getId());
					System.out.println("Name: " + user_group.getName());
					System.out.println("======================================");
						
				} else if (option.equals("edit")) {
					System.out.println("Enter group id to edit: ");
					int id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter name: ");
					String name = scan.nextLine();
					User_Group user_group = new User_Group(id, name);
					user_groupdao.update(user_group);
					
					System.out.println("Room correctly edited.");
					System.out.println("======================================");
					
				} else if (option.equals("delete")) {
					
					System.out.println("Enter group id: ");
					int id = Integer.parseInt(scan.nextLine());
					user_groupdao.delete(id);
					
					System.out.println("Group deleted.");
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
