package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.weapon;

@Repository
public interface WeaponRepo extends JpaRepository<weapon,Long>{
	
}