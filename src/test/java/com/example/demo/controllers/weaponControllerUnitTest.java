package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.example.demo.entities.weapon;
import com.example.demo.services.weaponservice;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
public class weaponControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private weaponservice service;
	
	
	@Test
	public void getAllTest() throws Exception {
		// Created a List
		List<weapon> result = new ArrayList<>();
		// Added my expected Customer to the List
		result.add(new weapon(1,"slashing",10,6,"rusty_sword","none"));
		// Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getAll()).thenReturn(result);
		
		mvc.perform(get("/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}	
	

	
	
}