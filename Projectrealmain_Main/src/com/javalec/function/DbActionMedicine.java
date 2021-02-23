
	package com.javalec.function;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import javax.swing.JOptionPane;


	import shareVar.ShareVar;

	public class DbActionMedicine {



		
		
		public DbActionMedicine() {
			
		}


//		private  String url_mysql = ShareVar.url_mysql;
//		private  String id_mysql = ShareVar.id_mysql;
//		private  String pw_mysql = ShareVar.pw_mysql;
		
		

		
		
		int likecount = 0;
		
		
	
		
		
 public int likecount() {

	 String A= "Select sum(lcode) from medilike where medicine_mcode = '"+ShareVar.nowmcode+"'";
	 try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	     @SuppressWarnings("unused")
	     Statement stmt_mysql = conn_mysql.createStatement();
	     ResultSet rs= stmt_mysql.executeQuery(A);
	     
	     if(rs.next()) {
	    	 int wklcode =rs.getInt(1);
	    	 likecount=wklcode;
	    	 System.out.println(likecount);
	    	 
	     }
     	}
     catch(Exception e) {
    	 System.out.println("카운트에러");
    	 
     }
     
	 return likecount;
	// ShareVar.nowlikecount=likecount;
	 
}
 
 
 
 int likecheck = 2;
		public int likecheck() {
		 String A= "Select lcode from medilike where user_usercode='"+ShareVar.nowusercode+"' and medicine_mcode='"+ShareVar.nowmcode+"'";
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
			
				           String A = "insert into medilike (medicine_mcode, user_usercode, lcode ";
				           String B = ") values (?,?,?)";
				           
				           ps = conn_mysql.prepareStatement(A+B);
				           ps.setString(1, ShareVar.nowmcode);				         
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

		    	           String A = "UPDATE medilike SET lcode='1' where medicine_mcode='"+ShareVar.nowmcode+"' and user_usercode= '"+ShareVar.nowusercode+"'";
		    	   
		    	     
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

		    	           String A = "UPDATE medilike SET lcode='0' where medicine_mcode='"+ShareVar.nowmcode+"' and user_usercode= '"+ShareVar.nowusercode+"'";
		
		    	           
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
