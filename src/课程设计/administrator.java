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

public class administrator extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	//�˵���
			JMenuBar menubar;
			JMenu menu,submenu,settings,jfstyle;
			JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
		
		//��ǩ����
		private JPanel imagePanel;
	    private ImageIcon background;
	    
		//����Ա��¼ҳ��
		private JLabel jl,jl1,jl2;
		private JTextField ano;
		private JPasswordField apd;
		
		//�ύ��������ҳ��������һҳ���˳�����ť,��հ�ť
		JButton arefresh,alogin,aback,ahome,aexit,areset,areset1,areset2;
		
		public administrator() {
	    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\����Ա.png");             // ����ͼƬ
	        JLabel label = new JLabel(background);       //�ѱ���ͼƬ��ʾ��һ����ǩ����
	        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
	       
	        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
	        imagePanel = (JPanel) this.getContentPane();
	        imagePanel.setOpaque(false);
	        this.getLayeredPane().setLayout(null);
	        
	        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
	        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	        this.setSize(background.getIconWidth(), background.getIconHeight());
	        
			// ���������ʼ��
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// ���ò��ַ�ʽΪ���Զ�λ
			this.setLayout(null);
			
			// ���ô���ı���ͼ��
			// Image image = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\С��.ico").getImage();
			// this.setIconImage(image);
			
			// ���ڴ�С�ı�
			this.setResizable(true);
			
			//   JLabel.setFont(new Font("΢���ź�", 0, 16));    //��������
			//   UIManager.put("Button.font", new java.awt.Font("����", 0, 12));
			 
			this.setTitle("С���ĳ�վ��Ʊϵͳ");               //������������
			
			// ������ʾ
			this.setLocationRelativeTo(null);
			
			// �ɼ�
			this.setVisible(true);
			
			//���ú���
			init();
			administrator1();
			
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
		void administrator1() {
			
			// ����һ������
			JFrame jf = this;
			Container con = jf.getContentPane();
			
			// ���������ǩ����
			jl = new JLabel();
		    jl.setBounds(0, 0, 576, 500);
			
			//�˺������
			jl1 = new JLabel("��  �ţ�");
			jl1.setBounds(100, 130, 70, 20);
			ano = new JTextField(20);
			ano.setBounds(200, 130, 165, 20);
			//�˺���հ�ť
			areset1 = new JButton("���");
			areset1.setBounds(400, 130, 70, 20);
		    areset1.addActionListener((ActionListener) this);
			areset1.setForeground(Color.GREEN);
			/*
			tno.addFocusListener(new FocusAdapter()
			{
			    @Override
				//��ȡ����ʱ�������ʾ����
			    public void focusGained(FocusEvent e){
			    		tno.setText("");
			    	}
			    @Override
				//ʧȥ����ʱ��û���������ݣ���ʾ��ʾ����
			    public void focusLost(FocusEvent e){
			    	tno.setText("�ο���Ʊ��������Ч������");
			    	}
			    });
			*/
			
			//���������
			jl2 = new JLabel("��   �룺");
			jl2.setBounds(100, 160, 70, 20);
			apd = new JPasswordField(20);
			apd.setBounds(200, 160, 165, 20);
			apd.setEchoChar('*');          // ���ǻ��Է���
			//������հ�ť
			areset2 = new JButton("���");
			areset2.setBounds(400, 160, 70, 20);
		    areset2.addActionListener(this);
			areset2.setForeground(Color.GREEN);
			
			/*
			// ���������˻����ַ�����Ҫ��ȡ�û���������ݣ�������Ӷ�������
			apd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					char ch[] = apd.getPassword();
					String str = new String(ch);
					System.out.println(str);
				}
			});
			*/

			//ˢ�°�ť
			arefresh = new JButton("ˢ��");
			arefresh.setBounds(0, 100, 70, 25);
		    arefresh.addActionListener(this);
			
			//��¼��ť
			alogin = new JButton("��¼");
			alogin.setBounds(160, 280, 70, 25);
			//��¼�ж��¼�
			alogin.addActionListener(this); 

				
			//������һҳ��ť
			aback = new JButton("����");
			aback.setBounds(330, 280, 70, 25);
			aback.addActionListener(this);
			
			//��հ�ť
			areset = new JButton("���");
			areset.setBounds(245, 300, 70, 25);
		    areset.addActionListener(this);
			areset.setForeground(Color.GREEN);

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
			jl.add(arefresh);
			jl.add(alogin);
			jl.add(ahome);
			jl.add(aback);
			jl.add(aexit);
			jl.add(areset);
			jl.add(areset1);
			jl.add(areset2);
			con.add(jl);
			con.add(ano);
			con.add(apd);
		}
			
		    //��ť����󴥷��¼�
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == alogin) {
		            alogin.setBackground(Color.blue);      // ��ɫ��¼
		            if (ano.getText().equals("") == true && apd.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
					} else if (ano.getText().equals("") == false && apd.getText().equals("") == true) {
						JOptionPane.showMessageDialog(null, "�������� ���벻��Ϊ�� ��������", "��������", JOptionPane.OK_OPTION);
					} else if (ano.getText().equals("") == true && apd.getText().equals("") == false) {
						JOptionPane.showMessageDialog(null, "�������� �˺Ų���Ϊ�� ��������", "��������", JOptionPane.OK_OPTION);
					} else if (ano.getText().equals("") == false && apd.getText().equals("") == false) {
						Statement sm = null;
		            	String RL = "jdbc:sqlserver://localhost:1433;";
			           	String sql = "use ֣˸��_sj"+"\n"+"select Apd from Administrator where Ano = "+"\'"+ano.getText()+"\';"; 	//��ȡ���ݿ�����  
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
				           		if(rs.getString("Apd").equals(apd.getText())) {
				           			JOptionPane.showMessageDialog(null, "�������� ��¼�ɹ� ��������", "�������", JOptionPane.INFORMATION_MESSAGE);
				           			dispose();
				           			new afunctionpage().setBounds(750,50,592,660);
				           			}
				           		else{
				           			JOptionPane.showMessageDialog(null, "�������� ��¼ʧ��,������� ��������", "�������", JOptionPane.WARNING_MESSAGE);
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
					}
		
		        } else if (e.getSource() == aexit) {
		            aexit.setBackground(Color.red);        // ��ɫ�˳�
		            System.exit(0);
		        }else if (e.getSource() == arefresh) {
		            dispose();
		            new administrator().setBounds(750,50,592,660);      // ˢ��
		        }else if (e.getSource() == ahome) {
		            ahome.setBackground(Color.green);      // ��ɫ��ҳ
		        	dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == aback) {
		            aback.setBackground(Color.yellow);     // ��ɫ����
		            dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == areset) {
		            areset.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ���
		            ano.setText("");
		            apd.setText("");
		        }else if (e.getSource() == areset1) {      // �˺����
		            ano.setText("");
		        }else if (e.getSource() == areset2) {      // �������
		            apd.setText("");
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
