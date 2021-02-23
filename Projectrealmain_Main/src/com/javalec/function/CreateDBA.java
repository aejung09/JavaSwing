package com.javalec.function;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import shareVar.ShareVar;

public class CreateDBA {

	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	    String address;
		String email;
		String relation;
	    String title;
	    String text;
	    FileInputStream file;
	    
	    
	public void CreateDBA(){
		
	}    
	    
	public CreateDBA(String title, String text, FileInputStream file) {
		super();
		this.title = title;
		this.text = text;
		this.file = file;
	}
	    
	public CreateDBA(FileInputStream file) {
		super();
	
		this.file = file;
	}


	
	
	public boolean InsertAction2() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "insert into board (file)";
	          String B = " values (?)";

	          ps = conn_mysql.prepareStatement(A+B);
	  
	          ps.setBinaryStream(1, file);
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
}
