package com.javalec.function;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import shareVar.ShareVar;

public class DbAction {
	

	public DbAction(String email, String username) {
		super();
		this.email = email;
		this.username = username;
	}



	private  String url_mysql = ShareVar.url_mysql;
	private  String id_mysql = ShareVar.id_mysql;
	private  String pw_mysql = ShareVar.pw_mysql;
	
	
	
	String userid;
	String userpw;
	String email;
	String username;
	String usercode;
//	String mcode;
	int mcode;
	String mname;
	String effect;
	String dosage;
	String company;
	String ingredient;
	
	
	int phcode;
	String phname;
	String phaddress;
	String telno;
	String time;
	
	
	
	
	
	
	
	


//	public DbAction(String mcode, String mname, String effect, String dosage, String company, String ingredient) {
//		super();
//		this.mcode = mcode;
//		this.mname = mname;
//		this.effect = effect;
//		this.dosage = dosage;
//		this.company = company;
//		this.ingredient = ingredient;
//	}



	public DbAction(int phcode, String phname, String phaddress, String telno, String time) {
		super();
		this.phcode = phcode;
		this.phname = phname;
		this.phaddress = phaddress;
		this.telno = telno;
		this.time = time;
	}



	public DbAction(int mcode, String mname, String effect, String dosage, String company, String ingredient) {
		super();
		this.mcode = mcode;
		this.mname = mname;
		this.effect = effect;
		this.dosage = dosage;
		this.company = company;
		this.ingredient = ingredient;
	}



	public DbAction(String mname, String effect, String dosage, String company, String ingredient) {
		super();
		this.mname = mname;
		this.effect = effect;
		this.dosage = dosage;
		this.company = company;
		this.ingredient = ingredient;
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



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public DbAction(String userid, String username, String email, String userpw) {
		super();
		this.userid = userid;
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

	            String A = "insert into user (userid, username, email, userpw) values (?,?,?,?) ";
	         //   String B = "' ) values (?,?,now());";

	            ps = conn_mysql.prepareStatement(A);
	            ps.setString(1,userid );
	            ps.setString(2,username);
	            ps.setString(3, email);
	            ps.setString(4, userpw);
	            
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
	    public boolean insertMedicineAction() {
	   		 PreparedStatement ps = null;
	   	        try{
	   	            Class.forName("com.mysql.cj.jdbc.Driver");
	   	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//	   	            @SuppressWarnings("unused")
	   				Statement stmt_mysql = conn_mysql.createStatement();

	   	            String A = "insert into medicine (mcode, mname, effect, company, ingredient, dosage";
	   	            String B = ") values (?,?,?,?,?,?)";
	   	            
	   	            ps = conn_mysql.prepareStatement(A+B);
	   	            ps.setInt(1, mcode);
	   	            ps.setString(2, mname);
	   	            ps.setString(3, effect);
	   	            ps.setString(4, company);
	   	            ps.setString(5, ingredient);
	   	            ps.setString(6, dosage);
	   	            ps.executeUpdate();

	   	            conn_mysql.close();
	   	        } catch (Exception e){
	   	        	System.out.println(e);
	   	        	return false;
	   	          
	   	        }
	   	        return true;
	   	}
	        
	    
	    public boolean insertPharmAction() {
	   		 PreparedStatement ps = null;
	   	        try{
	   	            Class.forName("com.mysql.cj.jdbc.Driver");
	   	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//	   	            @SuppressWarnings("unused")
	   				Statement stmt_mysql = conn_mysql.createStatement();

	   	            String A = "insert into pharmacy (phcode, phname, phaddress, telno, time";
	   	            String B = ") values (?,?,?,?,?)";
	   	            
	   	            ps = conn_mysql.prepareStatement(A+B);
	   	            ps.setInt(1, phcode);
	   	            ps.setString(2, phname);
	   	            ps.setString(3, phaddress);
	   	            ps.setString(4, telno);
	   	            ps.setString(5, time);
	   	            ps.executeUpdate();

	   	            conn_mysql.close();
	   	        } catch (Exception e){
	   	        	System.out.println(e);
	   	        	return false;
	   	          
	   	        }
	   	        return true;
	   	}      
	    
	    



		public boolean updateMedicineAction() {
			PreparedStatement ps = null;
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "update medicine set mname = ?, effect = ?, company = ?, ingredient = ?, dosage = ? ";
			String B = "where mcode = ?";
			
			ps = conn_mysql.prepareStatement(A+B);
			
	         ps.setString(1, mname);
	         ps.setString(2, effect);
	         ps.setString(3, ingredient);
	         ps.setString(4, company);
	         ps.setString(5, dosage);
	         ps.setInt(6, mcode);
	         ps.executeUpdate();
			conn_mysql.close();
			
			}
			catch(Exception e){
				System.out.println(e);
				return false;
			}
			return true;
	    
	}
}
	
	
	

