package com.javalec.function;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.main.realMain;
import com.javalec.update.Pharmacy;

import shareVar.*;

public class DbActionSearch {

	
	String mcode;
	String mname;
	String effect;
	String dosage;
	String company;
	String ingredient;
	
	


	
	public DbActionSearch() {
		
	}




	public DbActionSearch(String mcode) {
		super();
		this.mcode = mcode;
	}

	public DbActionSearch(String mname, String effect, String dosage, String company, String ingredient) {
		super();
		this.mname = mname;
		this.effect = effect;
		this.company = company;
		this.ingredient = ingredient;
		this.dosage = dosage;
	}





	public DbActionSearch(String mcode, String mname, String effect, String dosage, String company, String ingredient) {
		super();
		this.mcode = mcode;
		this.mname = mname;
		this.effect = effect;
		this.dosage = dosage;
		this.company = company;
		this.ingredient = ingredient;
	}
	
	
	
	
	



	public ArrayList<BeanMedicine> selectList(){
		ArrayList<BeanMedicine> beanList = new ArrayList<BeanMedicine>();
		realMain realMain = new realMain();
		String babo = realMain.getTfSearch().getText().toString();
	     
	        String WhereDefault = "select mcode, mname, effect, dosage, company, ingredient from medicine ";
	        String WhereDefault2 = "where mname like '%" + babo + "%' or effect like '%" +babo + "%'";
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

	            while(rs.next()){
	               // String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
	            	int wkMcode = rs.getInt(1);
	            	String wkName = rs.getString(2);
	            	String wkEffect = rs.getString(3);
	            	String wkDosage = rs.getString(4);
	            	String wkCompany = rs.getString(5);
	            	String wkIngredient = rs.getString(6);
	            	BeanMedicine beanMedicine = new BeanMedicine (wkMcode, wkName, wkEffect, wkDosage, wkCompany, wkIngredient);
	            	beanList.add(beanMedicine);		//add는 4개 한번에 들어감
	            
	            }
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	            
	        }
			return beanList;
		}
	

	
	
	public BeanMedicine tableClick() {
		BeanMedicine beanMedicine = null;
		
		//tfSelection.setText(stSequence);
		String WhereDefault = "select mcode, mname, effect, company, ingredient, dosage from medicine "; 
        String WhereDefault2 = "where mcode = " +mcode;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
            
            if(rs.next()){
            	int wkMcode = (rs.getInt(1));
            	String wkMname = (rs.getString(2));
            	String wkEffect = (rs.getString(3));
            	String wkCompany = (rs.getString(4));
            	String wkIngredient = (rs.getString(5));
            	String wkDosage = (rs.getString(6));
            	beanMedicine = new BeanMedicine (wkMcode, wkMname, wkEffect, wkCompany, wkIngredient, wkDosage);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	return beanMedicine;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
