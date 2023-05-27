package com.dao;

import java.time.LocalDate;
import java.util.List;

import com.dto.Masaian;
import com.exception.Somethingwent;

public interface Inter {

	void AddDB(Masaian a) throws Somethingwent;

	void UpadteDB(int id, String unit, String skill) throws Somethingwent;

	void deleteDB(int id) throws Somethingwent;

	Masaian FindbyidDB(int id) throws Somethingwent;

	List<Masaian> Findbyskill(String skill) throws Somethingwent;

	

	List<Masaian> FindbyYear(LocalDate year1, LocalDate year2) throws Somethingwent;

}
