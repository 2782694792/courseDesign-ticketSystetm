package �γ����;
import javax.swing.*;  //�ṩ�����

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimerTask;
import java.util.Timer;

public class zhengshuobin extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//�˵���
		JMenuBar menubar;
		JMenu menu,submenu,settings,jfstyle;
		JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//��ǩ����
	private JPanel imagePanel;
    private ImageIcon background;
    
	//��ҳ��
    private JLabel jl,jl1,jl2,sqljl1,sqljl2,sqljl3,sqljl4;
    private JTextField sno,sql1,sql2,sql3,sql4;
    private JPasswordField spd;
	JButton zsbreset,sreset1,sreset2,sqlback,sqlalogin,sqlenter,sqlback2;
	

    static JLabel jlre;
    //��¼��ˢ�¡��˳�����ť
	JButton zsbalogin,zsbexit,zsbrefresh;
	
	public zhengshuobin() {
    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\����.png");             // ����ͼƬ
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
		zhengshuobin1();
		
	} 
	void sqlcon(){
    	String RL = "jdbc:sqlserver://localhost:1433;";
        try{ 
           	try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           		}
           	catch (ClassNotFoundException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
				System.out.println("������������ʧ�ܣ�");
           		}
           	DriverManager.getConnection(RL,"sa","5436.......");
           	} 
        catch(SQLException err){
           		err.printStackTrace(System.out);
           		System.out.println("���ݿ�����ʧ�ܣ���");
           	}
        Object[] options ={"ȷ��"};          //�Զ��尴ť�ϵ�����
        int a = JOptionPane.showOptionDialog(null,
        		"�������� ���ݿ����ӳɹ� ��������", "�������",JOptionPane.YES_OPTION, 1, null, options, null); 
        if(a == JOptionPane.YES_OPTION) {
        	dispose();
        	new homepage().setBounds(750,50,576,650);
        }
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
		submenu.addSeparator();             //��ӷָ���
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
	void zhengshuobin1() {
		
		// ����һ������
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// ���������ǩ����
		jl = new JLabel();
	    jl.setBounds(0,0,576,350);
		
	    //ѧ������
	    jl1 = new JLabel("ѧ    ��:");
	    jl1.setBounds(100, 130, 70, 20);
	    sno = new JTextField(20);
	    sno.setBounds(200, 130, 165, 20);
		//ѧ����հ�ť
		sreset1 = new JButton("���");
		sreset1.setBounds(400, 130, 70, 20);
		sreset1.setForeground(Color.green);
		sreset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno.setText("");
			}
		});
		
		//��������
	    jl2 = new JLabel("��    ��:");
	    jl2.setBounds(100, 160, 70, 20);
	    spd = new JPasswordField(20);
	    spd.setBounds(200, 160, 165, 20);
		spd.setEchoChar('*');          // ���ǻ��Է���
		//������հ�ť
		sreset2 = new JButton("���");
		sreset2.setBounds(400, 160, 70, 20);
		sreset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spd.setText("");
			}
		});
		
		//��հ�ť
		zsbreset = new JButton("���");
		zsbreset.setBounds(338, 210, 100, 50);
		zsbreset.setForeground(Color.green);
		zsbreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno.setText("");
				spd.setText("");
			}
		});

		//ˢ�°�ť
		zsbrefresh = new JButton("ˢ��");
		zsbrefresh.setBounds(0, 80, 70, 30);
		zsbrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new zhengshuobin().setBounds(750,50,592,400);
			}
		});

		//ˢ�°�ť
		zsbalogin = new JButton("��¼");
		zsbalogin.setBounds(138, 210, 100, 50);
		zsbalogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(sno.getText().equals("") == true && spd.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "�������", JOptionPane.WARNING_MESSAGE);
				}else if(sno.getText().equals("") == false && spd.getText().equals("") == true){
					JOptionPane.showMessageDialog(null, "�������� ���벻��Ϊ�� ��������", "�������", JOptionPane.ERROR_MESSAGE);
	            	sno.requestFocusInWindow();
				}else if(sno.getText().equals("") == true && spd.getText().equals("") == false){
					JOptionPane.showMessageDialog(null, "�������� ѧ�Ų���Ϊ�� ��������", "�������", JOptionPane.ERROR_MESSAGE);
	            	spd.requestFocusInWindow();
				}else if(sno.getText().equals("201835010349") == true && spd.getText().equals("201835010349") == true){
					JOptionPane.showMessageDialog(null, "�������� ��¼�ɹ� ��������", "�������", JOptionPane.INFORMATION_MESSAGE);
           			JDialog jd = new JDialog();
           			jd.setBounds(520,180,360,360);
           			jd.setTitle("�������ݿ�����");
          			jd.getContentPane().setLayout(new GridLayout(5, 2));
           			sqljl1 = new JLabel("                     ����������");
           			sql1 = new JTextField(80);
           			sqljl2 = new JLabel("                     ���ݿ�����");
           			sql2 = new JTextField(80);
           			sqljl3 = new JLabel("                     ���ݿ��û���");
           			sql3 = new JTextField(80);
           			sqljl4 = new JLabel("                     ���ݿ����룺");
           			sql4 = new JPasswordField(80);
           			sqlalogin = new JButton("��¼");
           			sqlalogin.addActionListener(new ActionListener() {
           				public void actionPerformed(ActionEvent e2) {
           					if(sql1.getText().equals("") == true && sql2.getText().equals("") == true && sql3.getText().equals("") == true && sql4.getText().equals("") == true) {
           						JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "�������", JOptionPane.WARNING_MESSAGE);
           					}else if(sql1.getText().equals(".") == true && sql2.getText().equals("֣˸��_sj") == true && sql3.getText().equals("sa") == true && sql4.getText().equals("5436.......") == true){
           						Timer timer = new Timer();
           						JDialog jd2 = new JDialog();
	           	           		jd2.setBounds(520,180,360,360);
	           	           		jd2.setTitle("�������� ��¼�ɹ� ��������");
           						sqlenter = new JButton("�������ݿ�����");
           						sqlenter.addActionListener(new ActionListener() {
           	           				public void actionPerformed(ActionEvent e2) {
           	           					jd2.dispose(); 
           	           					jd.dispose();
           	           					dispose();
           	           					sqlcon();
           	           				}
           	           			});
           						sqlback2 = new JButton("����");
           						sqlback2.addActionListener(new ActionListener() {
           	           				public void actionPerformed(ActionEvent e2) {
           	           					jd2.setVisible(false);
           	           				}
           	           			});
           						//��������
           						sqlenter.setFont(new java.awt.Font("��Բ", 1, 22));
           						sqlback2.setFont(new java.awt.Font("��Բ", 1, 22));
           						//��dialog���������壬1������ʽ(1�Ǵ��壬0��ƽ���ģ�15���ֺ�
	           	         		jd2.getContentPane().setLayout(new GridLayout(2,2));
           						if (true) {
           							timer.schedule(new TimerTask() {
           								public void run() {
           								}
           							},200);
           						}
	           	          		jd2.add(sqlenter);
	           	          		jd2.add(sqlback2);
	           	           		jd2.setModal(true);//ȷ�������Ĵ�������������ǰ��
	           	           		jd2.setVisible(true);
           					}else {
           						JOptionPane.showMessageDialog(null, "�������� ��¼ʧ�ܣ����������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
           		            	sql1.requestFocusInWindow();
           					}
           				}
           			});
           			sqlback = new JButton("����");
           			sqlback.addActionListener(new ActionListener() {
           				public void actionPerformed(ActionEvent e2) {
           					jd.dispose();
           				}
           			});
           			jd.add(sqljl1);
           			jd.add(sql1);
           			jd.add(sqljl2);
           			jd.add(sql2);
           			jd.add(sqljl3);
           			jd.add(sql3);
           			jd.add(sqljl4);
           			jd.add(sql4);
           			jd.add(sqlalogin);
           			jd.add(sqlback);
           			jd.setModal(true);//ȷ�������Ĵ�������������ǰ��
           			jd.setVisible(true);
				}else if(sno.getText().equals("201835010349") == false && spd.getText().equals("201835010349") == true){
					JOptionPane.showMessageDialog(null, "�������� ѧ�Ŵ��� ��������", "�������", JOptionPane.ERROR_MESSAGE);
	            	sno.requestFocusInWindow();
           			sno.setText("");
				}else if(sno.getText().equals("201835010349") == true && spd.getText().equals("201835010349") == true){
					JOptionPane.showMessageDialog(null, "�������� ������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
	            	spd.requestFocusInWindow();
           			spd.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "�������� ���벻��ȷ������������ ��������", "�������", JOptionPane.ERROR_MESSAGE);
	            	sno.requestFocusInWindow();
           			spd.setText("");
           			sno.setText("");
				}
			}
		});
		
		//�˳�����ť
		zsbexit = new JButton("�˳�");
		zsbexit.setBounds(506, 80, 70, 30);
		zsbexit.setForeground(Color.red);
		zsbexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	zsbexit.setBackground(Color.red);              // ��ɫ�˳�
		        System.exit(0);
			}
		});
		
		jl.add(jl1);
		jl.add(jl2);
		jl.add(sno);
		jl.add(spd);
		jl.add(zsbalogin);
		jl.add(zsbreset);
		jl.add(sreset1);
		jl.add(sreset2);
		jl.add(zsbrefresh);
		jl.add(zsbexit);
		con.add(jl);
	}
	    //��ť����󴥷��¼�
		public void actionPerformed(ActionEvent e) {
	        //�˵����¼�
	        String look = "javax.swing.plaf.metal.MetalLookAndFeel";
			if (e.getSource() == jfstyle1) {
				look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";   // window���
			}else if(e.getSource()== jfstyle2) {
				look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";       // Linux���
			}else if(e.getSource()== jfstyle3) {
				look = "javax.swing.plaf.metal.MetalLookAndFeel";              // java���
			}else if(e.getSource()== sub1) {
				JOptionPane.showConfirmDialog(null, "������ϵͳѡ��ɹ�������", null, JOptionPane.OK_OPTION);
				dispose();
				new zhengshuobin().setBounds(750,50,592,660);
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
