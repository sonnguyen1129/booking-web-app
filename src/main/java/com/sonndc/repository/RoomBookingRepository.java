package com.sonndc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sonndc.entity.RoomBooking;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Long>{

	public RoomBooking findByIdAndDate(long id, String date);
	
	public List<RoomBooking> findByRoomIdAndDate(long roomId, String date);
	
//	public save(RoomBooking roomBooking);
	
	@Query("select e.time from RoomBooking e where e.roomId = ?1 and e.date = ?2")
	public List<String> getListTimeByRoomIdAndDate(long roomId, String date);

}
