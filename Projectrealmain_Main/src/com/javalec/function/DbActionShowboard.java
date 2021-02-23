package com.javalec.function;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.popup.showBoard;

import shareVar.ShareVar;

public class DbActionShowboard {
	
	int Seqno;
	String Date;
	String Title;
	String Text;
	String Category;
	
	showBoard showBoard = new showBoard();

	
	
public DbActionShowboard(int seqno) {
		super();
		Seqno = seqno;
	}



public DbActionShowboard(int seqno, String date, String title, String text, String category) {
		super();
		Seqno = seqno;
		Date = date;
		Title = title;
		Text = text;
		Category = category;
	}

public DbActionShowboard() {
		
	}
	
	public BeanShowboard tableClickshow() {
		BeanShowboard beanShowboard = null;
		
		//tfSelection.setText(stSequence);
		String WhereDefault = "select seqno, date, title, text, category from board "; 
        String WhereDefault2 = "where seqno = " + Seqno;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
            
            if(rs.next()){
            	int wkSeqno = (rs.getInt(1));
            	String wkDate = (rs.getString(2));
            	String wkTitle = (rs.getString(3));
            	String wkText = (rs.getString(4));
            	String wkCategory = (rs.getString(5));
            	beanShowboard = new BeanShowboard(wkSeqno, wkDate, wkTitle, wkText, wkCategory);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	return beanShowboard;
	}
	
	
	public ArrayList<BeanShowboard> selectListShowboard(){
		ArrayList<BeanShowboard> beanListShowboard = new ArrayList<BeanShowboard>();
	
	        
	        String WhereDefault = "select seqno, date, title, text, category, from board ";
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	            while(rs.next()){
	               // String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
	            	int wkSeqno = (rs.getInt(1));
	            	String wkDate = (rs.getString(2));
	            	String wkTitle = (rs.getString(3));
	            	String wkText = (rs.getString(4));
	            	String wkCategory = (rs.getString(5));
	            	BeanShowboard beanShowboard = new BeanShowboard(wkSeqno, wkDate, wkTitle, wkText, wkCategory);
	            	beanListShowboard.add(beanShowboard);		//add는 4개 한번에 들어감
	            
	            }
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return beanListShowboard;
		}
	
}
