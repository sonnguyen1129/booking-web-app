package com.sonndc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sonndc.dto.RoomBookingDTO;
import com.sonndc.entity.RoomBooking;
import com.sonndc.service.RoomBookingService;

@RestController
@RequestMapping("/room-booking")
public class RoomBookingController {
	
	@Autowired
	RoomBookingService roomBookingService;
	
	@GetMapping("/get/{roomId}/{date}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getRoomDTOByIdDate(@PathVariable(name = "roomId") String roomId, @PathVariable(name = "date") String date) {
		List<RoomBooking> list = roomBookingService.getListRoomDetailByRoomIdDate(Integer.parseInt(roomId), date);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/time/{roomId}/{date}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getListTimeBooked(@PathVariable(name = "roomId") String roomId, @PathVariable(name = "date") String date) {
		List<String> list = roomBookingService.getListTimeBooked(Integer.parseInt(roomId), date);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> insertBookingTime(@RequestBody RoomBookingDTO roomBookingDTO) {
		RoomBooking roomBooking = new RoomBooking(roomBookingDTO.getRoomId(), roomBookingDTO.getUserId(), roomBookingDTO.getDate(), roomBookingDTO.getTime(), roomBookingDTO.getComment());
		roomBookingService.insertRoomBooking(roomBooking);
		return ResponseEntity.ok(roomBooking);
	}
	
}
