package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import shareVar.ShareVar;

public class DbActionUpdate {
	

	public DbActionUpdate(String email, String username) {
		super();
		this.email = email;
		this.username = username;
	}



	private  String url_mysql = ShareVar.url_mysql;
	private  String id_mysql = ShareVar.id_mysql;
	private  String pw_mysql = ShareVar.pw_mysql;
	
	
	
	String userid;
//	public DbActionLogin(String userid, String userpw, String email, String emailaddress, String username) {
//		super();
//		this.userid = userid;
//		this.userpw = userpw;
//		this.email = email;
//		this.emailaddress = emailaddress;
//		this.username = username;
//	}



	String userpw;
	String email;
	String emailaddress;
	String username;
	String usercode;
	String userstatus;
	
	
	
	
	
	
	
	
	







	public DbActionUpdate(String userid, String username, String email, String userpw, String emailaddress) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.email = email;
		this.username = username;
		this.emailaddress = emailaddress;
	}



	//
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getUserpw() {
		return userpw;
	}



	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}



	public String getEmail() {
		return email;
	}



	public DbActionUpdate(String userpw, String email, String username) {
		super();
		this.userpw = userpw;
		this.email = email;
		this.username = username;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public DbActionUpdate(String username, String email, String userpw, String emailaddress) {
		super();
		this.emailaddress = emailaddress;
		this.username = username;
		this.email = email;
		this.userpw = userpw;
	}
	

	
		public boolean insertAction() {
		 PreparedStatement ps = null;
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

	            String A = "insert into user (userid, username, email,userpw,emailaddress , userstatus) values (?,?,?,?,?,'회원') ";
//	            String B = "' ) values (?,?,now());";

	            ps = conn_mysql.prepareStatement(A);
	            ps.setString(1,	userid );
	            ps.setString(2,	username);
	            ps.setString(3, email);
	            ps.setString(4, emailaddress);
	            ps.setString(5, userpw);
//	            ps.setString(3, insertdate);
//	            ps.setString(4, ShareVar.nowid);
//	            ps.setString(5, relation);
	            ps.executeUpdate();
	            conn_mysql.close();
	        } catch (Exception e){
	        	System.out.println(e);
	        	return false;
	          
	        }
	        return true;
	        
	        
	        
	}
	
//	public boolean inputAddreAction() {
//		 PreparedStatement ps = null;
//	        try{
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//	            Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//				Statement stmt_mysql = conn_mysql.createStatement();
//
//	            String A = "insert into user (userid, username, email, userpw, userstatus) values (?,?,?,?,'회원') ";
////	            String B = "' ) values (?,?,now());";
//
//	            ps = conn_mysql.prepareStatement(A);
//	            ps.setString(1,userid );
//	            ps.setString(2,username);
//	            ps.setString(3, email);
//	            ps.setString(4, userpw);
//	            ps.setString(5, userstatus);
////	            ps.setString(3, insertdate);
////	            ps.setString(4, ShareVar.nowid);
////	            ps.setString(5, relation);
//	            ps.executeUpdate();
//	            conn_mysql.close();
//	        } catch (Exception e){
//	        	System.out.println(e);
//	        	return false;
//	          
//	        }
//	        return true;
//	}
	
		public boolean updateAction() {
			 PreparedStatement ps = null;
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
					Statement stmt_mysql = conn_mysql.createStatement();

					String A = "update user set username = ?, email = ? ,userpw = ?, emailaddress = ? ";
					String B = "where userid = ? ";


		            ps = conn_mysql.prepareStatement(A+B);
		            ps.setString(1,username );
		            ps.setString(2,email);
		            ps.setString(3, userpw);
		            ps.setString(4, emailaddress);
		            ps.setString(5, userid);
		            
		            ps.executeUpdate();
		            conn_mysql.close();
		        } catch (Exception e){
		        	System.out.println(e);
		        	return false;
		          
		        }
		        return true;
		        
		        
		        
		}
		
		
}
