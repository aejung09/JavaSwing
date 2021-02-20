
package com.javalec.update;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.DbActionLogin;
import com.javalec.join.Join;
import com.javalec.main.realMain;
import com.javalec.start.StartMain;

import shareVar.ShareVar;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class Update extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rbupdate;
	private JRadioButton rbWithdrawal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField tfUpId;
	private JTextField tfUpPwChkShow;
	private JTextField tfUpName;
	private JTextField tfUpEmail;
	private JLabel label_5;
	private JComboBox cbUpEmailAddre;
	private JLabel label_6;
	private JPasswordField tfUpPw;
	private JPasswordField tfUpPwChk;
	private JTextField tfUpPwLength;
	private JTextField tfUpEmailAdd;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Update dialog = new Update();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setResizable(false);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Update() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				tfUpId.setText(ShareVar.nowid);
			}
		});
		setTitle("회원정보 수정 및 탈퇴");
		setBounds(100, 100, 566, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getRbupdate());
		contentPanel.add(getRbWithdrawal());
		contentPanel.add(getLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
		contentPanel.add(getLabel_3());
		contentPanel.add(getLabel_4());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnNewButton_1());
		contentPanel.add(getTfUpId());
		contentPanel.add(getTfUpPwChkShow());
		contentPanel.add(getTfUpName());
		contentPanel.add(getTfUpEmail());
		contentPanel.add(getLabel_5());
		contentPanel.add(getCbUpEmailAddre());
		contentPanel.add(getLabel_6());
		contentPanel.add(getTfUpPw());
		contentPanel.add(getTfUpPwChk());
		contentPanel.add(getTfUpPwLength());
		contentPanel.add(getTfUpEmailAdd());
		contentPanel.add(getLblNewLabel());
	}
	private JRadioButton getRbupdate() {
		if (rbupdate == null) {
			rbupdate = new JRadioButton("수정하기");
			rbupdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rbupdate.isSelected()==true) {
						tfUpName.setEditable(true);
						tfUpEmail.setEditable(true);
						tfUpEmailAdd.setEditable(true);
					}
				}
			});
			rbupdate.setBounds(152, 160, 139, 27);
			buttonGroup.add(rbupdate);
		}
		return rbupdate;
	}
	private JRadioButton getRbWithdrawal() {
		if (rbWithdrawal == null) {
			rbWithdrawal = new JRadioButton("탈퇴하기");
			rbWithdrawal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					tfUpName.setText(ShareVar.nowname);
					tfUpEmail.setText(ShareVar.nowemail);
					tfUpEmailAdd.setText(ShareVar.nowemailaddress);
//					cbUpEmailAddre.setEditable(false);
//					cbUpEmailAddre.setSelectedItem(ShareVar.nowemailaddress);
					System.out.println(ShareVar.nowname);
					if(rbWithdrawal.isSelected()==true) {
						tfUpName.setEditable(false);
						tfUpEmail.setEditable(false);
						tfUpEmailAdd.setEditable(false);
						cbUpEmailAddre.setEnabled(false);
						
//						cbUpEmailAddre.setSelectedItem(false);
					}
					
				}
			});
			rbWithdrawal.setBounds(336, 160, 139, 27);
			buttonGroup.add(rbWithdrawal);
		}
		return rbWithdrawal;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("아이디");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(73, 213, 62, 18);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("비밀번호");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(73, 260, 62, 18);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("비밀번호 확인");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(46, 290, 89, 18);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("이름");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(73, 353, 62, 18);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("이메일");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setBounds(73, 383, 62, 18);
		}
		return label_4;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("뒤로가기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
				}
			});
			btnNewButton.setBounds(137, 428, 105, 27);
		
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("확인");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rbupdate.isSelected()==true) {
						updateFieldCheck();
						
					}else if(rbWithdrawal.isSelected()==true) {
//						JOptionPane.showMessageDialog(Update2.this, "탈퇴가 완료되었습니다");
//						deleteChk();
						int result = JOptionPane.showConfirmDialog(Update.this, "탈퇴를 하시겠습니까?","회원탈퇴",JOptionPane.YES_NO_OPTION);
						if(result==JOptionPane.YES_OPTION) {
							if(tfUpPw.getText().equals(ShareVar.nowpw)) {
								JOptionPane.showMessageDialog(Update.this, "탈퇴가 완료되었습니다.");
								deleteChk();
							}
							else {
								JOptionPane.showMessageDialog(Update.this, "탈퇴 실패하였습니다.");
							}
						}
					
					}
					else {
						JOptionPane.showMessageDialog(Update.this, "항목을 선택해주세요.");
					}
				}
			});
			btnNewButton_1.setBounds(330, 428, 105, 27);
		}
		return btnNewButton_1;
	}
	private JTextField getTfUpId() {
		if (tfUpId == null) {
			tfUpId = new JTextField();
			tfUpId.setHorizontalAlignment(SwingConstants.RIGHT);
			tfUpId.setEditable(false);
			
			tfUpId.setBorder(null);
			tfUpId.setBounds(191, 210, 116, 24);
			tfUpId.setColumns(10);
		}
		return tfUpId;
	}
	private JTextField getTfUpPwChkShow() {
		if (tfUpPwChkShow == null) {
			tfUpPwChkShow = new JTextField();
			tfUpPwChkShow.setEditable(false);
			tfUpPwChkShow.setOpaque(false);
			tfUpPwChkShow.setBorder(null);
			tfUpPwChkShow.setColumns(10);
			tfUpPwChkShow.setBounds(191, 314, 257, 24);
		}
		return tfUpPwChkShow;
	}
	private JTextField getTfUpName() {
		if (tfUpName == null) {
			tfUpName = new JTextField();
			//ShareVar.nowname = tfUpName.getText();
		
			tfUpName.setColumns(10);
			tfUpName.setBounds(191, 350, 116, 24);
		}
		return tfUpName;
	}
	private JTextField getTfUpEmail() {
		if (tfUpEmail == null) {
			tfUpEmail = new JTextField();
			tfUpEmail.setColumns(10);
			tfUpEmail.setBounds(191, 380, 89, 24);
		}
		return tfUpEmail;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("@");
			label_5.setBounds(294, 383, 18, 18);
		}
		return label_5;
	}
	private JComboBox getCbUpEmailAddre() {
		if (cbUpEmailAddre == null) {
			cbUpEmailAddre = new JComboBox();
			cbUpEmailAddre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbUpEmailAddre.getSelectedItem().toString() =="직접입력") {
						tfUpEmailAdd.setText("");
						tfUpEmailAdd.setEditable(true);
					}
					else {
						tfUpEmailAdd.setEditable(false);
						tfUpEmailAdd.setText(cbUpEmailAddre.getSelectedItem().toString());
					}
					
				}
			});
			cbUpEmailAddre.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "naver.com", "daum.net", "gmail.com"}));
			cbUpEmailAddre.setBounds(424, 380, 98, 24);
		}
		return cbUpEmailAddre;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("님");
			label_6.setBounds(311, 213, 18, 18);
		}
		return label_6;
	}
	
	public boolean updateAction() {
		String username = tfUpName.getText() ;
		String userpw = tfUpPw.getText();
		String useremail = tfUpEmail.getText();
		String useremailaddress = cbUpEmailAddre.getSelectedItem().toString();
		String userid = tfUpId.getText();
//		String userid = myIdTf.getText();
		PreparedStatement ps = null;
		
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();

		
		
		String A = "update user set userid = ' " + ShareVar.nowid +"', username = ?, email = ? , userpw = ? useremailaddress = ? ";
		String B = "where userid = ? ";


		
		
		
		ps = conn_mysql.prepareStatement(A+B);
		
		 ps.setString(1, userid);
		 ps.setString(2,username);
		 ps.setString(3,useremail);
		 ps.setString(4,userpw);
		 ps.setString(5,useremailaddress);
		 ps.executeUpdate();
		 conn_mysql.close();
//		 JOptionPane.showMessageDialog(Update.this, "수정이 완료 되었습니다.");
		 
		}
		catch(Exception e){
		System.out.println(e);
//		updateFieldCheck();
//		JOptionPane.showMessageDialog(Update.this, "수정을 실패하였습니다.");
		return false;
	}
	return true;
}
	private JPasswordField getTfUpPw() {
		if (tfUpPw == null) {
			tfUpPw = new JPasswordField();
			tfUpPw.setEchoChar('*');
			tfUpPw.addKeyListener(new KeyAdapter() {
				
				
				@Override
				public void keyReleased(KeyEvent e) {
					pwlength();
					pwchek();
				}
			});
			tfUpPw.setBounds(191, 257, 116, 24);
		}
		return tfUpPw;
	}
	private JPasswordField getTfUpPwChk() {
		if (tfUpPwChk == null) {
			tfUpPwChk = new JPasswordField();
			tfUpPwChk.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					pwlength();
					pwchek();
					
				}
			});
			tfUpPwChk.setEchoChar('*');
			tfUpPwChk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwchek();
				}
			});
			tfUpPwChk.setBounds(191, 287, 116, 24);
		}
		return tfUpPwChk;
	}
	private JTextField getTfUpPwLength() {
		if (tfUpPwLength == null) {
			tfUpPwLength = new JTextField();
			tfUpPwLength.setForeground(new Color(192, 192, 192));
			tfUpPwLength.setEditable(false);
			tfUpPwLength.setOpaque(false);
			tfUpPwLength.setBorder(null);
			
			tfUpPwLength.setBounds(318, 257, 156, 24);
			tfUpPwLength.setColumns(10);
		}
		return tfUpPwLength;
	}
	private void pwlength() {
		
		 if(tfUpPw.getText().length()<8) {
			tfUpPwLength.setText("8글자 이상 적어주세요.");
		}
		if(tfUpPw.getText().length()>=7) {
			tfUpPwLength.setText("");
		}
	}
	private void pwchek() {
			
			if(tfUpPw.getText().length()!=0) {
				if(tfUpPw.getText().equals(tfUpPwChk.getText())){
					tfUpPwChkShow.setText("비밀번호가 일치합니다.");
					tfUpPwChkShow.setForeground(Color.blue);
				
				}else {
					tfUpPwChkShow.setText("비밀번호가 일치하지 않습니다.");
					tfUpPwChkShow.setForeground(Color.red);
				}
			
			}
	
		}
	
	private int updateFieldCheck(){
		String userid = tfUpId.getText().trim();
		String username=tfUpName.getText().trim();
		String email=tfUpEmail.getText().trim();
		String userpw = tfUpPw.getText().trim();
		String emailaddress = cbUpEmailAddre.getSelectedItem().toString();
		updateAction();
		
//		pwCheck();
		
		ShareVar.nowname = username;
		ShareVar.nowid = userid;
			
		
		 if(tfUpPw.getText().length() == 0){
			
			tfUpPw.requestFocus();
			userpw = tfUpPw.getText();
			userpw = ShareVar.nowpw;
			JOptionPane.showMessageDialog(Update.this, "비밀번호를 확인하세요.");
			return 0;
		}
	
		 if(tfUpPwChk.getText().length() == 0){
			
			tfUpPwChk.requestFocus();
			JOptionPane.showMessageDialog(Update.this, "비밀번호 확인을 해주세요.");
			return 0;
		 }
	
		 if(tfUpName.getText().length() == 0){
			tfUpName.requestFocus();
//			username = tfUpName.getText();
//			username = ShareVar.nowname;
			JOptionPane.showMessageDialog(Update.this, "이름 확인하세요.");
			return 0;
		}
		 if(tfUpEmail.getText().length() == 0){
			tfUpEmail.requestFocus();
			
			JOptionPane.showMessageDialog(Update.this, "Email 확인하세요.");
			return 0;
		}
		 if ( cbUpEmailAddre.getSelectedItem().toString()=="") {
				JOptionPane.showMessageDialog(Update.this, "이메일 주소를 선택 해주세요.");
				cbUpEmailAddre.requestFocus();
				return 0;
				}
		 if(tfUpPw.getText().equals(tfUpPwChk.getText())) {
			DbActionLogin dbActionlogin = new DbActionLogin(username, email, userpw,emailaddress);
			dbActionlogin.updateAction();
			
			JOptionPane.showMessageDialog(Update.this, "수정이 완료 되었습니다.");
			dispose();
			return 0;
			}
	 return 0;
	}
	private void userDeleteAction() {
		
		String username = tfUpName.getText() ;
		String userpw = tfUpPw.getText();
		String useremail = tfUpEmail.getText();
//		String userid = myIdTf.getText();
		PreparedStatement ps = null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();

		
		
		String A = "update user set userstatus = '탈퇴'";
		String B = "where userid = '" +ShareVar.nowid+ "'";

		
		
		
		ps = conn_mysql.prepareStatement(A+B);
//		
//		 ps.setString(1, username);
//		 ps.setString(2,useremail);
//		 ps.setString(3,userpw);
//		 ps.setString(4,ShareVar.nowid);
		 ps.executeUpdate();
		 conn_mysql.close();
//		 JOptionPane.showMessageDialog(Update.this, "삭제 완료 되었습니다.");
		 StartMain startMain = new StartMain();
			startMain.main(null);
			dispose();
//			realMain realMain = new realMain();
			
		 
		}
		catch(Exception e){
		System.out.println(e);
		JOptionPane.showMessageDialog(Update.this, "삭제 실패하였습니다.");
		//return false;
	}
	//return true;
}
	private int deleteChk() {
		String username=tfUpName.getText().trim();
		String email= tfUpEmail.getText().trim();
		String userpw = tfUpPw.getText().trim();
		
		
//		pwCheck();
//		int i = 0;
		
//			inPutPw();
		
		 if(tfUpPw.getText().length() == 0) {
//			i++;
			tfUpPw.requestFocus();
//			userpw = myPwTf.getText();
//			userpw = ShareVar.nowpw;
			JOptionPane.showMessageDialog(Update.this, "비밀번호를 확인하세요.");
			return 0;
		}
		 if(tfUpPwChk.getText().length() == 0){
//				i++;
				tfUpPwChk.requestFocus();
				JOptionPane.showMessageDialog(Update.this, "비밀번호 확인을 해주세요.");
//				inPutPw();
				return 0;
			}
		
		if(tfUpName.getText().length() == 0){
//			i++;
			tfUpName.requestFocus();
			JOptionPane.showMessageDialog(Update.this, "이름 확인하세요.");
			
			return 0;
			
		}
		 if(tfUpEmail.getText().length() == 0){
		
			tfUpEmail.requestFocus();
			JOptionPane.showMessageDialog(Update.this, "Email 확인하세요.");
			return 0;
					
		}
		 if ( cbUpEmailAddre.getSelectedItem().toString()=="") {
			JOptionPane.showMessageDialog(Update.this, "이메일 주소를 선택 해주세요.");
			cbUpEmailAddre.requestFocus();
			return 0;
			}
		 
//		 inPutPw();
		 userDeleteAction();
		 return 0;
//		else {
//			userDeleteAction();
		}
//		else if (myPwTf.getText().length()<8) {
//			JOptionPane.showMessageDialog(Update.this, "비밀번호를 8글자 이상 입력해주세요");
//			myPwTf.requestFocus();
//			}
		
//		 return i;
	private JTextField getTfUpEmailAdd() {
		if (tfUpEmailAdd == null) {
			tfUpEmailAdd = new JTextField();
			tfUpEmailAdd.setBounds(318, 380, 90, 24);
			tfUpEmailAdd.setColumns(10);
		}
		return tfUpEmailAdd;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/logo.png"));
			lblNewLabel.setBounds(137, 6, 298, 153);
		}
		return lblNewLabel;
	}
}


//package com.javalec.update;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//import com.javalec.function.DbActionLogin;
//import com.javalec.join.Join;
//import com.javalec.main.realMain;
//import com.javalec.start.StartMain;
//
//import shareVar.ShareVar;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.ImageIcon;
//
//
//
//public class Update extends JDialog {
//	
//
//
//	private final JPanel contentPanel = new JPanel();
//	private JTextField myIdTf;
//	private JPasswordField myPwTf;
//	private JPasswordField myPwChkTf;
//	private JTextField myNameTf;
//	private JTextField myEmailTf;
//	private JTextField myPwChkShowTf;
//
////	private final String url_mysql = ShareVar2.url_mysql;
////	private final String id_mysql = ShareVar2.id_mysql;
////	private final String pw_mysql = ShareVar2.pw_mysql;
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		
//		
//		try {
//			Update dialog = new Update();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			dialog.setLocationRelativeTo(null);
//			dialog.setResizable(false);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	public Update() {
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				myIdTf.setText(ShareVar.nowid);
//				
////				myPwTf.setText(ShareVar.nowpw);
//				myNameTf.setText(ShareVar.nowname);  
//				myEmailTf.setText(ShareVar.nowemail);
//				
//				
//			}
//		});
//		setBounds(100, 100, 364, 458);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBackground(Color.WHITE);
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//		{
//			JLabel lblNewLabel = new JLabel("회원정보수정");
//			lblNewLabel.setBounds(127, 191, 111, 16);
//			contentPanel.add(lblNewLabel);
//		}
//		{
//			JLabel lblNewLabel_1 = new JLabel("아이디");
//			lblNewLabel_1.setBounds(58, 235, 61, 16);
//			contentPanel.add(lblNewLabel_1);
//		}
//		{
//			JLabel lblNewLabel_1 = new JLabel("비밀번호");
//			lblNewLabel_1.setBounds(58, 263, 61, 16);
//			contentPanel.add(lblNewLabel_1);
//		}
//		{
//			JLabel lblNewLabel_1 = new JLabel("비밀번호 확인");
//			lblNewLabel_1.setBounds(58, 291, 96, 16);
//			contentPanel.add(lblNewLabel_1);
//		}
//		{
//			JLabel lblNewLabel_1 = new JLabel("이름");
//			lblNewLabel_1.setBounds(58, 319, 61, 16);
//			
//			contentPanel.add(lblNewLabel_1);
//		}
//		{
//			JLabel lblNewLabel_1 = new JLabel("전자우편");
//			lblNewLabel_1.setBounds(58, 347, 61, 16);
//			contentPanel.add(lblNewLabel_1);
//		}
//	
//		
//
//			myIdTf = new JTextField();
//			myIdTf.setBounds(168, 235, 130, 26);
//			myIdTf.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					
////						myIdTf.setText(ShareVar.nowid);
//						
//						
//				
//					}				
//				
//					
//				});
//			
//			
//			
//			
//			
//			myIdTf.setEditable(false);
//			contentPanel.add(myIdTf);
//			myIdTf.setColumns(10);
//		
//		
//		myPwTf = new JPasswordField();
//		myPwTf.setBounds(168, 263, 130, 26);
//		contentPanel.add(myPwTf);
//		
//		myPwChkTf = new JPasswordField();
//		myPwChkTf.setBounds(168, 291, 130, 26);
//		contentPanel.add(myPwChkTf);
//		
//		myNameTf = new JTextField();
//		myNameTf.setForeground(new Color(0, 0, 0));
//		myNameTf.setBounds(168, 319, 130, 26);
//		myNameTf.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				myNameTf.setText("");
//			}
//		});
//		myNameTf.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				ShareVar.nowname=myNameTf.getText(); 
////				myNameTf.getText() = ShareVar.nowname;
//			}
//		});
//		myNameTf.setColumns(10);
//		contentPanel.add(myNameTf);
//		
//		myEmailTf = new JTextField();
//		myEmailTf.setForeground(new Color(0, 0, 0));
//		myEmailTf.setBounds(168, 347, 130, 26);
//		myEmailTf.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				myEmailTf.setText("");
//			}
//		});
//		myEmailTf.setColumns(10);
//		contentPanel.add(myEmailTf);
//		
//		JButton myUpdate = new JButton("정보수정");
//		myUpdate.setBounds(58, 385, 96, 26);
//		myUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//						insertFieldCheck();
//						ShareVar.nowname = myNameTf.getText();
//						updateAction();
//			}
//		});
//		contentPanel.add(myUpdate);
//		
//		JButton button_1 = new JButton("회원탈퇴");
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			userDeleteAction();
//			
//			}
//		});
//		button_1.setBounds(202, 385, 96, 29);
//		contentPanel.add(button_1);
//		contentPanel.add(getMyPwChkShowTf());
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBackground(Color.WHITE);
//		lblNewLabel_2.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/logo.png"));
//		lblNewLabel_2.setBounds(26, 23, 305, 154);
//		contentPanel.add(lblNewLabel_2);
//
//		}
//	
//	public boolean updateAction() {
//		String username = myNameTf.getText() ;
//		String userpw = myPwTf.getText();
//		String useremail = myEmailTf.getText();
////		String userid = myIdTf.getText();
//		PreparedStatement ps = null;
//		
//		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
//		Statement stmt_mysql = conn_mysql.createStatement();
//
//		
//		
//		String A = "update user set username = ?, email = ? , userpw = ? ";
//		String B = "where userid = ? ";
//
//		
//		
//		
//		ps = conn_mysql.prepareStatement(A+B);
//		
//		 ps.setString(1, username);
//		 ps.setString(2,useremail);
//		 ps.setString(3,userpw);
//		 ps.setString(4,ShareVar.nowid);
//		 ps.executeUpdate();
//		 conn_mysql.close();
////		 JOptionPane.showMessageDialog(Update.this, "수정이 완료 되었습니다.");
//		 
//		}
//		catch(Exception e){
//		System.out.println(e);
//		insertFieldCheck();
////		JOptionPane.showMessageDialog(Update.this, "수정을 실패하였습니다.");
//		return false;
//	}
//	return true;
//}
//	private JTextField getMyPwChkShowTf() {
//		if (myPwChkShowTf == null) {
//			myPwChkShowTf = new JTextField();
//			myPwChkShowTf.setBounds(343, 153, 149, 24);
//			myPwChkShowTf.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//				}
//			});
//			myPwChkShowTf.setEditable(false);
//			myPwChkShowTf.setOpaque(false);
//			myPwChkShowTf.setBorder(null);
//			myPwChkShowTf.setColumns(10);
//			myPwChkShowTf.setForeground(new Color(205, 92, 92));
//		}
//		return myPwChkShowTf;
//	}
//	
//	
////	private void pwCheck() {
////		if(myPwTf.getText().length()!=0) {
////			if(myPwTf.getText().equals(myPwChkTf.getText())){
////				myPwChkShowTf.setText("비밀번호가 일치합니다.");
////			}else {
////				myPwChkShowTf.setText("비밀번호가 일치하지 않습니다.");
////			}
////		}
////	}
//	
//	
//	
//	private int insertFieldCheck(){
//		String username=myNameTf.getText().trim();
//		String email= myEmailTf.getText().trim();
//		String userpw = myPwTf.getText().trim();
//	
//		
//		
//		pwCheck();
//		int i = 0;
//		
//			
//		
//		 if(myPwTf.getText().length() == 0){
//			i++;
//			myPwTf.requestFocus();
//			userpw = myPwTf.getText();
//			userpw = ShareVar.nowpw;
//			JOptionPane.showMessageDialog(Update.this, "비밀번호를 확인하세요.");
//		}
//		else if(myPwChkTf.getText().length() == 0){
//			i++;
//			myPwChkTf.requestFocus();
//			JOptionPane.showMessageDialog(Update.this, "비밀번호 확인을 해주세요.");
//		}
//		else if(myNameTf.getText().length() == 0){
//			i++;
//			myNameTf.requestFocus();
//			JOptionPane.showMessageDialog(Update.this, "이름 확인하세요.");
//			
//		
//		}
//		else if(myEmailTf.getText().length() == 0){
//			i++;
//			myEmailTf.requestFocus();
//			JOptionPane.showMessageDialog(Update.this, "Email 확인하세요.");
//		}
//		else if(myPwTf.getText().equals(myPwChkTf.getText())) {
//			DbActionLogin dbAction = new DbActionLogin(username, email, userpw);
//			dbAction.insertAction();
//			JOptionPane.showMessageDialog(Update.this, "수정이 완료 되었습니다.");
//			dispose();}
//		return i;
//}
//	
//	
//	private void pwCheck() {
//		if(myPwTf.getText().length()!=0) {
//			if(myPwTf.getText().equals(myPwChkTf.getText())){
//				myPwChkShowTf.setText("비밀번호가 일치합니다.");
//			}else {
//				myPwChkShowTf.setText("비밀번호가 일치하지 않습니다.");
//			}
//		}
//	}
////	
////	private void deleteId() {
////		
////		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
////			Statement stmt_mysql = conn_mysql.createStatement();
////			String sql= "select userid, userpw, username, email from user " ; 
////			String sql2= "where userid = '" +tfId.getText()+"' and userpw= '" + String.valueOf(tfPw.getPassword()) +"' ";
////			
////		
////			
////			ResultSet rs=stmt_mysql.executeQuery(sql+sql2);
////			System.out.println(sql+ sql2);
////			
////			
////			
////			//>>>> MainBoard완성 되면 붙여 넣기!!<<<<
////			
////			String nowid;
////				nowid = tfId.getText().trim();
////				
////				if(rs.next() == true) {
////					ShareVar.nowid = nowid;
////					ShareVar.nowpw = rs.getString(2);
////					ShareVar.nowname = rs.getString(3);
////					ShareVar.nowemail = rs.getString(4);                                   
////					realMain realMain = new realMain();
////					realMain.main(null);
////				
////					
////					dispose();
////				
////				} else {
////					JOptionPane.showMessageDialog(StartMain.this, "아이디와 비밀번호를 확인하세요!");
////				}
////
////			conn_mysql.close();
////		
////	
////				
////		} catch (Exception e) {
////			
////		
////			System.out.println(e);
////		}
////	}
////	
//	private void userDeleteAction() {
//		
//			String username = myNameTf.getText() ;
//			String userpw = myPwTf.getText();
//			String useremail = myEmailTf.getText();
////			String userid = myIdTf.getText();
//			PreparedStatement ps = null;
//			
//			try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//
//			
//			
//			String A = "update user set userstatus = '탈퇴'";
//			String B = "where userid = '" +ShareVar.nowid+ "'";
//
//			
//			
//			
//			ps = conn_mysql.prepareStatement(A+B);
////			
////			 ps.setString(1, username);
////			 ps.setString(2,useremail);
////			 ps.setString(3,userpw);
////			 ps.setString(4,ShareVar.nowid);
//			 ps.executeUpdate();
//			 conn_mysql.close();
//			 JOptionPane.showMessageDialog(Update.this, "삭제 완료 되었습니다.");
//			 StartMain startMain = new StartMain();
//				startMain.main(null);
//				dispose();
////				realMain realMain = new realMain();
//				
//			 
//			}
//			catch(Exception e){
//			System.out.println(e);
//			JOptionPane.showMessageDialog(Update.this, "삭제 실패하였습니다.");
//			//return false;
//		}
//		//return true;
//	}
//	}
//	


	
