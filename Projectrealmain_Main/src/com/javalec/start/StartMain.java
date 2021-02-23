package com.javalec.start;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.javalec.find.Find;
import com.javalec.join.Join;
//>>>>MainBoard 만들 경우에 import 해주기!!<<<<
//import com.javalec.test.MainBoard; 
import com.javalec.main.realMain;

import shareVar.ShareVar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartMain extends JDialog {
	private JTextField tfId;
	private JPasswordField tfPw;

	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	private JFrame frame;
	private JLabel lblNewLabel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMain dialog = new StartMain();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true); //창띄우기 
					dialog.setResizable(false);// 창크기 조절 x 
					dialog.setLocationRelativeTo(null); // 창 가운데로
					dialog.setTitle("Copyright ⓒ 2020.겨우다했조.박인영,주혜정,유민규,도하진,최지...All Rights Reserved.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public StartMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfId.requestFocus();
			}
		});
		setBounds(100, 100, 450, 620);
		getContentPane().setLayout(null);
		
		tfId = new JTextField(1);
		tfId.setBounds(94, 214, 110, 21);
		getContentPane().add(tfId);
		tfId.setColumns(1);
		
		tfPw = new JPasswordField(10);
		tfPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logincheck();
			}
		});
		tfPw.setBounds(254, 214, 110, 21);
		getContentPane().add(tfPw);
		
		
		// Login 버튼 눌러줬을때, 저장 되어있던 Method 불러주기. 
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			logincheck();
		
				}
		});
		btnLogin.setBounds(264, 522, 145, 42);
		getContentPane().add(btnLogin);
		
		
		//Join 버튼을 눌렀을때, Join 창으로 가게해준다.
		JButton btnJoin = new JButton("JOIN");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotojoin();
			}
		});
		btnJoin.setBounds(33, 521, 146, 43);
		getContentPane().add(btnJoin);
		
		
		//Id/Pw 찾기 버튼 눌렀을때, Find 창 띄워주기.
		JButton btnFind = new JButton("ID/PW \uCC3E\uAE30");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotofind();
			}
		});
		btnFind.setBounds(309, 27, 112, 23);
		getContentPane().add(btnFind);
		getContentPane().add(getLblNewLabel_1());}

		
	
	
		//Login버튼 눌렀을때, 맞을경우엔 MainBoard로 가고 아닐경우엔 아니라고 팝업 띄워주기.
		//Login Method 
		public void logincheck() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				String sql= "select userid, userpw, username, email,  usercode from user " ; 
				//String sql2= "where userid = '" +tfId.getText()+"' and userpw= '" + String.valueOf(tfPw.getPassword()) +"' and userstatus = '회원'";
				String sql2= "where userid = '" +tfId.getText()+"' and userpw= '" + tfPw.getText() +"' and userstatus = '회원' ";
			
					
				ResultSet rs=stmt_mysql.executeQuery(sql+sql2);
				//System.out.println(sql+ sql2);
				
				
				
				//>>>> MainBoard완성 되면 붙여 넣기!!<<<<
				
				String nowid;
					nowid = tfId.getText().trim();
					
					if(rs.next() == true) {
						ShareVar.nowid = rs.getString(1);
						//ShareVar.nowpw = rs.getString(2);
						ShareVar.nowname = rs.getString(2);
						ShareVar.nowemail = rs.getString(3);
						ShareVar.nowpw = rs.getString(4);
						ShareVar.nowemailaddress = rs.getString(5);
//						ShareVar.nowusercode = rs.getString(5);
						realMain realMain = new realMain();
						gotomain();
						
						dispose();
					
					} else {
						JOptionPane.showMessageDialog(StartMain.this, "아이디와 비밀번호를 확인하세요!");
					}

				conn_mysql.close();
			
		
					
			} catch (Exception e) {
				
			
				System.out.println(e);
			}
		
			
		}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/Login.png"));
			lblNewLabel_1.setBounds(0, 0, 450, 600);
		}
		return lblNewLabel_1;
	}
	public void gotomain(){
		realMain main= new realMain();
		main.main(null);
		
		
	}
	public void gotojoin() {
	Join join = new Join();
	join.setVisible(true); // 창띄우기.
	join.setLocationRelativeTo(null); //창 가운데로 불러주기.
	join.setResizable(false);
	}
	public void gotofind() {
		Find find = new Find();
		find.setVisible(true); // 창띄우기 
		find.setLocationRelativeTo(null); //창 가운데
		find.setResizable(false); // 창 조절 x 
	}
}

