package 课程设计;
import javax.swing.*;  //提供组件类

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
	//菜单栏
		JMenuBar menubar;
		JMenu menu,submenu,settings,jfstyle;
		JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//标签背景
	private JPanel imagePanel;
    private ImageIcon background;
    
	//主页面
    private JLabel jl,jl1,jl2,sqljl1,sqljl2,sqljl3,sqljl4;
    private JTextField sno,sql1,sql2,sql3,sql4;
    private JPasswordField spd;
	JButton zsbreset,sreset1,sreset2,sqlback,sqlalogin,sqlenter,sqlback2;
	

    static JLabel jlre;
    //登录、刷新、退出程序按钮
	JButton zsbalogin,zsbexit,zsbrefresh;
	
	public zhengshuobin() {
    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\标题.png");             // 背景图片
    	JLabel label = new JLabel(background);       //把背景图片显示在一个标签里面
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());        // 把标签的大小位置设置为图片刚好填充整个面板
       
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().setLayout(null);
        
        // 把背景图片添加到分层窗格的最底层作为背景
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        this.setSize(background.getIconWidth(), background.getIconHeight());
        
    	this.setTitle("小生的车站售票系统");                //函数设立标题
    	
		// 设置布局方式为绝对定位
		this.setLayout(null);

		// 窗口大小改变
		this.setResizable(true);

		// 窗口组件初始化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		// 设置布局方式为绝对定位
		this.setLocationRelativeTo(null);
		
		// 可见
		this.setVisible(true);
		
		//调用函数
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
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				System.out.println("驱动程序连接失败！");
           		}
           	DriverManager.getConnection(RL,"sa","5436.......");
           	} 
        catch(SQLException err){
           		err.printStackTrace(System.out);
           		System.out.println("数据库连接失败！！");
           	}
        Object[] options ={"确定"};          //自定义按钮上的文字
        int a = JOptionPane.showOptionDialog(null,
        		"———— 数据库连接成功 ————", "操作结果",JOptionPane.YES_OPTION, 1, null, options, null); 
        if(a == JOptionPane.YES_OPTION) {
        	dispose();
        	new homepage().setBounds(750,50,576,650);
        }
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
		submenu.addSeparator();             //添加分隔线
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
	void zhengshuobin1() {
		
		// 创建一个容器
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// 设置总体标签容器
		jl = new JLabel();
	    jl.setBounds(0,0,576,350);
		
	    //学号输入
	    jl1 = new JLabel("学    号:");
	    jl1.setBounds(100, 130, 70, 20);
	    sno = new JTextField(20);
	    sno.setBounds(200, 130, 165, 20);
		//学号清空按钮
		sreset1 = new JButton("清空");
		sreset1.setBounds(400, 130, 70, 20);
		sreset1.setForeground(Color.green);
		sreset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno.setText("");
			}
		});
		
		//密码输入
	    jl2 = new JLabel("密    码:");
	    jl2.setBounds(100, 160, 70, 20);
	    spd = new JPasswordField(20);
	    spd.setBounds(200, 160, 165, 20);
		spd.setEchoChar('*');          // 星星回显符号
		//密码清空按钮
		sreset2 = new JButton("清空");
		sreset2.setBounds(400, 160, 70, 20);
		sreset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spd.setText("");
			}
		});
		
		//清空按钮
		zsbreset = new JButton("清空");
		zsbreset.setBounds(338, 210, 100, 50);
		zsbreset.setForeground(Color.green);
		zsbreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno.setText("");
				spd.setText("");
			}
		});

		//刷新按钮
		zsbrefresh = new JButton("刷新");
		zsbrefresh.setBounds(0, 80, 70, 30);
		zsbrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new zhengshuobin().setBounds(750,50,592,400);
			}
		});

		//刷新按钮
		zsbalogin = new JButton("登录");
		zsbalogin.setBounds(138, 210, 100, 50);
		zsbalogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(sno.getText().equals("") == true && spd.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作结果", JOptionPane.WARNING_MESSAGE);
				}else if(sno.getText().equals("") == false && spd.getText().equals("") == true){
					JOptionPane.showMessageDialog(null, "———— 密码不可为空 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
	            	sno.requestFocusInWindow();
				}else if(sno.getText().equals("") == true && spd.getText().equals("") == false){
					JOptionPane.showMessageDialog(null, "———— 学号不可为空 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
	            	spd.requestFocusInWindow();
				}else if(sno.getText().equals("201835010349") == true && spd.getText().equals("201835010349") == true){
					JOptionPane.showMessageDialog(null, "———— 登录成功 ————", "操作结果", JOptionPane.INFORMATION_MESSAGE);
           			JDialog jd = new JDialog();
           			jd.setBounds(520,180,360,360);
           			jd.setTitle("进行数据库连接");
          			jd.getContentPane().setLayout(new GridLayout(5, 2));
           			sqljl1 = new JLabel("                     服务器名：");
           			sql1 = new JTextField(80);
           			sqljl2 = new JLabel("                     数据库名：");
           			sql2 = new JTextField(80);
           			sqljl3 = new JLabel("                     数据库用户：");
           			sql3 = new JTextField(80);
           			sqljl4 = new JLabel("                     数据库密码：");
           			sql4 = new JPasswordField(80);
           			sqlalogin = new JButton("登录");
           			sqlalogin.addActionListener(new ActionListener() {
           				public void actionPerformed(ActionEvent e2) {
           					if(sql1.getText().equals("") == true && sql2.getText().equals("") == true && sql3.getText().equals("") == true && sql4.getText().equals("") == true) {
           						JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作结果", JOptionPane.WARNING_MESSAGE);
           					}else if(sql1.getText().equals(".") == true && sql2.getText().equals("郑烁彬_sj") == true && sql3.getText().equals("sa") == true && sql4.getText().equals("5436.......") == true){
           						Timer timer = new Timer();
           						JDialog jd2 = new JDialog();
	           	           		jd2.setBounds(520,180,360,360);
	           	           		jd2.setTitle("———— 登录成功 ————");
           						sqlenter = new JButton("进行数据库连接");
           						sqlenter.addActionListener(new ActionListener() {
           	           				public void actionPerformed(ActionEvent e2) {
           	           					jd2.dispose(); 
           	           					jd.dispose();
           	           					dispose();
           	           					sqlcon();
           	           				}
           	           			});
           						sqlback2 = new JButton("返回");
           						sqlback2.addActionListener(new ActionListener() {
           	           				public void actionPerformed(ActionEvent e2) {
           	           					jd2.setVisible(false);
           	           				}
           	           			});
           						//设置字体
           						sqlenter.setFont(new java.awt.Font("幼圆", 1, 22));
           						sqlback2.setFont(new java.awt.Font("幼圆", 1, 22));
           						//“dialog”代表字体，1代表样式(1是粗体，0是平常的）15是字号
	           	         		jd2.getContentPane().setLayout(new GridLayout(2,2));
           						if (true) {
           							timer.schedule(new TimerTask() {
           								public void run() {
           								}
           							},200);
           						}
	           	          		jd2.add(sqlenter);
	           	          		jd2.add(sqlback2);
	           	           		jd2.setModal(true);//确保弹出的窗口在其他窗口前面
	           	           		jd2.setVisible(true);
           					}else {
           						JOptionPane.showMessageDialog(null, "———— 登录失败，请重新输入 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
           		            	sql1.requestFocusInWindow();
           					}
           				}
           			});
           			sqlback = new JButton("返回");
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
           			jd.setModal(true);//确保弹出的窗口在其他窗口前面
           			jd.setVisible(true);
				}else if(sno.getText().equals("201835010349") == false && spd.getText().equals("201835010349") == true){
					JOptionPane.showMessageDialog(null, "———— 学号错误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
	            	sno.requestFocusInWindow();
           			sno.setText("");
				}else if(sno.getText().equals("201835010349") == true && spd.getText().equals("201835010349") == true){
					JOptionPane.showMessageDialog(null, "———— 密码错误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
	            	spd.requestFocusInWindow();
           			spd.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "———— 输入不正确，请重新输入 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
	            	sno.requestFocusInWindow();
           			spd.setText("");
           			sno.setText("");
				}
			}
		});
		
		//退出程序按钮
		zsbexit = new JButton("退出");
		zsbexit.setBounds(506, 80, 70, 30);
		zsbexit.setForeground(Color.red);
		zsbexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	zsbexit.setBackground(Color.red);              // 红色退出
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
	    //按钮点击后触发事件
		public void actionPerformed(ActionEvent e) {
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
				new zhengshuobin().setBounds(750,50,592,660);
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
