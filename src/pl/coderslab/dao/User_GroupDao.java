package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Room;
import pl.coderslab.entity.Status;
import pl.coderslab.entity.User_Group;
import pl.coderslab.other.DbUtil;

public class User_GroupDao {
	
	private static final String CREATE_USER_GROUP_QUERY = "INSERT INTO user_group(name) VALUES (?);";
	private static final String READ_USER_GROUP_QUERY = "Select * from user_group where id = ?;";
	private static final String READ_ALL_GROUP_QUERY = "Select * from user_group;";
	private static final String UPDATE_USER_GROUP_QUERY = "UPDATE user_group SET name = ? WHERE id = ?;";
	private static final String DELETE_USER_GROUP_QUERY = "DELETE FROM user_group where id = ?;";
	
	public void create(User_Group user_group) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(CREATE_USER_GROUP_QUERY);) {
			ps.setString(1, user_group.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public User_Group read(Integer id) {
		User_Group user_group = new User_Group();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_USER_GROUP_QUERY);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					user_group.setId(id);
					user_group.setName(rs.getString("name"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return user_group;
	}
	
	public User_Group[] readAll() {
		ArrayList<User_Group> user_groups = new ArrayList<User_Group>();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_ALL_GROUP_QUERY);) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					User_Group user_group = new User_Group();
					user_group.setId(rs.getInt("id"));
					user_group.setName(rs.getString("name"));
					user_groups.add(user_group);
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return user_groups.toArray(new User_Group[user_groups.size()]);
	}
	
	public void update(User_Group user_group) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(UPDATE_USER_GROUP_QUERY);) {
			ps.setString(1, user_group.getName());
			ps.setInt(2, user_group.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public void delete(Integer id) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(DELETE_USER_GROUP_QUERY);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

}
