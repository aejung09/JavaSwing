package com.javalec.function;

public class BeanMedicine {
//	String mcode;
	int mcode;
	String mname;
	String effect;
	String dosage;
	String company;
	String ingredient;
	
	public BeanMedicine() {
		
	}
	
	
	
	public BeanMedicine(int mcode) {
		super();
		this.mcode = mcode;
	}




	


	
	


//
//	public String getMcode() {
//		return mcode;
//	}
//
//
//
//	public void setMcode(String mcode) {
//		this.mcode = mcode;
//	}



	public int getMcode() {
		return mcode;
	}



	public void setMcode1(int mcode) {
		this.mcode = mcode;
	}


//
//	public BeanMedicine(String mcode, String mname, String effect, String dosage, String company, String ingredient) {
//		super();
//		this.mcode = mcode;
//		this.mname = mname;
//		this.effect = effect;
//		this.dosage = dosage;
//		this.company = company;
//		this.ingredient = ingredient;
//	}






	public BeanMedicine(String mname, String effect, String ingredient, String company, String dosage) {
		super();
		this.mname = mname;
		this.effect = effect;
		this.ingredient = ingredient;
		this.company = company;
		this.dosage = dosage;
	}



	

	public BeanMedicine(int mcode, String mname, String effect,  String company, String ingredient, String dosage) {
		super();
		this.mcode = mcode;
		this.mname = mname;
		this.effect = effect;
		this.dosage = dosage;
		this.company = company;
		this.ingredient = ingredient;
	}



	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getEffect() {
		return effect;
	}



	public void setEffect(String effect) {
		this.effect = effect;
	}



	public String getDosage() {
		return dosage;
	}



	public void setDosage(String dosage) {
		this.dosage = dosage;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getIngredient() {
		return ingredient;
	}



	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}



	

}

