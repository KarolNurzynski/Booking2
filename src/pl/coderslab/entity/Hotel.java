package pl.coderslab.entity;

public class Hotel {
	
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private Boolean animals=null;
	private String description=null;
	private String rooms;
	
	public Hotel() {
	}

	public Hotel(Integer id, String name, String address, String phone, Boolean animals, String description,
			String rooms) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.animals = animals;
		this.description = description;
		this.rooms = rooms;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getAnimals() {
		return animals;
	}

	public void setAnimals(Boolean animals) {
		this.animals = animals;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	
}
