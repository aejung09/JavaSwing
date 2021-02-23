package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import shareVar.ShareVar;

public class BeanShowboard {


	
	int Seqno;
	String Date;
	String Title;
	String Text;
	String Category;
	
	
	public BeanShowboard () {
		
	}
	
	
	
	
	
	public BeanShowboard(int seqno) {
		super();
		Seqno = seqno;
	}







	public BeanShowboard(int seqno, String date, String title, String text, String category) {
		super();
		Seqno = seqno;
		Date = date;
		Title = title;
		Text = text;
		Category = category;
	}








	public int getSeqno() {
		return Seqno;
	}








	public void setSeqno(int seqno) {
		Seqno = seqno;
	}








	public String getDate() {
		return Date;
	}








	public void setDate(String date) {
		Date = date;
	}








	public String getTitle() {
		return Title;
	}








	public void setTitle(String title) {
		Title = title;
	}








	public String getText() {
		return Text;
	}








	public void setText(String text) {
		Text = text;
	}








	public String getCategory() {
		return Category;
	}








	public void setCategory(String category) {
		Category = category;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
