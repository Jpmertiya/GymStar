package com.Gym.Star.Service;

import java.util.Optional;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.Gym.Star.Entity.Gymmers;

public class GymstarImplTest2 {
	@Mock
	private GymstarImpl gymstar;

	public static void main(String[] args) {
		new GymstarImplTest2().TestGetGymmerById();
	}

	public void TestGetGymmerById() {
		MockitoAnnotations.openMocks(this);
		Optional<Gymmers> gm=getGymstar();
		Mockito.when(gymstar.getGymmerById(1)).thenReturn(gm);
		System.out.println(gymstar.getGymmerById(1));
	}

	public static Optional<Gymmers> getGymstar() {
		Gymmers m = new Gymmers();
		m.setAge("15");
		m.setAssistant("no");
		m.setEmail("asbcas");
		m.setGender("male");
		m.setId(1);
		m.setName("jaspal");
		m.setPhone("1541545");
		return Optional.of(m);
	}
}
