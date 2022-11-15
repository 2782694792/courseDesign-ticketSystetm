package �γ����;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class conductor extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
		//�˵���
		JMenuBar menubar;
		JMenu menu,submenu,settings,jfstyle;
		JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
		
		//��ǩ����
		private JPanel imagePanel;
	    private ImageIcon background;
	    
		//����Ա��¼ҳ��
		private JLabel jl,jl1,jl2,jl3;
		private JTextField csex;
		private JPasswordField cno,cname;
		
		//�ύ��������ҳ��������һҳ���˳�����ť,��հ�ť
		JButton crefresh,alogin,aback,ahome,aexit,creset,creset1,creset2,creset3;
		
		public conductor() {
	    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\��ƱԱ.png");             // ����ͼƬ
	    	JLabel label = new JLabel(background);       //�ѱ���ͼƬ��ʾ��һ����ǩ����
	        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
	       
	        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
	        imagePanel = (JPanel) this.getContentPane();
	        imagePanel.setOpaque(false);
	        this.getLayeredPane().setLayout(null);
	        
	        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
	        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	        this.setSize(background.getIconWidth(), background.getIconHeight());
	        
	    	this.setTitle("С���ĳ�վ��Ʊϵͳ");                //������������
	    	
			// ���ò��ַ�ʽΪ���Զ�λ
			this.setLayout(null);

			// ���ڴ�С�ı�
			this.setResizable(true);

			// ���������ʼ��
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
			// ���ò��ַ�ʽΪ���Զ�λ
			this.setLocationRelativeTo(null);
			
			// �ɼ�
			this.setVisible(true);
			
			//���ú���
			init();
			conductor1();
			
			/*     
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       //�������ڹرհ�ťʱִ�в���(���ص�ǰ���ڲ��ͷŴ���ռ�е�������Դ)
			*/
		} 
		void init() {
			//����
			menubar = new JMenuBar();
			//�˵�
			menu = new JMenu("�˵�");
			submenu = new JMenu("�˵���Ŀ");
			menu.add(submenu);
			submenu.add(sub1 = new JMenuItem("��վ��Ʊ����ϵͳ"));
			sub1.addActionListener(this);
			submenu.addSeparator();
			submenu.add(sub2 = new JMenuItem("���ݹ���ϵͳ"));
			sub2.addActionListener(this);
			//����
			settings = new JMenu("����");
			jfstyle = new JMenu("���");
			jfstyle.add(jfstyle1 = new JMenuItem("Windows ����"));
			jfstyle.addSeparator();
			jfstyle1.addActionListener(this);
			jfstyle.add(jfstyle2 = new JMenuItem("Unix ����"));
			jfstyle.addSeparator();
			jfstyle2.addActionListener(this);
			jfstyle.add(jfstyle3 = new JMenuItem("Java ����"));
			jfstyle3.addActionListener(this);
			settings.add(jfstyle);
			//���
			menubar.add(menu);
			menubar.add(settings);
			setJMenuBar(menubar);
		}
		void conductor1() {
			
			// ����һ������
			JFrame jf = this;
			Container con = jf.getContentPane();
			
			// ���������ǩ����
			jl = new JLabel();
		    jl.setBounds(0, 0, 576, 500);
			
			//���������
			jl1 = new JLabel("��  �ţ�");
			jl1.setBounds(100, 130, 70, 20);
			cno = new JPasswordField(10);
			cno.setBounds(200, 130, 165, 20);
			//������հ�ť
			creset1 = new JButton("���");
			creset1.setBounds(400, 130, 70, 20);
		    creset1.addActionListener(this);
			creset1.setForeground(Color.GREEN);
			
			//���������
			jl2 = new JLabel("��   ����");
			jl2.setBounds(100, 160, 70, 20);
			cname = new JPasswordField(20);
			cname.setBounds(200, 160, 165, 20);
			//������հ�ť
			creset2 = new JButton("���");
			creset2.setBounds(400, 160, 70, 20);
		    creset2.addActionListener(this);
			creset2.setForeground(Color.GREEN);
			
			//�Ա������
			jl3 = new JLabel("��   ��");
			jl3.setBounds(100, 190, 70, 20);
			csex = new JTextField(20);
			csex.setBounds(200, 190, 165, 20);
			//�Ա���հ�ť
			creset3 = new JButton("���");
			creset3.setBounds(400, 190, 70, 20);
		    creset3.addActionListener(this);
			creset3.setForeground(Color.GREEN);
			
			//ˢ�°�ť
			crefresh = new JButton("ˢ��");
			crefresh.setBounds(0, 100, 70, 25);
		    crefresh.addActionListener(this);
			
			//��¼��ť
			alogin = new JButton("��¼");
			alogin.setBounds(160, 280, 70, 25);
			alogin.addActionListener(this);
			
			//������һҳ��ť
			aback = new JButton("����");
			aback.setBounds(330, 280, 70, 25);
			aback.addActionListener(this);
			
			//��հ�ť
			creset = new JButton("���");
			creset.setBounds(245, 300, 70, 25);
		    creset.addActionListener(this);
			creset.setForeground(Color.GREEN);

			//������ҳ��ť
			ahome = new JButton("��ҳ");
			ahome.setBounds(160, 320, 70, 25);
			ahome.addActionListener(this);
			ahome.setForeground(Color.blue);
			
			//�˳�����ť
			aexit = new JButton("�˳�");
			aexit.setBounds(330, 320, 70, 25);
			aexit.addActionListener(this);
			aexit.setForeground(Color.red);
			
			jl.add(jl1);
			jl.add(jl2);
			jl.add(jl3);
			jl.add(crefresh);
			jl.add(alogin);
			jl.add(ahome);
			jl.add(aback);
			jl.add(aexit);
			jl.add(creset);
			jl.add(creset1);
			jl.add(creset2);
			jl.add(creset3);
			con.add(jl);
			con.add(cno);
			con.add(cname);
			con.add(csex);
		}
			
		    //��ť����󴥷��¼�
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == alogin) {
		            alogin.setBackground(Color.blue);      // ��ɫ��¼
		            if (cno.getText().equals("") == true && cname.getText().equals("") == true && csex.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.OK_OPTION);
					} else if (cno.getText().equals("") == false && cname.getText().equals("") == true && csex.getText().equals("") == false) {
						JOptionPane.showMessageDialog(null, "�������� ��������Ϊ�� ��������", "��������", JOptionPane.OK_OPTION);
					} else if (cno.getText().equals("") == true && cname.getText().equals("") == false && csex.getText().equals("") == false) {
						JOptionPane.showMessageDialog(null, "�������� ���Ų���Ϊ�� ��������", "��������", JOptionPane.OK_OPTION);
					} else if (cno.getText().equals("") == false && cname.getText().equals("") == false && csex.getText().equals("") == true) {
						JOptionPane.showMessageDialog(null, "�������� �Ա𲻿�Ϊ�� ��������", "��������", JOptionPane.OK_OPTION);
						csex.requestFocusInWindow();
					} else if (cno.getText().equals("") == false && cname.getText().equals("") == false && csex.getText().equals("") == false) {
						Statement sm = null;
		            	String RL = "jdbc:sqlserver://localhost:1433;";
			           	String sql = "use ֣˸��_sj"+"\n"+"select Cno from Conductor where Cname = "+"\'"+cname.getText()+"\'"+" and Csex = "+"\'"+csex.getText()+"\'"; 	//��ȡ���ݿ�����  
				        try{ 
				           	try {
								Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				           		}
				           	catch (ClassNotFoundException e1) {
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
								System.out.println("������������ʧ�ܣ�");
				           		}
				           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
				           	sm = con.createStatement();
				           	ResultSet rs = sm.executeQuery(sql);
	                    
				           	while(rs.next()) {
				           		if(rs.getString("Cno").equals(cno.getText())) {
				           			JOptionPane.showMessageDialog(null, "�������� ��¼�ɹ� ��������", "�������", JOptionPane.INFORMATION_MESSAGE);
				           			dispose();
				           			new cfunctionpage().setBounds(750,50,592,660);
				           			}
				           		else{
				           			JOptionPane.showMessageDialog(null, "�������� ��¼ʧ��,������� ��������", "�������", JOptionPane.WARNING_MESSAGE);
				           			cno.setText("");
				           			cname.setText("");
				           			csex.setText("");
				           			}
				           	}
				           	rs.close();
							sm.close();
				        	}
				        catch(SQLException err){
				        	err.printStackTrace(System.out);
							System.out.println("���ݿ�����ʧ�ܣ�");
				        	}
						
					} else {
						JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
						cno.setText("");
						cname.setText("");
						csex.setText("");
					}
		        } else if (e.getSource() == aexit) {
		            aexit.setBackground(Color.red);        // ��ɫ�˳�
		            System.exit(0);
		        }else if (e.getSource() == crefresh) {
		            dispose();
		            new conductor().setBounds(750,50,576,650);      // ˢ��
		        }else if (e.getSource() == ahome) {
		            ahome.setBackground(Color.green);      // ��ɫ��ҳ
		        	dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == aback) {
		            aback.setBackground(Color.yellow);     // ��ɫ����
		            dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == creset) {
		            creset.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ���
		            cno.setText("");
		            cname.setText("");
		            csex.setText("");
		        }else if (e.getSource() == creset1) {      // �������
		            cno.setText("");
		        }else if (e.getSource() == creset2) {      // �������
		            cname.setText("");
		        }else if (e.getSource() == creset3) {      // �Ա����
		            csex.setText("");
		        }
		        
		      //�˵����¼�
		        String look = "javax.swing.plaf.metal.MetalLookAndFeel";
				if (e.getSource() == jfstyle1) {
					look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";   // window���
				}else if(e.getSource()== jfstyle2) {
					look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";       // Linux���
				}else if(e.getSource()== jfstyle3) {
					look = "javax.swing.plaf.metal.MetalLookAndFeel";              // java���
				}else if(e.getSource()== sub1) {
					JOptionPane.showConfirmDialog(null, "������ϵͳѡ��ɹ�������", null, JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new homepage().setBounds(750,50,592,660);
				}else if (e.getSource()== sub2) {
					JOptionPane.showConfirmDialog(null, "��������ϵͳ�����ڣ�����", null, JOptionPane.OK_OPTION);
				}
				try{
					UIManager.setLookAndFeel(look);
				    SwingUtilities.updateComponentTreeUI(this);
				    }
				catch(Exception ex){
				    System.out.println("Exception:"+ex); 
				    }
		    }
}
