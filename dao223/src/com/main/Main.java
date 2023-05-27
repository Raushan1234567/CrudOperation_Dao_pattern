package com.main;
import java.time.LocalDate;
import java.util.*;
import com.dto.*;
import com.exception.Somethingwent;
import com.dao.*;
public class Main {
	
 public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int c;
	do {
		System.out.println("1. Add");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Find by id");
		System.out.println("5. Find by Skill");
		System.out.println("6. Find by year");
		System.out.println("0. Exit");
		
		
		c=sc.nextInt();
		
		switch(c) {
		case 1:
			Add(sc);
			break;
		case 2:
			Update(sc);
			break;
		case 3:
		Delete(sc);
			break;
		case 4:
			FindByid(sc);
			break;
		case 5:
			Findbyskill(sc);
			break;
			
		case 6:
			Findbydaterange(sc);
			break;
		case 0:
			System.out.println("Thanks");
			break;
			
		}
		
		
	}while(c!=0);
	sc.close();
}

private static void Add(Scanner sc) {
	
	System.out.println("Enter name");
	String name=sc.next();
	System.out.println("Enter unit");
	String unit=sc.next();
	System.out.println("Enter join date");
	LocalDate jdate=LocalDate.parse(sc.next());
	System.out.println("Enter skill");
	String skill=sc.next();
	
	Masaian a=new Masaian(name,unit,jdate,skill);
	
	Inter b=new ServiceImple();
	
	try {
		b.AddDB(a);
		System.out.println("Success");
	} catch (Somethingwent e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
	
}

private static void Update(Scanner sc) {
	System.out.println("Enter id");
	int id=sc.nextInt();
	System.out.println("Enter unit");
	String unit=sc.next();
	System.out.println("Enter skill");
	String skill=sc.next();
	
Inter b=new ServiceImple();
	
	try {
		b.UpadteDB(id,unit,skill);
		System.out.println("Success");
	} catch (Somethingwent e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
	
}

private static void Delete(Scanner sc) {
	System.out.println("Enter id");
	int id=sc.nextInt();
	
Inter b=new ServiceImple();
	
	try {
		b.deleteDB(id);
		System.out.println("Success");
	} catch (Somethingwent e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
	
	
}

private static void FindByid(Scanner sc) {
	System.out.println("Enter id");
	int id=sc.nextInt();
	
Inter b=new ServiceImple();
	
	try {
		Masaian z=b.FindbyidDB(id);
		System.out.println(z);
	} catch (Somethingwent e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
	
}

private static void Findbyskill(Scanner sc) {
	System.out.println("Enter skill");
	String skill=sc.next();
	
Inter b=new ServiceImple();
	
	try {
		List<Masaian> z=b.Findbyskill(skill);
	z.forEach(System.out::println);
	} catch (Somethingwent e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
	
}

private static void Findbydaterange(Scanner sc) {
	System.out.println("Enter Year1");
	LocalDate Year1=LocalDate.parse(sc.next());
	System.out.println("Enter Year2");
	LocalDate Year2=LocalDate.parse(sc.next());
	
Inter b=new ServiceImple();
	
	try {
		List<Masaian> z=b.FindbyYear(Year1,Year2);
	z.forEach(System.out::println);
	} catch (Somethingwent e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
	
}

}
