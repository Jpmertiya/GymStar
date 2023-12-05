package com.Gym.Star.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(value = { MockitoExtension.class })
public class GymstarImplTest4 {
	@Spy
	private ArrayList<Integer> list;

	@Test
	public void TestGetGymmerById() {
		list.add(45);
		list.add(5);
		list.add(55);
		assertEquals(3, list.size());
		
		//stubbing
		Mockito.doReturn(40).when(list).size();
		assertEquals(40, list.size());
	}

}
