package com.javalec.popup;
import shareVar.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.javalec.function.BeanShowboard;
import com.javalec.function.DbActionShowboard;
import com.javalec.main.realMain;
import com.mysql.cj.util.TestUtils;

import shareVar.ShareVar;

public class showBoard extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfShowBoardTitle;
	private JTextField tfShowBoardCategory;
	private JTextArea textArea;
	private JButton btnRevise;
	private JButton btnDelete;
	private JButton btnShowBoardOut;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			showBoard dialog = new showBoard();
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
	public showBoard() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				btnDelete.setVisible(false);
				btnRevise.setVisible(false);
	
				if(ShareVar.nowid.equals(ShareVar.wkname)) {
					btnDelete.setVisible(true);
					btnRevise.setVisible(true);
				}
				if(ShareVar.nowid.equals("admin")) {
					btnDelete.setVisible(true);
					btnRevise.setVisible(true);
				}
				
				
				
				
				
				TableClick();
				
				
			}
		});
		setTitle("게시글 목록");
		setBounds(100, 100, 629, 772);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
		
		
		}
		
		tfShowBoardTitle = new JTextField();
		tfShowBoardTitle.setEditable(false);
		tfShowBoardTitle.setBounds(131, 53, 468, 26);
		contentPanel.add(tfShowBoardTitle);
		tfShowBoardTitle.setColumns(10);
		
		tfShowBoardCategory = new JTextField();
		tfShowBoardCategory.setEditable(false);
		tfShowBoardCategory.setBounds(31, 53, 88, 26);
		contentPanel.add(tfShowBoardCategory);
		tfShowBoardCategory.setColumns(10);
		contentPanel.add(getTextArea());
		contentPanel.add(getBtnRevise());
		contentPanel.add(getBtnDelete());
		contentPanel.add(getBtnShowBoardOut());
	}
			private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBounds(30, 105, 564, 600);
		}
		return textArea;
			}
	
	private void TableClick() {
		realMain realMain = new realMain();
        int i = realMain.getInnerBoard().getSelectedRow();
        String wkSequence = (String) realMain.getInnerBoard().getValueAt(i, 0);
     
        int tsSequence = Integer.parseInt(wkSequence);
        DbActionShowboard dbActionShowboard = new DbActionShowboard (tsSequence);
        
       BeanShowboard beanShowboard = dbActionShowboard.tableClickshow();
        tfShowBoardCategory.setText(beanShowboard.getCategory());
        tfShowBoardTitle.setText(beanShowboard.getTitle());
        textArea.setText(beanShowboard.getText());
        
//        tfSeqno.setText(Integer.toString(bean.getSeqno()));
//        tfAddress.setText(bean.getAddress());
//        tfEmail.setText(bean.getEmail());
//        tfRelation.setText(bean.getRelation());
	
	
	}
	private JButton getBtnRevise() {
		if (btnRevise == null) {
			btnRevise = new JButton("수정");
			btnRevise.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateActionShowBoard();
				}
			});
			btnRevise.setBounds(290, 717, 88, 29);
			
		}
		return btnRevise;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteActionShowBoard();
				}
			});
			btnDelete.setBounds(391, 717, 88, 29);
		}
		return btnDelete;
	}
	private JButton getBtnShowBoardOut() {
		if (btnShowBoardOut == null) {
			btnShowBoardOut = new JButton("나가기");
			btnShowBoardOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnShowBoardOut.setBounds(495, 717, 88, 29);
		}
		return btnShowBoardOut;
	}
	

	public boolean updateActionShowBoard() {
		String showCategory = tfShowBoardCategory.getText() ;
		String showTitle = tfShowBoardTitle.getText();
		String showText = textArea.getText();
//		String userid = myIdTf.getText();
		PreparedStatement ps = null;
		int wkseq = Integer.parseInt(ShareVar.wkseq);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();

		
		
		String A = "update board set category = ?, title = ?, text = ? ";
		String B = "where seqno = ? ";
		JOptionPane.showMessageDialog(showBoard.this, ShareVar.wkseq);

		
		
		
		ps = conn_mysql.prepareStatement(A+B);
		
		 ps.setString(1, showCategory);
		 ps.setString(2,showTitle);
		 ps.setString(3,showText);
		 ps.setInt(4,wkseq);
		 
		 ps.executeUpdate();
		 
		 conn_mysql.close();
		 JOptionPane.showMessageDialog(showBoard.this, "수정이 완료 되었습니다.");
		 
		}
		catch(Exception e){
		System.out.println(e);
		
		JOptionPane.showMessageDialog(showBoard.this, "수정을 실패하였습니다.");
		return false;
	}
	return true;
}
	
	public boolean DeleteActionShowBoard() {
		String showCategory = tfShowBoardCategory.getText() ;
		String showTitle = tfShowBoardTitle.getText();
		String showText = textArea.getText();
//		String userid = myIdTf.getText();
		PreparedStatement ps = null;
		int wkseq = Integer.parseInt(ShareVar.wkseq);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();

		
		
		String A = "update board set date = now() ";
		String B = "where seqno = ? ";
//		JOptionPane.showMessageDialog(showBoard.this, ShareVar.wkseq);

		
		
		
		ps = conn_mysql.prepareStatement(A+B);
		
//		 ps.setString(1, showCategory);
//		 ps.setString(2,showTitle);
//		 ps.setString(3,showText);
		 ps.setInt(1,wkseq);
		 
		 ps.executeUpdate();
		 
		 conn_mysql.close();
		 JOptionPane.showMessageDialog(showBoard.this, "삭제 완료 되었습니다.");
		 dispose();
		}
		catch(Exception e){
		System.out.println(e);
		
		JOptionPane.showMessageDialog(showBoard.this, "삭제를 실패하였습니다.");
		return false;
	}
	return true;
}

}
