package �γ����;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class cchpage extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
		//�˵���
		JMenuBar menubar;
		JMenu menu,submenu,settings,jfstyle;
		JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
		
		//��ǩ����
		private JPanel imagePanel;
	    private ImageIcon background;
	    
		//��ҳ���
		JLabel jl;
		JFrame jf;
		Container con;
		JComboBox<String> ccp;
		String[] ccp0 = new String[]{"������Coach��","վ�㣨City��","����ʱ�䣨Ctime��","��Ʊ��Ticket��","�˿ͣ�Passenger��","��Ʊ��Refund��","��������  ��ѡ��  ��������"};
		JButton ccrefresh,cchome,ccback,ccexit;
		
		//����
		JLabel jl0,jl01,jl02,jl03,jl011,jl022,jl033;
		JButton coacreate,coareset,coareset1,coareset2,coareset3;
		JTextField coacno,coaseat,coaholder,coacno1,coaseat1,coaholder1;

		//վ��
		JLabel jl1,jl11,jl12,jl13,jl14,jl15,jl111,jl112,jl113,jl114,jl115;
		JButton citcreate,citreset,citreset1,citreset2,citreset3,citreset4,citreset5;
		JTextField citcname,citcno,citmileage,citstart,cittarget,citcname1,citcno1,citmileage1,citstart1,cittarget1;
		
		//����ʱ��
		JLabel jl2,jl21,jl22,jl23,jl221,jl222,jl223;
		JButton timcreate,timreset,timreset1,timreset2,timreset3;
		JTextField timtime,timcname,timcno,timtime1,timcname1,timcno1;
		
		//��Ʊ
		JLabel jl3,jl31,jl32,jl33,jl34,jl35,jl36,jl331,jl332,jl333,jl334,jl335,jl336;
		JButton ticcreate,ticreset,ticreset1,ticreset2,ticreset3,ticreset4,ticreset5,ticreset6;
		JTextField tictno,ticcname,ticcno,tictime,ticprice,ticlast,tictno1,ticcname1,ticcno1,tictime1,ticprice1,ticlast1;

		//�˿�
		JLabel jl4,jl41,jl42,jl43,jl44,jl45,jl46,jl441,jl442,jl443,jl444,jl445,jl446;
		JButton pascreate,pasreset,pasreset1,pasreset2,pasreset3,pasreset4,pasreset6;
		JTextField pastno,pasname,pasid,pasnum,passeat,pastno1,pasname1,pasid1,pasnum1,passeat1;
		JComboBox<String> pasrorb,pasrorb1;
		String[] rorb = new String[]{"Ԥ��","����"};

		//��Ʊ
		JLabel jl5,jl51,jl52,jl53,jl54,jl55,jl56,jl551,jl552,jl553,jl554,jl555,jl556;
		JButton refcreate,refreset,refreset1,refreset2,refreset3,refreset4,refreset5,refreset6;
		JTextField reftno,refname,refid,refnum,reftprice,refdate,reftno1,refname1,refid1,refnum1,reftprice1,refdate1;
		
		public cchpage() {
	    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\��ƱԱ�޸�����.png");             // ����ͼƬ
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
			
			// ���ڴ�С�ı�
			this.setResizable(true);
			 
			this.setTitle("С���ĳ�վ��Ʊϵͳ");               //������������
			
			// ������ʾ
			this.setLocationRelativeTo(null);
			
			// �ɼ�
			this.setVisible(true);

			// ����һ������
			jf = this;
			con = jf.getContentPane();
			
			//���ú���
			init();
			cchpage1();

			coach0();
			jl0.setVisible(false);
			city0();
			jl1.setVisible(false);
			time0();
			jl2.setVisible(false);
			ticket0();
			jl3.setVisible(false);
			passenger0();
			jl4.setVisible(false);
			refund0();
			jl5.setVisible(false);
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
		void cchpage1() {
			
			//���������б��
			ccp = new JComboBox<String>(ccp0);
			
		    //�����б����ѡ�����
			jl = new JLabel();
			jl.setBounds(0, 0, 576, 500);

			ccp.setBounds(188, 68, 200, 30);
			ccp.setMaximumRowCount(4);
			ccp.setSelectedItem(ccp0[6]);
		    ccp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ccp.getSelectedItem() == ccp0[0]) {
						jl0.setVisible(true);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl4.setVisible(false);
						jl5.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[1]){
						jl0.setVisible(false);
						jl1.setVisible(true);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl4.setVisible(false);
						jl5.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[2]){
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(true);
						jl3.setVisible(false);
						jl4.setVisible(false);
						jl5.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[3]){
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(true);
						jl4.setVisible(false);
						jl5.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[4]){
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl4.setVisible(true);
						jl5.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[5]){
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl4.setVisible(false);
						jl5.setVisible(true);
						}
					else{
						ccp.removeItemAt(6);
						}
				}
				
			});

			//ˢ�°�ť
			ccrefresh = new JButton("ˢ��");
			ccrefresh.setBounds(94, 68, 85, 30);
		    ccrefresh.addActionListener(this);

			//������һҳ��ť
		    ccback = new JButton("����");
		    ccback.setBounds(397, 68, 85, 30);
		    ccback.addActionListener(this);
			

			//������ҳ��ť
			cchome = new JButton("��ҳ");
			cchome.setBounds(0, 68, 85, 30);
			cchome.addActionListener(this);
			cchome.setForeground(Color.blue);
			
			//�˳�����ť
			ccexit = new JButton("�˳�");
			ccexit.setBounds(491, 68, 85, 30);
			ccexit.addActionListener(this);
			ccexit.setForeground(Color.red);

			jl.add(cchome);
		    jl.add(ccrefresh);
			jl.add(ccback);
			jl.add(ccexit);
		    jl.add(ccp);
		    con.add(jl);
		}
		
		//�������
		void coach0() {
			jl0 = new JLabel();
			jl0.setBounds(0, 0, 576, 500);
		    
			//���������
			jl01 = new JLabel("��       �Σ�");
			jl01.setBounds(20, 160, 70, 20);
			coacno = new JTextField(10);
			coacno.setBounds(90, 160, 150, 20);
			//�����޸Ŀ�
			jl011 = new JLabel("��  Ϊ��");
			jl011.setBounds(265, 160, 70, 20);
			coacno1 = new JTextField(10);
			coacno1.setBounds(325, 160, 150, 20);
			//������հ�ť
			coareset1 = new JButton("���");
			coareset1.setBounds(486, 160, 70, 20);
			coareset1.setForeground(Color.GREEN);
		    coareset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // �������
		        	coacno.setText("");
		        	coacno1.setText("");
				}
			});
			
			//��λ�������
			jl02 = new JLabel("�� λ ����");
			jl02.setBounds(20, 190, 70, 20);
			coaseat = new JTextField(10);
			coaseat.setBounds(90, 190, 150, 20);
			//��λ���޸Ŀ�
			jl022 = new JLabel("��  Ϊ��");
			jl022.setBounds(265, 190, 70, 20);
			coaseat1 = new JTextField(10);
			coaseat1.setBounds(325, 190, 150, 20);
			//��λ����հ�ť
			coareset2 = new JButton("���");
			coareset2.setBounds(486, 190, 70, 20);
			coareset2.setForeground(Color.GREEN);
		    coareset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // ��λ�����
		        	coaseat.setText("");
		        	coaseat1.setText("");
				}
			});

			//�����������
			jl03 = new JLabel("�� �� �ˣ�");
			jl03.setBounds(20, 220, 70, 20);
			coaholder = new JTextField(10);
			coaholder.setBounds(90, 220, 150, 20);
			//�������޸Ŀ�
			jl033 = new JLabel("��  Ϊ��");
			jl033.setBounds(265, 220, 70, 20);
			coaholder1 = new JTextField(10);
			coaholder1.setBounds(325, 220, 150, 20);
			//��հ�ť
			coareset3 = new JButton("���");
			coareset3.setBounds(486, 220, 70, 20);
			coareset3.setForeground(Color.GREEN);
		    coareset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // ���������
		        	coaholder.setText("");
		        	coaholder1.setText("");
				}
			});
			
			//��Ӱ�ť
			coacreate = new JButton("�޸�");
			coacreate.setBounds(168, 280, 70, 30);
			//��¼�ж��¼�
			coacreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
					coacreate.setBackground(Color.blue);     // ��ɫ���
		            coach1();
				}
			});
			
			//��հ�ť
			coareset = new JButton("���");
			coareset.setBounds(338, 280, 70, 30);
			coareset.setForeground(Color.GREEN);
		    coareset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
		            coareset.setBackground(Color.black);     // ��ɫ���
		            coacno.setText("");
		            coaseat.setText("");
		            coaholder.setText("");
		            coacno1.setText("");
		            coaseat1.setText("");
		            coaholder1.setText("");
				}
			});

			jl0.add(jl01);
			jl0.add(jl02);
			jl0.add(jl03);
			jl0.add(coacno);
			jl0.add(coaseat);
			jl0.add(coaholder);
			jl0.add(jl011);
			jl0.add(jl022);
			jl0.add(jl033);
			jl0.add(coacno1);
			jl0.add(coaseat1);
			jl0.add(coaholder1);
			jl0.add(coareset);
			jl0.add(coareset1);
			jl0.add(coareset2);
			jl0.add(coareset3);
			jl0.add(coacreate);
			con.add(jl0);
			
		}		
		void coach1() {
			coacreate.setBackground(Color.blue);      // ��ɫ�ύ
            if (coacno.getText().equals("") == true && coaseat.getText().equals("") == true && coaholder.getText().equals("") == true && coacno1.getText().equals("") == true && coaseat1.getText().equals("") == true && coaholder1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
			} else if (coacno.getText().equals("") == false && coaseat.getText().equals("") == false && coaholder.getText().equals("") == true && coacno1.getText().equals("") == false && coaseat1.getText().equals("") == false && coaholder1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "�������� �����˲���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				coaholder.requestFocusInWindow();
			} else if (coacno.getText().equals("") == false && coaseat.getText().equals("") == true && coaholder.getText().equals("") == false  && coacno1.getText().equals("") == false && coaseat1.getText().equals("") == true && coaholder1.getText().equals("") ==  false) {
				JOptionPane.showMessageDialog(null, "�������� ��λ������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				coaseat.requestFocusInWindow();
			}  else if (coacno.getText().equals("") == true && coaseat.getText().equals("") == false && coaholder.getText().equals("") == false  && coacno1.getText().equals("") == true && coaseat1.getText().equals("") == false && coaholder1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� ���β���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				coacno.requestFocusInWindow();
			} else if (coacno.getText().equals("") == false && coaseat.getText().equals("") == false && coaholder.getText().equals("") == false && coacno1.getText().equals("") == false && coaseat1.getText().equals("") == false && coaholder1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int coa2 = sm.executeUpdate("use ֣˸��_sj"+"\n"
							+"update Coach set "
							+"Ccno = \'"+coacno1.getText()+"\',"
							+"Cseat = \'"+coaseat1.getText()+"\',"
							+"Cholder = \'"+coaholder1.getText()+"\'"+"\n"
							+"where "
							+"Ccno = \'"+coacno.getText()+"\' and "
							+"Cseat = \'"+coaseat.getText()+"\' and "
							+"Cholder = \'"+coaholder.getText()+"\';"); 	
	           	if(coa2 == 1){
               	 Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
               	 JOptionPane.showOptionDialog(null,
               			 "�������� "+ccp.getSelectedItem()+"�޸ĳɹ� ��������" +"\n\n\t���Σ�"+coacno1.getText()+"\n\t��λ����"+coaseat1.getText()+"\n\t�����ˣ�"+coaholder1.getText(),
               			 "�������",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
               	 	JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
                	}
	           	coacno.setText("");
			   	coaseat.setText("");
			 	coaholder.setText("");
	           	coacno1.setText("");
			   	coaseat1.setText("");
			 	coaholder1.setText("");
				sm.close();
	        		}
	        catch(SQLException err){
	        	err.printStackTrace(System.out);
				System.out.println("���ݿ�����ʧ�ܣ�____Coach��");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//վ�����
		void city0() {
			jl1 = new JLabel();
			jl1.setBounds(0, 0, 576, 500);
		    
			//վ�������
			jl11 = new JLabel("վ        ����");
			jl11.setBounds(20, 160, 70, 20);
			citcname = new JTextField(10);
			citcname.setBounds(90, 160, 150, 20);
			//վ���޸Ŀ�
			jl111 = new JLabel("��  Ϊ��");
			jl111.setBounds(265, 160, 70, 20);
			citcname1 = new JTextField(10);
			citcname1.setBounds(325, 160, 150, 20);
			//վ����հ�ť
			citreset1 = new JButton("���");
			citreset1.setBounds(486,160, 70, 20);
			citreset1.setForeground(Color.GREEN);
		    citreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // վ�����
		        	citcname.setText("");
		        	citcname1.setText("");
				}
			});
			
			//���������
			jl12 = new JLabel("��        �Σ�");
			jl12.setBounds(20, 190, 70, 20);
			citcno = new JTextField(10);
			citcno.setBounds(90, 190, 150, 20);
			//�����޸Ŀ�
			jl112 = new JLabel("��  Ϊ��");
			jl112.setBounds(265, 190, 70, 20);
			citcno1 = new JTextField(10);
			citcno1.setBounds(325, 190, 150, 20);
			//������հ�ť
			citreset2 = new JButton("���");
			citreset2.setBounds(486,190, 70, 20);
			citreset2.setForeground(Color.GREEN);
		    citreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
		        	citcno.setText("");
		        	citcno1.setText("");
				}
			});

			//��������
			jl13 = new JLabel("��        �̣�");
			jl13.setBounds(20, 220, 70, 20);
			citmileage = new JTextField(10);
			citmileage.setBounds(90, 220, 150, 20);
			//����޸Ŀ�
			jl113 = new JLabel("��  Ϊ��");
			jl113.setBounds(265, 220, 70, 20);
			citmileage1 = new JTextField(10);
			citmileage1.setBounds(325, 220, 150, 20);
			//�����հ�ť
			citreset3 = new JButton("���");
			citreset3.setBounds(486,220, 70, 20);
			citreset3.setForeground(Color.GREEN);
		    citreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
		        	citmileage.setText("");
		        	citmileage1.setText("");
				}
			});

			//��ʼ�ص������
			jl14 = new JLabel("��ʼ�ص㣺");
			jl14.setBounds(20, 250, 70, 20);
			citstart = new JTextField(10);
			citstart.setBounds(90, 250, 150, 20);
			//�޸Ŀ�
			jl114 = new JLabel("��  Ϊ��");
			jl114.setBounds(265, 250, 70, 20);
			citstart1 = new JTextField(10);
			citstart1.setBounds(325, 250, 150, 20);
			//��ʼ�ص���հ�ť
			citreset4 = new JButton("���");
			citreset4.setBounds(486,250, 70, 20);
			citreset4.setForeground(Color.GREEN);
		    citreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
		        	citstart.setText("");
		        	citstart1.setText("");
				}
			});
			
			//Ŀ��ص������
			jl15 = new JLabel("Ŀ��ص㣺");
			jl15.setBounds(20, 280, 70, 20);
			cittarget = new JTextField(10);
			cittarget.setBounds(90, 280, 150, 20);
			//�޸Ŀ�
			jl115 = new JLabel("��  Ϊ��");
			jl115.setBounds(265, 280, 70, 20);
			cittarget1 = new JTextField(10);
			cittarget1.setBounds(325, 280, 150, 20);
			
			
			//Ŀ��ص���հ�ť
			citreset5 = new JButton("���");
			citreset5.setBounds(486,280, 70, 20);
			citreset5.setForeground(Color.GREEN);
		    citreset5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
		        	cittarget.setText("");
		        	cittarget1.setText("");
				}
			});
			
			//��Ӱ�ť
			citcreate = new JButton("�޸�");
			citcreate.setBounds(168, 340, 70, 30);
			//��¼�ж��¼�
			citcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					citcreate.setBackground(Color.blue);      // ��ɫ�ύ
		        	city1();
				}
			});
			
			//��հ�ť
			citreset = new JButton("���");
			citreset.setBounds(338, 340, 70, 30);
			citreset.setForeground(Color.GREEN);
		    citreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // ���
					citreset.setBackground(Color.black);      // ��ɫ�ύ
		        	citcno.setText("");
		        	citcname.setText("");
		        	citmileage.setText("");
		        	citstart.setText("");
		        	cittarget.setText("");
		        	citcno1.setText("");
		        	citcname1.setText("");
		        	citmileage1.setText("");
		        	citstart1.setText("");
		        	cittarget1.setText("");
				}
			});

			jl1.add(jl11);
			jl1.add(jl12);
			jl1.add(jl13);
			jl1.add(jl14);
			jl1.add(jl15);
			jl1.add(citcreate);
			jl1.add(citreset);
			jl1.add(citreset1);
			jl1.add(citreset2);
			jl1.add(citreset3);
			jl1.add(citreset4);
			jl1.add(citreset5);
			jl1.add(citcname);
			jl1.add(citcno);
			jl1.add(citmileage);
			jl1.add(citstart);
			jl1.add(cittarget);

			jl1.add(jl111);
			jl1.add(jl112);
			jl1.add(jl113);
			jl1.add(jl114);
			jl1.add(jl115);
			jl1.add(citcname1);
			jl1.add(citcno1);
			jl1.add(citmileage1);
			jl1.add(citstart1);
			jl1.add(cittarget1);
			con.add(jl1);
		}
		void city1() {
			citcreate.setBackground(Color.blue);      // ��ɫ�ύ
            if (citcno.getText().equals("") == true && citcname.getText().equals("") == true && citmileage.getText().equals("") == true && citstart.getText().equals("") == true && cittarget.getText().equals("") == true && citcno1.getText().equals("") == true && citcname1.getText().equals("") == true && citmileage1.getText().equals("") == true && citstart1.getText().equals("") == true && cittarget1.getText().equals("") == true) {
            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == true && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "�������� Ŀ��ص㲻��Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				cittarget.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == true && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == true && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� ��ʼ�ص㲻��Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				citstart.requestFocusInWindow();
			}  else if (citcno.getText().equals("") == true && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == true && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� ���β���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				citcno.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == true && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == true && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� ��̲���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				citmileage.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == true && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == true && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� վ������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				citcname.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int cit2 = sm.executeUpdate("use ֣˸��_sj"+"\n"
	           								+"update City set "
	           								+"Cityname = \'"+citcname1.getText()+"\',"
	           								+"Ccno = \'"+citcno1.getText()+"\',"
	           								+"Cmileage = \'"+citmileage1.getText()+"\',"
	           								+"Cstart = \'"+citstart1.getText()+"\',"
	           								+"Ctarget = \'"+cittarget1.getText()+"\'"+"\n"
	           								+"where "
	           								+"Cityname = \'"+citcname.getText()+"\' and "
	           								+"Ccno = \'"+citcno.getText()+"\' and "
	           								+"Cmileage = \'"+citmileage.getText()+"\' and "
	           								+"Cstart = \'"+citstart.getText()+"\' and "
	           								+"Ctarget = \'"+cittarget.getText()+"\';"); 	
	           	if(cit2 == 1){
               	 Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
               	 JOptionPane.showOptionDialog(null,
               			 "�������� "+ccp.getSelectedItem()+"�޸ĳɹ� ��������" +"\n\n\tվ����"+citcname1.getText()+"\n\t���Σ�"+citcno1.getText()+"\n\t��̣�"+citmileage.getText()+"\n\t��ʼ�ص㣺"+citstart1.getText()+"\n\tĿ��ص㣺"+cittarget1.getText(),
               			 "�������",JOptionPane.YES_OPTION, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
               	 	JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
                	}
	           	citcname.setText("");
	          	citcno.setText("");
	          	citmileage.setText("");
	         	citstart.setText("");
	          	cittarget.setText("");
	           	citcname1.setText("");
	          	citcno1.setText("");
	          	citmileage1.setText("");
	         	citstart1.setText("");
	          	cittarget1.setText("");
				sm.close();
	        		}
	        catch(SQLException err){
	        	err.printStackTrace(System.out);
				System.out.println("���ݿ�����ʧ�ܣ�____City��");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
		}
		}

		//����ʱ�����
		void time0() {
			jl2 = new JLabel();
			jl2.setBounds(0, 0, 576, 500);
		    
			//���������
			jl21 = new JLabel("����ʱ�䣺");
			jl21.setBounds(20, 220, 70, 20);
			timtime = new JTextField(10);
			timtime.setBounds(90, 220, 150, 20);
			//�޸Ŀ�
			jl221 = new JLabel("��  Ϊ��");
			jl221.setBounds(265, 220, 70, 20);
			timtime1 = new JTextField(10);
			timtime1.setBounds(325, 220, 150, 20);
			//��հ�ť
			timreset1 = new JButton("���");
			timreset1.setBounds(486, 220, 70, 20);
			timreset1.setForeground(Color.GREEN);
			timreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // �������
					timtime.setText("");
					timtime1.setText("");
				}
			});
			
			//վ�������
			jl22 = new JLabel("վ        ����");
			jl22.setBounds(20, 160, 70, 20);
			timcname = new JTextField(10);
			timcname.setBounds(90, 160, 150, 20);
			//�޸Ŀ�
			jl222 = new JLabel("��  Ϊ��");
			jl222.setBounds(265, 160, 70, 20);
			timcname1 = new JTextField(10);
			timcname1.setBounds(325, 160, 150, 20);
			//��հ�ť
			timreset2 = new JButton("���");
			timreset2.setBounds(486, 160, 70, 20);
			timreset2.setForeground(Color.GREEN);
			timreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // ��λ�����
					timcname.setText("");
					timcname1.setText("");
				}
			});

			//���������
			jl23 = new JLabel("��        �Σ�");
			jl23.setBounds(20, 190, 70, 20);
			timcno = new JTextField(10);
			timcno.setBounds(90, 190, 150, 20);
			//�޸Ŀ�
			jl223 = new JLabel("��  Ϊ��");
			jl223.setBounds(265, 190, 70, 20);
			timcno1 = new JTextField(10);
			timcno1.setBounds(325, 190, 150, 20);
			//��հ�ť
			timreset3 = new JButton("���");
			timreset3.setBounds(486, 190, 70, 20);
			timreset3.setForeground(Color.GREEN);
			timreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // ���������
					timcno.setText("");
					timcno1.setText("");
				}
			});
			
			//��Ӱ�ť
			timcreate = new JButton("�޸�");
			timcreate.setBounds(168, 280, 70, 30);
			//��¼�ж��¼�
			timcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
					ticcreate.setBackground(Color.blue);     // ��ɫ���
		            time1();
				}
			});
			
			//��հ�ť
			timreset = new JButton("���");
			timreset.setBounds(338, 280, 70, 30);
			timreset.setForeground(Color.GREEN);
			timreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
					timreset.setBackground(Color.black);     // ��ɫ���
					timcno.setText("");
					timcname.setText("");
					timtime.setText("");
					timcno1.setText("");
					timcname1.setText("");
					timtime1.setText("");
				}
			});

			jl2.add(jl21);
			jl2.add(jl22);
			jl2.add(jl23);
			jl2.add(timtime);
			jl2.add(timcname);
			jl2.add(timcno);
			jl2.add(timcreate);
			jl2.add(timreset);
			jl2.add(timreset1);
			jl2.add(timreset2);
			jl2.add(timreset3);

			jl2.add(jl221);
			jl2.add(jl222);
			jl2.add(jl223);
			jl2.add(timtime1);
			jl2.add(timcname1);
			jl2.add(timcno1);
			con.add(jl2);
			
		}		
		void time1() {
			timcreate.setBackground(Color.blue);      // ��ɫ�ύ
            if (timcno.getText().equals("") == true && timcname.getText().equals("") == true && timtime.getText().equals("") == true && timcno1.getText().equals("") == true && timcname1.getText().equals("") == true && timtime1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
			} else if (timcno.getText().equals("") == false && timcname.getText().equals("") == false && timtime.getText().equals("") == true && timcno1.getText().equals("") == false && timcname1.getText().equals("") == false && timtime1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "�������� ����ʱ�䲻��Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				timtime.requestFocusInWindow();
			} else if (timcno.getText().equals("") == false && timcname.getText().equals("") == true && timtime.getText().equals("") == false && timcno1.getText().equals("") == false && timcname1.getText().equals("") == true && timtime1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� վ������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				timcname.requestFocusInWindow();
			}  else if (timcno.getText().equals("") == true && timcname.getText().equals("") == false && timtime.getText().equals("") == false && timcno1.getText().equals("") == true && timcname1.getText().equals("") == false && timtime1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� ���β���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				timcno.requestFocusInWindow();
			} else if (timcno.getText().equals("") == false && timcname.getText().equals("") == false && timtime.getText().equals("") == false && timcno1.getText().equals("") == false && timcname1.getText().equals("") == false && timtime1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tim2 = sm.executeUpdate("use ֣˸��_sj"+"\n"
						+"update CTime set "
						+"Ccno = \'"+timcno1.getText()+"\',"
						+"Cityname = \'"+timcname1.getText()+"\',"
						+"Ttime = \'"+timtime1.getText()+"\'"+"\n"
						+"where "
						+"Ccno = \'"+timcno.getText()+"\' and "
						+"Cityname = \'"+timcname.getText()+"\' and "
						+"Ttime = \'"+timtime.getText()+"\';"); 	
	           	if(tim2 == 1){
	           		Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
	           		JOptionPane.showOptionDialog(null,
               			 "�������� "+ccp.getSelectedItem()+"�޸ĳɹ� ��������" +"\n\n\tվ����"+timcname1.getText()+"\n\t���Σ�"+timcno1.getText()+"\n\t����ʱ�䣺"+timtime1.getText(),
               			 "�������",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
	           		}
                else{
               	 	Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
               	 	JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.ERROR_MESSAGE,0,null, options, null);
                	}
              	timcno.setText("");
               	timcname.setText("");
               	timtime.setText("");
              	timcno1.setText("");
               	timcname1.setText("");
               	timtime1.setText("");
				sm.close();
	        		}
	        catch(SQLException err){
	        	err.printStackTrace(System.out);
				System.out.println("���ݿ�����ʧ�ܣ�____CTime��");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//��Ʊ���
		void ticket0() {
			jl3 = new JLabel();
			jl3.setBounds(0, 0, 576, 500);
		    
			//Ʊ�������
			jl31 = new JLabel("Ʊ        �ţ�");
			jl31.setBounds(20, 130, 70, 20);
			tictno = new JTextField(10);
			tictno.setBounds(90, 130, 150, 20);
			//�޸Ŀ�
			jl331 = new JLabel("��  Ϊ��");
			jl331.setBounds(265, 130, 70, 20);
			tictno1 = new JTextField(10);
			tictno1.setBounds(325, 130, 150, 20);
			//��հ�ť
			ticreset1 = new JButton("���");
			ticreset1.setBounds(486, 130, 70, 20);
			ticreset1.setForeground(Color.GREEN);
			ticreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // վ�����
					tictno.setText("");
					tictno1.setText("");
				}
			});
			
			//վ�������
		    jl32 = new JLabel("վ        ����");
		    jl32.setBounds(20, 160, 70, 20);
		    ticcname = new JTextField(10);
		    ticcname.setBounds(90, 160, 150, 20);
			//�޸Ŀ�
			jl332 = new JLabel("��  Ϊ��");
			jl332.setBounds(265, 160, 70, 20);
			ticcname1 = new JTextField(10);
			ticcname1.setBounds(325, 160, 150, 20);
			//��հ�ť
			ticreset2 = new JButton("���");
			ticreset2.setBounds(486, 160, 70, 20);
			ticreset2.setForeground(Color.GREEN);
			ticreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     
					ticcname.setText("");
					ticcname1.setText("");
				}
			});

			//���������
		    jl33 = new JLabel("��        �Σ�");
		    jl33.setBounds(20, 190, 70, 20);
			ticcno = new JTextField(10);
			ticcno.setBounds(90, 190, 150, 20);
			//�޸Ŀ�
			jl333 = new JLabel("��  Ϊ��");
			jl333.setBounds(265, 190, 70, 20);
			ticcno1 = new JTextField(10);
			ticcno1.setBounds(325, 190, 150, 20);
			//��հ�ť
			ticreset3 = new JButton("���");
			ticreset3.setBounds(486, 190, 70, 20);
			ticreset3.setForeground(Color.GREEN);
			ticreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					ticcno.setText("");
					ticcno1.setText("");
				}
			});

			//����ʱ�������
		    jl34 = new JLabel("����ʱ�䣺");
		    jl34.setBounds(20, 220, 70, 20);
			tictime = new JTextField(10);
			tictime.setBounds(90, 220, 150, 20);
			//�������޸Ŀ�
			jl334 = new JLabel("��  Ϊ��");
			jl334.setBounds(265, 220, 70, 20);
			tictime1 = new JTextField(10);
			tictime1.setBounds(325, 220, 150, 20);
			//��ʼ�ص���հ�ť
		    ticreset4 = new JButton("���");
		    ticreset4.setBounds(486, 220, 70, 20);
		    ticreset4.setForeground(Color.GREEN);
		    ticreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					tictime.setText("");
					tictime1.setText("");
				}
			});
			
			//Ʊ�������
		    jl35 = new JLabel("Ʊ        �ۣ�");
		    jl35.setBounds(20, 250, 70, 20);
		    ticprice = new JTextField(10);
		    ticprice.setBounds(90, 250, 150, 20);
			//�������޸Ŀ�
			jl335 = new JLabel("��  Ϊ��");
			jl335.setBounds(265, 250, 70, 20);
			ticprice1 = new JTextField(10);
			ticprice1.setBounds(325, 250, 150, 20);
			//Ŀ��ص���հ�ť
		    ticreset5 = new JButton("���");
		    ticreset5.setBounds(486, 250, 70, 20);
		    ticreset5.setForeground(Color.GREEN);
		    ticreset5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					ticprice.setText("");
					ticprice1.setText("");
				}
			});

			//ʣ��Ʊ��
		    jl36 = new JLabel("ʣ��Ʊ����");
		    jl36.setBounds(20, 280, 70, 20);
			ticlast = new JTextField(10);
			ticlast.setBounds(90, 280, 150, 20);
			//�޸Ŀ�
			jl336 = new JLabel("��  Ϊ��");
			jl336.setBounds(265, 280, 70, 20);
			ticlast1 = new JTextField(10);
			ticlast1.setBounds(325, 280, 150, 20);
			//��հ�ť
		    ticreset6 = new JButton("���");
		    ticreset6.setBounds(486, 280, 70, 20);
		    ticreset6.setForeground(Color.GREEN);
		    ticreset6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					ticlast.setText("");
					ticlast1.setText("");
				}
			});
		    
			//��Ӱ�ť
		    ticcreate = new JButton("�޸�");
		    ticcreate.setBounds(168, 370, 70, 30);
			//��¼�ж��¼�
		    ticcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					ticcreate.setBackground(Color.blue);      // ��ɫ�ύ
		        	ticket1();
				}
			});
			
			//��հ�ť
		    ticreset = new JButton("���");
		    ticreset.setBounds(338, 370, 70, 30);
		    ticreset.setForeground(Color.GREEN);
		    ticreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // ���
					ticreset.setBackground(Color.black);      // ��ɫ�ύ
					tictno.setText("");
					ticcname.setText("");
					ticcno.setText("");
					tictime.setText("");
					ticprice.setText("");
					ticlast.setText("");
					tictno1.setText("");
					ticcname1.setText("");
					ticcno1.setText("");
					tictime1.setText("");
					ticprice1.setText("");
					ticlast1.setText("");
				}
			});

		    jl3.add(jl31);
		    jl3.add(jl32);
		    jl3.add(jl33);
		    jl3.add(jl34);
		    jl3.add(jl35);
		    jl3.add(jl36);
		    jl3.add(ticcreate);
		    jl3.add(ticreset);
		    jl3.add(ticreset1);
		    jl3.add(ticreset2);
		    jl3.add(ticreset3);
		    jl3.add(ticreset4);
		    jl3.add(ticreset5);
		    jl3.add(ticreset6);
		    jl3.add(tictno);
		    jl3.add(ticcname);
		    jl3.add(ticcno);
		    jl3.add(tictime);
		    jl3.add(ticprice);
		    jl3.add(ticlast);

		    jl3.add(jl331);
		    jl3.add(jl332);
		    jl3.add(jl333);
		    jl3.add(jl334);
		    jl3.add(jl335);
		    jl3.add(jl336);
		    jl3.add(tictno1);
		    jl3.add(ticcname1);
		    jl3.add(ticcno1);
		    jl3.add(tictime1);
		    jl3.add(ticprice1);
		    jl3.add(ticlast1);
			con.add(jl3);
		}
		void ticket1() {
			ticcreate.setBackground(Color.blue);      // ��ɫ�ύ
            if (tictno.getText().equals("") == true && ticcname.getText().equals("") == true && ticcno.getText().equals("") == true && tictime.getText().equals("") == true && ticprice.getText().equals("") == true && ticlast.getText().equals("") == true && tictno1.getText().equals("") == true && ticcname1.getText().equals("") == true && ticcno1.getText().equals("") == true && tictime1.getText().equals("") == true && ticprice1.getText().equals("") == true && ticlast1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
			} else if (tictno.getText().equals("") == true && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == true && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� Ʊ�Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				tictno.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == true && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == true && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� վ������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				ticcname.requestFocusInWindow();
			}  else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == true && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == true && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� ���β���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				ticcno.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == true && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == true && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� ����ʱ�䲻��Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				tictime.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == true && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == true && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� Ʊ�۲���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				ticprice.requestFocusInWindow();
			}  else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == true && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "�������� ʣ��Ʊ������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				ticlast.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tic2 = sm.executeUpdate("use ֣˸��_sj"+"\n"
							+"update Ticket set "
							+"Tno = \'"+tictno1.getText()+"\',"
							+"Cityname = \'"+ticcname1.getText()+"\',"
							+"Ccno = \'"+ticcno1.getText()+"\',"
							+"Ttime = \'"+tictime1.getText()+"\',"
							+"Tprice = \'"+ticprice1.getText()+"\',"
							+"Tlast = \'"+ticlast1.getText()+"\'"+"\n"
							+"where "
							+"Tno = \'"+tictno.getText()+"\' and "
							+"Cityname = \'"+ticcname.getText()+"\' and "
							+"Ccno = \'"+ticcno.getText()+"\' and "
							+"Ttime = \'"+tictime.getText()+"\' and "
							+"Tprice = \'"+ticprice.getText()+"\' and "
							+"Tlast = \'"+ticlast.getText()+"\';"); 	
	           	if(tic2 == 1){
               	 Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
               	 JOptionPane.showOptionDialog(null,
               			 "�������� "+ccp.getSelectedItem()+"�޸ĳɹ� ��������" +"\n\n\tƱ�ţ�"+tictno1.getText()+"\n\tվ����"+ticcname1.getText()+"\n\t���Σ�"+ticcno1.getText()+"\n\t����ʱ�䣺"+tictime1.getText()+"\n\tƱ�ۣ�"+ticprice1.getText()+"\n\tʣ��Ʊ����"+ticlast1.getText(),
               			 "�������",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
               	 	JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
                	}
               	tictno.setText("");
               	ticcname.setText("");
               	ticcno.setText("");
               	tictime.setText("");
               	ticprice.setText("");
               	ticlast.setText("");
               	tictno1.setText("");
               	ticcname1.setText("");
               	ticcno1.setText("");
               	tictime1.setText("");
               	ticprice1.setText("");
               	ticlast1.setText("");
				sm.close();
	        		}
	        catch(SQLException err){
	        	err.printStackTrace(System.out);
				System.out.println("���ݿ�����ʧ�ܣ�____Ticket��");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//�˿����
		void passenger0() {
			jl4 = new JLabel();
			jl4.setBounds(0, 0, 576, 500);
		    
			//Ʊ�������
			jl41 = new JLabel("Ʊ        �ţ�");
			jl41.setBounds(20, 130, 70, 20);
			pastno = new JTextField(10);
			pastno.setBounds(90, 130, 150, 20);
			//�޸Ŀ�
			jl441 = new JLabel("��  Ϊ��");
			jl441.setBounds(265, 130, 70, 20);
			pastno1 = new JTextField(10);
			pastno1.setBounds(325, 130, 150, 20);
			//��հ�ť
			pasreset1 = new JButton("���");
			pasreset1.setBounds(486, 130, 70, 20);
			pasreset1.setForeground(Color.GREEN);
			pasreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // վ�����
					pastno.setText("");
					pastno1.setText("");
				}
			});
			
			//վ�������
			jl42 = new JLabel("�˿�������");
			jl42.setBounds(20, 160, 70, 20);
			pasname = new JTextField(10);
			pasname.setBounds(90, 160, 150, 20);
			//�޸Ŀ�
		    jl442 = new JLabel("��  Ϊ��");
		    jl442.setBounds(265, 160, 70, 20);
		    pasname1 = new JTextField(10);
		    pasname1.setBounds(325, 160, 150, 20);
			//��հ�ť
		    pasreset2 = new JButton("���");
		    pasreset2.setBounds(486, 160, 70, 20);
		    pasreset2.setForeground(Color.GREEN);
		    pasreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     
					pasname.setText("");
					pasname1.setText("");
				}
			});

			//���������
			jl43 = new JLabel("���֤�ţ�");
			jl43.setBounds(20, 190, 70, 20);
			pasid = new JTextField(10);
			pasid.setBounds(90, 190, 150, 20);
			//�޸Ŀ�
			jl443 = new JLabel("��  Ϊ��");
			jl443.setBounds(265, 190, 70, 20);
			pasid1 = new JTextField(10);
			pasid1.setBounds(325, 190, 150, 20);
			//��հ�ť
			pasreset3 = new JButton("���");
			pasreset3.setBounds(486, 190, 70, 20);
			pasreset3.setForeground(Color.GREEN);
			pasreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					pasid.setText("");
					pasid1.setText("");
				}
			});

			//����ʱ�������
			jl44 = new JLabel("��  ��  �ţ�");
			jl44.setBounds(20, 220, 70, 20);
			pasnum = new JTextField(10);
			pasnum.setBounds(90, 220, 150, 20);
			//�������޸Ŀ�
			jl444 = new JLabel("��  Ϊ��");
			jl444.setBounds(265, 220, 70, 20);
			pasnum1 = new JTextField(10);
			pasnum1.setBounds(325, 220, 150, 20);
			//��ʼ�ص���հ�ť
		    pasreset4 = new JButton("���");
		    pasreset4.setBounds(486, 220, 70, 20);
		    pasreset4.setForeground(Color.GREEN);
		    pasreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					pasnum.setText("");
					pasnum1.setText("");
				}
			});

			//���������б��
			pasrorb = new JComboBox<String>(rorb);
			pasrorb1 = new JComboBox<String>(rorb);
			
			//Ʊ�������
		    jl45 = new JLabel("Ԥ�����ѹ� ��");
		    jl45.setBounds(5, 250, 85, 20);
		    pasrorb.setBounds(90, 250, 150, 20);
			//�������޸Ŀ�
		    jl445 = new JLabel("��  Ϊ��");
		    jl445.setBounds(265, 250, 70, 20);
		    pasrorb1.setBounds(325, 250, 150, 20);

			//ʣ��Ʊ��
		    jl46 = new JLabel("��  λ  �ţ�");
		    jl46.setBounds(20, 280, 70, 20);
		    passeat = new JTextField(10);
		    passeat.setBounds(90, 280, 150, 20);
			//�޸Ŀ�
			jl446 = new JLabel("��  Ϊ��");
			jl446.setBounds(265, 280, 70, 20);
			passeat1 = new JTextField(10);
			passeat1.setBounds(325, 280, 150, 20);
			//��հ�ť
			pasreset6 = new JButton("���");
			pasreset6.setBounds(486, 280, 70, 20);
			pasreset6.setForeground(Color.GREEN);
			pasreset6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					passeat.setText("");
					passeat1.setText("");
				}
			});
		    
			//��Ӱ�ť
			pascreate = new JButton("�޸�");
			pascreate.setBounds(168, 370, 70, 30);
			//��¼�ж��¼�
			pascreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					pascreate.setBackground(Color.blue);      // ��ɫ�ύ
		        	passenger1();
				}
			});
			
			//��հ�ť
			pasreset = new JButton("���");
			pasreset.setBounds(338, 370, 70, 30);
			pasreset.setForeground(Color.GREEN);
			pasreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // ���
					pasreset.setBackground(Color.black);      // ��ɫ�ύ
					pastno.setText("");
					pasname.setText("");
					pasid.setText("");
					pasnum.setText("");
					passeat.setText("");
					pastno1.setText("");
					pasname1.setText("");
					pasid1.setText("");
					pasnum1.setText("");
					passeat1.setText("");
				}
			});

		    jl4.add(jl41);
		    jl4.add(jl42);
		    jl4.add(jl43);
		    jl4.add(jl44);
		    jl4.add(jl45);
		    jl4.add(jl46);
		    jl4.add(pascreate);
		    jl4.add(pasreset);
		    jl4.add(pasreset1);
		    jl4.add(pasreset2);
		    jl4.add(pasreset3);
		    jl4.add(pasreset4);
		    jl4.add(pasreset6);
		    jl4.add(pastno);
		    jl4.add(pasname);
		    jl4.add(pasid);
		    jl4.add(pasnum);
		    jl4.add(pasrorb);
		    jl4.add(passeat);
		    
		    jl4.add(jl441);
		    jl4.add(jl442);
		    jl4.add(jl443);
		    jl4.add(jl444);
		    jl4.add(jl445);
		    jl4.add(jl446);
		    jl4.add(pastno1);
		    jl4.add(pasname1);
		    jl4.add(pasid1);
		    jl4.add(pasnum1);
		    jl4.add(pasrorb1);
		    jl4.add(passeat1);
			con.add(jl4);
		}
		void passenger1() {
			pascreate.setBackground(Color.blue);      // ��ɫ�ύ
            if (pastno.getText().equals("") == true && pasname.getText().equals("") == true && pasid.getText().equals("") == true && pasnum.getText().equals("") == true  && passeat.getText().equals("") == true && pastno1.getText().equals("") == true && pasname1.getText().equals("") == true && pasid1.getText().equals("") == true && pasnum1.getText().equals("") == true  && passeat1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
			} else if (pastno.getText().equals("") == true && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == true && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false  && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� Ʊ�Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				pastno.requestFocusInWindow();
			} else if (pastno.getText().equals("") == false && pasname.getText().equals("") == true && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == true && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false  && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� �˿���������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				pasname.requestFocusInWindow();
			}  else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == true && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == true && pasnum1.getText().equals("") == false && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� ���֤�Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				pasid.requestFocusInWindow();
			} else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == true  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == true  && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "�������� �ֻ��Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				pasnum.requestFocusInWindow();
			}  else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == true && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false && passeat1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "�������� ��λ�Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				passeat.requestFocusInWindow();
			} else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false && passeat1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tic2 = sm.executeUpdate("use ֣˸��_sj"+"\n"
							+"update Passenger set "
							+"Tno = \'"+pastno1.getText()+"\',"
							+"Pname = \'"+pasname1.getText()+"\',"
							+"Pid = \'"+pasid1.getText()+"\',"
							+"Pnum = \'"+pasnum1.getText()+"\',"
							+"RorB = \'"+pasrorb1.getSelectedItem()+"\',"
							+"Pseat = \'"+passeat1.getText()+"\'"+"\n"
							+"where "
							+"Tno = \'"+pastno.getText()+"\' and "
							+"Pname = \'"+pasname.getText()+"\' and "
							+"Pid = \'"+pasid.getText()+"\' and "
							+"Pnum = \'"+pasnum.getText()+"\' and "
							+"RorB = \'"+pasrorb.getSelectedItem()+"\' and "
							+"Pseat = \'"+passeat.getText()+"\';"); 	
	           	if(tic2 == 1){
               	 Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
               	 JOptionPane.showOptionDialog(null,
               			 "�������� "+ccp.getSelectedItem()+"�޸ĳɹ� ��������" +"\n\n\tƱ�ţ�"+pastno1.getText()+"\n\t�˿�������"+pasname1.getText()+"\n\t���֤�ţ�"+pasid1.getText()+"\n\t�ֻ��ţ�"+pasnum1.getText()+"\n\tԤ�����ѹ���"+pasrorb1.getSelectedItem()+"\n\t��λ�ţ�"+passeat1.getText(),
               			 "�������",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
               	 	JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
                	}
	           	pastno.setText("");
	           	pasname.setText("");
               	pasid.setText("");
               	pasnum.setText("");
               	passeat.setText("");
               	pastno1.setText("");
               	pasname1.setText("");
               	pasid1.setText("");
               	pasnum1.setText("");
               	passeat1.setText("");
				sm.close();
	        		}
	        catch(SQLException err){
	        	err.printStackTrace(System.out);
				System.out.println("���ݿ�����ʧ�ܣ�____passenger��");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//��Ʊ���
		void refund0() {
			jl5 = new JLabel();
			jl5.setBounds(0, 0, 576, 500);
		    
			//Ʊ�������
			jl51 = new JLabel("Ʊ        �ţ�");
			jl51.setBounds(20, 130, 70, 20);
			reftno = new JTextField(10);
			reftno.setBounds(90, 130, 150, 20);
			//�޸Ŀ�
			jl551 = new JLabel("��  Ϊ��");
			jl551.setBounds(265, 130, 70, 20);
			reftno1 = new JTextField(10);
			reftno1.setBounds(325, 130, 150, 20);
			//��հ�ť
			refreset1 = new JButton("���");
			refreset1.setBounds(486, 130, 70, 20);
			refreset1.setForeground(Color.GREEN);
			refreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // վ�����
					reftno.setText("");
					reftno1.setText("");
				}
			});
			
			//վ�������
			jl52 = new JLabel("�˿�������");
			jl52.setBounds(20, 160, 70, 20);
			refname = new JTextField(10);
			refname.setBounds(90, 160, 150, 20);
			//�޸Ŀ�
			jl552 = new JLabel("��  Ϊ��");
			jl552.setBounds(265, 160, 70, 20);
			refname1 = new JTextField(10);
			refname1.setBounds(325, 160, 150, 20);
			//��հ�ť
			refreset2 = new JButton("���");
			refreset2.setBounds(486, 160, 70, 20);
			refreset2.setForeground(Color.GREEN);
			refreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     
					refname.setText("");
					refname1.setText("");
				}
			});

			//���������
		    jl53 = new JLabel("���֤�ţ�");
		    jl53.setBounds(20, 190, 70, 20);
		    refid = new JTextField(10);
		    refid.setBounds(90, 190, 150, 20);
			//�޸Ŀ�
			jl553 = new JLabel("��  Ϊ��");
			jl553.setBounds(265, 190, 70, 20);
			refid1 = new JTextField(10);
			refid1.setBounds(325, 190, 150, 20);
			//��հ�ť
			refreset3 = new JButton("���");
			refreset3.setBounds(486, 190, 70, 20);
			refreset3.setForeground(Color.GREEN);
			refreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					refid.setText("");
					refid1.setText("");
				}
			});

			//����ʱ�������
			jl54 = new JLabel("��  ��  �ţ�");
			jl54.setBounds(20, 220, 70, 20);
			refnum = new JTextField(10);
			refnum.setBounds(90, 220, 150, 20);
			//�������޸Ŀ�
			jl554 = new JLabel("��  Ϊ��");
			jl554.setBounds(265, 220, 70, 20);
			refnum1 = new JTextField(10);
			refnum1.setBounds(325, 220, 150, 20);
			//��ʼ�ص���հ�ť
			refreset4 = new JButton("���");
			refreset4.setBounds(486, 220, 70, 20);
			refreset4.setForeground(Color.GREEN);
			refreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					refnum.setText("");
					refnum1.setText("");
				}
			});
			
			//Ʊ�������
			jl55 = new JLabel("Ӧ  ��  �");
			jl55.setBounds(20, 250, 70, 20);
			reftprice = new JTextField(10);
			reftprice.setBounds(90, 250, 150, 20);
			//�������޸Ŀ�
		    jl555 = new JLabel("��  Ϊ��");
		    jl555.setBounds(265, 250, 70, 20);
		    reftprice1 = new JTextField(10);
		    reftprice1.setBounds(325, 250, 150, 20);
		    //��հ�ť
		    refreset5 = new JButton("���");
		    refreset5.setBounds(486, 250, 70, 20);
		    refreset5.setForeground(Color.GREEN);
		    refreset5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					reftprice.setText("");
					reftprice1.setText("");
				}
			});
		    
			//ʣ��Ʊ��
		    jl56 = new JLabel("��Ʊʱ�䣺");
		    jl56.setBounds(20, 280, 70, 20);
		    refdate = new JTextField(10);
		    refdate.setBounds(90, 280, 150, 20);
			//�޸Ŀ�
		    jl556 = new JLabel("��  Ϊ��");
		    jl556.setBounds(265, 280, 70, 20);
		    refdate1 = new JTextField(10);
		    refdate1.setBounds(325, 280, 150, 20);
			//��հ�ť
		    refreset6 = new JButton("���");
		    refreset6.setBounds(486, 280, 70, 20);
		    refreset6.setForeground(Color.GREEN);
		    refreset6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // �������
					refdate.setText("");
					refdate1.setText("");
				}
			});
		    
			//��Ӱ�ť
		    refcreate = new JButton("�޸�");
		    refcreate.setBounds(168, 370, 70, 30);
			//��¼�ж��¼�
		    refcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					refcreate.setBackground(Color.blue);      // ��ɫ�ύ
					refund1();
				}
			});
			
			//��հ�ť
		    refreset = new JButton("���");
		    refreset.setBounds(338, 370, 70, 30);
		    refreset.setForeground(Color.GREEN);
		    refreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // ���
					refreset.setBackground(Color.black);      // ��ɫ�ύ
					reftno.setText("");
					refname.setText("");
					refid.setText("");
					refnum.setText("");
					reftprice.setText("");
					refdate.setText("");
					reftno1.setText("");
					refname1.setText("");
					refid1.setText("");
					refnum1.setText("");
					reftprice1.setText("");
					refdate1.setText("");
				}
			});

			jl5.add(jl51);
			jl5.add(jl52);
			jl5.add(jl53);
		    jl5.add(jl54);
		    jl5.add(jl55);
		    jl5.add(jl56);
		    jl5.add(refcreate);
		    jl5.add(refreset);
		    jl5.add(refreset1);
		    jl5.add(refreset2);
		    jl5.add(refreset3);
		    jl5.add(refreset4);
		    jl5.add(refreset5);
		    jl5.add(refreset6);
		    jl5.add(reftno);
		    jl5.add(refname);
		    jl5.add(refid);
		    jl5.add(refnum);
		    jl5.add(reftprice);
		    jl5.add(refdate);
		    
		    jl5.add(jl551);
		    jl5.add(jl552);
		    jl5.add(jl553);
		    jl5.add(jl554);
		    jl5.add(jl555);
		    jl5.add(jl556);
		    jl5.add(reftno1);
		    jl5.add(refname1);
		    jl5.add(refid1);
		    jl5.add(refnum1);
		    jl5.add(reftprice1);
		    jl5.add(refdate1);
			con.add(jl5);
		}
		void refund1() {
			refcreate.setBackground(Color.blue);      // ��ɫ�ύ
            if (reftno.getText().equals("") == true && refname.getText().equals("") == true && refid.getText().equals("") == true && refnum.getText().equals("") == true  && reftprice.getText().equals("") == true && refdate.getText().equals("") == true && reftno1.getText().equals("") == true && refname1.getText().equals("") == true && refid1.getText().equals("") == true && refnum1.getText().equals("") == true  && reftprice1.getText().equals("") == true && refdate1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������", "��������", JOptionPane.WARNING_MESSAGE);
			} else if (reftno.getText().equals("") == true && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == true && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� Ʊ�Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				reftno.requestFocusInWindow();
			} else if (reftno.getText().equals("") == false && refname.getText().equals("") == true && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == true && refid1.getText().equals("") == false && refnum1.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� �˿���������Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				refname.requestFocusInWindow();
			}  else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == true && refnum.getText().equals("") == false  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == true && refnum1.getText().equals("") == false && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� ���֤�Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				refid.requestFocusInWindow();
			} else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == true  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == true  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� �ֻ��Ų���Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				refnum.requestFocusInWindow();
			}  else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice1.getText().equals("") == true && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false && reftprice1.getText().equals("") == true && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "�������� Ӧ�˿��Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				reftprice.requestFocusInWindow();
			} else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == true  && reftprice.getText().equals("") == false && refdate.getText().equals("") == true && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == true) {
				JOptionPane.showMessageDialog(null, "�������� �˿�ʱ�䲻��Ϊ�� ��������", "��������", JOptionPane.ERROR_MESSAGE);
				refdate.requestFocusInWindow();
			}  else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tic2 = sm.executeUpdate("use ֣˸��_sj"+"\n"
							+"update Refund set "
							+"Rno = \'"+reftno1.getText()+"\',"
							+"Pname = \'"+refname1.getText()+"\',"
							+"Pid = \'"+refid1.getText()+"\',"
							+"Pnum = \'"+refnum1.getText()+"\',"
							+"Rprice = \'"+reftprice1.getText()+"\',"
							+"Rtime = \'"+refdate1.getText()+"\'"+"\n"
							+"where "
							+"Rno = \'"+reftno.getText()+"\' and "
							+"Pname = \'"+refname.getText()+"\' and "
							+"Pid = \'"+refid.getText()+"\' and "
							+"Pnum = \'"+refnum.getText()+"\' and "
							+"Rprice = \'"+reftprice.getText()+"\' and "
							+"Rtime = \'"+refdate.getText()+"\';"); 	
	           	if(tic2 == 1){
               	 Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
               	 JOptionPane.showOptionDialog(null,
               			 "�������� "+ccp.getSelectedItem()+"�޸ĳɹ� ��������" +"\n\n\tƱ�ţ�"+reftno1.getText()+"\n\t�˿�������"+refname1.getText()+"\n\t���֤�ţ�"+refid1.getText()+"\n\t�ֻ��ţ�"+refnum1.getText()+"\n\tӦ�˿"+reftprice1.getText()+"\n\t�˿�ʱ�䣺"+refdate1.getText(),
               			 "�������",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
               	 	JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
                	}
	           	reftno.setText("");
	           	refname.setText("");
	           	refid.setText("");
	           	refnum.setText("");
	           	reftprice.setText("");
	           	refdate.setText("");
               	reftno1.setText("");
               	refname1.setText("");
               	refid1.setText("");
               	refnum1.setText("");
               	reftprice1.setText("");
               	refdate1.setText("");
				sm.close();
	        		}
	        catch(SQLException err){
	        	err.printStackTrace(System.out);
				System.out.println("���ݿ�����ʧ�ܣ�____Refund��");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "�������� �ദ�������� ��������", "�������", JOptionPane.ERROR_MESSAGE);
		}			
		}
		
		//��ť����󴥷��¼�
        String RL = "jdbc:sqlserver://localhost:1433;";
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      		}
	        catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
				System.out.println("������������ʧ�ܣ�");
	       		}
		        if (e.getSource() == ccexit) {
		        	ccexit.setBackground(Color.red);        // ��ɫ�˳�
		            System.exit(0);
		        }else if (e.getSource() == cchome) {
		        	cchome.setBackground(Color.green);      // ��ɫ��ҳ
		        	dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == ccback) {
		        	ccback.setBackground(Color.yellow);     // ��ɫ����
		            dispose();
		        	new cfunctionpage().setBounds(750,50,592,660);
		        }else if(e.getSource() == ccrefresh) {
		        	dispose();
			        new cchpage().setBounds(750,50,592,660);      // ˢ��
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
