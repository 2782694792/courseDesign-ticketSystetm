package �γ����;
import javax.swing.*;  //�ṩ�����

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
public class passenger extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//�˵���
	JMenuBar menubar;
	JMenu menu,submenu,settings,jfstyle;
	JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//��ǩ����
	private JPanel imagePanel;
    private ImageIcon background;
    
	//��ҳѡ��ҳ��
    private JLabel jl;
	JButton srorb,squery,srefund;
	
	//��ҳ���˳����򡢷��ء�ˢ�°�ť
	JButton shome,sexit,sback,srefresh;
	
	personal pe;
	homepage he;
	
	public passenger() {
    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\�˿�.png");             // ����ͼƬ
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
		select1();
		
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

	
	void select1() {
		
		// ����һ������
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// ���������ǩ����
		jl = new JLabel();
	    jl.setBounds(0, 0, 576, 500);
		
		//Ԥ����ť
		srorb = new JButton("Ԥ������");
		srorb.setBounds(235, 150, 100, 50);
		srorb.addActionListener(this);
		
		//��ѯ��ť
		squery = new JButton("��    ѯ");
		squery.setBounds(235, 220, 100,50);
		squery.addActionListener(this);
		
		//��Ʊ��ť
		srefund = new JButton("��    Ʊ");
		srefund.setBounds(235, 290, 100,50);
		srefund.addActionListener(this);

		//��ҳ��ť
		shome = new JButton("��ҳ");
		shome.setBounds(50, 100, 70, 30);
		shome.addActionListener(this);
		shome.setForeground(Color.blue);
		
		//�˳�����ť
		sexit = new JButton("�˳�");
		sexit.setBounds(450, 100, 70, 30);
		sexit.addActionListener(this);
		sexit.setForeground(Color.red);
		
		//��ҳ��ť
		srefresh = new JButton("ˢ��");
		srefresh.setBounds(150, 350, 70, 30);
		srefresh.addActionListener(this);
				
		//�˳�����ť
		sback = new JButton("����");
		sback.setBounds(350, 350, 70, 30);
		sback.addActionListener(this);
		
		jl.add(srorb);
		jl.add(squery);
		jl.add(srefund);
		jl.add(shome);
		jl.add(sexit);
		jl.add(sback);
		jl.add(srefresh);
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
			//��ť�¼�
	        if (e.getSource() == shome) {
	        	shome.setBackground(Color.getHSBColor(209, 224, 239));             // ��ɫ��ҳ
	        	dispose();
	        	new homepage().setBounds(750,50,592,660);
	        } else if (e.getSource() == sexit) {
	            sexit.setBackground(Color.getHSBColor(237, 98, 98));              // ��ɫ�˳�
	            System.exit(0);
	        }else if (e.getSource() == srorb) {
	            srorb.setBackground(Color.green);       // ��ɫԤ��
	            dispose();
	            new porg().setBounds(750,50,576,650);
	        }else if (e.getSource() == squery) {
	            squery.setBackground(Color.yellow);     // ��ɫ��ѯ
	            dispose();
	            new pquerypage().setBounds(750,50,576,650);
	        }else if (e.getSource() == srefund) {
	            srefund.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ��Ʊ
	            dispose();
	            new porgr().setBounds(750,50,576,650);
	        }else if (e.getSource() == srefresh) {
	            srefresh.setBackground(Color.blue);     // ��ɫˢ��
	            dispose();
	        	new passenger().setBounds(750,50,576,650);
	        }else if (e.getSource() == sback) {
	            sback.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ����
	            dispose();
	        	new homepage().setBounds(750,50,592,660);
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
				JOptionPane.showConfirmDialog(null, "������ϵͳѡ��ɹ�������", null, JOptionPane.OK_OPTION);
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
