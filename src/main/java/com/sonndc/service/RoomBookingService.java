package com.sonndc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonndc.entity.RoomBooking;
import com.sonndc.repository.RoomBookingRepository;

@Service
public class RoomBookingService {
	
	@Autowired
	RoomBookingRepository roomDetailRepository;
	
	public RoomBooking getRoomDetailByIdDate(long id, String date) {
		RoomBooking roomDetail = roomDetailRepository.findByIdAndDate(id, date);
		return roomDetail;
	}
	
	public List<RoomBooking> getListRoomDetailByRoomIdDate(long roomId, String date) {
		List<RoomBooking> list = roomDetailRepository.findByRoomIdAndDate(roomId, date);
		return list;
	}
	
	public List<String> getListTimeBooked(long roomId, String date) {
		List<String> list = roomDetailRepository.getListTimeByRoomIdAndDate(roomId, date);
		return list;
	}
	
	public RoomBooking insertRoomBooking(RoomBooking roomBooking) {
		return roomDetailRepository.save(roomBooking);
	}
}
