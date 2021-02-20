package com.javalec.update;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import shareVar.ShareVar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Bean;
import com.javalec.function.BeanMedicine;
import com.javalec.function.DbAction;
import com.javalec.function.DbActionMedicine;
import com.javalec.function.DbActionSearch;
import shareVar.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Medicine extends JDialog {

	private final JPanel contentPanel = new JPanel();
//	private JTable innerMedicine;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField tfMname;
	private JTextField tfCompany;
	private JTextField tfIngredient;
	
	//private JTextField tflikecount;
	private JButton btnlike;
	private JLabel lblikecount;
	private JButton btnunlike;
	/**
	 * Launch the application.
	 */
	
	protected final DefaultTableModel Outer_Table3 = new DefaultTableModel();
	private JScrollPane scrollPaneSearch;
	private JTable innerSearch;
	private JScrollPane scrollPane;
	private JTextArea taEffect;
	private JScrollPane scrollPane_1;
	private JTextArea taDosage;
	private JButton button;
	private JButton btnMedicinOk;
	private JRadioButton radioInsertMedicine;
	private JRadioButton radioUpdateMedicine;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel labelMcode;
	private JTextField tfMcode;
	private JLabel lblShapeInput;
	private JTextField tfFilePath;
	private JButton btnFilePath;
	private JLabel lblShape;
	private JLabel lblImage;
	
	public static void main(String[] args) {
		try {
			Medicine dialog = new Medicine();
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
	public Medicine() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			TableInit3();
			SearchAction3();
			if (ShareVar.nowid.equals("admin")) {
				radioInsertMedicine.setVisible(true);
				radioUpdateMedicine.setVisible(true);
				btnMedicinOk.setVisible(true);
				labelMcode.setVisible(true);
				tfMcode.setVisible(true);
				lblShapeInput.setVisible(true);
				tfFilePath.setVisible(true);
				btnFilePath.setVisible(true);
				
				btnlike.setVisible(false);
				btnunlike.setVisible(false);
				//tflikecount.setVisible(false);
				lblikecount.setVisible(false);
			}
			else {
				radioInsertMedicine.setVisible(false);
				radioUpdateMedicine.setVisible(false);
				btnMedicinOk.setVisible(false);
				labelMcode.setVisible(false);
				tfMcode.setVisible(false);
				lblShapeInput.setVisible(false);
				tfFilePath.setVisible(false);
				btnFilePath.setVisible(false);
				
				btnlike.setVisible(false);
				btnunlike.setVisible(false);
				//tflikecount.setVisible(false);
				lblikecount.setVisible(false);
			}
			}
			@Override
			public void windowActivated(WindowEvent e) {
				TableInit3();
				SearchAction3();
			}
		});
		setBounds(100, 100, 514, 566);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
		}
		contentPanel.setLayout(null);
		contentPanel.add(getLabel());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
		contentPanel.add(getLabel_3());
		contentPanel.add(getTfMname());
		contentPanel.add(getTfCompany());
		contentPanel.add(getTfIngredient());
		contentPanel.add(getScrollPaneSearch());
		contentPanel.add(getScrollPane());
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getButton());
		contentPanel.add(getBtnMedicinOk());
		contentPanel.add(getRadioInsertMedicine());
		contentPanel.add(getRadioUpdateMedicine());
		contentPanel.add(getLabelMcode());
		contentPanel.add(getTfMcode());
		contentPanel.add(getLblShapeInput());
		contentPanel.add(getTfFilePath());
		contentPanel.add(getBtnFilePath());
		contentPanel.add(getLblShape());
		contentPanel.add(getLblImage());
		
		//contentPanel.add(getTflikecount());
		contentPanel.add(getLblikecount());
		contentPanel.add(getBtnunlike());
		contentPanel.add(getBtnlike());
	}
//	private JTable getInnerMedicine() {
//		try {
//		if (innerMedicine == null) {
//			innerMedicine = new JTable();
////			innerMedicine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			innerMedicine.setModel(Outer_Table3); // <--***************************************************
//		}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e);
//		}
//		
//		return innerMedicine;
//	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("약 이름");
			label.setBounds(6, 273, 61, 16);
		}
		return label;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("효능 효과");
			lblNewLabel.setBounds(6, 301, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("복용법");
			label_1.setBounds(6, 404, 61, 16);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("제약회사");
			label_2.setBounds(6, 347, 61, 16);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("성분");
			label_3.setBounds(6, 375, 61, 16);
		}
		return label_3;
	}
	private JTextField getTfMname() {
		if (tfMname == null) {
			tfMname = new JTextField();
			tfMname.setBounds(92, 268, 148, 26);
			tfMname.setEditable(false);
			tfMname.setColumns(10);
		}
		return tfMname;
	}
	private JTextField getTfCompany() {
		if (tfCompany == null) {
			tfCompany = new JTextField();
			tfCompany.setBounds(92, 337, 130, 26);
			tfCompany.setEditable(false);
			tfCompany.setColumns(10);
		}
		return tfCompany;
	}
	private JTextField getTfIngredient() {
		if (tfIngredient == null) {
			tfIngredient = new JTextField();
			tfIngredient.setBounds(92, 365, 188, 26);
			tfIngredient.setEditable(false);
			tfIngredient.setColumns(10);
		}
		return tfIngredient;
	}
	
	private void TableInit3(){
        int i = Outer_Table3.getRowCount();
        
        Outer_Table3.addColumn("코드");
        Outer_Table3.addColumn("의약품명");
        Outer_Table3.addColumn("효능및효과");
        Outer_Table3.addColumn("복용법");
        Outer_Table3.addColumn("제약회사");
        Outer_Table3.addColumn("성분");
        Outer_Table3.setColumnCount(6);

        for(int j = 0 ; j < i ; j++){
            Outer_Table3.removeRow(0);
        }

        innerSearch.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = innerSearch.getColumnModel().getColumn(vColIndex);
        int width = 80;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 4;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
	
        vColIndex = 5;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);
	}
	
	
	
	private JScrollPane getScrollPaneSearch() {
		if (scrollPaneSearch == null) {
			scrollPaneSearch = new JScrollPane();
			scrollPaneSearch.setBounds(0, 0, 514, 261);
			scrollPaneSearch.setViewportView(getInnerSearch());
	
		}
		return scrollPaneSearch;
		
		
	}
	private JTable getInnerSearch() {
		if (innerSearch == null) {
			innerSearch = new JTable();
			innerSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableClick();
				    changebtnheart();
				    lblikecount.setVisible(true);
				    //tflikecount.setVisible(true);
				}
			});
			innerSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerSearch.setModel(Outer_Table3);

		}
		return innerSearch;
	}
	public void SearchAction3(){
        DbActionSearch dbActionSearch = new DbActionSearch();
        ArrayList<BeanMedicine> beanList = dbActionSearch.selectList();
        
        int listCaount = beanList.size();
        for(int i = 0; i<listCaount; i++) {
        	String seqString = Integer.toString(beanList.get(i).getMcode());
        	String[] qTxt = {seqString, beanList.get(i).getMname(), beanList.get(i).getEffect(), beanList.get(i).getCompany(), beanList.get(i).getIngredient(), beanList.get(i).getDosage()};
        	Outer_Table3.addRow(qTxt);
        }

	}

	private void TableClick() {
        int i = innerSearch.getSelectedRow();
        
        String mcode = (String) innerSearch.getValueAt(i, 0);
        ShareVar.nowmcode = mcode;
//        int tsSequence = Integer.parseInt(wkSequence);
        DbActionSearch dbActionSearch = new DbActionSearch(mcode);
        
        BeanMedicine beanMedicine = dbActionSearch.tableClick();
        
        //String Mcode = Integer.toString(beanMedicine.getMcode());
        
        
       tfMname.setText(beanMedicine.getMname());
       taEffect.setText(beanMedicine.getEffect());
       tfCompany.setText(beanMedicine.getCompany());
       tfIngredient.setText(beanMedicine.getIngredient());
       taDosage.setText(beanMedicine.getDosage());
      
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(92, 299, 305, 36);
			scrollPane.setViewportView(getTaEffect());
		}
		return scrollPane;
	}
	private JTextArea getTaEffect() {
		if (taEffect == null) {
			taEffect = new JTextArea();
		}
		return taEffect;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(92, 404, 305, 56);
			scrollPane_1.setViewportView(getTaDosage());
		}
		return scrollPane_1;
	}
	private JTextArea getTaDosage() {
		if (taDosage == null) {
			taDosage = new JTextArea();
		}
		return taDosage;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("닫기");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			button.setBounds(397, 509, 117, 29);
		}
		return button;
	}
	private JButton getBtnMedicinOk() {
		if (btnMedicinOk == null) {
			btnMedicinOk = new JButton("확인");
			btnMedicinOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(radioInsertMedicine.isSelected()==true) {
						insertMedicineAction();
					}
					if(radioUpdateMedicine.isSelected()==true) {
						updateMedicineAction();
					}
				}
			});
			btnMedicinOk.setBounds(280, 509, 117, 29);
		}
		return btnMedicinOk;
	}
	private JRadioButton getRadioInsertMedicine() {
		if (radioInsertMedicine == null) {
			radioInsertMedicine = new JRadioButton("입력");
			radioInsertMedicine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfMname.setEditable(true);
					tfCompany.setEditable(true);
					tfIngredient.setEditable(true);
					taDosage.setEditable(true);
					taEffect.setEditable(true);
					tfFilePath.setEditable(true);
					
					tfCompany.setText("");
					tfMname.setText("");
					tfIngredient.setText("");
					taDosage.setText("");
					taEffect.setText("");
					tfMcode.setText("");
					tfFilePath.setText("");
				}
			});
			buttonGroup.add(radioInsertMedicine);
			radioInsertMedicine.setBounds(23, 510, 75, 23);
		}
		return radioInsertMedicine;
	}
	private JRadioButton getRadioUpdateMedicine() {
		if (radioUpdateMedicine == null) {
			radioUpdateMedicine = new JRadioButton("수정");
			radioUpdateMedicine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfMname.setEditable(true);
					tfCompany.setEditable(true);
					tfIngredient.setEditable(true);
					taDosage.setEditable(true);
					taEffect.setEditable(true);
					tfFilePath.setEditable(true);
				}
			});
			buttonGroup.add(radioUpdateMedicine);
			radioUpdateMedicine.setBounds(127, 510, 75, 23);
		}
		return radioUpdateMedicine;
	}
	private void insertMedicineAction(){
		String mcode = tfMcode.getText().trim();
		String mname = tfMname.getText().trim();
		String effect = taEffect.getText().trim();
		String company = tfCompany.getText().trim();
		String ingredient = tfIngredient.getText().trim();
		String dosage = taDosage.getText().trim();
		
		int wkmcode = Integer.parseInt(mcode);
		DbAction dbAction = new DbAction(wkmcode, mname, effect, company, ingredient, dosage);
		

		boolean msg = dbAction.insertMedicineAction();
		
		if (msg == true) {
			JOptionPane.showMessageDialog(null, "입력완료 !");
		}else {
			JOptionPane.showMessageDialog(null, "입력실패 !");
		}
	}
	private void updateMedicineAction(){
		int mcode = Integer.parseInt(tfMcode.getText().trim());
		String mname = tfMname.getText().trim();
		String effect = taEffect.getText().trim();
		String company = tfCompany.getText().trim();
		String ingredient = tfIngredient.getText().trim();
		String dosage = taDosage.getText().trim();
		DbAction dbAction = new DbAction(mcode, mname, effect, company, ingredient, dosage);
		
		
		boolean msgg = dbAction.updateMedicineAction();
		
		if (msgg == true) {
			JOptionPane.showMessageDialog(null, "입력완료 !");
		}else {
			JOptionPane.showMessageDialog(null, "입력실패 !");
		}
	}
	
	
	private JLabel getLabelMcode() {
		if (labelMcode == null) {
			labelMcode = new JLabel("약 코드");
			labelMcode.setBounds(246, 273, 61, 16);
		}
		return labelMcode;
	}
	private JTextField getTfMcode() {
		if (tfMcode == null) {
			tfMcode = new JTextField();
			tfMcode.setBounds(305, 268, 92, 26);
			tfMcode.setColumns(10);
		}
		return tfMcode;
	}
//	
	private JLabel getLblShapeInput() {
		if (lblShapeInput == null) {
			lblShapeInput = new JLabel("모양");
			lblShapeInput.setBounds(6, 470, 61, 16);
		}
		return lblShapeInput;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(92, 472, 130, 26);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("파일 경로");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(252, 468, 117, 29);
		}
		return btnFilePath;
	}
	private JLabel getLblShape() {
		if (lblShape == null) {
			lblShape = new JLabel("모양");
			lblShape.setBounds(351, 375, 61, 16);
		}
		return lblShape;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/tj/Documents/Kenny/Temp/null.png"));
			lblImage.setBounds(397, 375, 98, 82);
		}
		return lblImage;
	}
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
      String filePath = Integer.toString(ShareVar.filename);
      tfFilePath.setText(filePath);
      
      lblImage.setIcon(new ImageIcon(filePath));
      lblImage.setHorizontalAlignment(SwingConstants.CENTER);
      
      File file = new File(filePath);
      file.delete();
      
      tfFilePath.setText("");
      
		
	}
	//좋아요는왜눌렀니------------------------------------------------------------------------------------------


		//----------화면구성
//		private JTextField getTflikecount() {
//			if (tflikecount == null) {
//				tflikecount = new JTextField();
//				tflikecount.setEditable(false);
//				tflikecount.setColumns(10);
//				tflikecount.setBounds(468, 283, 24, 16);
//				tflikecount.setOpaque(false);
//				DbActionMedicine actionMedicine  = new DbActionMedicine();
//				tflikecount.setText(Integer.toString(actionMedicine.likecount()));
//				
//				
//			}
//			return tflikecount;
//		}


		private JLabel getLblikecount() {
			if (lblikecount == null) {
				lblikecount = new JLabel("New label");
				lblikecount.setIcon(new ImageIcon("/Users/tuna/Pictures/like copy.png"));
				lblikecount.setBounds(447, 273, 50, 44);
			}
			return lblikecount;
		}

		private JButton getBtnlike() {
			if (btnlike == null) {
				btnlike = new JButton("");
				btnlike.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					DbActionMedicine actionMedicine =new DbActionMedicine();
						{					
							LkInsertAction();
							changebtnheart();
						
						}		
					}
				});
				btnlike.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/pillunlike.png"));
				btnlike.setBounds(447, 324, 50, 50);
				
			}
			return btnlike;
		}
		private JButton getBtnunlike() {
			if (btnunlike == null) {
				btnunlike = new JButton("");
				btnunlike.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					DbActionMedicine actionMedicine =new DbActionMedicine();	
						LKdeleteAction();
						changebtnheart();
					}
				});
				btnunlike.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/pilllike.png"));
				btnunlike.setOpaque(false);
				btnunlike.setBounds(447, 325, 50, 50);
			}
			return btnunlike;
		}
		//---------------------------------------------------------



		//--------메소드
				String nowmcode;
				String nowusercode;
				int lcode;
				
				
				//첫좋아요
				private void LkInsertAction() {
					int likecheck2=2;
					DbActionMedicine dbactionmedicine = new DbActionMedicine();
					int likecheck =(dbactionmedicine.likecheck());
					
					if(likecheck==2){
						if(dbactionmedicine.insertAction(nowmcode, nowusercode, lcode)==true) {              
							JOptionPane.showMessageDialog(null, "이 약을 '좋아요'합니다.");
							likecheck2++;
						}
					}
					if(likecheck==0) {
						if(dbactionmedicine.updateAction(lcode)==true) {              
							JOptionPane.showMessageDialog(null, "이 약을 '좋아요'합니다.");
							likecheck2++;
						}
					}
				}
				
				//취소했다가 좋아요
//				private void LKUpdateAction(){
//					
//					int likecheck2=2;
//					DbActionMedicine dbactionmedicine = new DbActionMedicine();
//					int likecheck =(dbactionmedicine.likecheck());
//					
//					//if(likecheck==0){
//						if(dbactionmedicine.updateAction(lcode)==true) {              
//							JOptionPane.showMessageDialog(null, "이 약을 '좋아요'합니다.");
//							likecheck2++;
//						}
//					//}
//				}
			
				        
				//좋아요 취소
				 private void LKdeleteAction() {
					 
					 int likecheck2=2;	
						DbActionMedicine dbactionmedicine = new DbActionMedicine();
						int likecheck =(dbactionmedicine.likecheck());
						
						if(likecheck==1){
							if(dbactionmedicine.deleteAction(lcode)==true) {              
								JOptionPane.showMessageDialog(null, "'좋아요'를 취소합니다.");
								likecheck2++;
							}
						}
					}
					private void changebtnheart() {
						int likecheck2=2;
						DbActionMedicine dbactionmedicine = new DbActionMedicine();
						int likecheck =(dbactionmedicine.likecheck());
						if (likecheck==1) {
							btnunlike.setVisible(true);
							btnlike.setVisible(false);
						}
						
						if (likecheck==0) {
							btnlike.setVisible(true);
							btnunlike.setVisible(false);
						}
						
						if (likecheck==2) {
							btnlike.setVisible(true);
							btnunlike.setVisible(false);
						}
						
					
					
						
					}
}//-----------------
