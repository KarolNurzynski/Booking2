package pl.coderslab.program;

import java.sql.Date;
import java.util.Scanner;

import pl.coderslab.dao.ReservationDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.User;

//Program4: tests reservation module

public class Program6 {
	
	public static void main(String[] args) {
		
		try {
			
			ReservationDao reservationdao = new ReservationDao();	
			boolean program_working=true;
			Scanner scan = new Scanner(System.in);
			
			while (program_working) {
				
				Reservation[] rArray = reservationdao.readAll();
				System.out.println("List of reservations:");
				for (Reservation reservation : rArray) {
					System.out.println(reservation.getId() + ". Ordered on: " + reservation.getOrder_date() + ", status: " + reservation.getStatus_id());
				}
				
				System.out.println("----------------------------");
				System.out.println("Choose one of the following options: ");
				System.out.println("* add - to add new reservation");
				System.out.println("* view - to view reservation details by giving reservation id");
				System.out.println("* edit - to edit existing reservation");
				System.out.println("* delete - to delete existing reservation");
				System.out.println("* quit - to exit");

				String option = scan.nextLine();
				
				if (option.equals("add")) {
					boolean inputOK = false;
					Integer status_id=null;
					Date order_date = Date.valueOf(Reservation.getCurrentDateTime());
					System.out.println("Enter check in date: ");
					Date checkin_date = Date.valueOf(scan.nextLine());
					System.out.println("Enter check out date: ");
					Date checkout_date = Date.valueOf(scan.nextLine());
					System.out.println("Enter description: ");
					String description = scan.nextLine();
					
					while (inputOK==false) {
						try {
							System.out.println("Enter status (1-accepted/2-paid/3-cancelled): ");
							status_id = Integer.parseInt(scan.nextLine());
							if ((status_id==1) || (status_id==2 || (status_id==3))) {
								inputOK=true;
							} else {
								System.out.println("Wrong value!");
							}
						} catch (Exception e) {
							System.out.println("Wrong value!");
						}
					}
					
					System.out.println("Enter user id: ");
					Integer user_id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter room id: ");
					Integer room_id = Integer.parseInt(scan.nextLine());
					
					Reservation reservation = new Reservation(null, order_date, checkin_date, checkout_date, description, status_id, user_id, room_id);
					reservationdao.create(reservation);
					
					System.out.println("Reservation correctly added.");
					System.out.println("======================================");
					
				} else if (option.equals("view")) {
					
					System.out.println("Enter reservation id to view details: ");
					int id = Integer.parseInt(scan.nextLine());
					Reservation reservation = reservationdao.read(id);
					System.out.println("Reservation details:");
					System.out.println("Id: " + reservation.getId());
					System.out.println("Order date: " + reservation.getOrder_date());
					System.out.println("Check in date: " + reservation.getCheckin_date());
					System.out.println("Check out date: " + reservation.getCheckout_date());
					System.out.println("Description: " + reservation.getDescription());
					System.out.println("Status: " + reservation.getStatus_id());
					System.out.println("User id: " + reservation.getUser_id());
					System.out.println("Room id: " + reservation.getRoom_id());
					System.out.println("======================================");
					
				} else if (option.equals("edit")) {
					boolean inputOK = false;
					Integer status_id=null;
					System.out.println("Enter reservation id to edit: ");
					int id = Integer.parseInt(scan.nextLine());
					Date order_date = Date.valueOf(Reservation.getCurrentDateTime());
					System.out.println("Enter check in date: ");
					Date checkin_date = Date.valueOf(scan.nextLine());
					System.out.println("Enter check out date: ");
					Date checkout_date = Date.valueOf(scan.nextLine());
					System.out.println("Enter description: ");
					String description = scan.nextLine();
					
					System.out.println("Enter status (accepted/paid/cancelled): ");
					while (inputOK==false) {
						try {
							System.out.println("Enter status (1-accepted/2-paid/3-cancelled): ");
							status_id = Integer.parseInt(scan.nextLine());
							if ((status_id==1) || (status_id==2 || (status_id==3))) {
								inputOK=true;
							} else {
								System.out.println("Wrong value!");
							}
						} catch (Exception e) {
							System.out.println("Wrong value!");
						}
					}
					
					System.out.println("Enter user id: ");
					Integer user_id = Integer.parseInt(scan.nextLine());
					System.out.println("Enter room id: ");
					Integer room_id = Integer.parseInt(scan.nextLine());
					Reservation reservation = new Reservation(id, order_date, checkin_date, checkout_date, description, status_id, user_id, room_id);
					reservationdao.update(reservation);
					
					System.out.println("Reservation correctly edited.");
					System.out.println("======================================");
					
				} else if (option.equals("delete")) {
					
					System.out.println("Reservation id: ");
					int id = Integer.parseInt(scan.nextLine());
					reservationdao.delete(id);
					
					System.out.println("Reservation deleted.");
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
			System.out.println("Wrong inputs!");
		}
	}

}
