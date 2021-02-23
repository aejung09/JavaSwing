package com.javalec.function;

import shareVar.ShareVar;

public class Bean {

	
	int seqno;
	String category;
	String title;
	String date;
	String user;
	String text;
	String userid;
	String userpw;
	String email;
	String username;
	String usercode;
	
	
	public Bean(int seqno, String category, String title, String userid) {
		super();
		this.seqno = seqno;
		this.category = category;
		this.title = title;
		this.userid = userid;
	}

	public void Bean() {
	
	
	
	}

	public Bean(String username, String email) {
		super();
		this.email = email;
		this.username = username;
	}


	public Bean(String category, String title, String text) {
		super();
		this.category = category;
		this.title = title;
		this.text = text;
	}


	public Bean(String userid, String username, String email, String userpw) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.email = email;
		this.username = username;
	}

	public Bean(int seqno, String category, String title, String date, String user) {
		super();
		this.seqno = seqno;
		this.category = category;
		this.title = title;
		this.date = date;
		this.user = user;
	}



	public int getSeqno() {
		return seqno;
	}



	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

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

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
