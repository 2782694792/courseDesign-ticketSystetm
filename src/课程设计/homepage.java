package �γ����;
import javax.swing.*;  //�ṩ�����

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
public class homepage extends JFrame implements ActionListener{
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
	JButton hpassenge,hconductor,hadministrator;
	
	//ˢ�¡��˳�����ť
	JButton home,hexit;
	
	public homepage() {
    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\���ȷ��.png");             // ����ͼƬ
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
		homepage1();
		
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
	void homepage1() {
		
		// ����һ������
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// ���������ǩ����
		jl = new JLabel();
	    jl.setBounds(0,0,576,650);
		
		//�˿Ͱ�ť
		hpassenge = new JButton("��      ��");
		hpassenge.setBounds(235, 150, 100, 50);
		hpassenge.addActionListener(this);
		
		//��ƱԱ��ť
		hconductor = new JButton("��ƱԱ");
		hconductor.setBounds(235, 230, 100, 50);
		hconductor.addActionListener(this);
		
		//����Ա��ť
		hadministrator = new JButton("����Ա");
		hadministrator.setBounds(235, 310, 100, 50);
		hadministrator.addActionListener(this);

		//ˢ�°�ť
		home = new JButton("ˢ��");
		home.setBounds(50, 100, 70, 30);
		home.addActionListener(this);
		home.setForeground(Color.blue);
		
		//�˳�����ť
		hexit = new JButton("�˳�");
		hexit.setBounds(450, 100, 70, 30);
		hexit.addActionListener(this);
		hexit.setForeground(Color.red);
		
		
		jl.add(hpassenge);
		jl.add(hconductor);
		jl.add(hadministrator);
		jl.add(home);
		jl.add(hexit);
		con.add(jl);
	}
	    //��ť����󴥷��¼�
		public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == home) {
	        	home.setBackground(Color.getHSBColor(209, 224, 239));             // ��ɫˢ��
	        	dispose();
	        	new homepage().setBounds(750,50,592,660);
	        } else if (e.getSource() == hexit) {
	            hexit.setBackground(Color.getHSBColor(237, 98, 98));              // ��ɫ�˳�
	            System.exit(0);
	        }else if (e.getSource() == hpassenge) {
	            hpassenge.setBackground(Color.green);       // ��ɫ�˿�
	            dispose();
	            new passenger().setBounds(750,50,592,660);
	        }else if (e.getSource() == hconductor) {
	            hconductor.setBackground(Color.yellow);     // ��ɫ��ƱԱ
	            dispose();
	            new conductor().setBounds(750,50,592,660);
	        }else if (e.getSource() == hadministrator) {
	            hadministrator.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ����Ա
	            dispose();
	            new administrator().setBounds(750,50,592,660);
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
