package com.example.demo.entities;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class weaponTest {
	
	@Test
	public void equalsNullTest() {
		weapon weapon = new weapon(1,"slashing",10,6,"rust_sword","none");
		
		assertFalse(weapon.equals(null));
	}
	
	@Test
	public void differentClassTest() {
		weapon weapon = new weapon(1,"slashing",10,6,"rust_sword","none");
		String testString = "Hi";
		
		assertFalse(weapon.equals(testString));
	}
	
	@Test
	public void checkHashTest() {
		weapon one = new weapon(1,"slashing",10,6,"rust_sword","none");
		weapon two = new weapon(1,"slashing",10,6,"rust_sword","none");
		
		assertTrue(one.hashCode() == two.hashCode());
	}
}