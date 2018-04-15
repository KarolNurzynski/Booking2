package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.User;
import pl.coderslab.other.DbUtil;

public class UserDao {
	
	private static final String CREATE_USER_QUERY = "INSERT INTO user(name,email,password,user_group_id) VALUES (?,?,?,?);";
	private static final String READ_USER_QUERY = "Select * from user where id = ?";
	private static final String UPDATE_USER_QUERY = "UPDATE user SET name = ? , email = ?, password = ?, user_group_id =? WHERE id = ?;";
	private static final String DELETE_USER_QUERY = "DELETE FROM user where id = ?;";
	private static final String READ_ALL_USERS_QUERY = "SELECT * FROM user;";
	private static final String READ_USERS_BY_GROUP_QUERY = "SELECT * FROM user where user_group_id=?;";
	private static final String READ_USER_BY_EMAIL_QUERY = "Select * from user where email = ?;";

	public void create(User user) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(CREATE_USER_QUERY);) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getUserGroupId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public User read(Integer userId) {
		User user = new User();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_USER_QUERY);) {
			ps.setInt(1, userId);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setUserGroupId(resultSet.getInt("user_group_id"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return user;
	}
	
	public User readByEmail(String email) {
		User user = new User();
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_USER_BY_EMAIL_QUERY);) {
			ps.setString(1, email);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setUserGroupId(resultSet.getInt("user_group_id"));
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return user;
	}
	
	public User[] readByGroup(int user_group_id) {
		ArrayList<User> users = new ArrayList<User>();		
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_USERS_BY_GROUP_QUERY);) {
			ps.setInt(1, user_group_id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setUserGroupId(resultSet.getInt("user_group_id"));
					users.add(user);
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return users.toArray(new User[users.size()]);
	}	
	
	public User[] readAll() {
		ArrayList<User> users = new ArrayList<User>();		
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(READ_ALL_USERS_QUERY);) {
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setUserGroupId(resultSet.getInt("user_group_id"));
					users.add(user);
				}
			}
		} catch (Exception e) { 
				e.printStackTrace();
				System.out.println("Error occured, try again!");
		}
		return users.toArray(new User[users.size()]);
	}
	
	public void update(User user) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(UPDATE_USER_QUERY);) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getUserGroupId());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	
	public void delete(Integer userId) {
		try (Connection conn = DbUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(DELETE_USER_QUERY);) {
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}
	

	
}
