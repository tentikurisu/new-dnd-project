package com.example.demo.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class weapon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private long cost;
	@Column(nullable=false)
	private long dice;
	@Column(nullable=false)
	private String damagetype;
	@Column(nullable=false)
	private String propeties;
	
	public weapon() {
		super();
	}
	
	public weapon(String name, long cost, long dice, String damagetype, String propeties) {
		super();
		this.name = name;
		this.cost = cost;
		this.dice = dice;
		this.damagetype = damagetype;
		this.propeties = propeties;
	}
	
	public weapon(long id, String name, long cost, long dice, String damagetype, String propeties) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.dice = dice;
		this.damagetype = damagetype;
		this.propeties = propeties;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCost() {
		return (long) cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public long getDice() {
		return (long) dice;
	}
	public void setDice(long dice) {
		this.dice = dice;
	}
	public String getDamagetype() {
		return damagetype;
	}
	public void setDamagetype(String damagetype) {
		this.damagetype = damagetype;
	}
	public String getPropeties() {
		return propeties;
	}
	public void setPropeties(String propeties) {
		this.propeties = propeties;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, damagetype, dice, name, propeties, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		weapon other = (weapon) obj;
		return cost == other.cost && Objects.equals(damagetype, other.damagetype) && dice == other.dice
				&& Objects.equals(name, other.name) && Objects.equals(propeties, other.propeties) && id == other.id;
	}
	
}
