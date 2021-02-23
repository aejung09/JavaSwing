package com.javalec.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import shareVar.ShareVar;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Find extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton btnFindId;
	private JRadioButton btnFindPw;
	private JLabel idFindLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnFindResult;
	private JTextField tfFindId;
	private JTextField tfFindName;
	private JTextField tfFindEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnGoback;

	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Find dialog = new Find();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Find() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				btnchk();
				tfFindName.requestFocus();
			}
		});
		setBounds(100, 100, 340, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnFindId());
		contentPanel.add(getBtnFindPw());
		contentPanel.add(getIdFindLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getBtnFindResult());
		contentPanel.add(getTfFindId());
		contentPanel.add(getTfFindName());
		contentPanel.add(getTfFindEmail());
		contentPanel.add(getBtnGoback());
		contentPanel.add(getLblNewLabel());
	}
	private JRadioButton getBtnFindId() {
		if (btnFindId == null) {
			btnFindId = new JRadioButton("ID \uCC3E\uAE30");
			btnFindId.setSelected(true);
			btnFindId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnchk();
					tfFindName.requestFocus();
				}
			});
			buttonGroup.add(btnFindId);
			btnFindId.setBounds(55, 210, 106, 23);
		}
		return btnFindId;
	}
	private JRadioButton getBtnFindPw() {
		if (btnFindPw == null) {
			btnFindPw = new JRadioButton("\uBE44\uBC00\uBC88\uD638\uCC3E\uAE30");
			btnFindPw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				btnchk();
				tfFindId.requestFocus();
				}
			});
			buttonGroup.add(btnFindPw);
			btnFindPw.setBounds(181, 210, 113, 23);
		}
		return btnFindPw;
	}
	private JLabel getIdFindLabel() {
		if (idFindLabel == null) {
			idFindLabel = new JLabel("I   D");
			idFindLabel.setBounds(61, 259, 50, 15);
		}
		return idFindLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774  \uB984");
			lblNewLabel_1.setBounds(61, 289, 79, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC804\uC790\uC6B0\uD3B8");
			lblNewLabel_2.setBounds(61, 319, 50, 15);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnFindResult() {
		if (btnFindResult == null) {
			btnFindResult = new JButton("\uCC3E\uAE30");
			btnFindResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btnFindId.isSelected()==true) {
						findIdChk();
						
						}
					if(btnFindPw.isSelected()==true) {
						findPwChk();
						
					}
					ClearColumn();
				}
			});
			btnFindResult.setBounds(55, 408, 91, 23);
		}
		return btnFindResult;
	}
	private JTextField getTfFindId() {
		if (tfFindId == null) {
			tfFindId = new JTextField();
			tfFindId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			tfFindId.setBounds(176, 256, 96, 21);
			tfFindId.setColumns(10);
		}
		return tfFindId;
	}
	private JTextField getTfFindName() {
		if (tfFindName == null) {
			tfFindName = new JTextField();
			tfFindName.setBounds(176, 286, 96, 21);
			tfFindName.setColumns(10);
		}
		return tfFindName;
	}
	private JTextField getTfFindEmail() {
		if (tfFindEmail == null) {
			tfFindEmail = new JTextField();
			tfFindEmail.setBounds(176, 319, 96, 21);
			tfFindEmail.setColumns(10);
		}
		return tfFindEmail;
	}
	
	private void btnchk () {
		if(btnFindPw.isSelected()==true) {
			idFindLabel.setVisible(true);
			tfFindId.setVisible(true);
			
	//		findIdChk();
		}
		if(btnFindId.isSelected()==true) {
			idFindLabel.setVisible(false);
			tfFindId.setVisible(false);
		
		}
		ClearColumn();
	}





	private JButton getBtnGoback() {
		if (btnGoback == null) {
			btnGoback = new JButton("\uB2EB\uAE30");
			btnGoback.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnGoback.setBounds(181, 408, 91, 23);
		}
		return btnGoback;
	}
	
	
		//Id 찾는 Method
	public void findIdChk() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			String sql= "select userid from user " ; 
			String sql2= "where username = '" +tfFindName.getText()+"'and email= '" +tfFindEmail.getText() +"' and userstatus = '회원' ";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResultSet rs=stmt_mysql.executeQuery(sql+sql2);

				if(rs.next()) {
					JOptionPane.showMessageDialog(Find.this, "Id는 " + rs.getString(1) + "입니다.");
				
				} else {
					JOptionPane.showMessageDialog(Find.this, "이름과 이메일을 확인하세요!");
				}

			conn_mysql.close();
		
	
				
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
		//Pw 찾는 Method 
	public void findPwChk() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			String sql= "select userpw from user " ; 
			String sql2= "where userid = '"+tfFindId.getText()+"'and username = '" +tfFindName.getText()+"'and email= '" +tfFindEmail.getText() +"' and userstatus = '회원'";
			
			//userpw를 선택하고 where에서 userid와 username과 useremail 이 동일 할경우 userpw를 보여준다. 
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			ResultSet rs=stmt_mysql.executeQuery(sql+sql2);

				if(rs.next()) {
				
					
					JOptionPane.showMessageDialog(Find.this, "Pw는 " + rs.getString(1) + "입니다."); // getString에 처음으로 불러와준게 pw 이기 때문에 1을 써준다. 
				
				} else {
					JOptionPane.showMessageDialog(Find.this, "이름과 이메일을 확인하세요!");
				}

			conn_mysql.close();
		
	
				
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
	
		//화면 초기화 해주는 Method 
	private void ClearColumn() { 
		if(btnFindId.isSelected()==true) {
		tfFindEmail.setText("");
		tfFindName.setText("");
		}
		if(btnFindPw.isSelected()==true) {
			tfFindId.setText("");
			tfFindEmail.setText("");
			tfFindName.setText("");
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/logo.png"));
			lblNewLabel.setBounds(20, 17, 299, 160);
		}
		return lblNewLabel;
	}
}
