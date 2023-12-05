package com.Gym.Star.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Gym.Star.Entity.Gymmers;

@ExtendWith(value = { MockitoExtension.class })
@TestInstance(value=Lifecycle.PER_CLASS)
public class GymstarImplTest3 {

	private GymstarImpl gymstar;

	@BeforeAll
	public void setup() {
		gymstar = Mockito.mock(GymstarImpl.class);
	}
	
	@Test
	public void TestGetGymmerById() {
		
		Optional<Gymmers> gm = getGymstar();
		Mockito.when(gymstar.getGymmerById(1)).thenReturn(gm);
		assertEquals("jaspal",gymstar.getGymmerById(1).get().getName() );
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
