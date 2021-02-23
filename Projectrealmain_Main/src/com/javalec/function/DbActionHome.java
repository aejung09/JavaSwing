package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import shareVar.ShareVar;

public class DbActionHome {

	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	int seqno;
	String category;
	String title;
	String date;
	String user;
	String text;
	
	public DbActionHome() {
		
	}
	
	
	public DbActionHome(int seqno, String category, String title, String date, String user) {
		super();
		this.seqno = seqno;
		this.category = category;
		this.title = title;
		this.date = date;
		this.user = user;
	}
	
	public ArrayList<Bean> selectList(){
		ArrayList<Bean> beanList = new ArrayList<Bean>();
	
	        
	        String WhereDefault = "select seqno, category, title, date, userid from board, user where usercode=user_usercode and date is null";
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	            while(rs.next()){
	               // String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
	            	int wkSeq = rs.getInt(1);
	            	String wkCategory = rs.getString(2);
	            	String wkTitle = rs.getString(3);
	            	String wkDate = rs.getString(4);
	            	String wkUser = rs.getString(5);
	            	
	            	Bean bean = new Bean(wkSeq, wkCategory, wkTitle, wkDate, wkUser);
	            	beanList.add(bean);		//add는 4개 한번에 들어감
	            
	            }
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            System.out.println(e );
	        }
			return beanList;
		}

	
	
	
	
	
	
	
	
}
