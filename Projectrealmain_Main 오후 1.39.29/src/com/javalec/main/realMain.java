package com.javalec.main;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.javalec.function.Bean;
import com.javalec.function.BeanPharm;
import com.javalec.function.BeanShowboard;
import com.javalec.function.Beanmypage;
import com.javalec.function.DbActionHome;
import com.javalec.function.DbActionMypage;
import com.javalec.function.DbActionSearchPharm;
import com.javalec.function.DbActionShowboard;
import com.javalec.popup.Event;
import com.javalec.popup.InputScreen;
import com.javalec.popup.showBoard;
import com.javalec.start.StartMain;
import com.javalec.update.Medicine;
import com.javalec.update.Pharmacy;
import com.javalec.update.Update;
import com.mysql.cj.xdevapi.TableImpl;

import shareVar.ShareVar;
import javax.swing.ImageIcon;
import java.awt.Color;



public class realMain {
	
	
	private JFrame frame;
	private JPanel panel;
	private JPanel panelHome;
	private JScrollPane scrollPane;
	private JTable innerHome;
	private JPanel panelSearch;
	private JButton btnBoardSearch;
	private JPanel panelBoard;
	private JLabel label;
	private JPanel panelMypage;
	private JLabel label_1;
	private JButton btnHome;
	private JButton btnSearch;
	private JButton btnBoard;
	private JButton btnMypage;
	private JButton btnCreate;
	private JButton btnLogout;
	public static JTextField tfSearch;
	private JComboBox cbSearch;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField welComeTf2;
	private JTextField welComNameTf;
	private JLabel label_2;
	private JScrollPane scrollPaneMine;
	private JTable innertableMy1;
	private JLabel label_3;
	private JScrollPane scrollPaneLikeP;
	private JTable innertableMy2;
	private JScrollPane scrollPaneBoard;
	private static JTable innerBoard;
	private JButton btnUpdate;
	private JTextField welComeTf;
	private JLabel lblNewLabel_2;
	private JLabel label_4;
	private JScrollPane scrollPaneLikeM;
	private JTable innertableMy3;
	private JLabel labeHome;
	
	protected final DefaultTableModel Outer_Table = new DefaultTableModel();
	protected final static DefaultTableModel Outer_Table2 = new DefaultTableModel();
//	private String url_mysql = ShareVar.url_mysql;
//	private String id_mysql = ShareVar.id_mysql;
//	private String pw_mysql = ShareVar.pw_mysql;
	protected final DefaultTableModel Outer_Table_M1=new  DefaultTableModel();
	protected final DefaultTableModel Outer_Table_M2=new DefaultTableModel();
	protected final DefaultTableModel Outer_Table_M3=new DefaultTableModel();
	public  JTextField tfSearch2;
	private JLabel lbMedicine;
	private JLabel lbPharm;
	private JLabel lblNewLabel_3;
	private JLabel LabelHome;
	private JButton btnEvent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					realMain window = new realMain();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public realMain() {
		initialize();
	}

	//--------------------------------------------------------------
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				panelHome.setVisible(true);
				panelSearch.setVisible(false);
				panelBoard.setVisible(false);
				panelMypage.setVisible(false);
				
				welComNameTf.setText(ShareVar.nowname);
				welComeTf2.setText(ShareVar.nowid);
				welComeTf.setText(ShareVar.nowname);
				frame.setLocationRelativeTo(null);
				
				TableInitHome();
				SearchAction();
			}
			@Override
			public void windowActivated(WindowEvent e) {
//				TableInitBoard();
//				SearchAction();
//				panelHome.setVisible(false);
//				panelSearch.setVisible(false);
//				panelBoard.setVisible(true);
//				panelMypage.setVisible(false);
			}
		});
		frame.setBounds(100, 100, 570, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.setTitle("Copyright ⓒ 2020.겨우다했조.박인영,주혜정,유민규,도하진,최지...All Rights Reserved.");
	}
	//메인패널------------------------------------------------------------------

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 570, 735);
			panel.setLayout(null);
			panel.add(getPanelHome());
			panel.add(getPanelMypage());
			panel.add(getPanelSearch());
			panel.add(getPanelBoard());
			panel.add(getBtnBoard());
			panel.add(getBtnMypage());
			panel.add(getBtnCreate());
			panel.add(getBtnLogout());
			panel.add(getBtnHome());
			panel.add(getBtnSearch());
			panel.add(getLblNewLabel_3());
			panel.add(getBtnEvent());
			
		}
		return panel;
	}
	
	private JButton getBtnCreate() {
		if (btnCreate == null) {
			btnCreate = new JButton("");
			btnCreate.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/btncreatepsd.png"));
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gotoCreate();
					
				}
			});
			btnCreate.setBounds(30, 8, 80, 70);
		}
		return btnCreate;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("");
			btnLogout.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/btnlogout..png"));
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedOption = JOptionPane.showConfirmDialog(null, 
                            "정말 로그아웃하시겠습니까? 로그인 화면으로 돌아갑니다.", 
                            "Choose", 
                            JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION) {
						gotostartmain();
						frame.setVisible(false);
						
					
						}
				

			
				}
			
				
				
			});
			btnLogout.setBounds(462, 8, 80, 70);
		}
		return btnLogout;
	}
	
	//===========================homepanel

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/btnhome.png"));
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelHome.setVisible(true);
					panelSearch.setVisible(false);
					panelBoard.setVisible(false);
					panelMypage.setVisible(false);
					TableInitHome();
					SearchAction();
				}
			});
			btnHome.setBounds(30, 659, 80, 70);
		}
		return btnHome;
	}
	private JPanel getPanelHome() {
		if (panelHome == null) {
			panelHome = new JPanel();
			panelHome.setBackground(Color.WHITE);
			panelHome.setBounds(6, 90, 558, 557);
			panelHome.setLayout(null);
			panelHome.add(getScrollPane());
			panelHome.add(getLabelHome());
			
		}
		return panelHome;
	}
	private void TableInitHome(){
        int i = Outer_Table.getRowCount();
        
        Outer_Table.addColumn("Seq.");
        Outer_Table.addColumn("Category");
        Outer_Table.addColumn("title");
        Outer_Table.addColumn("id");
        Outer_Table.addColumn("date");
        Outer_Table.setColumnCount(5);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        innerHome.setAutoResizeMode(innerHome.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = innerHome.getColumnModel().getColumn(vColIndex);
        int width = 40;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innerHome.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = innerHome.getColumnModel().getColumn(vColIndex);
        width = 322;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = innerHome.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 4;
        col = innerHome.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 209, 546, 194);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (innerHome == null) {
			innerHome = new JTable();
			innerHome.setRowSelectionAllowed(false);
			innerHome.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerHome.setModel(Outer_Table); // <--***************************************************
			
		}
		return innerHome;
	}
//	private JScrollPane getScrollPane() {
//		if (scrollPane == null) {
//			scrollPane = new JScrollPane();
//			scrollPane.setBounds(6, 44, 546, 299);
//			scrollPane.setViewportView(getInner_Home());
//		}
//		return scrollPane;
//	}
	private JLabel getLabelHome() {
		if (LabelHome == null) {
			LabelHome = new JLabel("Mstagram에 오신것을 환영합니다");
			LabelHome.setFont(new Font("Lucida Grande",Font.PLAIN, 19));
			LabelHome.setBounds(154, 48, 263, 33);
			
			//panelHome.add(labelHome);
		}
		return LabelHome;
	}

	
	
	
	
	
	
	//===========================searchpanel
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("");
			btnSearch.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/btnsearch.png"));
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelHome.setVisible(false);
					panelSearch.setVisible(true);
					panelBoard.setVisible(false);
					panelMypage.setVisible(false);
					lbMedicine.setVisible(true);
					lbPharm.setVisible(false);
					TableInitBoard();
					SearchAction();
				}
			});
			btnSearch.setBounds(132, 659, 80, 70);
		}
		return btnSearch;
	}

	private JPanel getPanelSearch() {
		if (panelSearch == null) {
			panelSearch = new JPanel();
			panelSearch.setBackground(Color.WHITE);
			panelSearch.setBounds(6, 90, 558, 557);
			panelSearch.setLayout(null);
			panelSearch.add(getBtnBoardSearch());
			panelSearch.add(getTfSearch());
			panelSearch.add(getCbSearch());
			panelSearch.add(getLbMedicine());
			panelSearch.add(getLbPharm());
		}
		return panelSearch;
	}
	private JButton getBtnBoardSearch() {
		if (btnBoardSearch == null) {
			btnBoardSearch = new JButton("검색");
			btnBoardSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SelectedSearch();
					
					
				}
			});
			btnBoardSearch.setBounds(456, 151, 96, 29);
		}
		return btnBoardSearch;
	}
	//=============================================boardpanel

	public JButton getBtnBoard() {
		if (btnBoard == null) {
			btnBoard = new JButton("");
			btnBoard.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/btnboard.png"));
			btnBoard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableInitBoard();
					SearchAction();
					panelHome.setVisible(false);
					panelSearch.setVisible(false);
					panelBoard.setVisible(true);
					panelMypage.setVisible(false);
				}
			});
			btnBoard.setBounds(350, 659, 80, 70);
		}
		return btnBoard;
	}
	private JPanel getPanelBoard() {
		if (panelBoard == null) {
			panelBoard = new JPanel();
			panelBoard.setBackground(Color.WHITE);
			panelBoard.setBounds(6, 90, 558, 557);
			panelBoard.setLayout(null);
			panelBoard.add(getLabel());
			panelBoard.add(getScrollPaneBoard());
		}
		return panelBoard;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("게시판");
			label.setBounds(237, 54, 61, 16);
		}
		return label;
	}
	
	//=============================================mypanel
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("");
			btnMypage.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/btnmypage.png"));
			btnMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelHome.setVisible(false);
					panelSearch.setVisible(false);
					panelBoard.setVisible(false);
					panelMypage.setVisible(true);
					TableInitMy1();
					TableInitMy2();
					TableInitMy3();
					
					ConditionQueryAction1(ShareVar.nowid);
					ConditionQueryAction2(ShareVar.nowid);
					ConditionQueryAction3(ShareVar.nowid);
				}
			});
			btnMypage.setBounds(452, 659, 80, 70);
		}
		return btnMypage;
	}
	
	private JPanel getPanelMypage() {
		if (panelMypage == null) {
			panelMypage = new JPanel();
			panelMypage.setBackground(Color.WHITE);
			panelMypage.setBounds(6, 90, 558, 557);
			panelMypage.setLayout(null);
			panelMypage.add(getLabel_1());
			panelMypage.add(getLblNewLabel());
			panelMypage.add(getLblNewLabel_1());
			panelMypage.add(getWelComeTf2());
			panelMypage.add(getWelComNameTf());
			panelMypage.add(getLabel_2());
			panelMypage.add(getScrollPaneMine());
			panelMypage.add(getLabel_3());
			panelMypage.add(getScrollPaneLikeP());
			panelMypage.add(getBtnUpdate());
			panelMypage.add(getLblNewLabel_2());
			panelMypage.add(getWelComeTf());
			panelMypage.add(getLabel_4());
			panelMypage.add(getScrollPaneLikeM());
		}
		return panelMypage;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("회원정보");
			label_1.setBounds(6, 68, 61, 16);
		}
		return label_1;
	}
	
	
	
	
	
	public JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					tfSearch.setText("");
				}
			});
			
			tfSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SelectedSearch ();
				}
			});
			tfSearch.setBounds(149, 151, 308, 26);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cbSearch.getSelectedItem().toString()=="약") {
						lbMedicine.setVisible(true);
						lbPharm.setVisible(false);
					}
					if (cbSearch.getSelectedItem().toString()=="약국") {
						lbPharm.setVisible(true);
						lbMedicine.setVisible(false);
					}
				}
			});
			cbSearch.setModel(new DefaultComboBoxModel(new String[] {"약", "약국"}));
			cbSearch.setBounds(60, 152, 88, 27);
		}
		return cbSearch;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(6, 96, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(6, 124, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getWelComeTf2() {
		if (welComeTf2 == null) {
			welComeTf2 = new JTextField();
			welComeTf2.setEditable(false);
			welComeTf2.setBounds(56, 91, 91, 26);
			welComeTf2.setColumns(10);
			welComeTf2.setBorder(null);
		}
		return welComeTf2;
	}
	private JTextField getWelComNameTf() {
		if (welComNameTf == null) {
			welComNameTf = new JTextField();
			welComNameTf.setEditable(false);
			welComNameTf.setColumns(10);
			welComNameTf.setBounds(56, 119, 91, 26);
			welComNameTf.setBorder(null);
		}
		return welComNameTf;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("내가 쓴 글");
			label_2.setBounds(6, 157, 61, 16);
		}
		return label_2;
	}
	private JScrollPane getScrollPaneMine() {
		if (scrollPaneMine == null) {
			scrollPaneMine = new JScrollPane();
			scrollPaneMine.setBounds(6, 185, 546, 82);
			scrollPaneMine.setViewportView(getInnertableMy1());
		}
		return scrollPaneMine;
	}
	private JTable getInnertableMy1() {
		if (innertableMy1 == null) {
			innertableMy1 = new JTable();
			innertableMy1.setModel(Outer_Table_M1);
		}
		return innertableMy1;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("즐겨찾는 약국");
			label_3.setBounds(6, 296, 86, 16);
		}
		return label_3;
	}
	private JScrollPane getScrollPaneLikeP() {
		if (scrollPaneLikeP == null) {
			scrollPaneLikeP = new JScrollPane();
			scrollPaneLikeP.setBounds(6, 333, 269, 121);
			scrollPaneLikeP.setViewportView(getInnertableMy2());
		}
		return scrollPaneLikeP;
	}
	private JTable getInnertableMy2() {
		if (innertableMy2 == null) {
			innertableMy2 = new JTable();
			innertableMy2.setModel(Outer_Table_M2);
		}
		return innertableMy2;
	}
	private JScrollPane getScrollPaneBoard() {
		if (scrollPaneBoard == null) {
			scrollPaneBoard = new JScrollPane();
			scrollPaneBoard.setBounds(6, 103, 546, 344);
			scrollPaneBoard.setViewportView(getInnerBoard());
		}
		return scrollPaneBoard;
	}

	
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("회원정보수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Update update =new Update();
					update.setVisible(true);
					update.setResizable(false);
					update.setLocationRelativeTo(null);
				}
			});
			btnUpdate.setBounds(452, 39, 100, 29);
		}
		return btnUpdate;
	}
	private JTextField getWelComeTf() {
		if (welComeTf == null) {
			welComeTf = new JTextField();
			welComeTf.setBounds(292, 39, 77, 26);
			welComeTf.setEditable(false);
			welComeTf.setColumns(10);
			welComeTf.setOpaque(false);
			welComeTf.setBorder(null);
		}
		return welComeTf;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("님 환영합니다 !");
			lblNewLabel_2.setBounds(370, 44, 86, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("즐겨찾는 약");
			label_4.setBounds(292, 296, 61, 16);
		}
		return label_4;
	}
	private JScrollPane getScrollPaneLikeM() {
		if (scrollPaneLikeM == null) {
			scrollPaneLikeM = new JScrollPane();
			scrollPaneLikeM.setBounds(287, 332, 265, 122);
			scrollPaneLikeM.setViewportView(getInnertableMy3());
		}
		return scrollPaneLikeM;
	}  
	private JTable getInnertableMy3() {
		if (innertableMy3 == null) {
			innertableMy3 = new JTable();
			innertableMy3.setModel(Outer_Table_M3);
		}
		return innertableMy3;
	}



	
	
	
	public void SearchAction(){
        DbActionHome dbActionHome = new DbActionHome();
        ArrayList<Bean> beanList = dbActionHome.selectList();
        
        int listCaount = beanList.size();
        for(int i = 0; i<listCaount; i++) {
        	String seqString = Integer.toString(beanList.get(i).getSeqno());  // 가져온 Seqno를 스트링으로 변환한다
        	String[] qTxt = {seqString, beanList.get(i).getCategory(), beanList.get(i).getTitle(), beanList.get(i).getDate(), beanList.get(i).getUser()};
        	Outer_Table.addRow(qTxt);              // Outer_Table에 QTxt를 넣는다.
        	Outer_Table2.addRow(qTxt);
        }
	}

	

	
	public void TableInitBoard(){
        int i = Outer_Table2.getRowCount();
        
        Outer_Table2.addColumn("Seq.");
        Outer_Table2.addColumn("Category");
        Outer_Table2.addColumn("title");
        Outer_Table2.addColumn("date");
        Outer_Table2.addColumn("id");
        Outer_Table2.setColumnCount(5);

        for(int j = 0 ; j < i ; j++){
            Outer_Table2.removeRow(0);
        }

        innerBoard.setAutoResizeMode(innerBoard.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = innerBoard.getColumnModel().getColumn(vColIndex);
        int width = 40;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innerBoard.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = innerBoard.getColumnModel().getColumn(vColIndex);
        width = 322;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = innerBoard.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 4;
        col = innerBoard.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);
	}
	
	public static JTable getInnerBoard() {
		if (innerBoard == null) {
			innerBoard = new JTable();
			innerBoard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//선택한 셀의 행 번호계산 
					int row = innerBoard.getSelectedRow();
					showBoard showBoard = new showBoard();
					showBoard.main(null);
					getwkname();
//					TableInit2();
					getSeqno();
									}
			});
			innerBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerBoard.setModel(Outer_Table2);
		}
		return innerBoard;
	}

	
	
	
	
	
	
	public void SelectedSearch () {
		if(cbSearch.getSelectedItem().toString()=="약") {
		
//		
		Medicine medicine = new Medicine();
		medicine.setVisible(true);
			medicine.SearchAction3();
		}
		if(cbSearch.getSelectedItem().toString()=="약국") {
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setVisible(true);
			pharmacy.SearchAction4();
		
		}
		
			
		}
	public static void getwkname() {
		int i= innerBoard.getSelectedRow();
		String wkname = (String)innerBoard.getValueAt(i, 4);
		ShareVar.wkname = wkname;
	}
	
	public static void getSeqno() {
		int i= innerBoard.getSelectedRow();
		String wkseq = (String)innerBoard.getValueAt(i, 0);
		ShareVar.wkseq = wkseq;
	}
	private JLabel getLbMedicine() {
		if (lbMedicine == null) {
			lbMedicine = new JLabel("증상이나 약 이름을 검색하세요 ex)소화, 감기 or 타이레놀");
			lbMedicine.setBounds(149, 177, 308, 16);
		}
		return lbMedicine;
	}
	private JLabel getLbPharm() {
		if (lbPharm == null) {
			lbPharm = new JLabel("지역구나 약국이름을 검색하세요 ex)종로구 or 메디팜약국");
			lbPharm.setBounds(149, 177, 301, 16);
		}
		return lbPharm;
	}
	public void TableInitMy1() {
		int i = Outer_Table_M1.getRowCount();
		        
		Outer_Table_M1.addColumn("Seq.");
		Outer_Table_M1.addColumn("Category");
		Outer_Table_M1.addColumn("title");
		Outer_Table_M1.addColumn("date");
		Outer_Table_M1.setColumnCount(4);

        for(int j = 0 ; j < i ; j++){
        	Outer_Table_M1.removeRow(0);
        }

        	innertableMy1.setAutoResizeMode(innertableMy1.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = innertableMy1.getColumnModel().getColumn(vColIndex);
        int width = 40;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innertableMy1.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = innertableMy1.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = innertableMy1.getColumnModel().getColumn(vColIndex);
        width = 265;
        col.setPreferredWidth(width);

	}
	
	public void TableInitMy2() {
		int i = Outer_Table_M2.getRowCount();
		
		Outer_Table_M2.addColumn("name");
		Outer_Table_M2.addColumn("address");
		Outer_Table_M2.addColumn("tel");
		Outer_Table_M2.setColumnCount(3);
		
		for(int j = 0 ; j < i ; j++){
			Outer_Table_M2.removeRow(0);
		}
		
		innertableMy2.setAutoResizeMode(innertableMy2.AUTO_RESIZE_OFF);
		
		
		int vColIndex = 0;
		TableColumn col = innertableMy2.getColumnModel().getColumn(vColIndex);
		int width = 80;
		col.setPreferredWidth(width);
		vColIndex = 1;
		col = innertableMy2.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innertableMy2.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		
		
	}
	

	public void TableInitMy3() {
		int i = Outer_Table_M3.getRowCount();
		
		Outer_Table_M3.addColumn("name");
		Outer_Table_M3.addColumn("ingredient");
		Outer_Table_M3.addColumn("effect");
		Outer_Table_M3.setColumnCount(3);
		
		for(int j = 0 ; j < i ; j++){
			Outer_Table_M3.removeRow(0);
		}
		
		innertableMy3.setAutoResizeMode(innertableMy3.AUTO_RESIZE_OFF);
		
		
		int vColIndex = 0;
		TableColumn col = innertableMy3.getColumnModel().getColumn(vColIndex);
		int width = 80;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = innertableMy3.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innertableMy3.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);

	}
	
	public void ConditionQueryAction1(String ConditionQueryColumn) {
		DbActionMypage dbActionmypage = new DbActionMypage();
		ArrayList<Beanmypage> beanList = dbActionmypage.ConditionList1();
		
		int listCount = beanList.size();
		
		for (int i = 0; i < listCount; i++) {
			String temp = Integer.toString(beanList.get(i).getSeqno());
			String[] qTxt = {temp,beanList.get(i).getCategory(), beanList.get(i).getTitle(), beanList.get(i).getText()};
			Outer_Table_M1.addRow(qTxt);
		}
	}
	public void ConditionQueryAction2(String ConditionQueryColumn) {
		DbActionMypage dbActionmypage = new DbActionMypage();
		ArrayList<Beanmypage> beanList = dbActionmypage.ConditionList2();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String[] qTxt = {beanList.get(index).getText(), beanList.get(index).getTitle()};
			Outer_Table_M2.addRow(qTxt);
		}
	}
	public void ConditionQueryAction3(String ConditionQueryColumn) {
		DbActionMypage dbActionmypage = new DbActionMypage();
		ArrayList<Beanmypage> beanList = dbActionmypage.ConditionList3();
		
		int listCount = beanList.size();
		

		
		for (int index = 0; index < listCount; index++) {
			
			String[] qTxt = {beanList.get(index).getText(), beanList.get(index).getCategory(), beanList.get(index).getTitle()};
			Outer_Table_M3.addRow(qTxt);
		}
	}
	
//	public static void getwkname() {
//		int i= innerBoard.getSelectedRow();
//		String wkname = (String)innerBoard.getValueAt(i, 4);
//		ShareVar.wkname = wkname;
//	}
//	
//	public static void getSeqno() {
//		int i= innerBoard.getSelectedRow();
//		String wkseq = (String)innerBoard.getValueAt(i, 0);
//		ShareVar.wkseq = wkseq;
//	}


	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/mst.png"));
			lblNewLabel_3.setBounds(141, 8, 278, 70);
		}
		return lblNewLabel_3;
	}
	
	
	
	public void gotoupdate() {
		Update update = new Update();
		update.setVisible(true);
		update.setResizable(false);
		update.setLocationRelativeTo(null);
	}
	public void gotoCreate(){
	InputScreen inputScreen = new InputScreen();
	
	 inputScreen.setVisible(true);
	 inputScreen.setResizable(false);
	 inputScreen.setLocationRelativeTo(null);
	
	}
	public void gotostartmain() {
		StartMain login =new StartMain(); 
		 login.setVisible(true);
		 login.setResizable(false);
		 login.setLocationRelativeTo(null);
	}
	public void gotoshowboard() {
		showBoard showBoard= new showBoard(); 
		 showBoard.setVisible(true);
		 showBoard.setResizable(false);
		 showBoard.setLocationRelativeTo(null);
	}
	
	
	
	
	
//	public void gotomedicine() {
//		Medicine medicine = new Medicine();
//		 medicine.setVisible(true);
//		 medicine.SearchAction3();
//		 medicine.setResizable(false);
//		 medicine.setLocationRelativeTo(null);
//	}
//	
//	public void gotopharmacy() {
//		Pharmacy pharmacy = new Pharmacy();
//		pharmacy.setVisible(true);
//		pharmacy.SearchAction4();
//		pharmacy.setResizable(false);
//		pharmacy.setLocationRelativeTo(null);
//	
//	}
	private JButton getBtnEvent() {
		if (btnEvent == null) {
			btnEvent = new JButton("");
			btnEvent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gotoEvent();
				}
			});
			btnEvent.setIcon(new ImageIcon("/Users/tuna/Desktop/Mstagram_ImageFile/mst2.png"));
			btnEvent.setBounds(243, 659, 72, 66);
		}
		return btnEvent;
	}
	
	public void gotoEvent(){
		Event event = new Event();
		event.setVisible(true);
		event.setResizable(false);
		event.setLocationRelativeTo(null);
		
	}
	
	
	
}//End___
