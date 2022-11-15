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

public class administrator extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	//菜单栏
			JMenuBar menubar;
			JMenu menu,submenu,settings,jfstyle;
			JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
		
		//标签背景
		private JPanel imagePanel;
	    private ImageIcon background;
	    
		//管理员登录页面
		private JLabel jl,jl1,jl2;
		private JTextField ano;
		private JPasswordField apd;
		
		//提交、返回主页、返回上一页、退出程序按钮,清空按钮
		JButton arefresh,alogin,aback,ahome,aexit,areset,areset1,areset2;
		
		public administrator() {
	    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\管理员.png");             // 背景图片
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
			
			// 设置窗体的标题图标
			// Image image = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\小生.ico").getImage();
			// this.setIconImage(image);
			
			// 窗口大小改变
			this.setResizable(true);
			
			//   JLabel.setFont(new Font("微软雅黑", 0, 16));    //设置字体
			//   UIManager.put("Button.font", new java.awt.Font("宋体", 0, 12));
			 
			this.setTitle("小生的车站售票系统");               //函数设立标题
			
			// 居中显示
			this.setLocationRelativeTo(null);
			
			// 可见
			this.setVisible(true);
			
			//调用函数
			init();
			administrator1();
			
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
		void administrator1() {
			
			// 创建一个容器
			JFrame jf = this;
			Container con = jf.getContentPane();
			
			// 设置总体标签容器
			jl = new JLabel();
		    jl.setBounds(0, 0, 576, 500);
			
			//账号输入框
			jl1 = new JLabel("账  号：");
			jl1.setBounds(100, 130, 70, 20);
			ano = new JTextField(20);
			ano.setBounds(200, 130, 165, 20);
			//账号清空按钮
			areset1 = new JButton("清空");
			areset1.setBounds(400, 130, 70, 20);
		    areset1.addActionListener((ActionListener) this);
			areset1.setForeground(Color.GREEN);
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
			
			//密码输入框
			jl2 = new JLabel("密   码：");
			jl2.setBounds(100, 160, 70, 20);
			apd = new JPasswordField(20);
			apd.setBounds(200, 160, 165, 20);
			apd.setEchoChar('*');          // 星星回显符号
			//密码清空按钮
			areset2 = new JButton("清空");
			areset2.setBounds(400, 160, 70, 20);
		    areset2.addActionListener(this);
			areset2.setForeground(Color.GREEN);
			
			/*
			// 密码设置了回显字符，需要获取用户输入的内容，所以添加动作监听
			apd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					char ch[] = apd.getPassword();
					String str = new String(ch);
					System.out.println(str);
				}
			});
			*/

			//刷新按钮
			arefresh = new JButton("刷新");
			arefresh.setBounds(0, 100, 70, 25);
		    arefresh.addActionListener(this);
			
			//登录按钮
			alogin = new JButton("登录");
			alogin.setBounds(160, 280, 70, 25);
			//登录判断事件
			alogin.addActionListener(this); 

				
			//返回上一页按钮
			aback = new JButton("返回");
			aback.setBounds(330, 280, 70, 25);
			aback.addActionListener(this);
			
			//清空按钮
			areset = new JButton("清空");
			areset.setBounds(245, 300, 70, 25);
		    areset.addActionListener(this);
			areset.setForeground(Color.GREEN);

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
			jl.add(arefresh);
			jl.add(alogin);
			jl.add(ahome);
			jl.add(aback);
			jl.add(aexit);
			jl.add(areset);
			jl.add(areset1);
			jl.add(areset2);
			con.add(jl);
			con.add(ano);
			con.add(apd);
		}
			
		    //按钮点击后触发事件
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == alogin) {
		            alogin.setBackground(Color.blue);      // 蓝色登录
		            if (ano.getText().equals("") == true && apd.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
					} else if (ano.getText().equals("") == false && apd.getText().equals("") == true) {
						JOptionPane.showMessageDialog(null, "———— 密码不可为空 ————", "操作有误", JOptionPane.OK_OPTION);
					} else if (ano.getText().equals("") == true && apd.getText().equals("") == false) {
						JOptionPane.showMessageDialog(null, "———— 账号不可为空 ————", "操作有误", JOptionPane.OK_OPTION);
					} else if (ano.getText().equals("") == false && apd.getText().equals("") == false) {
						Statement sm = null;
		            	String RL = "jdbc:sqlserver://localhost:1433;";
			           	String sql = "use 郑烁彬_sj"+"\n"+"select Apd from Administrator where Ano = "+"\'"+ano.getText()+"\';"; 	//读取数据库数据  
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
				           		if(rs.getString("Apd").equals(apd.getText())) {
				           			JOptionPane.showMessageDialog(null, "———— 登录成功 ————", "操作结果", JOptionPane.INFORMATION_MESSAGE);
				           			dispose();
				           			new afunctionpage().setBounds(750,50,592,660);
				           			}
				           		else{
				           			JOptionPane.showMessageDialog(null, "———— 登录失败,输入错误 ————", "操作结果", JOptionPane.WARNING_MESSAGE);
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
					}
		
		        } else if (e.getSource() == aexit) {
		            aexit.setBackground(Color.red);        // 红色退出
		            System.exit(0);
		        }else if (e.getSource() == arefresh) {
		            dispose();
		            new administrator().setBounds(750,50,592,660);      // 刷新
		        }else if (e.getSource() == ahome) {
		            ahome.setBackground(Color.green);      // 绿色主页
		        	dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == aback) {
		            aback.setBackground(Color.yellow);     // 绿色返回
		            dispose();
		        	new homepage().setBounds(750,50,592,660);
		        }else if (e.getSource() == areset) {
		            areset.setBackground(Color.getHSBColor(51, 72, 71));     // 黑色清空
		            ano.setText("");
		            apd.setText("");
		        }else if (e.getSource() == areset1) {      // 账号清空
		            ano.setText("");
		        }else if (e.getSource() == areset2) {      // 密码清空
		            apd.setText("");
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
