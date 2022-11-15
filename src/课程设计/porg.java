package �γ����;
import javax.swing.*;  //�ṩ�����

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
public class porg extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//�˵���
	private JMenuBar menubar;
	private JMenu menu,submenu,settings,jfstyle;
	private JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//��ǩ����
	private JPanel imagePanel;
    private ImageIcon background;
    
	//��ҳѡ��ҳ��
    private JLabel jl;
	private JButton personalrorb,grouprorb;
	
	//��ҳ���˳����򡢷��ء�ˢ�°�ť
	private JButton pghome,pgexit,pgback,pgrefresh;
	
	public porg() {
    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\Ԥ��.png");             // ����ͼƬ
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
		porg1();
		
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
	void porg1() {
		
		// ����һ������
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// ���������ǩ����
		jl = new JLabel();
	    jl.setBounds(0, 0, 576, 500);
		
		//Ԥ����ť
	    personalrorb = new JButton("��    ��");
	    personalrorb.setBounds(235, 200, 100, 50);
	    personalrorb.addActionListener(this);
		
		//��ѯ��ť
	    grouprorb = new JButton("��    ��");
	    grouprorb.setBounds(235, 270, 100,50);
	    grouprorb.addActionListener(this);

		//��ҳ��ť
		pghome = new JButton("��ҳ");
		pghome.setBounds(50, 100, 70, 30);
		pghome.addActionListener(this);
		pghome.setForeground(Color.blue);
		
		//�˳�����ť
		pgexit = new JButton("�˳�");
		pgexit.setBounds(450, 100, 70, 30);
		pgexit.addActionListener(this);
		pgexit.setForeground(Color.red);
		
		//��ҳ��ť
		pgrefresh = new JButton("ˢ��");
		pgrefresh.setBounds(150, 350, 70, 30);
		pgrefresh.addActionListener(this);
				
		//�˳�����ť
		pgback = new JButton("����");
		pgback.setBounds(350, 350, 70, 30);
		pgback.addActionListener(this);
		
		jl.add(personalrorb);
		jl.add(grouprorb);
		jl.add(pghome);
		jl.add(pgexit);
		jl.add(pgback);
		jl.add(pgrefresh);
		con.add(jl);
	}
		
		/*
		 if (isSelected) {//���ѡ���������
			 background = Color.BLUE;//����ɫ����Ϊ��ɫ�������ɫ��
			 foreground = Color.WHITE;//ǰ��ɫ����Ϊ��ɫ��������ɫ��
			 // unselected, and not the DnD drop location
			 } else {
			 background = Color.WHITE;//����ɫ����Ϊ��ɫ
			 foreground = Color.BLACK;//ǰ��ɫ����Ϊ��ɫ
			 }
	    */
		
	    //��ť����󴥷��¼�
		public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == pghome) {
	        	pghome.setBackground(Color.getHSBColor(209, 224, 239));             // ��ɫ��ҳ
	        	dispose();
	        	new homepage().setBounds(750,50,592,660);
	        } else if (e.getSource() == pgexit) {
	        	pgexit.setBackground(Color.getHSBColor(237, 98, 98));              // ��ɫ�˳�
	            System.exit(0);
	        }else if (e.getSource() == personalrorb) {
	        	personalrorb.setBackground(Color.green);       // ��ɫ����
	            dispose();
	            new personal().setBounds(750,50,576,650);
	        }else if (e.getSource() == grouprorb) {
	        	grouprorb.setBackground(Color.yellow);      // ��ɫ�Ŷ�
	        	dispose();
	        	new group().setBounds(750,50,576,650);
	        	
	        	/*
		    	JDialog jd = new JDialog();
		    	jd.setBounds(800,250,250,100);
		    	jd.setTitle("�Ŷӳ˿���");
		        jd.getContentPane().setLayout(new GridLayout(2,2));
		    	jd.add(new JLabel("������������"));
		    	jdt = new JTextField(80);
		    	jd.add(jdt);
		        
		    	jds = new JButton("�ύ");
		    	jd.add(jds);
		    	jdb = new JButton("����");
		    	jd.add(jdb);
		    	jdb.addActionListener(this);
		    	
		    	jds.addActionListener(new ActionListener()//������
		    	{
					@Override
					public void actionPerformed(ActionEvent e) {
						int jdt_int = Integer.parseInt(jdt.getText());
						if(jdt_int > 1){
							// TODO �Զ����ɵķ������
							jd.dispose();
							group groupit = new group();
							groupit.setBounds(750,50,576,650);
							    
							groupit.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent e) {
									int it = 2;
									super.windowClosing(e);
							    	for(;;it ++) {
							    		new group().setBounds(750,50,576,650);
							    		}
							    	}
							    });
						}else if(jdt_int == 1){
							// TODO �Զ����ɵķ������

							jd.dispose();
							group groupit = new group();
							groupit.setBounds(750,50,576,650);
						}else {
							Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
							JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.NO_OPTION,0,null, options, null);
							jdt.setText("");
							}
						}
						
		    	});
		    	
		    	jdb.addActionListener(new ActionListener()//������
		    	{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						jd.dispose();
						new porg().setBounds(750,50,576,650);
					}
		    	});
		    	
		    	jd.setModal(true);              //ȷ�������Ĵ�������������ǰ��
		    	jd.setVisible(true);
		    	
					*/
            }else if (e.getSource() == pgrefresh) {
	        	pgrefresh.setBackground(Color.blue);     // ��ɫˢ��
	            dispose();
	        	new porg().setBounds(750,50,576,650);
	        }else if (e.getSource() == pgback) {
	        	pgback.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ����
	            dispose();
	        	new passenger().setBounds(750,50,576,650);
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
