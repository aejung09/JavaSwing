package com.javalec.function;



public class BeanPharm {

		public BeanPharm() {
			
		}
		int Phcode;
		String phcode;
		String Phname;
		String Phaddress;
		String Telno;
		String Time;
		
		
		




		public BeanPharm(int phcode) {
			super();
			Phcode = phcode;
		}





		





		public void setPhcode(String phcode) {
			this.phcode = phcode;
		}











		public BeanPharm(String phcode, String phname, String phaddress, String telno, String time) {
			super();
			this.phcode = phcode;
			Phname = phname;
			Phaddress = phaddress;
			Telno = telno;
			Time = time;
		}











		public BeanPharm(String phname, String phaddress, String telno, String time) {
			super();
			Phname = phname;
			Phaddress = phaddress;
			Telno = telno;
			Time = time;
		}



		public BeanPharm(int phcode, String phname, String phaddress, String telno, String time) {
			super();
			Phcode = phcode;
			Phname = phname;
			Phaddress = phaddress;
			Telno = telno;
			Time = time;
		}











		public int getPhcode() {
			return Phcode;
		}











		public void setPhcode(int phcode) {
			Phcode = phcode;
		}











		public String getPhname() {
			return Phname;
		}











		public void setPhname(String phname) {
			Phname = phname;
		}











		public String getPhaddress() {
			return Phaddress;
		}











		public void setPhaddress(String phaddress) {
			Phaddress = phaddress;
		}











		public String getTelno() {
			return Telno;
		}











		public void setTelno(String telno) {
			Telno = telno;
		}











		public String getTime() {
			return Time;
		}











		public void setTime(String time) {
			Time = time;
		}






		
		
		
		
		
		
		
	
}
