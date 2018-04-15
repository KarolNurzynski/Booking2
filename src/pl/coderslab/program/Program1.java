package pl.coderslab.program;

import java.util.Scanner;
import pl.coderslab.dao.HotelDao;
import pl.coderslab.entity.Hotel;

// Program1: tests hotel management functions

public class Program1 {
	
	public static void main(String[] args) {
		
		try {
			
			HotelDao hoteldao = new HotelDao();		
			boolean program_working=true;
			Scanner scan = new Scanner(System.in);
			
			while (program_working) {
				
				Hotel[] hArray = hoteldao.readAll();
				System.out.println("List of hotels:");
				for (Hotel hotel : hArray) {
					System.out.println(hotel.getId() + ". " + hotel.getName());
				}
				
				System.out.println("----------------------------");
				System.out.println("Choose one of the following options: ");
				System.out.println("* add - to add new hotel");
				System.out.println("* view - to view hotel extra info by giving hotel id");
				System.out.println("* edit - to edit existing hotel");
				System.out.println("* delete - to delete existing hotel");
				System.out.println("* quit - to exit");

				String option = scan.nextLine();
				
				if (option.equals("add")) {
					System.out.println("Enter name: ");
					String name = scan.nextLine();
					System.out.println("Enter address: ");
					String address = scan.nextLine();
					System.out.println("Enter phone: ");
					String phone = scan.nextLine();
					System.out.println("Enter animals welcome (true/false): ");
					Boolean animals = Boolean.parseBoolean(scan.nextLine());
					System.out.println("Enter description: ");
					String description = scan.nextLine();
					System.out.println("Enter rooms: ");
					String rooms = scan.nextLine();
					Hotel hotel = new Hotel(null, name, address, phone, animals, description, rooms);
					hoteldao.create(hotel);
					
					System.out.println("Hotel correctly added.");
					System.out.println("======================================");
					
				} else if (option.equals("view")){
					
					System.out.println("Enter hotel id to view details: ");
					int id = Integer.parseInt(scan.nextLine());
					Hotel hotel = hoteldao.read(id);
					System.out.println("Hotel details:");
					System.out.println("Id: " + hotel.getId());
					System.out.println("Name: " + hotel.getName());
					System.out.println("Address: " + hotel.getAddress());
					System.out.println("Phone: " + hotel.getPhone());
					System.out.println("Description: " + hotel.getDescription());
					System.out.println("Accepts animals: " + hotel.getAnimals());
					System.out.println("Rooms: " + hotel.getRooms());
					System.out.println("======================================");
						
				} else if (option.equals("edit")) {
					System.out.println("Enter hotel id to edit: ");
					int id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter name: ");
					String name = scan.nextLine();
					System.out.println("Enter address: ");
					String address = scan.nextLine();
					System.out.println("Enter phone: ");
					String phone = scan.nextLine();
					System.out.println("Enter animals welcome (true/false): ");
					Boolean animals = Boolean.parseBoolean(scan.nextLine());
					System.out.println("Enter description: ");
					String description = scan.nextLine();
					System.out.println("Enter rooms: ");
					String rooms = scan.nextLine();
					Hotel hotel = new Hotel(id, name, address, phone, animals, description, rooms);
					hoteldao.update(hotel);
					
					System.out.println("Hotel correctly edited.");
					System.out.println("======================================");
					
				} else if (option.equals("delete")) {
					
					System.out.println("Enter hotel id: ");
					int id = Integer.parseInt(scan.nextLine());
					hoteldao.delete(id);
					
					System.out.println("Hotel deleted.");
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
