package com.javalec.update;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import shareVar.ShareVar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



import com.javalec.function.BeanPharm;
import com.javalec.function.DbAction;
import com.javalec.function.DbActionPharmacy;
import com.javalec.function.DbActionSearch;
import com.javalec.function.DbActionSearchPharm;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Pharmacy extends JDialog {

	private final JPanel contentPanel = new JPanel();
//	private JTable innerMedicine;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField tfPhname;
	private JTextField tfTelno;

	private JTextField tflikecount;
	private JButton btnlike;
	private JLabel lblikecount;
	private JButton btnunlike;
	/**
	 * Launch the application.
	 */
	
	protected final DefaultTableModel Outer_Table4 = new DefaultTableModel();
	private JScrollPane scrollPaneSearch;
	private JTable innerSearch;
	private JScrollPane scrollPane;
	private JTextArea taPhaddress;
	private JButton button;
	private JScrollPane scrollPane_1;
	private JTextArea taTime;
	private JRadioButton radioInsertPharm;
	private JRadioButton radioUpdatePharm;
	private JButton btnPharmacyOk;
	private JLabel labelPhcode;
	private JTextField tfPhcode;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static void main(String[] args) {
		try {
			Pharmacy dialog = new Pharmacy();
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
	public Pharmacy() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			TableInit4();
			SearchAction4();
			if (ShareVar.nowid.equals("admin")) {
				radioInsertPharm.setVisible(true);
				radioUpdatePharm.setVisible(true);
				btnPharmacyOk.setVisible(true);
				labelPhcode.setVisible(true);
				tfPhcode.setVisible(true);
				
				btnlike.setVisible(false);
				btnunlike.setVisible(false);
				tflikecount.setVisible(false);
				lblikecount.setVisible(false);
			}
			else {
				radioInsertPharm.setVisible(false);
				radioUpdatePharm.setVisible(false);
				btnPharmacyOk.setVisible(false);
				labelPhcode.setVisible(false);
				tfPhcode.setVisible(false);
				
				btnlike.setVisible(false);
				btnunlike.setVisible(false);
				tflikecount.setVisible(false);
				lblikecount.setVisible(false);
			}
			}
			public void windowActivated(WindowEvent e) {
				TableInit4();
				SearchAction4();
			}
		});
		setBounds(100, 100, 514, 587);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
		}
		contentPanel.add(getLabel());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLabel_2());
		contentPanel.add(getLabel_3());
		contentPanel.add(getTfPhname());
		contentPanel.add(getTfTelno());
		contentPanel.add(getScrollPaneSearch());
		contentPanel.add(getScrollPane());
		contentPanel.add(getButton());
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getRadioInsertPharm());
		contentPanel.add(getRadioUpdatePharm());
		contentPanel.add(getBtnPharmacyOk());
		contentPanel.add(getLabelPhcode());
		
		//contentPanel.add(getTflikecount());
		contentPanel.add(getLblikecount());
		contentPanel.add(getBtnunlike());
		contentPanel.add(getBtnlike());
		contentPanel.add(getTfPhcode());
		
	}
//	private JTable getInnerMedicine() {
//		try {
//		if (innerMedicine == null) {
//			innerMedicine = new JTable();
////			innerMedicine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			innerMedicine.setModel(Outer_Table4); // <--***************************************************
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
			label = new JLabel("약국 이름");
			label.setBounds(16, 304, 61, 16);
		}
		return label;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("약국 주소");
			lblNewLabel.setBounds(16, 332, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("전화번호");
			label_2.setBounds(16, 371, 61, 16);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("운영시간");
			label_3.setBounds(16, 399, 61, 16);
		}
		return label_3;
	}
	private JTextField getTfPhname() {
		if (tfPhname == null) {
			tfPhname = new JTextField();
			tfPhname.setEditable(false);
			tfPhname.setBounds(102, 299, 130, 26);
			tfPhname.setColumns(10);
		}
		return tfPhname;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setEditable(false);
			tfTelno.setColumns(10);
			tfTelno.setBounds(102, 361, 130, 26);
		}
		return tfTelno;
	}
	
	private void TableInit4(){
        int i = Outer_Table4.getRowCount();
        
        Outer_Table4.addColumn("약국 이름");
        Outer_Table4.addColumn("약국 주소");
        Outer_Table4.addColumn("전화번호");
        Outer_Table4.addColumn("운영시간");
 
        Outer_Table4.setColumnCount(4);

        for(int j = 0 ; j < i ; j++){
            Outer_Table4.removeRow(0);
        }

        innerSearch.setAutoResizeMode(innerSearch.AUTO_RESIZE_OFF);
        
//
//        int vColIndex = 0;
//        TableColumn col = innerSearch.getColumnModel().getColumn(vColIndex);
//        int width = 80;
//        col.setPreferredWidth(width);

        
        int vColIndex = 0;
        TableColumn col = innerSearch.getColumnModel().getColumn(vColIndex);
        int width = 100;
        col.setPreferredWidth(width);
     
        vColIndex = 1;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 120;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = innerSearch.getColumnModel().getColumn(vColIndex);
        width = 180;
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
					TableClick2();
					changebtnheart();
//					lblikecount.setVisible(true);
//				    tflikecount.setVisible(true);
				}
			});
			innerSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerSearch.setModel(Outer_Table4);
		}
		return innerSearch;
	}
	public void SearchAction4(){
        DbActionSearchPharm dbActionSearchPharm = new DbActionSearchPharm();
        ArrayList<BeanPharm> beanList2 = dbActionSearchPharm.selectList2();
        
        int listCaount = beanList2.size();
        for(int i = 0; i<listCaount; i++) {
        	String seqPhcode =Integer.toString(beanList2.get(i).getPhcode());
        	String[] qTxt = {seqPhcode,beanList2.get(i).getPhname(), beanList2.get(i).getPhaddress(), beanList2.get(i).getTelno(), beanList2.get(i).getTime()};
        	Outer_Table4.addRow(qTxt);
        }

	}
	
	private void TableClick2() {
    
		int i = innerSearch.getSelectedRow();
		
		DbActionSearchPharm dbActionSearchPharm = new DbActionSearchPharm();
		ArrayList<BeanPharm> beanList2 = dbActionSearchPharm.selectList2();
        
		String phcode = Integer.toString(beanList2.get(i).getPhcode());
        int intphcode = Integer.parseInt(phcode);
        DbActionSearchPharm dbActionSearchPharm1 = new DbActionSearchPharm(intphcode);
        
        BeanPharm beanPharm = dbActionSearchPharm1.tableClick2();
        
       
//       int wkPhcode = Integer.parseInt(beanPharm.getPhcode());
       tfPhcode.setText(phcode);
       tfPhname.setText(beanPharm.getPhname());
       taPhaddress.setText(beanPharm.getPhaddress());
       tfTelno.setText(beanPharm.getTelno());
       taTime.setText(beanPharm.getTime());
    
       ShareVar.nowphcode = phcode;
   
	}
	
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(102, 332, 336, 26);
			scrollPane.setViewportView(getTaPhaddress());
		}
		return scrollPane;
	}
	private JTextArea getTaPhaddress() {
		if (taPhaddress == null) {
			taPhaddress = new JTextArea();
		}
		return taPhaddress;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("닫기");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			button.setBounds(391, 510, 117, 29);
		}
		return button;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(102, 399, 336, 64);
			scrollPane_1.setViewportView(getTaTime());
		}
		return scrollPane_1;
	}
	private JTextArea getTaTime() {
		if (taTime == null) {
			taTime = new JTextArea();
			taTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return taTime;
	}
	private JRadioButton getRadioInsertPharm() {
		if (radioInsertPharm == null) {
			radioInsertPharm = new JRadioButton("입력");
			radioInsertPharm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				tfPhcode.setText("");
				tfPhname.setText("");
				taPhaddress.setText("");
				taTime.setText("");
				tfTelno.setText("");
				
				tfPhcode.setEditable(true);
				tfPhname.setEditable(true);
				taPhaddress.setEditable(true);
				taTime.setEditable(true);
				tfTelno.setEditable(true);
				
				
				
				}
			});
			buttonGroup.add(radioInsertPharm);
			radioInsertPharm.setBounds(39, 511, 83, 23);
		}
		return radioInsertPharm;
	}
	private JRadioButton getRadioUpdatePharm() {
		if (radioUpdatePharm == null) {
			radioUpdatePharm = new JRadioButton("수정");
			radioUpdatePharm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				tfPhcode.setEditable(true);
				tfPhname.setEditable(true);
				tfTelno.setEditable(true);
				taPhaddress.setEditable(true);
				taTime.setEditable(true);
				}
			});
			buttonGroup.add(radioUpdatePharm);
			radioUpdatePharm.setBounds(149, 511, 69, 23);
			
		
		
		}
		return radioUpdatePharm;
	}
	private JButton getBtnPharmacyOk() {
		if (btnPharmacyOk == null) {
			btnPharmacyOk = new JButton("확인");
			btnPharmacyOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(radioInsertPharm.isSelected()==true) {
						insertPharmAction();
					}
					if(radioUpdatePharm.isSelected()==true) {
						updatePharmAction();
					}
				}
			});
			btnPharmacyOk.setBounds(276, 510, 117, 29);
		}
		return btnPharmacyOk;
	}
	private void insertPharmAction(){
		String phcode = tfPhcode.getText().trim();
		String phname = tfPhname.getText().trim();
		String phaddress = taPhaddress.getText().trim();
		String telno = tfTelno.getText().trim();
		String time = taTime.getText().trim();
		
		int wkPhcode = Integer.parseInt(phcode);
		DbAction dbAction = new DbAction(wkPhcode, phname, phaddress, telno, time);
		

		boolean msg = dbAction.insertPharmAction();
		
		if (msg == true) {
			JOptionPane.showMessageDialog(null, "입력완료 !");
		}else {
			JOptionPane.showMessageDialog(null, "입력실패 !");
		}
	}
	
	private void updatePharmAction(){
		int phcode = Integer.parseInt(tfPhcode.getText().trim());
		String phname = tfPhname.getText().trim();
		String phaddress = taPhaddress.getText().trim();
		String telno = tfTelno.getText().trim();
		String time = taTime.getText().trim();
		DbActionSearchPharm dbActionSearchPharm = new DbActionSearchPharm(phcode, phname, phaddress, telno, time);
		
		
		boolean msgg = dbActionSearchPharm.updatePharmAction();
		
		if (msgg == true) {
			JOptionPane.showMessageDialog(null, "입력완료 !");
		}else {
			JOptionPane.showMessageDialog(null, "입력실패 !");
		}
	}

	private JLabel getLabelPhcode() {
		if (labelPhcode == null) {
			labelPhcode = new JLabel("약국코드");
			labelPhcode.setBounds(244, 304, 194, 16);
		}
		return labelPhcode;
	}
	private JTextField getTfPhcode() {
		if (tfPhcode == null) {
			tfPhcode = new JTextField();
			tfPhcode.setBounds(317, 299, 121, 26);
			tfPhcode.setColumns(10);
		}
		return tfPhcode;
	}
	//좋아요는왜눌렀니------------------------------------------------------------------------------------------


			//----------화면구성
			private JTextField getTflikecount() {
				if (tflikecount == null) {
					tflikecount = new JTextField();
					tflikecount.setEditable(false);
					tflikecount.setColumns(10);
					tflikecount.setBounds(468, 283, 24, 16);
					tflikecount.setOpaque(false);
					DbActionPharmacy actionPharmacy  = new DbActionPharmacy();
					tflikecount.setText(Integer.toString(actionPharmacy.likecount()));
					
					
				}
				return tflikecount;
			}


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
						DbActionPharmacy actionPharmacy =new DbActionPharmacy();
							{					
								LkInsertAction();
								changebtnheart();
							
							}		
						}
					});
					btnlike.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/phalike.png"));
					btnlike.setBounds(447, 324, 50, 50);
					
				}
				return btnlike;
			}
			private JButton getBtnunlike() {
				if (btnunlike == null) {
					btnunlike = new JButton("");
					btnunlike.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						DbActionPharmacy actionPharmacy =new DbActionPharmacy();	
							LKdeleteAction();
							changebtnheart();
						}
					});
					btnunlike.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/phaunlike.png"));
					btnunlike.setOpaque(false);
					btnunlike.setBounds(447, 325, 50, 50);
				}
				return btnunlike;
			}
			//---------------------------------------------------------



			//--------메소드
					String nowphcode;
					String nowusercode;
					int lcode;
					private JLabel lblNewLabel_1;
					
					
					//첫좋아요
					private void LkInsertAction() {
						int likecheck2=2;
						DbActionPharmacy actionPharmacy = new DbActionPharmacy();
						int likecheck =(actionPharmacy.likecheck());
						
						if(likecheck==2){
							if(actionPharmacy.insertAction(nowphcode, nowusercode, lcode)==true) {              
								JOptionPane.showMessageDialog(null, "이 약을 '좋아요'합니다.");
								likecheck2++;
							}
						}
						if(likecheck==0) {
							if(actionPharmacy.updateAction(lcode)==true) {              
								JOptionPane.showMessageDialog(null, "이 약을 '좋아요'합니다.");
								likecheck2++;
							}
						}
					}
					
					//취소했다가 좋아요
//					private void LKUpdateAction(){
//						
//						int likecheck2=2;
//						DbActionMedicine dbactionmedicine = new DbActionMedicine();
//						int likecheck =(dbactionmedicine.likecheck());
//						
//						//if(likecheck==0){
//							if(dbactionmedicine.updateAction(lcode)==true) {              
//								JOptionPane.showMessageDialog(null, "이 약을 '좋아요'합니다.");
//								likecheck2++;
//							}
//						//}
//					}
				
					        
					//좋아요 취소
					 private void LKdeleteAction() {
						 
						 int likecheck2=2;	
						 DbActionPharmacy actionPharmacy = new DbActionPharmacy();
							int likecheck =(actionPharmacy.likecheck());
							
							if(likecheck==1){
								if(actionPharmacy.deleteAction(lcode)==true) {              
									JOptionPane.showMessageDialog(null, "'좋아요'를 취소합니다.");
									likecheck2++;
								}
							}
						}
						private void changebtnheart() {
							int likecheck2=2;
							DbActionPharmacy dbactionmedicine = new DbActionPharmacy();
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


