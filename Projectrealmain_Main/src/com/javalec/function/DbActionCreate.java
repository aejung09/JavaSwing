package com.javalec.function;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import shareVar.*;
public class DbActionCreate {

	String category;
	String title;
	String text;
	
//	public static final String url_mysql = "jdbc:mysql://127.0.0.1/mproject?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
//    public static final String id_mysql = "root";
//    public static final String pw_mysql = "qwer1234";
//	
public DbActionCreate () {
	
}


public DbActionCreate(String category, String title, String text) {
	super();
	this.category = category;
	this.title = title;
	this.text = text;
}





public String getCategory() {
	return category;
}


public void setCategory(String category) {
	this.category = category;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getText() {
	return text;
}


public void setText(String text) {
	this.text = text;
}





public boolean insertAction(String category, String title, String text) {
	 PreparedStatement ps = null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
           @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

           String A = "insert into board (category, title, text, user_usercode";
           String B = ") values (?,?,?,?)";
           
           ps = conn_mysql.prepareStatement(A+B);
           ps.setString(1, category);
           ps.setString(2, title);
           ps.setString(3, text);
           ps.setString(4, shareVar.ShareVar.nowusercode);
  
           ps.executeUpdate();

           conn_mysql.close();
       } catch (Exception e){
    	   System.out.println(e);
       	return false;
         
       }
       return true;
}








}
