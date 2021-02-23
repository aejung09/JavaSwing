package com.javalec.update;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PwChk extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PwChk dialog = new PwChk();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PwChk() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("비밀번호를 한번 더 확인해주세요 !");
			lblNewLabel.setBounds(130, 70, 211, 34);
			contentPanel.add(lblNewLabel);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(151, 116, 140, 34);
			contentPanel.add(passwordField);
		}
		{
			JButton btnNewButton = new JButton("확인");
			btnNewButton.setBounds(160, 182, 117, 29);
			contentPanel.add(btnNewButton);
		}
	}

}
