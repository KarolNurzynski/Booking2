package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.User;
import pl.coderslab.other.DbUtil;

public class ReservationDao {
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO reservation(order_date, checkin_date, checkout_date, description, status_id, user_id, room_id) VALUES (?,?,?,?,?,?,?);";
	private static final String READ_RESERVATION_QUERY = "Select * from reservation where id = ?;";
	private static final String READ_ALL_RESERVATION_QUERY = "Select * from reservation;";
	private static final String UPDATE_RESERVATION_QUERY = "UPDATE reservation SET order_date = ? , checkin_date = ?, checkout_date = ?, description =?, status_id = ?, user_id = ?, room_id = ? WHERE id = ?;";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM reservation where id = ?;";
	
	public void create(Reservation reservation) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(CREATE_RESERVATION_QUERY);) {
			ps.setDate(1, reservation.getOrder_date());
			ps.setDate(2, reservation.getCheckin_date());
			ps.setDate(3, reservation.getCheckout_date());
			ps.setString(4, reservation.getDescription());
			ps.setInt(5, reservation.getStatus_id());
			ps.setInt(6, reservation.getUser_id());
			ps.setInt(7, reservation.getRoom_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public Reservation read(Integer id) {
		Reservation reservation = new Reservation();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_RESERVATION_QUERY);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					reservation.setId(rs.getInt("id"));
					reservation.setOrder_date(rs.getDate("order_date"));
					reservation.setCheckin_date(rs.getDate("checkin_date"));
					reservation.setCheckout_date(rs.getDate("checkout_date"));
					reservation.setDescription(rs.getString("description"));
					reservation.setStatus_id(rs.getInt("status_id"));
					reservation.setUser_id(rs.getInt("user_id"));
					reservation.setRoom_id(rs.getInt("room_id"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return reservation;
	}
	
	public Reservation[] readAll() {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_ALL_RESERVATION_QUERY);) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Reservation reservation = new Reservation();
					reservation.setId(rs.getInt("id"));
					reservation.setOrder_date(rs.getDate("order_date"));
					reservation.setCheckin_date(rs.getDate("checkin_date"));
					reservation.setCheckout_date(rs.getDate("checkout_date"));
					reservation.setDescription(rs.getString("description"));
					reservation.setStatus_id(rs.getInt("status_id"));
					reservation.setUser_id(rs.getInt("user_id"));
					reservation.setRoom_id(rs.getInt("room_id"));
					reservations.add(reservation);
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return reservations.toArray(new Reservation[reservations.size()]);
	}
	
	public void update(Reservation reservation) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(UPDATE_RESERVATION_QUERY);) {
			ps.setDate(1, reservation.getOrder_date());
			ps.setDate(2, reservation.getCheckin_date());
			ps.setDate(3, reservation.getCheckout_date());
			ps.setString(4, reservation.getDescription());
			ps.setInt(5, reservation.getStatus_id());
			ps.setInt(6, reservation.getUser_id());
			ps.setInt(7, reservation.getRoom_id());
			ps.setInt(8, reservation.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public void delete(Integer id) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(DELETE_RESERVATION_QUERY);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

}
