package com.javalec.function;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import shareVar.ShareVar;
import com.mysql.cj.xdevapi.PreparableStatement;


public class DbActionMypage {

	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	int seqno;
	String category;
	String title;
	String date;
	String user;
	
	String phname;
	String phadress;
	String phtel;
	
	String mename;
	String ingredient;
	String effect;
	
	
	String connid;
	String connpcode;
	String connmcode;
	
	
	
    
    
    public DbActionMypage() {
    	super();
		// TODO Auto-generated constructor stub
	} 
    
  
  
public ArrayList<Beanmypage> ConditionList1(){
		
		ArrayList<Beanmypage> BeanList = new ArrayList<Beanmypage>();
		
		String sql= 	"select b.seqno, b.category, b.title, b.text " + 
								"from board as b, user as u  " + 
								"where b.user_usercode = u.usercode and u.userid = '" +ShareVar.nowid+ "'";
		
		
	
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         
            
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();
            ResultSet rs = stmt_mysql.executeQuery(sql);
     
            
           // stmt_mysql.setString(1, ShareVar.nowid);
            while(rs.next()){
            	
            	int wkSeqno = rs.getInt(1);
            	String wkCategory = rs.getString(2);
            	String wkTitle = rs.getString(3);
            	String wkText = rs.getString(4);
            	
            	Beanmypage bean = new Beanmypage(wkSeqno, wkCategory, wkTitle, wkText);
            	BeanList.add(bean);
            }
          // System.out.println(BeanList.get(1).getSeqno());
            
            conn_mysql.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
		return BeanList;
	}
public ArrayList<Beanmypage> ConditionList2(){
	
	ArrayList<Beanmypage> BeanList = new ArrayList<Beanmypage>();
	
	String sql="select p.phname, p.phaddress, p.telno " + 
			"from pharmacy as p, user as u, phlike as l "+
			"where l.pharmacy_phcode= p.phcode and l.user_usercode = u.usercode and l.user_usercode ='"+ShareVar.nowusercode+"'";

	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		ResultSet rs = stmt_mysql.executeQuery(sql);
		
		
		// stmt_mysql.setString(1, ShareVar.nowid);
		while(rs.next()){
			
		
			String wkDate = rs.getString(1);
			String wkCategory = rs.getString(2);
			String wkTitle = rs.getString(3);
			
			Beanmypage bean = new Beanmypage(wkCategory, wkTitle, wkDate);
			BeanList.add(bean);
		}
	
		
		conn_mysql.close();
	}
	catch (Exception e){
		System.out.println(e);
	}
	return BeanList;
}
public ArrayList<Beanmypage> ConditionList3(){
	
	ArrayList<Beanmypage> BeanList = new ArrayList<Beanmypage>();
	
	String sql=	"select m.mname, m.effect, m.ingredient "+
			"from medicine as m, user as u, medilike as l "+
			"where l.medicine_mcode= m.mcode and l.user_usercode = u.usercode and l.user_usercode ='"+ShareVar.nowusercode+"'";

	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		ResultSet rs = stmt_mysql.executeQuery(sql);
		
		
		// stmt_mysql.setString(1, ShareVar.nowid);
		while(rs.next()){
			
			
			String wkDate = rs.getString(1);
			String wkCategory = rs.getString(2);
			String wkTitle = rs.getString(3);
			
			Beanmypage bean = new Beanmypage(wkCategory, wkTitle, wkDate);
			BeanList.add(bean);
		}
		
		
		conn_mysql.close();
	}
	catch (Exception e){
		System.out.println(e);
	}
	return BeanList;
}
//			public ArrayList<Beanmypage> ConditionList3(){
//				
//				ArrayList<Beanmypage> BeanList = new ArrayList<Beanmypage>();
//				
//				String sql= 	"select m.mname, m.effect, m.ingredient"+
//								"from medicine as m, user as u, medilike as l"+
//								"where l.medicine_mcode= m.mcode and l.user_usercode = u.usercode and u.userid ='"+ShareVar.nowid+ "'";
//				
//				
//				
//				try{
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					
//					
//					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//					Statement stmt_mysql = conn_mysql.createStatement();
//					ResultSet rs = stmt_mysql.executeQuery(sql);
//					
//					
//					// stmt_mysql.setString(1, ShareVar.nowid);
//					while(rs.next()){
//						
//						String wkDate = rs.getString(1);
//						String wkCategory = rs.getString(2);
//						String wkTitle = rs.getString(3);
//						
//						
//						Beanmypage bean = new Beanmypage( wkCategory, wkTitle, wkTitle);
//						BeanList.add(bean);
//					}
//					System.out.println(BeanList.get(0).getSeqno());
//					
//					conn_mysql.close();
//				}
//				catch (Exception e){
//					System.out.println(e);
//				}
//				return BeanList;
//			}
//
//    
    



    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    

