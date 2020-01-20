package com.sonndc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "room_booking")
public class RoomBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long roomId;
	@Column
	private long userId;
	@Column
	private String date;
	@Column
	private String time;
	@Column
	private String comment;
	
	public RoomBooking(long roomId, long userId, String date, String time, String comment) {
		super();
		this.userId = userId;
		this.roomId = roomId;
		this.date = date;
		this.time = time;
		this.comment = comment;
	}

	public RoomBooking() {
		super();
	}
	
	

}