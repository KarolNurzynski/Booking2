package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

public class User {
	
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer user_group_id=null;
	
	public User() {};
	
	public User(Integer id, String name, String email, String password, Integer user_group_id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.user_group_id = user_group_id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public Integer getUserGroupId() {
		return user_group_id;
	}
	public void setUserGroupId(Integer user_group_id) {
		this.user_group_id = user_group_id;
	}

}
