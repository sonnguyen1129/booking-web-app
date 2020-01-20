package com.sonndc.dto;

import lombok.Data;

@Data
public class RoomDTO {
	private long id;
	private String floor;
	private String name;
	private String personNumber;
	private String roomFeatures;
	private String img;
	
	public RoomDTO(long id, String floor, String name, String personNumber, String roomFeatures, String img) {
		super();
		this.id = id;
		this.floor = floor;
		this.name = name;
		this.personNumber = personNumber;
		this.roomFeatures = roomFeatures;
		this.img = img;
	}
	
	
}