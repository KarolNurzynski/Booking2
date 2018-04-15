package pl.coderslab.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	private Integer id;
	private Date order_date;
	private Date checkin_date;
	private Date checkout_date;
	private String description=null;
	private Integer status_id;
	private Integer user_id;
	private Integer room_id;
	
	public Reservation() {}
	
	public Reservation(Integer id, Date order_date, Date checkin_date, Date checkout_date, String description,
			Integer status_id, Integer user_id, Integer room_id) {
		this.id = id;
		this.order_date = order_date;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.description = description;
		this.status_id = status_id;
		this.user_id = user_id;
		this.room_id = room_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(Date checkin_date) {
		this.checkin_date = checkin_date;
	}

	public Date getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	
	public static String getCurrentDateTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
}
