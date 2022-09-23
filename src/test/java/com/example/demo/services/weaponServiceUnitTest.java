package com.example.demo.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entities.weapon;
import com.example.demo.repo.WeaponRepo;



@SpringBootTest
public class weaponServiceUnitTest {
	
	@Autowired
	private weaponservice service;
	
	@MockBean
	private WeaponRepo repo;
	
	@Test
	public void testCreate() {
		// Create and object for saving
		weapon input = new weapon(1,"slashing",10,6,"rust_sword","none");
		
		// Create an object for the result
		weapon result = new weapon(1,"slashing",10,6,"rust_sword","none");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(result);
		
		// assertEquals(expected, actual);
		assertEquals(result, service.create(input));
	}
	
	@Test
	public void testGetAll() {
		// Create and object for saving
		List<weapon> result = new ArrayList<>();
		result.add(new weapon(1,"slashing",12,6,"rust_sword","none"));

		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
	
	@Test
	public void getByIdTest() {
		Optional<weapon> OptionalOutput = Optional.of(new weapon(1,"slashing",12,6,"rust_sword","none"));
		weapon output = new weapon(1,"slashing",10,6,"rust_sword","none");
		
		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
		
	}
	
	@Test
	public void getByIdFailTest() {
		Optional<weapon> OptionalOutput = Optional.empty();
		
		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
	}
	
	
	@Test
	public void updateTest() {
		weapon input = new weapon(1,"slashing",10,6,"rust_sword","none");
		Optional<weapon> existing = Optional.of(new weapon(1,"slashing",10,6,"rust_sword","none"));
		weapon output = new weapon(1,"slashing",10,6,"rust_sword","none");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, this.service.update(1L, input));

	}
	
	
	@Test
	public void deleteFalseTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(true);
		
	}
}