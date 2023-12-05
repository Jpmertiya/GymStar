package com.Gym.Star.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class testArgumentCapture {
	@Captor
	ArgumentCaptor<String> ac;
	@Test
	public void argumentCapture() {
		List<String> ml=Mockito.mock(List.class);
		ml.add("kk");
	//  ArgumentCaptor<String> ac=ArgumentCaptor.forClass(String.class);
		verify(ml).add(ac.capture());
		assertEquals("kk", ac.getValue());
	}
	
}
