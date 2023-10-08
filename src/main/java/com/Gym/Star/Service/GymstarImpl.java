package com.Gym.Star.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gym.Star.Entity.Gymmers;
import com.Gym.Star.Repository.Gymstar;

@Service
public class GymstarImpl {

	@Autowired
	private Gymstar gymstar;

	public List<Gymmers> getAllGymmers() {
		return gymstar.findAll();
	}
	
	public Optional<Gymmers> getGymmerById(long id) {
		return gymstar.findById(id);
	}
	
	public boolean saveGymmer(Gymmers gymmers) {
		boolean isSave=false;
		try {
			gymstar.save(gymmers);
			isSave=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSave;
	}
	
	public boolean deleteGymmer(long id) {
		boolean isDelete=false;
		try {
			gymstar.deleteById(id);
			isDelete=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isDelete;
	}
	
}
