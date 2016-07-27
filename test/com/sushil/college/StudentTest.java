package com.sushil.college;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import com.sushil.order.bo.OrderBOImpl;

public class StudentTest {

	Student STUDENT;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		STUDENT = new Student();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetFirstName() {
		when(STUDENT.getFirstName()).thenThrow(IllegalArgumentException.class);
	}

	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAge() {
		fail("Not yet implemented");
	}

}
