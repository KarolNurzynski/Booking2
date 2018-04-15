package pl.coderslab.program;

import java.util.Scanner;

import pl.coderslab.dao.RoomDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.User;

//Program4: tests user module

public class Program4 {
	
	public static void main(String[] args) {
		
		try {
			
			UserDao userdao = new UserDao();	
			boolean program_working=true;
			Scanner scan = new Scanner(System.in);
			
			while (program_working) {
				
				User[] uArray = userdao.readAll();
				System.out.println("List of users:");
				for (User user : uArray) {
					System.out.println(user.getId() + ". " + user.getName());
				}
				
				System.out.println("----------------------------");
				System.out.println("Choose one of the following options: ");
				System.out.println("* add - to add new user");
				System.out.println("* view - to view user info by giving user id");
				System.out.println("* view_name - to view user info by giving user name");
				System.out.println("* view_email - to view user info by giving user email");
				System.out.println("* edit - to edit existing user");
				System.out.println("* delete - to delete existing user");
				System.out.println("* quit - to exit");

				String option = scan.nextLine();
				
				if (option.equals("add")) {
					System.out.println("Enter name: ");
					String name = scan.nextLine();
					System.out.println("Enter email: ");
					String email = scan.nextLine();
					System.out.println("Enter password: ");
					String password = scan.nextLine();
					System.out.println("Enter group id: ");
					Integer user_group_id = Integer.parseInt(scan.nextLine());
					User user = new User(null, name, email, password, user_group_id);
					userdao.create(user);
					
					System.out.println("User correctly added.");
					System.out.println("======================================");
					
				} else if (option.equals("view_name")){
					
					System.out.println("Enter user name to view details: ");
					String name = scan.nextLine();
					User user = userdao.readByName(name);
					System.out.println("User details:");
					System.out.println("Id: " + user.getId());
					System.out.println("Name: " + user.getName());
					System.out.println("Email: " + user.getEmail());
					System.out.println("Group id: " + user.getUserGroupId());
					System.out.println("======================================");
						
				} else if (option.equals("view_email")) {
					
					System.out.println("Enter user email to view details: ");
					String email = scan.nextLine();
					User user = userdao.readByEmail(email);
					System.out.println("User details:");
					System.out.println("Id: " + user.getId());
					System.out.println("Name: " + user.getName());
					System.out.println("Email: " + user.getEmail());
					System.out.println("Group id: " + user.getUserGroupId());
					System.out.println("======================================");
					
				} else if (option.equals("view")) {
					
					System.out.println("Enter user id to view details: ");
					int id = Integer.parseInt(scan.nextLine());
					User user = userdao.read(id);
					System.out.println("User details:");
					System.out.println("Id: " + user.getId());
					System.out.println("Name: " + user.getName());
					System.out.println("Email: " + user.getEmail());
					System.out.println("Group id: " + user.getUserGroupId());
					System.out.println("======================================");
					
				} else if (option.equals("edit")) {
					System.out.println("Enter user id to edit: ");
					int id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter name: ");
					String name = scan.nextLine();
					System.out.println("Enter email: ");
					String email = scan.nextLine();
					System.out.println("Enter password: ");
					String password = scan.nextLine();
					System.out.println("Enter group id: ");
					Integer user_group_id = Integer.parseInt(scan.nextLine());
					User user = new User(id, name, email, password, user_group_id);
					userdao.update(user);
					
					System.out.println("User correctly edited.");
					System.out.println("======================================");
					
				} else if (option.equals("delete")) {
					
					System.out.println("User room id: ");
					int id = Integer.parseInt(scan.nextLine());
					userdao.delete(id);
					
					System.out.println("User deleted.");
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
