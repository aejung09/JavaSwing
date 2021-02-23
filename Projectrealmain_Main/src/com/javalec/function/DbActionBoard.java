package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.main.realMain;

import shareVar.ShareVar;

public class DbActionBoard {
	

	int seqno;
	String category;
	String title;
	String date;
	String user;
	String text;
	
	
	
	public DbActionBoard(int seqno, String category, String title, String date, String user) {
		super();
		this.seqno = seqno;
		this.category = category;
		this.title = title;
		this.date = date;
		this.user = user;
	}

	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	public DbActionBoard() {
		
	}

	public Bean tableClick() {
		Bean bean = null;
		
		//tfSelection.setText(stSequence);
		String WhereDefault = "select b.seqno, b.category, b.title, b.date, u.userid from board as b, user as u ; "; 
        String WhereDefault2 = "where seqno = " + seqno;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
            
            if(rs.next()){
            	int wkSeq = (rs.getInt(1));
            	String wkCategory = (rs.getString(2));
            	String wkTitle = (rs.getString(3));
            	String wkDate = (rs.getString(4));
            	String wkuser = (rs.getString(5));
            	
            	bean = new Bean(wkSeq, wkCategory, wkTitle, wkDate, wkuser);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	return bean;
	}
	
	
	
	
	
	
	
	

}
