package 课程设计;
import javax.swing.*;  //提供组件类
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
	//菜单栏
			JMenuBar menubar;
			JMenu menu,submenu,settings,jfstyle;
			JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//标签背景
	private JPanel imagePanel;
    private ImageIcon background;
    
	//乘客提交信息页面
	private JLabel jl,jl1,jl2,jl3,jl4;
	private JTextField tno,name,id,num;
	
	
	
	//提交、返回主页、返回上一页、退出程序按钮
	JButton prefresh,psubmit,pback,phome,pexit,preset,preset1,preset2,preset3,preset4;
	
	public prefund() {
    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\个人退票.png");             // 背景图片
        JLabel label = new JLabel(background);       //把背景图片显示在一个标签里面
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());        // 把标签的大小位置设置为图片刚好填充整个面板
       
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().setLayout(null);
        
        // 把背景图片添加到分层窗格的最底层作为背景
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        this.setSize(background.getIconWidth(), background.getIconHeight());
        
		// 窗口组件初始化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 设置布局方式为绝对定位
		this.setLayout(null);
		
		this.setTitle("小生的车站售票系统");                //函数设立标题
		
		// 设置窗体的标题图标
		// Image image = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\小生.ico").getImage();
		// this.setIconImage(image);
		
		// 窗口大小改变
		this.setResizable(true);
		
		//   JLabel.setFont(new Font("微软雅黑", 0, 16));    //设置字体
		//   UIManager.put("Button.font", new java.awt.Font("宋体", 0, 12));
		
		// 居中显示
		this.setLocationRelativeTo(null);
		
		// 可见
		this.setVisible(true);
		
		//调用函数
		init();
		prefund1();
		
		/*     
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       //单击窗口关闭按钮时执行操作(隐藏当前窗口并释放窗体占有的其他资源)
		*/
	} 
	void init() {
		//首栏
		menubar = new JMenuBar();
		//菜单
		menu = new JMenu("菜单");
		submenu = new JMenu("菜单项目");
		menu.add(submenu);
		submenu.add(sub1 = new JMenuItem("车站售票管理系统"));
		sub1.addActionListener(this);
		submenu.addSeparator();
		submenu.add(sub2 = new JMenuItem("宾馆管理系统"));
		sub2.addActionListener(this);
		//设置
		settings = new JMenu("设置");
		jfstyle = new JMenu("风格");
		jfstyle.add(jfstyle1 = new JMenuItem("Windows 窗口"));
		jfstyle.addSeparator();
		jfstyle1.addActionListener(this);
		jfstyle.add(jfstyle2 = new JMenuItem("Unix 窗口"));
		jfstyle.addSeparator();
		jfstyle2.addActionListener(this);
		jfstyle.add(jfstyle3 = new JMenuItem("Java 窗口"));
		jfstyle3.addActionListener(this);
		settings.add(jfstyle);
		//添加
		menubar.add(menu);
		menubar.add(settings);
		setJMenuBar(menubar);
	}
	void prefund1() {
		
		// 创建一个容器
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// 设置总体标签容器
		jl = new JLabel();
	    jl.setBounds(0, 0, 576, 500);
	    
		
		//票号输入框
		jl1 = new JLabel("票         号：");
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
	    
		//票号清空按钮
		preset1 = new JButton("清空");
		preset1.setBounds(400, 100, 70, 20);
	    preset1.addActionListener(this);
		preset1.setForeground(Color.GREEN);
		/*
		tno.addFocusListener(new FocusAdapter()
		{
		    @Override
			//获取焦点时，清空提示内容
		    public void focusGained(FocusEvent e){
		    		tno.setText("");
		    	}
		    @Override
			//失去焦点时，没有输入内容，显示提示内容
		    public void focusLost(FocusEvent e){
		    	tno.setText("参考车票表，其他无效！！！");
		    	}
		    });
		*/
		/*
		try{
			tno_int = Integer.parseInt(tno.getText());
			}
		catch(Exception etno){
			System.out.println("———— 票号输入有误，请输入整数 ————");
			}
		*/
		
		//乘客姓名输入框
		jl2 = new JLabel("姓         名：");
		jl2.setBounds(100, 130, 70, 20);
		name = new JTextField();
		name.setBounds(200, 130, 165, 20);
	    name.addActionListener(this);
	    
		//姓名清空按钮
		preset2 = new JButton("清空");
		preset2.setBounds(400, 130, 70, 20);
	    preset2.addActionListener(this);
		preset2.setForeground(Color.GREEN);
		
		//乘客身份证号输入框
		jl3 = new JLabel("身份证号：");
		jl3.setBounds(100, 160, 70, 20);
		id = new JTextField();
		id.setBounds(200, 160, 165, 20);
	    id.addActionListener(this);
		//身份证号清空按钮
		preset3 = new JButton("清空");
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
		    	id.setText("限定18位!!!");
		    	}
		    });
		*/
		
		//乘客手机号输入框
		jl4 = new JLabel("手机号： ");
		jl4.setBounds(105, 190, 70, 20);
		num = new JTextField();
		num.setBounds(200, 190, 165, 20);
	    num.addActionListener(this);
	    
		//手机号清空按钮
		preset4 = new JButton("清空");
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
		    	num.setText("限定11位！！！");
		    	}
		    });
	    */
		
		//刷新按钮
		prefresh = new JButton("刷新");
		prefresh.setBounds(0, 100, 70, 25);
	    prefresh.addActionListener(this);
		
		//提交按钮
		psubmit = new JButton("提交");
		psubmit.setBounds(160, 280, 70, 25);
		psubmit.addActionListener(this);
		
		//返回上一页按钮
		pback = new JButton("返回");
		pback.setBounds(330, 280, 70, 25);
		pback.addActionListener(this);
		
		//清空按钮
		preset = new JButton("清空");
		preset.setBounds(245, 300, 70, 25);
	    preset.addActionListener(this);
		preset.setForeground(Color.GREEN);

		//返回主页按钮
		phome = new JButton("主页");
		phome.setBounds(160, 320, 70, 25);
		phome.addActionListener(this);
		phome.setForeground(Color.blue);
		
		//退出程序按钮
		pexit = new JButton("退出");
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
	    //按钮点击后触发事件
		public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == psubmit) {
	            psubmit.setBackground(Color.blue);     // 蓝色提交
	            
	            //监听文本框输入事件
		            if (tno.getText().equals("") == true && name.getText().equals("") == false && id.getText().equals("") == false && num.getText().equals("") == false) {
		            	JOptionPane.showMessageDialog(null, "———— 票号不可为空 ————");
		            	tno.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "———— 票号不可为空 ————", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == true && id.getText().equals("") == false && num.getText().equals("") == false) {
		            	JOptionPane.showMessageDialog(null, "———— 姓名不可为空 ————");
		            	name.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "———— 姓名不可为空 ————", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == false && id.getText().equals("") == true && num.getText().equals("") == false) {
		            	JOptionPane.showMessageDialog(null, "———— 身份证号不可为空 ————");
		            	id.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "———— 身份证号不可为空 ————", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == false && id.getText().equals("") == false && num.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "———— 手机号不可为空————");
		            	num.requestFocusInWindow();
		            	//JOptionPane.showConfirmDialog(null, "———— 手机号不可为空————", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == false && name.getText().equals("") == false && id.getText().equals("") == false && num.getText().equals("") == false) {
		            	
		            	
		            	Statement sm = null;
		            	String RL = "jdbc:sqlserver://localhost:1433;";
		            	            
		            	
		                    try{ 
		                    	 try {
									Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
								} catch (ClassNotFoundException e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
		                         System.out.println("驱动程序连接成功！");
		                         Connection con = DriverManager.getConnection(RL,"sa","5436.......");
		                         System.out.println("数据库连接成功！！");
		                         sm = con.createStatement();
		            //--------------------------------------------------------------------------------------------------------------------------------------//                          
		                         /* 演示1 ：查看 表Student             
		                         Statement st = con.createStatement();
		                         ResultSet rs = st.executeQuery(sqlStr);
		                         System.out.println("操作数据库成功！！！");

		                         System.out.println(" ----------------------------------------------------------------------------------------------------------------");
		                         
		                         while(rs.next()) {
		                        	 System.out.println(" | " + "\t" + rs.getString("Sno") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Ssex") + "\t" + " | " + "\t" + rs.getInt("Sage") + "\t" + " | " + "\t" + rs.getString("Sdept")  + " | ");
		                             System.out.println(" ----------------------------------------------------------------------------------------------------------------");
		                         }
		                         
		                         rs.close();
		                         */
		            //--------------------------------------------------------------------------------------------------------------------------------------//             
		                         
		                         //获取当前时间(精确到毫秒)
		                         Calendar cal = Calendar.getInstance(); 
		                         Date date = cal.getTime();
		                         //  2016/05/05-01:01:34:364
		                         String rtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		                         
		                         String sql = "use 郑烁彬_sj"+"\n"+"select Tprice from Ticket where Tno = "+"\'"+tno.getText()+"\'"; 	//读取数据库数据  
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
		                         		                   +" and Passenger.RorB = '预定'"
                                         				   +" delete from Passenger"
                                         				   +" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
                                         				   +" and Passenger.Pname = "+"\'"+name.getText()+"\'"
                                         				   +" and Passenger.Pid = "+"\'"+id.getText()+"\'"
                                         				   +" and Passenger.Pnum	= "+"\'"+num.getText()+"\'" 
                                         				   +" and Passenger.RorB = '预定'"
                                         				    
                                         				    +" insert into Refund(Rno,Pname,Pid,Pnum,Rprice,Rtime) "
               		                   						+" select Passenger.Tno,Passenger.Pname,Passenger.Pid,Passenger.Pnum,Ticket.Tprice,"+"\'"+rtime+"\'"
               		                   						+" from Passenger,Ticket"
               		                   						+" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
               		                   						+" and Passenger.Pname = "+"\'"+name.getText()+"\'"
               		                   						+" and Passenger.Pid = "+"\'"+id.getText()+"\'"
               		                   						+" and Passenger.Pnum = "+"\'"+num.getText()+"\'"
               		                   						+" and Passenger.RorB = '购买'"
               		                   						+" and Passenger.Tno = Ticket.Tno"
               		                   						+" delete from Passenger"
               		                   						+" where Passenger.Tno = "+"\'"+tno.getText()+"\'"
               		                   						+" and Passenger.Pname = "+"\'"+name.getText()+"\'"
               		                   						+" and Passenger.Pid = "+"\'"+id.getText()+"\'"
               		                   						+" and Passenger.Pnum = "+"\'"+num.getText()+"\'" 
               		                   						+" and Passenger.RorB = '购买'");
		                         
		                         if(i0 == 1){
		                        	 dispose();
		                        	 Object[] options ={"确定"};  //自定义按钮上的文字
		                        		 int a = JOptionPane.showOptionDialog(null,
		                        				 			"———— 退票成功 ————" +"\n\n\t票号："+tno.getText()
		                        				 			+"\n\t姓名："+name.getText()+"\n\t身份证号："+id.getText()
		                        				 			+"\n\t手机号："+num.getText()+"\n\t应退款："+tprice+"\n\t退款时间："+rtime,
		                        				 				"操作结果",JOptionPane.YES_OPTION, 
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
		                        	 Object[] options ={"重新输入"};  //自定义按钮上的文字
		                        	 JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.NO_OPTION,0,null, options, null); 
		    			              tno.setText("");
		    			              name.setText("");
		    			              id.setText("");
		    			              num.setText("");
		             			 }
		             			 
		            //--------------------------------------------------------------------------------------------------------------------------------------//             
		                         /* 演示3 ： 更新Student表中数据
		                         int i = sm.executeUpdate("update Student set Sno = '201835555' where Sname = 'UnseeR'");
		                         if(i==1){
		             				System.out.println("数据更新成功！！！！");
		             			 }
		                         else{
		             				System.out.println("数据更新失败！！！！！");
		             			 }

		                         sm.close();
		                         */
		            //--------------------------------------------------------------------------------------------------------------------------------------//             
		                         /* 演示4 ： 删除Student表中数据 
		                         int i = sm.executeUpdate("delete from Student where Sno = '201835555'");
		                         if(i==1){
		             				System.out.println("数据删除成功！！！！");
		             			 }
		                         else{
		             				System.out.println("数据删除失败！！！！！");
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
			            //JOptionPane.showConfirmDialog(null, "———— 提交成功 ————", null, JOptionPane.OK_OPTION);
		            }else if(tno.getText().equals("") == true && name.getText().equals("") == true && id.getText().equals("") == true && num.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————");
			            psubmit.requestFocusInWindow();
			            //JOptionPane.showConfirmDialog(null, "———— 必填项不可为空 ————", null, JOptionPane.OK_OPTION);
		            }else {
		            	JOptionPane.showMessageDialog(null, "———— 输入有误！请重新输入————");
			            psubmit.requestFocusInWindow();
			            //JOptionPane.showConfirmDialog(null, "———— 输入有误！请重新输入————", null, JOptionPane.OK_OPTION);
		            }
		            try {
		                this.repaint();
		            } catch (Exception ep) {
		                System.out.println("输入有误：" + ep);
		            }
	            
	        } else if (e.getSource() == prefresh) {
	            dispose();
	            new prefund().setBounds(750,50,576,650);      // 刷新
	        }else if (e.getSource() == pexit) {
	            pexit.setBackground(Color.red);        // 红色退出
	            System.exit(0);
	        }else if (e.getSource() == phome) {
	            phome.setBackground(Color.green);      // 绿色主页
	            dispose();
	        	new homepage().setBounds(750,50,592,660);
	        }else if (e.getSource() == pback) {
	            pback.setBackground(Color.yellow);     // 绿色返回
	            dispose();
	        	new porgr().setBounds(750,50,576,650);
	        }else if (e.getSource() == preset) {
	            preset.setBackground(Color.getHSBColor(51, 72, 71));     // 黑色清空
	            tno.setText("");
	            name.setText("");
	            id.setText("");
	            num.setText("");
	        }else if (e.getSource() == preset1) {      // 票号清空
	            tno.setText("");
	        }else if (e.getSource() == preset2) {      // 姓名清空
	            name.setText("");
	        }else if (e.getSource() == preset3) {      // 身份证号清空
	            id.setText("");
	        }else if (e.getSource() == preset4) {      // 手机号清空
	            num.setText("");
	        }
	      //菜单栏事件
	        String look = "javax.swing.plaf.metal.MetalLookAndFeel";
			if (e.getSource() == jfstyle1) {
				look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";   // window风格
			}else if(e.getSource()== jfstyle2) {
				look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";       // Linux风格
			}else if(e.getSource()== jfstyle3) {
				look = "javax.swing.plaf.metal.MetalLookAndFeel";              // java风格
			}else if(e.getSource()== sub1) {
				JOptionPane.showConfirmDialog(null, "！！！系统选入成功！！！", null, JOptionPane.OK_OPTION);
				dispose();
				new homepage().setBounds(750,50,592,660);
			}else if (e.getSource()== sub2) {
				JOptionPane.showConfirmDialog(null, "！！！该系统不存在！！！", null, JOptionPane.OK_OPTION);
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
