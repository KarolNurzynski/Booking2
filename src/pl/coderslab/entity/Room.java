package pl.coderslab.entity;

public class Room {
	
	private Integer id;
	private String extension_number=null;
	private Integer max_people;
	private String description=null;
	private Double price;
	private Integer hotel_id;
	
	public Room() {}
	
	public Room(Integer id, String extension_number, Integer max_people, String description, Double price,
			Integer hotel_id) {
		this.id = id;
		this.extension_number = extension_number;
		this.max_people = max_people;
		this.description = description;
		this.price = price;
		this.hotel_id = hotel_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExtension_number() {
		return extension_number;
	}

	public void setExtension_number(String extension_number) {
		this.extension_number = extension_number;
	}

	public Integer getMax_people() {
		return max_people;
	}

	public void setMax_people(Integer max_people) {
		this.max_people = max_people;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}
	
}
