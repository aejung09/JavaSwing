package com.javalec.popup;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.function.CreateDBA;
import com.javalec.function.DbActionCreate;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class InputScreen extends JDialog {
	public static final String url_mysql = "jdbc:mysql://192.168.0.78/mproject?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
    public static final String id_mysql = "root";
    public static final String pw_mysql = "qwer1234";
	private JComboBox cbTextList;
	private JTextField tfTitle;
	private JButton okButton;
	private JTextArea taText;
	private JButton button;
	private JTextField tfFIlePath;
	private JLabel lblImage;
	private JTextField tfFilepath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputScreen dialog = new InputScreen();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public InputScreen() {
		setBounds(100, 100, 534, 682);
		getContentPane().setLayout(null);
		getContentPane().add(getLblImage());
		getContentPane().add(getCbTextList());
		getContentPane().add(getTfTitle());
		getContentPane().add(getOkButton());
		getContentPane().add(getTaText());
		getContentPane().add(getButton());
		getContentPane().add(getTfFilepath());

	}
	private JComboBox getCbTextList() {
		if (cbTextList == null) {
			cbTextList = new JComboBox();
			cbTextList.setModel(new DefaultComboBoxModel(new String[] {"뉴스", "정보", "기타"}));
			cbTextList.setBounds(16, 29, 88, 27);
		}
		return cbTextList;
	}
	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setBounds(103, 28, 413, 26);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton("작성");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
					
				}
			});
			okButton.setBounds(285, 611, 117, 29);
		}
		return okButton;
	}
	private JTextArea getTaText() {
		if (taText == null) {
			taText = new JTextArea();
			taText.setBounds(16, 68, 500, 505);
		}
		return taText;
	}
	private void insertAction(){
		
		String category = cbTextList.getSelectedItem().toString();
		String title = tfTitle.getText().trim();
		String text = taText.getText();
		
		
		DbActionCreate dbActionCreate = new DbActionCreate();
		
		
		boolean msg = dbActionCreate.insertAction(category, title, text);
		
		
		if (msg == true) {
			JOptionPane.showMessageDialog(null, "입력완료 !");
		}else {
			JOptionPane.showMessageDialog(null, "입력실패 !");
		}
		dispose();
		
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("나가기");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = JOptionPane.showConfirmDialog(
							InputScreen.this,
				            "글쓰기를 취소하시겠습니까? 작성하신 내용은 저장되지 않습니다.",
				            "An Inane Question",
				            JOptionPane.YES_NO_OPTION);
								
				        if(n == JOptionPane.YES_OPTION){
				        
				        	dispose();
				        }
				          else {	  
				        }

					   
				}
			});
			button.setBounds(399, 611, 117, 29);
		}
		return button;
	}
	
	//------------
	
	
	
//	private void insertAction2(){
//		
//		// Image File
//		FileInputStream input = null;
//		File file = new File(tfFilepath.getText());
//		try {
//			input = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		CreateDBA createDBA = new CreateDBA(file);
//		boolean aaa = createDBA.InsertAction2();
//		if(aaa == true){
//	          JOptionPane.showMessageDialog(null, "이미지가 입력 되었습니다.!");                    
//		}else{
//	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
//		}
//	}
	
	public void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg", "png","bmp","jpeg");
		chooser.setFileFilter(filter);
//				FileNameExtensionFilter();
		
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilepath.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
					

	
	
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("이미지");
			lblImage.setBounds(328, 363, 164, 176);
		}
		return lblImage;
	}
	private JTextField getTfFilepath() {
		if (tfFilepath == null) {
			tfFilepath = new JTextField();
			tfFilepath.setBounds(16, 588, 130, 26);
			tfFilepath.setColumns(10);
		}
		return tfFilepath;
	}
}
