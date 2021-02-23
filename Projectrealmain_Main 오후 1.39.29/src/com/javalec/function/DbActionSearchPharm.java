package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.main.realMain;

import shareVar.ShareVar;

public class DbActionSearchPharm {
//	private  String phcode;
//	private final String url_mysql = ShareVar.url_mysql;
//	private final String id_mysql = ShareVar.id_mysql;
//	private final String pw_mysql = ShareVar.pw_mysql;
//	
	String Phcode;
	int phcode;
	String Phname;
	String Phaddress;
	
	public DbActionSearchPharm(int phcode, String phname, String phaddress, String telno, String time) {
		super();
		this.phcode = phcode;
		Phname = phname;
		Phaddress = phaddress;
		Telno = telno;
		Time = time;
	}



	String Telno;
	String Time;
	
	public DbActionSearchPharm(int phcode) {
		super();
		this.phcode = phcode;
	}




	public DbActionSearchPharm() {
	
	}
	
	
	
	
	public DbActionSearchPharm(String phname, String phaddress, String telno, String time) {
		super();
		Phname = phname;
		Phaddress = phaddress;
		Telno = telno;
		Time = time;
	}



	public DbActionSearchPharm(String phcode, String phname, String phaddress, String telno, String time) {
		super();
		Phcode = phcode;
		Phname = phname;
		Phaddress = phaddress;
		Telno = telno;
		Time = time;
	}




	public DbActionSearchPharm(String phcode) {
		super();
		Phcode = phcode;
	}




	public ArrayList<BeanPharm> selectList2(){
		ArrayList<BeanPharm> beanList2 = new ArrayList<BeanPharm>();
		realMain realMain = new realMain();
		String babo2 = realMain.getTfSearch().getText().toString();
	     
	        String WhereDefault = "select phcode, phname, phaddress, telno, time from pharmacy ";
	        String WhereDefault2 = "where phname like '%" + babo2 + "%' or phaddress like '%" +babo2 + "%'";
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

	            while(rs.next()){
	               // String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
	            	int wkPhcode = rs.getInt(1);
	            	String wkPhname = rs.getString(2);
	            	String wkPhaddress = rs.getString(3);
	            	String wkTelno = rs.getString(4);
	            	String wkTime = rs.getString(5);
	            	
	            	BeanPharm beanPharm = new BeanPharm (wkPhcode, wkPhname, wkPhaddress, wkTelno, wkTime);
	            	beanList2.add(beanPharm);		//add는 4개 한번에 들어감
	            
	            }
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	            
	        }
			return beanList2;
		}
	
	
	public BeanPharm tableClick2() {
		BeanPharm beanPharm = null;
		
		//tfSelection.setText(stSequence);
		String WhereDefault = "select phname, phaddress, telno, time from pharmacy "; 
        String WhereDefault2 = "where phcode = '" + phcode+"'";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
            
            if(rs.next()){
            	
            	String wkPhname = (rs.getString(1));
            	String wkPhaddress = (rs.getString(2));
            	String wkTelno = (rs.getString(3));
            	String wkTime = (rs.getString(4));
            	beanPharm = new BeanPharm (wkPhname, wkPhaddress, wkTelno, wkTime);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	return beanPharm;
	}
	
	
	
	public boolean updatePharmAction() {
		PreparedStatement ps = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		String A = "update pharmacy set phname = ?, phaddress = ?, telno = ?, time = ? ";
		String B = "where phcode = ?";
		
		ps = conn_mysql.prepareStatement(A+B);
		
         ps.setString(1, Phname);
         ps.setString(2, Phaddress);
         ps.setString(3, Telno);
         ps.setString(4, Time);
         ps.setInt(5, phcode);
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
