package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.Status;
import pl.coderslab.other.DbUtil;

public class StatusDao {
	
	private static final String CREATE_STATUS_QUERY = "INSERT INTO status(name) VALUES (?);";
	private static final String READ_STATUS_QUERY = "Select * from status where id = ?";
	private static final String UPDATE_STATUS_QUERY = "UPDATE status SET name = ? WHERE id = ?;";
	private static final String DELETE_STATUS_QUERY = "DELETE FROM status where id = ?;";
	
	public void create(Status status) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(CREATE_STATUS_QUERY);) {
			ps.setString(1, status.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public Status read(Integer id) {
		Status status = new Status();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_STATUS_QUERY);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					status.setId(id);
					status.setName(rs.getString("status"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return status;
	}
	
	public void update(Status status) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(UPDATE_STATUS_QUERY);) {
			ps.setString(1, status.getName());
			ps.setInt(2, status.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public void delete(Integer id) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(DELETE_STATUS_QUERY);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

}
