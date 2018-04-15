package pl.coderslab.program;

import java.util.Scanner;
import pl.coderslab.dao.RoomDao;
import pl.coderslab.entity.Room;

//Program2: tests room management functions

public class Program2 {
	
	public static void main(String[] args) {
		
		try {
			
			RoomDao roomdao = new RoomDao();	
			boolean program_working=true;
			Scanner scan = new Scanner(System.in);
			
			while (program_working) {
				
				Room[] rArray = roomdao.readAll();
				System.out.println("List of rooms:");
				for (Room room : rArray) {
					System.out.println(room.getId() + ". Room in hotel no. " + room.getHotel_id() + " || PRICE: " + room.getPrice());
				}
				
				System.out.println("----------------------------");
				System.out.println("Choose one of the following options: ");
				System.out.println("* add - to add new room");
				System.out.println("* view - to view hotel room info by giving hotel id");
				System.out.println("* edit - to edit existing room");
				System.out.println("* delete - to delete existing room");
				System.out.println("* quit - to exit");

				String option = scan.nextLine();
				
				if (option.equals("add")) {
					System.out.println("Enter hotel id: ");
					Integer hotel_id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter max. people: ");
					Integer max_people = Integer.parseInt(scan.nextLine());
					System.out.println("Enter description: ");
					String description = scan.nextLine();
					System.out.println("Enter ext. number: ");
					String extension_number = scan.nextLine();
					System.out.println("Enter price: ");
					Double price = Double.parseDouble(scan.nextLine());
					Room room = new Room(null, extension_number, max_people, description, price, hotel_id);
					roomdao.create(room);
					
					System.out.println("Room correctly added.");
					System.out.println("======================================");
					
				} else if (option.equals("view")){
					
					System.out.println("Enter room id to view details: ");
					int id = Integer.parseInt(scan.nextLine());
					Room room = roomdao.read(id);
					System.out.println("Room details:");
					System.out.println("Room id: " + room.getId());
					System.out.println("Hotel id: " + room.getHotel_id());
					System.out.println("Max. people: " + room.getMax_people());
					System.out.println("Description: " + room.getDescription());
					System.out.println("Ext. number: " + room.getExtension_number());
					System.out.println("Price: " + room.getPrice());
					System.out.println("======================================");
						
				} else if (option.equals("edit")) {
					System.out.println("Enter room id to edit: ");
					int id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter hotel id: ");
					Integer hotel_id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter max. people: ");
					Integer max_people = Integer.parseInt(scan.nextLine());
					System.out.println("Enter description: ");
					String description = scan.nextLine();
					System.out.println("Enter ext. number: ");
					String extension_number = scan.nextLine();
					System.out.println("Enter price: ");
					Double price = Double.parseDouble(scan.nextLine());
					Room room = new Room(id, extension_number, max_people, description, price, hotel_id);
					roomdao.update(room);
					
					System.out.println("Room correctly edited.");
					System.out.println("======================================");
					
				} else if (option.equals("delete")) {
					
					System.out.println("Enter room id: ");
					int id = Integer.parseInt(scan.nextLine());
					roomdao.delete(id);
					
					System.out.println("Room deleted.");
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
