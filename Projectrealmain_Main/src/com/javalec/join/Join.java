package com.javalec.join;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.javalec.function.DbActionLogin;

import shareVar.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;

public class Join extends JDialog {

	private final JPanel join = new JPanel();
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfJoinId;
	private JTextField tfJoinName;
	private JTextField tfJoinEmail;
	private JLabel label_1;
	private JTextField tfShowChkId;
	private JTextField tfPwChkShow;
	private JComboBox cbJoinEmailAddre;
	private JButton btnChkid;
	private JButton btnJoin;

	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
//	private JPasswordField tfJoinPwChk;
	private JTextField tfJoinPwChkShow;
	int count;
	private JPasswordField tfJoinPw;
	private JPasswordField tfjoinPwChk;
	private JLabel lblNewLabel_4;
	private JTextField tflength;
	private JLabel lblNewLabel_5;
//	private JComboBox cbEmailAddress1;
//	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Join dialog = new Join();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setResizable(false);// 창크기 조절 x 
			dialog.setLocationRelativeTo(null); // 창 가운데로 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Join() {
		setTitle("회원가입");
		setBounds(100, 100, 460, 521);
		getContentPane().setLayout(new BorderLayout());
		join.setBackground(Color.WHITE);
		join.setToolTipText("join");
		join.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(join, BorderLayout.CENTER);
		join.setLayout(null);
		join.add(getLabel());
		join.add(getLblNewLabel());
		join.add(getLblNewLabel_1());
		join.add(getLblNewLabel_2());
		join.add(getLblNewLabel_3());
		join.add(getTfJoinId());
		join.add(getTfJoinName());
		join.add(getTfJoinEmail());
		join.add(getLabel_1());
		join.add(getTfShowChkId());
		join.add(getTfPwChkShow());
		join.add(getCbJoinEmailAddre());
		join.add(getBtnChkid());
		join.add(getBtnJoin());
		join.add(getTfJoinPw());
		join.add(getTfjoinPwChk());
		join.add(getTflength());
		join.add(getLblNewLabel_5());
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("아이디");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(83, 249, 62, 18);
		}
		return label;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(83, 284, 62, 18);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("비밀번호확인");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(46, 314, 99, 18);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(83, 345, 62, 18);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("이메일");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(83, 377, 62, 18);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfJoinId() {
		if (tfJoinId == null) {
			tfJoinId = new JTextField();
			tfJoinId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IdCheck();
				}
			});
			tfJoinId.setBounds(159, 246, 116, 24);
			tfJoinId.setColumns(10);
		}
		return tfJoinId;
	}
	private JTextField getTfJoinName() {
		if (tfJoinName == null) {
			tfJoinName = new JTextField();
			tfJoinName.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					pwchek();
				}
			});
			System.out.println(tfJoinPwChkShow);
			tfJoinName.setColumns(10);
			tfJoinName.setBounds(159, 344, 116, 24);
		}
		return tfJoinName;
	}
	private JTextField getTfJoinEmail() {
		if (tfJoinEmail == null) {
			tfJoinEmail = new JTextField();
			tfJoinEmail.setColumns(10);
			tfJoinEmail.setBounds(159, 374, 116, 24);
		}
		return tfJoinEmail;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("@");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(274, 377, 20, 18);
		}
		return label_1;
	}
	private JPasswordField getTfJoinPw() {
		if (tfJoinPw == null) {
			tfJoinPw = new JPasswordField();
//			tfJoinPw.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					if(tfJoinPw.getText().length()>8) {
//						tflength.setOpaque(true);
//					}
//				}
//			});
			tfJoinPw.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					pwchek();
					pwlength();
				}
			});

			tfJoinPw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					IdCheck();
				}
			});
			tfJoinPw.setBounds(159, 281, 116, 24);
		}
		return tfJoinPw;
	}
	private JPasswordField getTfjoinPwChk() {
		if (tfjoinPwChk == null) {
			tfjoinPwChk = new JPasswordField();
			tfjoinPwChk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwchek();
				}
			});
			
			tfjoinPwChk.setBounds(159, 312, 116, 24);
		}
		return tfjoinPwChk;
	}
	private JTextField getTfShowChkId() {
		if (tfShowChkId == null) {
			tfShowChkId = new JTextField();
			tfShowChkId.setForeground(new Color(255, 0, 0));
			tfShowChkId.setOpaque(false);
			tfShowChkId.setEditable(false);
			tfShowChkId.setBorder(null);
			tfShowChkId.setBounds(159, 245, 198, 24);
			tfShowChkId.setColumns(10);
		}
		return tfShowChkId;
	}
	private JTextField getTfPwChkShow() {
		if (tfPwChkShow == null) {
			tfPwChkShow = new JTextField();
			tfPwChkShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwchek();
				}
			});
			tfPwChkShow.setForeground(new Color(255, 0, 0));
			tfPwChkShow.setEditable(false);
			tfPwChkShow.setBorder(null);
			tfPwChkShow.setOpaque(false);
			tfPwChkShow.setColumns(10);
			tfPwChkShow.setBounds(154, 310, 240, 24);
		}
		return tfPwChkShow;
	}
	private JComboBox getCbJoinEmailAddre() {
		if (cbJoinEmailAddre == null) {
			cbJoinEmailAddre = new JComboBox();
			cbJoinEmailAddre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				}
			});
			cbJoinEmailAddre.setModel(new DefaultComboBoxModel(new String[] {"", "naver.com", "daum.net", "gmail.com"}));
			cbJoinEmailAddre.setBounds(295, 375, 99, 24);
		}
		return cbJoinEmailAddre;
	}
	private JButton getBtnChkid() {
		if (btnChkid == null) {
			btnChkid = new JButton("중복체크");
			btnChkid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					IdCheck();
				}
			});
			btnChkid.setBounds(289, 245, 105, 27);
			
		}
		return btnChkid;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입하기");
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					System.out.println(tfJoinPw.getText());
					insertFieldCheck();
				}
			});
			btnJoin.setBounds(162, 443, 105, 27);
		}
		return btnJoin;
	}
	
public void IdCheck() {
		
		try {
			String sql= "select count(userid) cnt from user where userid = '" +tfJoinId.getText()+ "' ";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs=stmt_mysql.executeQuery(sql);
			int id = 0;
			while (rs.next()) {
			id = rs.getInt(1);
			}

			
				
			
			if (tfJoinId.getText().length() >= 3) {
		
				 if (id==0){
					tfShowChkId.setText("사용가능한 아이디입니다.");
					tfJoinPw.requestFocus();
					}
					
				else{
					tfShowChkId.setText("이미 사용중인 아이디 입니다.");
					tfJoinId.requestFocus();
					}
				}
			else {
				tfShowChkId.setText("아이디를 3글자 이상 입력해주세요.");
				tfJoinId.requestFocus();
			}
			
			
			
			conn_mysql.close();
		} catch (Exception e) {
			
	}
		
}
	
	private void pwchek() {
		
		if(tfJoinPw.getText().length()!=0) {
			if(tfJoinPw.getText().equals(tfjoinPwChk.getText())){
				tfPwChkShow.setText("비밀번호가 일치합니다.");
			
			}else {
				tfPwChkShow.setText("비밀번호가 일치하지 않습니다.");
			}
		
		}

	}
		
	
	private int insertFieldCheck(){
		String userid = tfJoinId.getText().trim();
		String username= tfJoinName.getText().trim();
		String email= tfJoinEmail.getText().trim();
		String userpw = tfJoinPw.getText().trim();
		String emailaddress = cbJoinEmailAddre.getSelectedItem().toString();
		ShareVar.nowname=username;
		ShareVar.nowemail=email;
		ShareVar.nowpw=userpw;
		ShareVar.nowemailaddress = emailaddress;
		
		pwchek();

		
		if(tfJoinId.getText().length() == 0){
			JOptionPane.showMessageDialog(Join.this, "아이디를 확인하세요.");
			tfJoinId.requestFocus();
			
			return 0;
		}
		
		if(tfJoinPw.getText().length() == 0){
//			userpw = tfJoinPw.getText();
//			userpw = ShareVar.nowpw;
			JOptionPane.showMessageDialog(Join.this, "비밀번호를 확인하세요.");
			tfJoinPw.requestFocus();
			
			return 0;
			}
	 
		if(tfjoinPwChk.getText().length() == 0){
			JOptionPane.showMessageDialog(Join.this, "비밀번호 확인을 해주세요.");
			tfjoinPwChk.requestFocus();
			return 0;
		}
		
	 if(tfJoinName.getText().length()==0){
			
			JOptionPane.showMessageDialog(Join.this, "이름 확인하세요.");
			tfJoinName.requestFocus();
			return 0;
		}
	 
		if(tfJoinEmail.getText().length()==0 ){
			
			JOptionPane.showMessageDialog(Join.this, "이메일을 확인하세요.");
			tfJoinEmail.requestFocus();
			return 0;
			}
		
		if ( cbJoinEmailAddre.getSelectedItem().toString()=="") {
			JOptionPane.showMessageDialog(Join.this, "이메일 주소를 선택 해주세요.");
			cbJoinEmailAddre.requestFocus();
			return 0;
			}
		if (tfJoinPw.getText().length()<8 || tfjoinPwChk.getText().length()<8) {
			tfPwChkShow.setText( "비밀번호를 다시 입력해주세요.");
		
			tfjoinPwChk.setText("");
			tfJoinPw.setText("");

			tfJoinPw.requestFocus();
			return 0;
		}
		if(tfJoinPw.getText().equals(tfjoinPwChk.getText())) {
			DbActionLogin dbActionlogin = new DbActionLogin(userid, username, email+"@"+emailaddress, userpw);
			dbActionlogin.insertAction();
			JOptionPane.showMessageDialog(Join.this, "가입이 완료되었습니다.");
			dispose();
			return 0;
			}
			return 0;
	
	}
	private JTextField getTflength() {
		if (tflength == null) {
			tflength = new JTextField();
			tflength.setForeground(new Color(192, 192, 192));
			tflength.setBorder(null);
			
			tflength.setEditable(false);
			tflength.setOpaque(false);
			
			tflength.setBounds(275, 185, 167, 24);
			tflength.setColumns(10);
		}
		return tflength;
	}
	private void pwlength() {
		
		 if(tfJoinPw.getText().length()<8) {
			tflength.setText("8글자 이상 적어주세요.");
		}
		if(tfJoinPw.getText().length()>=7) {
			tflength.setText("");
		}
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/logo.png"));
			lblNewLabel_5.setBounds(72, 33, 305, 160);
		}
		return lblNewLabel_5;
	}
}
			
	
