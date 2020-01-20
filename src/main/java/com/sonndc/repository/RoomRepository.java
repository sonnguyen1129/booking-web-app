package com.sonndc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonndc.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findAll();
	
	Room findById(long id);
	
	
}
