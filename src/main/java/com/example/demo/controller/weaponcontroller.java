package com.example.demo.controller;
import java.util.List;


import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.weapon;
import com.example.demo.services.weaponservice;


@RestController
@CrossOrigin
public class weaponcontroller {
	public weaponservice service;
	public weaponcontroller(weaponservice service) {
		super();
		this.service = service;
	
	}
    @PostMapping("/create")
    public weapon createWeapon(@RequestBody weapon weapon) {
        return this.service.create(weapon);
    }

    @GetMapping("/getAll")
    public List<weapon> getAllWeapon() {
        return this.service.getAll();
    }

    @PutMapping("/update")
    public weapon updateWeapon(@PathVariable long id, @RequestBody weapon input) {
    	return service.update(id, input);
    	}

    @DeleteMapping("/delete/{id}")
    public boolean deleteweapon(@PathVariable int id) {
        return this.service.deleteweapon(id);
    }}