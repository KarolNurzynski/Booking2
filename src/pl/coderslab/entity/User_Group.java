package pl.coderslab.entity;

public class User_Group {
	
	private Integer id;
	private String name;
	
	public User_Group() {}
	
	public User_Group(Integer id, String name) {
		this.id = id;
		this.name = name;
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

}
