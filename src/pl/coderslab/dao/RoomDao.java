package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Hotel;
import pl.coderslab.entity.Room;
import pl.coderslab.other.DbUtil;

public class RoomDao {
	
	private static final String CREATE_ROOM_QUERY = "INSERT INTO room(extension_number, max_people, description, price, hotel_id) VALUES (?,?,?,?,?);";
	private static final String READ_ROOM_QUERY = "Select * from room where id = ?;";
	private static final String READ_ALL_ROOM_QUERY = "Select * from room;";
	private static final String UPDATE_ROOM_QUERY = "UPDATE room SET extension_number = ? , max_people = ?, description = ?, price =?, hotel_id = ? WHERE id = ?;";
	private static final String DELETE_ROOM_QUERY = "DELETE FROM room where id = ?;";
	
	public void create(Room room) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(CREATE_ROOM_QUERY);) {
			ps.setString(1, room.getExtension_number());
			ps.setInt(2, room.getMax_people());
			ps.setString(3, room.getDescription());
			ps.setDouble(4, room.getPrice());
			ps.setInt(5, room.getHotel_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public Room read(Integer id) {
		Room room = new Room();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_ROOM_QUERY);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					room.setId(rs.getInt("id"));
					room.setHotel_id(rs.getInt("hotel_id"));
					room.setExtension_number(rs.getString("extension_number"));
					room.setMax_people(rs.getInt("max_people"));
					room.setDescription(rs.getString("description"));
					room.setPrice(rs.getDouble("price"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return room;
	}
	
	public Room[] readAll() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_ALL_ROOM_QUERY);) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Room room = new Room();
					room.setId(rs.getInt("id"));
					room.setHotel_id(rs.getInt("hotel_id"));
					room.setExtension_number(rs.getString("extension_number"));
					room.setMax_people(rs.getInt("max_people"));
					room.setDescription("description");
					room.setPrice(rs.getDouble("price"));
					rooms.add(room);
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return rooms.toArray(new Room[rooms.size()]);
	}
	
	public void update(Room room) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(UPDATE_ROOM_QUERY);) {
			ps.setString(1, room.getExtension_number());
			ps.setInt(2, room.getMax_people());
			ps.setString(3, room.getDescription());
			ps.setDouble(4, room.getPrice());
			ps.setInt(5, room.getHotel_id());
			ps.setInt(6, room.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public void delete(Integer id) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(DELETE_ROOM_QUERY);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

}
