package 课程设计;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class cqpage extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
		//菜单栏
		JMenuBar menubar;
		JMenu menu,submenu,settings,jfstyle;
		JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
		
		//标签背景
		private JPanel imagePanel;
	    private ImageIcon background;
	    
		//主页组件
		JLabel jl;
		JFrame jf;
		Container con;
		Connection Con ;
		JComboBox<String> ccp;
		String[] ccp0 = new String[]{"车辆（Coach）","站点（City）","发车时间（Ctime）","车票（Ticket）","乘客（Passenger）","退票（Refund）","————  请选择  ————"};
		JButton ccrefresh,cchome,ccback,ccexit;
		Statement sql;
		ResultSet coachrs,cityrs,timers,ticketrs,passengerrs,refundrs;
    	String RL = "jdbc:sqlserver://localhost:1433;";
		
		//车辆
		JLabel jl0;
		String coachsql = "use 郑烁彬_sj "+"\n"+" select * from Coach";
		String [] coachcolumn;
		String [][] coachrecord;
		String coachhead[] = {"车次","座位数","负责人"};
		String [] coachHead;
		String [][] coachcontent;
		Statement coachSql;
		JTable coachtable;
		JScrollPane coachTable ;

		//站点
		JLabel jl1;
		String citysql = "use 郑烁彬_sj "+"\n"+" select * from City";
		String [] citycolumn;
		String [][] cityrecord;
		String cityhead[] = {"站名","车次","里程（公里）","起始地点","目标地点"};
		String [] cityHead;
		String [][] citycontent;
		Statement citySql;
		JTable citytable;
		JScrollPane cityTable ;
		
		//发车时间
		JLabel jl2;
		String timesql = "use 郑烁彬_sj "+"\n"+" select * from CTime";
		String [] timecolumn;
		String [][] timerecord;
		String timehead[] = {"站名","车次","发车时间"};
		String [] timeHead;
		String [][] timecontent;
		Statement timeSql;
		JTable timetable;
		JScrollPane timeTable ;
		
		//车票
		JLabel jl3;
		String ticketsql = "use 郑烁彬_sj "+"\n"+" select * from Ticket";
		String [] ticketcolumn;
		String [][] ticketrecord;
		String tickethead[] = {"票号","站名","车次","发车时间","票价","剩余票数"};
		String [] ticketHead;
		String [][] ticketcontent;
		Statement ticketSql;
		JTable tickettable;
		JScrollPane ticketTable ;

		
		//乘客
		JLabel jl5;
		String passengersql = "use 郑烁彬_sj "+"\n"+" select * from Passenger";
		String [] passengercolumn;
		String [][] passengerrecord;
		String passengerhead[] = {"票号","乘客姓名","身份证号","手机号","预定或已购","座位号"};
		String [] passengerHead;
		String [][] passengercontent;
		Statement passengerSql;
		JTable passengertable;
		JScrollPane passengerTable ;
				
		//退票
		JLabel jl6;
		String refundsql = "use 郑烁彬_sj "+"\n"+" select * from Refund";
		String [] refundcolumn;
		String [][] refundrecord;
		String refundhead[] = {"票号","乘客姓名","身份证号","手机号","应退款","退票时间"};
		String [] refundHead;
		String [][] refundcontent;
		Statement refundSql;
		JTable refundtable;
		JScrollPane refundTable ;
		
		public cqpage() {
	    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\售票员查询数据.png");             // 背景图片
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
			
			// 窗口大小改变
			this.setResizable(true);
			 
			this.setTitle("小生的车站售票系统");               //函数设立标题
			
			// 居中显示
			this.setLocationRelativeTo(null);
			
			// 可见
			this.setVisible(true);

			// 创建一个容器
			jf = this;
			con = jf.getContentPane();
			
			//调用函数
			init();
			aqpage1();
			
			
			coach0();
			city0();
			time0();
			ticket0();
			passenger0();
			refund0();
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
		void aqpage1() {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           		}
           	catch (ClassNotFoundException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				System.out.println("驱动程序连接失败！");
           		}
			//创建下拉列表框
			ccp = new JComboBox<String>(ccp0);
			
		    //下拉列表进行选择添加
			jl = new JLabel();
			jl.setBounds(0, 0, 576, 660);

			ccp.setBounds(188, 68, 200, 30);
			ccp.setMaximumRowCount(4);
			ccp.setSelectedItem(ccp0[6]);
		    ccp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ccp.getSelectedItem() == ccp0[0]) {
						jl0.add(coachTable);
						
						jl0.setVisible(true);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl5.setVisible(false);
						jl6.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[1]){
						jl1.add(cityTable);
						
						jl0.setVisible(false);
						jl1.setVisible(true);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl5.setVisible(false);
						jl6.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[2]){
						jl2.add(timeTable);
						
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(true);
						jl3.setVisible(false);
						jl5.setVisible(false);
						jl6.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[3]){
						jl3.add(ticketTable);
						
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(true);
						jl5.setVisible(false);
						jl6.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[4]){
						jl5.add(passengerTable);
						
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl5.setVisible(true);
						jl6.setVisible(false);
						}
					else if(ccp.getSelectedItem() == ccp0[5]){
						jl6.add(refundTable);
						
						jl0.setVisible(false);
						jl1.setVisible(false);
						jl2.setVisible(false);
						jl3.setVisible(false);
						jl5.setVisible(false);
						jl6.setVisible(true);
						}
					else{
						ccp.removeItemAt(6);
						}
				}
				
			});

			//刷新按钮
			ccrefresh = new JButton("刷新");
			ccrefresh.setBounds(94, 68, 85, 30);
		    ccrefresh.addActionListener(this);

			//返回上一页按钮
		    ccback = new JButton("返回");
		    ccback.setBounds(397, 68, 85, 30);
		    ccback.addActionListener(this);
			

			//返回主页按钮
			cchome = new JButton("主页");
			cchome.setBounds(0, 68, 85, 30);
			cchome.addActionListener(this);
			cchome.setForeground(Color.blue);
			
			//退出程序按钮
			ccexit = new JButton("退出");
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
		
		//车辆组件
		void coach0() {
			jl0 = new JLabel();
			jl0.setBounds(0, 0, 576, 562);
			coach1();

			coachcontent = coachrecord;
			coachHead = coachcolumn;
			coachtable = new JTable(coachcontent,coachHead);
			coachTable = new JScrollPane(coachtable);
			coachTable.setBounds(0,150,576,408);

			jl0.add(coachTable);
			con.add(jl0);
			
		}			
		void coach1() {
			try {
				Con = DriverManager.getConnection(RL,"sa","5436.......");
				coachSql = Con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				coachrs = coachSql.executeQuery(coachsql);
				ResultSetMetaData coachData = coachrs.getMetaData();
				int coachcolumnCount = coachData.getColumnCount();
				coachcolumn = new String[coachcolumnCount];
				for(int i = 1;i <= coachcolumnCount;i ++)
				{
					coachcolumn[i - 1] = coachhead[i - 1];
				}
				coachrs.last();
				int coachrecordAmount = coachrs.getRow();
				coachrecord = new String[coachrecordAmount][coachcolumnCount];
				int i = 0;
				coachrs.beforeFirst();
				while(coachrs.next()) {
					for(int j = 1;j <= coachcolumnCount;j ++) {
						coachrecord[i][j -1] =coachrs.getString(j);
					}
					i ++;
				}
				coachrs.close();
				Con.close();
				}
			catch(SQLException e) {
				System.out.println("coach表" + e + "有误！请输入正确的表名！！");
				}
			}
		
		//站点组件
		void city0() {
			jl1 = new JLabel();
			jl1.setBounds(0, 0, 576, 562);
			city1();
			
			citycontent = cityrecord;
			cityHead = citycolumn;
			citytable = new JTable(citycontent,cityHead);
			cityTable = new JScrollPane(citytable);
			cityTable.setBounds(0,150,576,408);
			
			con.add(jl1);
		}
		void city1() {
			try {
				Con = DriverManager.getConnection(RL,"sa","5436.......");
				citySql = Con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				cityrs = citySql.executeQuery(citysql);
	            ResultSetMetaData cityData = cityrs.getMetaData();
	            int citycolumnCount = cityData.getColumnCount();
	            citycolumn = new String[citycolumnCount];
	            for(int i = 1;i <= citycolumnCount;i ++)
	            {
	            	citycolumn[i - 1] = cityhead[i - 1];
	            }
	            cityrs.last();
	            int cityrecordAmount = cityrs.getRow();
	            cityrecord = new String[cityrecordAmount][citycolumnCount];
	            int i = 0;
	            cityrs.beforeFirst();
	            while(cityrs.next()) {
	            	for(int j = 1;j <= citycolumnCount;j ++) {
	            		cityrecord[i][j -1] =cityrs.getString(j);
	            	}
	            	i ++;
	            }
	            cityrs.close();
	            Con.close();
			}
		catch(SQLException e) {
				System.out.println("city表" + e + "有误！请输入正确的表名！！");
			}
		}

		//发车时间组件
		void time0() {
			jl2 = new JLabel();
			jl2.setBounds(0, 0, 576,562);
			time1();
			
			timecontent = timerecord;
			timeHead = timecolumn;
			timetable = new JTable(timecontent,timeHead);
			timeTable = new JScrollPane(timetable);
			timeTable.setBounds(0,150,576,408);
			
			con.add(jl2);
		}		
		void time1() {
			try {
				Con = DriverManager.getConnection(RL,"sa","5436.......");
				timeSql = Con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				timers = timeSql.executeQuery(timesql);
	            ResultSetMetaData timeData =timers.getMetaData();
	            int timecolumnCount = timeData.getColumnCount();
	            timecolumn = new String[timecolumnCount];
	            for(int i = 1;i <= timecolumnCount;i ++)
	            {
	            	timecolumn[i - 1] = timehead[i - 1];
	            }
	            timers.last();
	            int timerecordAmount = timers.getRow();
	            timerecord = new String[timerecordAmount][timecolumnCount];
	            int i = 0;
	            timers.beforeFirst();
	            while(timers.next()) {
	            	for(int j = 1;j <= timecolumnCount;j ++) {
	            		timerecord[i][j -1] =timers.getString(j);
	            	}
	            	i ++;
	            }
	            timers.close();
	            Con.close();
			}
			catch(SQLException e) {
				System.out.println("time表" + e + "有误！请输入正确的表名！！");
			}
		}
		
		//车票组件
		void ticket0() {
			jl3 = new JLabel();
			jl3.setBounds(0, 0, 576, 562);
			ticket1();

			ticketcontent = ticketrecord;
			ticketHead = ticketcolumn;
			tickettable = new JTable(ticketcontent,ticketHead);
			ticketTable = new JScrollPane(tickettable);
			ticketTable.setBounds(0,150,576,408);
			
			con.add(jl3);
		};
		void ticket1() {
			try {
				Con = DriverManager.getConnection(RL,"sa","5436.......");
				ticketSql = Con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ticketrs = ticketSql.executeQuery(ticketsql);
	            ResultSetMetaData ticketData =ticketrs.getMetaData();
	            int ticketcolumnCount = ticketData.getColumnCount();
	            ticketcolumn = new String[ticketcolumnCount];
	            for(int i = 1;i <= ticketcolumnCount;i ++)
	            {
	            	ticketcolumn[i - 1] = tickethead[i - 1];
	            }
	            ticketrs.last();
	            int ticketrecordAmount = ticketrs.getRow();
	            ticketrecord = new String[ticketrecordAmount][ticketcolumnCount];
	            int i = 0;
	            ticketrs.beforeFirst();
	            while(ticketrs.next()) {
	            	for(int j = 1;j <= ticketcolumnCount;j ++) {
	            		ticketrecord[i][j -1] =ticketrs.getString(j);
	            	}
	            	i ++;
	            }
	            ticketrs.close();
	            Con.close();
			}
			catch(SQLException e) {
				System.out.println("ticket表" + e + "有误！请输入正确的表名！！");
			}
		}
		
		//售票员组件
		void passenger0() {
			jl5 = new JLabel();
			jl5.setBounds(0, 0, 576, 562);
			passenger1();
			
			passengercontent = passengerrecord;
			passengerHead = passengercolumn;
			passengertable = new JTable(passengercontent,passengerHead);
			passengerTable = new JScrollPane(passengertable);
			passengerTable.setBounds(0,150,576,408);
					
			con.add(jl5);
		}
		void passenger1() {
			try {
				Con = DriverManager.getConnection(RL,"sa","5436.......");
				passengerSql = Con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				passengerrs = passengerSql.executeQuery(passengersql);
			    ResultSetMetaData passengerData =passengerrs.getMetaData();
			    int passengercolumnCount = passengerData.getColumnCount();
			    passengercolumn = new String[passengercolumnCount];
			    for(int i = 1;i <= passengercolumnCount;i ++)
			    {
			    	passengercolumn[i - 1] = passengerhead[i - 1];
			    }
			    passengerrs.last();
			    int passengerrecordAmount = passengerrs.getRow();
			    passengerrecord = new String[passengerrecordAmount][passengercolumnCount];
			    int i = 0;
			    passengerrs.beforeFirst();
			    while(passengerrs.next()) {
			    	for(int j = 1;j <= passengercolumnCount;j ++) {
			    		passengerrecord[i][j -1] =passengerrs.getString(j);
			    	}
			    	i ++;
			    }
			    passengerrs.close();
			    Con.close();
						}
						catch(SQLException e) {
							System.out.println("passenger表" + e + "有误！请输入正确的表名！！");
						}
					}
				
		//退票组件
		void refund0() {
			jl6 = new JLabel();
			jl6.setBounds(0, 0, 576, 562);
			refund1();
			
			refundcontent = refundrecord;
			refundHead = refundcolumn;
			refundtable = new JTable(refundcontent,refundHead);
			refundTable = new JScrollPane(refundtable);
			refundTable.setBounds(0,150,576,408);
					
			con.add(jl6);
		}
		void refund1() {
			try {
				Con = DriverManager.getConnection(RL,"sa","5436.......");
				refundSql = Con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				refundrs = refundSql.executeQuery(refundsql);
				ResultSetMetaData refundData = refundrs.getMetaData();
				int refundcolumnCount = refundData.getColumnCount();
				refundcolumn = new String[refundcolumnCount];
				for(int i = 1;i <= refundcolumnCount;i ++)
				{
					refundcolumn[i - 1] = refundhead[i - 1];
				}
				refundrs.last();
				int refundrecordAmount = refundrs.getRow();
				refundrecord = new String[refundrecordAmount][refundcolumnCount];
				int i = 0;
				refundrs.beforeFirst();
				while(refundrs.next()) {
					for(int j = 1;j <= refundcolumnCount;j ++) {
						refundrecord[i][j -1] =refundrs.getString(j);
					}
					i ++;
				}
				refundrs.close();
				Con.close();
			}
			catch(SQLException e) {
				System.out.println("refund表" + e + "有误！请输入正确的表名！！");
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      		}
	        catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
				e1.printStackTrace();
				System.out.println("驱动程序连接失败！");
	       		}
		        if (e.getSource() == ccexit) {
		        	ccexit.setBackground(Color.red);        // 红色退出
		            System.exit(0);
		        }else if (e.getSource() == cchome) {
		        	cchome.setBackground(Color.green);      // 绿色主页
		        	dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == ccback) {
		        	ccback.setBackground(Color.yellow);     // 绿色返回
		            dispose();
		        	new afunctionpage().setBounds(750,50,592,660);
		        }else if(e.getSource() == ccrefresh) {
		        	dispose();
			        new cqpage().setBounds(750,50,592,660);      // 刷新
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
