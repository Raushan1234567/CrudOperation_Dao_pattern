package com.dto;

import java.time.LocalDate;

public class Masaian {
	
	private int id;
	private String  name ;
	private String unit;
	private LocalDate jdate;
	private String Skills;
	public Masaian(String name, String unit, LocalDate jdate, String skills) {
		super();
		
		this.name = name;
		this.unit = unit;
		this.jdate = jdate;
		Skills = skills;
	}
	
	
	
	public Masaian(int id, String name, String unit, LocalDate jdate, String skills) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.jdate = jdate;
		Skills = skills;
	}



	@Override
	public String toString() {
		return "Masaian [id=" + id + ", name=" + name + ", unit=" + unit + ", jdate=" + jdate + ", Skills=" + Skills
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public LocalDate getJdate() {
		return jdate;
	}
	public void setJdate(LocalDate jdate) {
		this.jdate = jdate;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}

	
	
	
	

}
