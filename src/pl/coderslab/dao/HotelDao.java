package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Hotel;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.User;
import pl.coderslab.other.DbUtil;

public class HotelDao {
	
	private static final String CREATE_HOTEL_QUERY = "INSERT INTO hotel(name,address,phone,animals,description,rooms) VALUES (?,?,?,?,?,?);";
	private static final String READ_HOTEL_QUERY = "Select * from hotel where id = ?;";
	private static final String READ_ALL_HOTEL_QUERY = "Select * from hotel;";
	private static final String UPDATE_HOTEL_QUERY = "UPDATE hotel SET name = ? , address = ?, phone = ?, animals =?, description = ?, rooms = ? WHERE id = ?;";
	private static final String DELETE_HOTEL_QUERY = "DELETE FROM hotel where id = ?;";
	
	public void create(Hotel hotel) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(CREATE_HOTEL_QUERY);) {
			ps.setString(1, hotel.getName());
			ps.setString(2, hotel.getAddress());
			ps.setString(3, hotel.getPhone());
			ps.setBoolean(4, hotel.getAnimals());
			ps.setString(5, hotel.getDescription());
			ps.setString(6, hotel.getRooms());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public Hotel read(Integer id) {
		Hotel hotel = new Hotel();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_HOTEL_QUERY);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					hotel.setId(rs.getInt("id"));
					hotel.setName(rs.getString("name"));
					hotel.setAddress(rs.getString("address"));
					hotel.setPhone(rs.getString("phone"));
					hotel.setAnimals(rs.getBoolean("animals"));
					hotel.setDescription(rs.getString("description"));
					hotel.setRooms(rs.getString("rooms"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return hotel;
	}
	
	public Hotel[] readAll() {
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_ALL_HOTEL_QUERY);) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Hotel hotel = new Hotel();
					hotel.setId(rs.getInt("id"));
					hotel.setName(rs.getString("name"));
					hotel.setAddress(rs.getString("address"));
					hotel.setPhone(rs.getString("phone"));
					hotel.setAnimals(rs.getBoolean("animals"));
					hotel.setDescription(rs.getString("description"));
					hotel.setRooms(rs.getString("rooms"));
					hotels.add(hotel);
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return hotels.toArray(new Hotel[hotels.size()]);
	}
	
	public void update(Hotel hotel) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(UPDATE_HOTEL_QUERY);) {
			ps.setString(1, hotel.getName());
			ps.setString(2, hotel.getAddress());
			ps.setString(3, hotel.getPhone());
			ps.setBoolean(4, hotel.getAnimals());
			ps.setString(5, hotel.getDescription());
			ps.setString(6, hotel.getRooms());
			ps.setInt(7, hotel.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public void delete(Integer id) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(DELETE_HOTEL_QUERY);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

}
