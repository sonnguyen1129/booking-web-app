package com.sonndc.dto;

import lombok.Data;

@Data
public class RoomBookingDTO {
	private long id;
	private long roomId;
	private long userId;
	private String date;
	private String time;
	private String comment;
	
	public RoomBookingDTO(long roomId, long userId, String date, String time, String comment) {
		super();
		this.roomId = roomId;
		this.userId = userId;
		this.date = date;
		this.time = time;
		this.comment = comment;
	}
}