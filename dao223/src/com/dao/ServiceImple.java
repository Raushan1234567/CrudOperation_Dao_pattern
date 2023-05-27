package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.dto.Masaian;
import com.exception.Somethingwent;

public class ServiceImple implements Inter{

	@Override
	public void AddDB(Masaian a) throws Somethingwent {
	Connection c=null;
	
	try {
		c=Connect.getco();
		
		
		
		
		String qw="insert into masian(name,unit,k_date,skill) values(?,?,?,?)";
		
		
		
		
		PreparedStatement ps=c.prepareStatement(qw);
		
		ps.setString(1, a.getName());
		ps.setString(2, a.getUnit());
		ps.setDate(3, Date.valueOf(a.getJdate()));
		ps.setString(4, a.getSkills());
		
		int d=ps.executeUpdate();
		
		if(d==0){
			throw new Somethingwent("Something went wrong");
		}
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		e.printStackTrace();
	}
		
	}

	@Override
	public void UpadteDB(int id, String unit, String skill) throws Somethingwent  {
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			
			
			
			String qw="update masian set unit=?,skill=? where id=?";
			
			
			
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(3, id);
			ps.setString(1, unit);
		
			ps.setString(2, skill);
			
			int d=ps.executeUpdate();
			
			if(d==0){
				throw new Somethingwent("Something went wrong");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDB(int id) throws Somethingwent {
Connection c=null;
		
		try {
			c=Connect.getco();
			
			
			
			
			String qw="delete from masian where id=?";
			
			
			
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(1, id);
			
			
			int d=ps.executeUpdate();
			
			if(d==0){
				throw new Somethingwent("Something went wrong");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public Masaian FindbyidDB(int id) throws Somethingwent {
Connection c=null;
Masaian mo=null;
		
		try {
			c=Connect.getco();
			
			
			
			
			String qw="select * from masian where id=?";
			
			
			
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(1, id);
			
			
			ResultSet rs=ps.executeQuery();
			
			if(isEmpty(rs)){
				throw new Somethingwent("list is empty");
			}else {
				rs.next();
				mo=new Masaian(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5));
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		return mo;
	}

	private boolean isEmpty(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return (!rs.isBeforeFirst()&&rs.getRow()==0);
	}

	@Override
	public List<Masaian> Findbyskill(String skill) throws Somethingwent {
		Connection c=null;
	List<Masaian> list=new ArrayList<>();
				
				try {
					c=Connect.getco();
					
					
					
					
					String qw="select * from masian where skill=?";
					
					
					
					
					PreparedStatement ps=c.prepareStatement(qw);
					
					ps.setString(1, skill);
					
					
					ResultSet rs=ps.executeQuery();
					
					if(isEmpty(rs)){
						throw new Somethingwent("list is empty");
					}else {
						while(rs.next()) {
						list.add (new Masaian(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5)));
						}
					}
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				}
				
				
				return list;
	}

	

	@Override
	public List<Masaian> FindbyYear(LocalDate year1, LocalDate year2) throws Somethingwent {
		Connection c=null;
		List<Masaian> list=new ArrayList<>();
					
					try {
						c=Connect.getco();
						
						
						
						
						String qw="select * from masian where k_date > '"+year1+"' and k_date <'"+year2+"' ";
						
						
						
						
						PreparedStatement ps=c.prepareStatement(qw);
						
						
						
						
						ResultSet rs=ps.executeQuery();
						
						if(isEmpty(rs)){
							throw new Somethingwent("list is empty");
						}else {
							while(rs.next()) {
							list.add (new Masaian(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5)));
							}
						}
						
						
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
						e.printStackTrace();
					}
					
					
					return list;
	}

}
