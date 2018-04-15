package pl.coderslab.other;

public class SQLQueries {
	
	String user_group = "create table user_group (id int(1) not null auto_increment, name varchar(30) not null, primary key(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	String user = "CREATE TABLE user (id int(11) NOT NULL auto_increment, name varchar(50) COLLATE utf8_polish_ci NOT NULL, email varchar(50) NOT NULL, password varchar(30) NOT NULL, user_group_id int(11), primary key(id), foreign key(user_group_id) references user_group(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;";
	String hotel = "CREATE TABLE hotel (id int(11) NOT NULL auto_increment, name varchar(50) COLLATE utf8_polish_ci NOT NULL, address varchar(80) not null, phone varchar(30) not null, animals bit(1), description text, rooms text not null, primary key(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;";
	String room = "create table room (id int(11) not null auto_increment, extension_number varchar(10), max_people int(2) not null, description text, price double(7,2) not null, hotel_id int(11) not null, primary key(id), foreign key (hotel_id) references hotel(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	String reservation = "create table reservation (id int(11) not null auto_increment, order_date date not null, checkin_date date not null, checkout_date date not null, description text, status varchar(20) not null, user_id int(11) not null, room_id int(11) not null, primary key(id), foreign key(user_id) references user(id), foreign key(room_id) references room(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	String status = "create table status (id int(1) not null auto_increment, status varchar(20) not null, primary key(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	// status: accepted / payed / cancelled
	
	
}
