package �γ����;
import javax.swing.*;  //�ṩ�����
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class prefund extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//�˵���
			JMenuBar menubar;
			JMenu menu,submenu,settings,jfstyle;
			JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//��ǩ����
	private JPanel imagePanel;
    private ImageIcon background;
    
	//�˿��ύ��Ϣҳ��
	private JLabel jl,jl1,jl2,jl3,jl4;
	private JTextField tno,name,id,num;
	
	
	
	//�ύ��������ҳ��������һҳ���˳�����ť
	JButton prefresh,psubmit,pback,phome,pexit,preset,preset1,preset2,preset3,preset4;
	
	public prefund() {
    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\������Ʊ.png");             // ����ͼƬ
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
		
		this.setTitle("С���ĳ�վ��Ʊϵͳ");                //������������
		
		// ���ô���ı���ͼ��
		// Image image = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\С��.ico").getImage();
		// this.setIconImage(image);
		
		// ���ڴ�С�ı�
		this.setResizable(true);
		
		//   JLabel.setFont(new Font("΢���ź�", 0, 16));    //��������
		//   UIManager.put("Button.font", new java.awt.Font("����", 0, 12));
		
		// ������ʾ
		this.setLocationRelativeTo(null);
		
		// �ɼ�
		this.setVisible(true);
		
		//���ú���
		init();
		prefund1();
		
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
	void prefund1() {
		
		// ����һ������
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// ���������ǩ����
		jl = new JLabel();
	    jl.setBounds(0, 0, 576, 500);
	    
		
		//Ʊ�������
		jl1 = new JLabel("Ʊ         �ţ�");
		jl1.setBounds(100, 100, 70, 20);
		tno = new JTextField();
		tno.setBounds(200, 100, 165, 20);
	    tno.addActionListener(this);
	    /*
	    tno.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            // Restrict input to only integers 
	            if (key < 96 && key > 105) e.setKeyChar("");
	        }
	    });
	    */
	    
		//Ʊ����հ�ť
		preset1 = new JButton("���");
		preset1.setBounds(400, 100, 70, 20);
	    preset1.addActionListener(this);
		preset1.setForeground(Color.GREEN);
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
		/*
		try{
			tno_int = Integer.parseInt(tno.getText());
			}
		catch(Exception etno){
			System.out.println("�������� Ʊ�������������������� ��������");
			}
		*/
		
		//�˿����������
		jl2 = new JLabel("��         ����");
		jl2.setBounds(100, 130, 70, 20);
		name = new JTextField();
		name.setBounds(200, 130, 165, 20);
	    name.addActionListener(this);
	    
		//������հ�ť
		preset2 = new JButton("���");
		preset2.setBounds(400, 130, 70, 20);
	    preset2.addActionListener(this);
		preset2.setForeground(Color.GREEN);
		
		//�˿����֤�������
		jl3 = new JLabel("���֤�ţ�");
		jl3.setBounds(100, 160, 70, 20);
		id = new JTextField();
		id.setBounds(200, 160, 165, 20);
	    id.addActionListener(this);
		//���֤����հ�ť
		preset3 = new JButton("���");
		preset3.setBounds(400, 160, 70, 20);
	    preset3.addActionListener(this);
		preset3.setForeground(Color.GREEN);
		/*
		id.addFocusListener(new FocusAdapter()
		{
		    @Override
		    public void focusGained(FocusEvent e){
		    	id.setText("");
		    	}
		    @Override
		    public void focusLost(FocusEvent e){
		    	id.setText("�޶�18λ!!!");
		    	}
		    });
		*/
		
		//�˿��ֻ��������
		jl4 = new JLabel("�ֻ��ţ� ");
		jl4.setBounds(105, 190, 70, 20);
		num = new JTextField();
		num.setBounds(200, 190, 165, 20);
	    num.addActionListener(this);
	    
		//�ֻ�����հ�ť
		preset4 = new JButton("���");
		preset4.setBounds(400, 190, 70, 20);
	    preset4.addActionListener(this);
		preset4.setForeground(Color.GREEN);
		/*
		num.addFocusListener(new FocusAdapter()
		{
		    @Override
		    public void focusGained(FocusEvent e){
		    	num.setText("");
		    	}
		    @Override
		    public void focusLost(FocusEvent e){
		    	num.setText("�޶�11λ������");
		    	}
		    });
	    */
		
		//ˢ�°�ť
		prefresh = new JButton("ˢ��");
		prefresh.setBounds(0, 100, 70, 25);
	    prefresh.addActionListener(this);
		
		//�ύ��ť
		psubmit = new JButton("�ύ");
		psubmit.setBounds(160, 280, 70, 25);
		psubmit.addActionListener(this);
		
		//������һҳ��ť
		pback = new JButton("����");
		pback.setBounds(330, 280, 70, 25);
		pback.addActionListener(this);
		
		//��հ�ť
		preset = new JButton("���");
		preset.setBounds(245, 300, 70, 25);
	    preset.addActionListener(this);
		preset.setForeground(Color.GREEN);

		//������ҳ��ť
		phome = new JButton("��ҳ");
		phome.setBounds(160, 320, 70, 25);
		phome.addActionListener(this);
		phome.setForeground(Color.blue);
		
		//�˳�����ť
		pexit = new JButton("�˳�");
		pexit.setBounds(330, 320, 70, 25);
		pexit.addActionListener(this);
		pexit.setForeground(Color.red);
		
		
		jl.add(jl1);
		jl.add(jl2);
		jl.add(jl3);
		jl.add(jl4);
		jl.add(prefresh);
		jl.add(psubmit);
		jl.add(phome);
		jl.add(pback);
		jl.add(pexit);
		jl.add(preset);
		jl.add(preset1);
		jl.add(preset2);
		jl.add(preset3);
		jl.add(preset4);
		con.add(jl);
		con.add(tno);
		con.add(name);
		con.add(id);
		con.add(num);
	}
	    //��ť����󴥷��¼�
		public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == psubmit) {
	            psubmit.setBackground(Color.blue);     // ��ɫ�ύ
	            
	            //�����ı��������¼�
		            if (tno.getText().equals("") == true && name.getText().equals("") == false && id.getText().equals("") == false && num.getText().equals("") == false) {
		            	JOptionPane.showMessageDialog(null, "�������� Ʊ�Ų���Ϊ�� ��������");
		            	tno.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "�������� Ʊ�Ų���Ϊ�� ��������", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == true && id.getText().equals("") == false && num.getText().equals("") == false) {
		            	JOptionPane.showMessageDialog(null, "�������� ��������Ϊ�� ��������");
		            	name.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "�������� ��������Ϊ�� ��������", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == false && id.getText().equals("") == true && num.getText().equals("") == false) {
		            	JOptionPane.showMessageDialog(null, "�������� ���֤�Ų���Ϊ�� ��������");
		            	id.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "�������� ���֤�Ų���Ϊ�� ��������", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == false && id.getText().equals("") == false && num.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "�������� �ֻ��Ų���Ϊ�ա�������");
		            	num.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "�������� �ֻ��Ų���Ϊ�ա�������", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == false && id.getText().equals("") == false && num.getText().equals("") == false) {
		            	
		            	
		            	Statement sm = null;
		            	String RL = "jdbc:sqlserver://localhost:1433;";
		            	            
		            	
		                    try{ 
		                    	 try {
									Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
								} catch (ClassNotFoundException e1) {
									// TODO �Զ����ɵ� catch ��
									e1.printStackTrace();
								}
		                         System.out.println("�����������ӳɹ���");
		                         Connection con = DriverManager.getConnection(RL,"sa","5436.......");
		                         System.out.println("���ݿ����ӳɹ�����");
		                         sm = con.createStatement();
		            //--------------------------------------------------------------------------------------------------------------------------------------//                          
		                         /* ��ʾ1 ���鿴 ��Student             
		                         Statement st = con.createStatement();
		                         ResultSet rs = st.executeQuery(sqlStr);
		                         System.out.println("�������ݿ�ɹ�������");

		                         System.out.println(" ----------------------------------------------------------------------------------------------------------------");
		                         
		                         while(rs.next()) {
		                        	 System.out.println(" | " + "\t" + rs.getString("Sno") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Ssex") + "\t" + " | " + "\t" + rs.getInt("Sage") + "\t" + " | " + "\t" + rs.getString("Sdept")  + " | ");
		                             System.out.println(" ----------------------------------------------------------------------------------------------------------------");
		                         }
		                         
		                         rs.close();
		                         */
		            //--------------------------------------------------------------------------------------------------------------------------------------//             
		                         
		                         //��ȡ��ǰʱ��(��ȷ������)
		                         Calendar cal = Calendar.getInstance(); 
		                         Date date = cal.getTime();
		                         //  2016/05/05-01:01:34:364
		                         String rtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		                         
		                         String sql = "use ֣˸��_sj"+"\n"+"select Tprice from Ticket where Tno = "+"\'"+tno.getText()+"\'"; 	//��ȡ���ݿ�����  
		                         ResultSet rs = sm.executeQuery(sql);
		                         float tprice = 0; 
		                         while(rs.next())
		             			 {  
		                        	 if(rs.next()) {
		                        		 tprice = rs.getFloat("Tprice");
		                        		 }
		             			 }
		                         
		                         int i0 = sm.executeUpdate("insert into Refund(Rno,Pname,Pid,Pnum,Rprice,Rtime)"
		                         		                   +" select Passenger.Tno,Passenger.Pname,Passenger.Pid,Passenger.Pnum,'0',"+"\'"+rtime+"\'" 
		                         		                   +" from Passenger"
		                         		                   +" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
		                         		                   +" and Passenger.Pname = "+"\'"+name.getText()+"\'"
		                         		                   +" and Passenger.Pid = "+"\'"+id.getText()+"\'"
		                         		                   +" and Passenger.Pnum	= "+"\'"+num.getText()+"\'"
		                         		                   +" and Passenger.RorB = 'Ԥ��'"
                                         				   +" delete from Passenger"
                                         				   +" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
                                         				   +" and Passenger.Pname = "+"\'"+name.getText()+"\'"
                                         				   +" and Passenger.Pid = "+"\'"+id.getText()+"\'"
                                         				   +" and Passenger.Pnum	= "+"\'"+num.getText()+"\'" 
                                         				   +" and Passenger.RorB = 'Ԥ��'"
                                         				    
                                         				    +" insert into Refund(Rno,Pname,Pid,Pnum,Rprice,Rtime) "
               		                   						+" select Passenger.Tno,Passenger.Pname,Passenger.Pid,Passenger.Pnum,Ticket.Tprice,"+"\'"+rtime+"\'"
               		                   						+" from Passenger,Ticket"
               		                   						+" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
               		                   						+" and Passenger.Pname = "+"\'"+name.getText()+"\'"
               		                   						+" and Passenger.Pid = "+"\'"+id.getText()+"\'"
               		                   						+" and Passenger.Pnum = "+"\'"+num.getText()+"\'"
               		                   						+" and Passenger.RorB = '����'"
               		                   						+" and Passenger.Tno = Ticket.Tno"
               		                   						+" delete from Passenger"
               		                   						+" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
               		                   						+" and Passenger.Pname = "+"\'"+name.getText()+"\'"
               		                   						+" and Passenger.Pid = "+"\'"+id.getText()+"\'"
               		                   						+" and Passenger.Pnum = "+"\'"+num.getText()+"\'" 
               		                   						+" and Passenger.RorB = '����'");
		                         
		                         if(i0 == 1){
		                        	 dispose();
		                        	 Object[] options ={"ȷ��"};  //�Զ��尴ť�ϵ�����
		                        		 int a = JOptionPane.showOptionDialog(null,
		                        				 			"�������� ��Ʊ�ɹ� ��������" +"\n\n\tƱ�ţ�"+tno.getText()
		                        				 			+"\n\t������"+name.getText()+"\n\t���֤�ţ�"+id.getText()
		                        				 			+"\n\t�ֻ��ţ�"+num.getText()+"\n\tӦ�˿"+tprice+"\n\t�˿�ʱ�䣺"+rtime,
		                        				 				"�������",JOptionPane.YES_OPTION, 
		                        				 				1, null, options, null); 
		                        		 if(a == JOptionPane.YES_OPTION) {
		                        			 tno.setText("");
		                        			 name.setText("");
		                        			 id.setText("");
		                        			 num.setText("");
		                        			 new passenger().setBounds(750,50,576,650);
		                        		 }
		                        	 }
		                         else{
		                        	 Object[] options ={"��������"};  //�Զ��尴ť�ϵ�����
		                        	 JOptionPane.showOptionDialog(null, "�������� �������� ��������","�������",JOptionPane.NO_OPTION,0,null, options, null); 
		    			              tno.setText("");
		    			              name.setText("");
		    			              id.setText("");
		    			              num.setText("");
		             			 }
		             			 
		            //--------------------------------------------------------------------------------------------------------------------------------------//             
		                         /* ��ʾ3 �� ����Student��������
		                         int i = sm.executeUpdate("update Student set Sno = '201835555' where Sname = 'UnseeR'");
		                         if(i==1){
		             				System.out.println("���ݸ��³ɹ���������");
		             			 }
		                         else{
		             				System.out.println("���ݸ���ʧ�ܣ���������");
		             			 }

		                         sm.close();
		                         */
		            //--------------------------------------------------------------------------------------------------------------------------------------//             
		                         /* ��ʾ4 �� ɾ��Student�������� 
		                         int i = sm.executeUpdate("delete from Student where Sno = '201835555'");
		                         if(i==1){
		             				System.out.println("����ɾ���ɹ���������");
		             			 }
		                         else{
		             				System.out.println("����ɾ��ʧ�ܣ���������");
		             			 }

		                         sm.close();
		                         con.close();
		                         */
		            //--------------------------------------------------------------------------------------------------------------------------------------//                         

		                         rs.close();
		                         sm.close();   
		                    }
		                    catch(SQLException err){
		                    	err.printStackTrace(System.out);
		                    	
		                    }
			            //JOptionPane.showConfirmDialog(null, "�������� �ύ�ɹ� ��������", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == true && name.getText().equals("") == true && id.getText().equals("") == true && num.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "�������� �������Ϊ�� ��������");
			            psubmit.requestFocusInWindow();
			            //JOptionPane.showConfirmDialog(null, "�������� �������Ϊ�� ��������", null, JOptionPane.OK_OPTION);
		            }else {
		            	JOptionPane.showMessageDialog(null, "�������� �����������������롪������");
			            psubmit.requestFocusInWindow();
			            //JOptionPane.showConfirmDialog(null, "�������� �����������������롪������", null, JOptionPane.OK_OPTION);
		            }
		            try {
		                this.repaint();
		            } catch (Exception ep) {
		                System.out.println("��������" + ep);
		            }
	            
	        } else if (e.getSource() == prefresh) {
	            dispose();
	            new prefund().setBounds(750,50,576,650);      // ˢ��
	        }else if (e.getSource() == pexit) {
	            pexit.setBackground(Color.red);        // ��ɫ�˳�
	            System.exit(0);
	        }else if (e.getSource() == phome) {
	            phome.setBackground(Color.green);      // ��ɫ��ҳ
	            dispose();
	        	new homepage().setBounds(750,50,592,660);
	        }else if (e.getSource() == pback) {
	            pback.setBackground(Color.yellow);     // ��ɫ����
	            dispose();
	        	new porgr().setBounds(750,50,576,650);
	        }else if (e.getSource() == preset) {
	            preset.setBackground(Color.getHSBColor(51, 72, 71));     // ��ɫ���
	            tno.setText("");
	            name.setText("");
	            id.setText("");
	            num.setText("");
	        }else if (e.getSource() == preset1) {      // Ʊ�����
	            tno.setText("");
	        }else if (e.getSource() == preset2) {      // �������
	            name.setText("");
	        }else if (e.getSource() == preset3) {      // ���֤�����
	            id.setText("");
	        }else if (e.getSource() == preset4) {      // �ֻ������
	            num.setText("");
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
