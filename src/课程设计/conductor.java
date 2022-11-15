package 课程设计;

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

public class conductor extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
		//菜单栏
		JMenuBar menubar;
		JMenu menu,submenu,settings,jfstyle;
		JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
		
		//标签背景
		private JPanel imagePanel;
	    private ImageIcon background;
	    
		//管理员登录页面
		private JLabel jl,jl1,jl2,jl3;
		private JTextField csex;
		private JPasswordField cno,cname;
		
		//提交、返回主页、返回上一页、退出程序按钮,清空按钮
		JButton crefresh,alogin,aback,ahome,aexit,creset,creset1,creset2,creset3;
		
		public conductor() {
	    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\售票员.png");             // 背景图片
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
			conductor1();
			
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
		void conductor1() {
			
			// 创建一个容器
			JFrame jf = this;
			Container con = jf.getContentPane();
			
			// 设置总体标签容器
			jl = new JLabel();
		    jl.setBounds(0, 0, 576, 500);
			
			//工号输入框
			jl1 = new JLabel("工  号：");
			jl1.setBounds(100, 130, 70, 20);
			cno = new JPasswordField(10);
			cno.setBounds(200, 130, 165, 20);
			//工号清空按钮
			creset1 = new JButton("清空");
			creset1.setBounds(400, 130, 70, 20);
		    creset1.addActionListener(this);
			creset1.setForeground(Color.GREEN);
			
			//姓名输入框
			jl2 = new JLabel("姓   名：");
			jl2.setBounds(100, 160, 70, 20);
			cname = new JPasswordField(20);
			cname.setBounds(200, 160, 165, 20);
			//姓名清空按钮
			creset2 = new JButton("清空");
			creset2.setBounds(400, 160, 70, 20);
		    creset2.addActionListener(this);
			creset2.setForeground(Color.GREEN);
			
			//性别输入框
			jl3 = new JLabel("性   别：");
			jl3.setBounds(100, 190, 70, 20);
			csex = new JTextField(20);
			csex.setBounds(200, 190, 165, 20);
			//性别清空按钮
			creset3 = new JButton("清空");
			creset3.setBounds(400, 190, 70, 20);
		    creset3.addActionListener(this);
			creset3.setForeground(Color.GREEN);
			
			//刷新按钮
			crefresh = new JButton("刷新");
			crefresh.setBounds(0, 100, 70, 25);
		    crefresh.addActionListener(this);
			
			//登录按钮
			alogin = new JButton("登录");
			alogin.setBounds(160, 280, 70, 25);
			alogin.addActionListener(this);
			
			//返回上一页按钮
			aback = new JButton("返回");
			aback.setBounds(330, 280, 70, 25);
			aback.addActionListener(this);
			
			//清空按钮
			creset = new JButton("清空");
			creset.setBounds(245, 300, 70, 25);
		    creset.addActionListener(this);
			creset.setForeground(Color.GREEN);

			//返回主页按钮
			ahome = new JButton("主页");
			ahome.setBounds(160, 320, 70, 25);
			ahome.addActionListener(this);
			ahome.setForeground(Color.blue);
			
			//退出程序按钮
			aexit = new JButton("退出");
			aexit.setBounds(330, 320, 70, 25);
			aexit.addActionListener(this);
			aexit.setForeground(Color.red);
			
			jl.add(jl1);
			jl.add(jl2);
			jl.add(jl3);
			jl.add(crefresh);
			jl.add(alogin);
			jl.add(ahome);
			jl.add(aback);
			jl.add(aexit);
			jl.add(creset);
			jl.add(creset1);
			jl.add(creset2);
			jl.add(creset3);
			con.add(jl);
			con.add(cno);
			con.add(cname);
			con.add(csex);
		}
			
		    //按钮点击后触发事件
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == alogin) {
		            alogin.setBackground(Color.blue);      // 蓝色登录
		            if (cno.getText().equals("") == true && cname.getText().equals("") == true && csex.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.OK_OPTION);
					} else if (cno.getText().equals("") == false && cname.getText().equals("") == true && csex.getText().equals("") == false) {
						JOptionPane.showMessageDialog(null, "———— 姓名不可为空 ————", "操作有误", JOptionPane.OK_OPTION);
					} else if (cno.getText().equals("") == true && cname.getText().equals("") == false && csex.getText().equals("") == false) {
						JOptionPane.showMessageDialog(null, "———— 工号不可为空 ————", "操作有误", JOptionPane.OK_OPTION);
					} else if (cno.getText().equals("") == false && cname.getText().equals("") == false && csex.getText().equals("") == true) {
						JOptionPane.showMessageDialog(null, "———— 性别不可为空 ————", "操作有误", JOptionPane.OK_OPTION);
						csex.requestFocusInWindow();
					} else if (cno.getText().equals("") == false && cname.getText().equals("") == false && csex.getText().equals("") == false) {
						Statement sm = null;
		            	String RL = "jdbc:sqlserver://localhost:1433;";
			           	String sql = "use 郑烁彬_sj"+"\n"+"select Cno from Conductor where Cname = "+"\'"+cname.getText()+"\'"+" and Csex = "+"\'"+csex.getText()+"\'"; 	//读取数据库数据  
				        try{ 
				           	try {
								Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				           		}
				           	catch (ClassNotFoundException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
								System.out.println("驱动程序连接失败！");
				           		}
				           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
				           	sm = con.createStatement();
				           	ResultSet rs = sm.executeQuery(sql);
	                    
				           	while(rs.next()) {
				           		if(rs.getString("Cno").equals(cno.getText())) {
				           			JOptionPane.showMessageDialog(null, "———— 登录成功 ————", "操作结果", JOptionPane.INFORMATION_MESSAGE);
				           			dispose();
				           			new cfunctionpage().setBounds(750,50,592,660);
				           			}
				           		else{
				           			JOptionPane.showMessageDialog(null, "———— 登录失败,输入错误 ————", "操作结果", JOptionPane.WARNING_MESSAGE);
				           			cno.setText("");
				           			cname.setText("");
				           			csex.setText("");
				           			}
				           	}
				           	rs.close();
							sm.close();
				        	}
				        catch(SQLException err){
				        	err.printStackTrace(System.out);
							System.out.println("数据库连接失败！");
				        	}
						
					} else {
						JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
						cno.setText("");
						cname.setText("");
						csex.setText("");
					}
		        } else if (e.getSource() == aexit) {
		            aexit.setBackground(Color.red);        // 红色退出
		            System.exit(0);
		        }else if (e.getSource() == crefresh) {
		            dispose();
		            new conductor().setBounds(750,50,576,650);      // 刷新
		        }else if (e.getSource() == ahome) {
		            ahome.setBackground(Color.green);      // 绿色主页
		        	dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == aback) {
		            aback.setBackground(Color.yellow);     // 绿色返回
		            dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == creset) {
		            creset.setBackground(Color.getHSBColor(51, 72, 71));     // 黑色清空
		            cno.setText("");
		            cname.setText("");
		            csex.setText("");
		        }else if (e.getSource() == creset1) {      // 工号清空
		            cno.setText("");
		        }else if (e.getSource() == creset2) {      // 姓名清空
		            cname.setText("");
		        }else if (e.getSource() == creset3) {      // 性别清空
		            csex.setText("");
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
					JOptionPane.showConfirmDialog(null, "！！！系统选入成功！！！", null, JOptionPane.INFORMATION_MESSAGE);
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
