package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


import shareVar.ShareVar;

public class DbActionPharmacy {



	
	
	public DbActionPharmacy() {
		
	}


//	private  String url_mysql = ShareVar.url_mysql;
//	private  String id_mysql = ShareVar.id_mysql;
//	private  String pw_mysql = ShareVar.pw_mysql;
	
	

	
	
	int likecount = 0;
	
	

	
	
public int likecount() {

 String A= "Select sum(lcode) from phlike where pharmacy_phcode = '"+ShareVar.nowphcode+"'";
 try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
     @SuppressWarnings("unused")
     Statement stmt_mysql = conn_mysql.createStatement();
     ResultSet rs= stmt_mysql.executeQuery(A);
     
     if(rs.next()) {
    	 int wklcode =rs.getInt(1);
    	 System.out.println(wklcode);
    	 likecount=wklcode;
    	 
     }
 	}
 catch(Exception e) {
	 System.out.println("카운트에러");
	 
 }
 System.out.println("aaa"+likecount+";"+ShareVar.nowphcode);
 return likecount;
// ShareVar.nowlikecount=likecount;
 
}



int likecheck = 2;
	public int likecheck() {
	 String A= "Select lcode from phlike where user_usercode='"+ShareVar.nowusercode+"' and pharmacy_phcode='"+ShareVar.nowphcode+"'";
	 try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	     @SuppressWarnings("unused")
	     Statement stmt_mysql = conn_mysql.createStatement();
	     ResultSet rs= stmt_mysql.executeQuery(A);
	     
	     if(rs.next()) {
	    	 int wklcode =rs.getInt(1);
	    	 likecheck=wklcode;
	    	 System.out.println(likecheck);
	     }
     	}
     catch(Exception e) {
    	 System.out.println("체크에러");
    	 
     }
     
	 return likecheck;

	}
	
	
	

			public boolean insertAction(String nowmcode, String nowusercode, int lcode) {//이 메소드는 건들지 말것!
				 PreparedStatement ps = null;
			       try{
			           Class.forName("com.mysql.cj.jdbc.Driver");
			           Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
			           @SuppressWarnings("unused")
						Statement stmt_mysql = conn_mysql.createStatement();
		
			           String A = "insert into phlike (pharmacy_phcode, user_usercode, lcode ";
			           String B = ") values (?,?,?)";
			           
			           ps = conn_mysql.prepareStatement(A+B);
			           ps.setString(1, ShareVar.nowphcode);	
			           
			           ps.setString(2, ShareVar.nowusercode);
			           ps.setInt(3, 1);
			  
			           ps.executeUpdate();
		
			           conn_mysql.close();
			       } catch (Exception e){
			    	   System.out.println(e);
			       	return false;
			         
			       }
			       return true;
			
			}
			
			
	
	       public boolean updateAction(int lcode) {
	    		 PreparedStatement ps = null;
	    	       try{
	    	           Class.forName("com.mysql.cj.jdbc.Driver");
	    	           Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	    	           @SuppressWarnings("unused")
	    				Statement stmt_mysql = conn_mysql.createStatement();

	    	           String A = "UPDATE phlike SET lcode='1' where pharmacy_phcode='"+ShareVar.nowphcode+"' and user_usercode= '"+ShareVar.nowusercode+"'";
	    	   
	    	     
	    	           ps = conn_mysql.prepareStatement(A);
	    	       
	    	          
	    	  
	    	           ps.executeUpdate();

	    	           conn_mysql.close();
	    	       } catch (Exception e){
	    	    	   System.out.println(e);
	    	       	return false;
	    	         
	    	       }
	    	       return true;
	       }
	
	       
	       
	       public boolean deleteAction(int lcode) {
	    		 PreparedStatement ps = null;
	    	       try{
	    	           Class.forName("com.mysql.cj.jdbc.Driver");
	    	           Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	    	           @SuppressWarnings("unused")
	    				Statement stmt_mysql = conn_mysql.createStatement();

	    	           String A = "UPDATE phlike SET lcode='0' where pharmacy_phcode='"+ShareVar.nowphcode+"' and user_usercode= '"+ShareVar.nowusercode+"'";
	
	    	           
	    	           ps = conn_mysql.prepareStatement(A);
	    	       
	    	         
	    	           ps.executeUpdate();

	    	           conn_mysql.close();
	    	       } catch (Exception e){
	    	    	   System.out.println(e);
	    	       	return false;
	    	         
	    	       }
	    	       return true;




	       }




}

