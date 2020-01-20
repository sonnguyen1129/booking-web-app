package com.sonndc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonndc.entity.Room;

import com.sonndc.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	public List<Room> getAllRoom() {
		List<Room> listRoom = roomRepository.findAll();
		return listRoom;
	};
	
	public Room findRoomById(long id) {
		Room room = roomRepository.findById(id);
		return room;
	}
}
