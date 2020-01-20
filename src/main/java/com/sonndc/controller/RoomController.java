package com.sonndc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sonndc.entity.Room;
import com.sonndc.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/get/all")
	public ResponseEntity<?> getAllRoom() {
		List<Room> listRoom = roomService.getAllRoom();
		return ResponseEntity.ok(listRoom);
	}
	
	@GetMapping("/get/{roomId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> findRoomById(@PathVariable(name = "roomId") String id) {
		Room room = roomService.findRoomById(Integer.parseInt(id));
		return ResponseEntity.ok(room);
	}
	
}
