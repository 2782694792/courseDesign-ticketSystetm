package 课程设计;
import javax.swing.*;  //提供组件类

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
public class porg extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//菜单栏
	private JMenuBar menubar;
	private JMenu menu,submenu,settings,jfstyle;
	private JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//标签背景
	private JPanel imagePanel;
    private ImageIcon background;
    
	//主页选项页面
    private JLabel jl;
	private JButton personalrorb,grouprorb;
	
	//主页、退出程序、返回、刷新按钮
	private JButton pghome,pgexit,pgback,pgrefresh;
	
	public porg() {
    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\预购.png");             // 背景图片
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
		porg1();
		
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
	void porg1() {
		
		// 创建一个容器
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// 设置总体标签容器
		jl = new JLabel();
	    jl.setBounds(0, 0, 576, 500);
		
		//预购按钮
	    personalrorb = new JButton("个    人");
	    personalrorb.setBounds(235, 200, 100, 50);
	    personalrorb.addActionListener(this);
		
		//查询按钮
	    grouprorb = new JButton("团    队");
	    grouprorb.setBounds(235, 270, 100,50);
	    grouprorb.addActionListener(this);

		//主页按钮
		pghome = new JButton("主页");
		pghome.setBounds(50, 100, 70, 30);
		pghome.addActionListener(this);
		pghome.setForeground(Color.blue);
		
		//退出程序按钮
		pgexit = new JButton("退出");
		pgexit.setBounds(450, 100, 70, 30);
		pgexit.addActionListener(this);
		pgexit.setForeground(Color.red);
		
		//主页按钮
		pgrefresh = new JButton("刷新");
		pgrefresh.setBounds(150, 350, 70, 30);
		pgrefresh.addActionListener(this);
				
		//退出程序按钮
		pgback = new JButton("返回");
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
		 if (isSelected) {//如果选择了这个项
			 background = Color.BLUE;//背景色设置为蓝色（填充颜色）
			 foreground = Color.WHITE;//前景色设置为白色（字体颜色）
			 // unselected, and not the DnD drop location
			 } else {
			 background = Color.WHITE;//背景色设置为白色
			 foreground = Color.BLACK;//前景色设置为黑色
			 }
	    */
		
	    //按钮点击后触发事件
		public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == pghome) {
	        	pghome.setBackground(Color.getHSBColor(209, 224, 239));             // 蓝色主页
	        	dispose();
	        	new homepage().setBounds(750,50,592,660);
	        } else if (e.getSource() == pgexit) {
	        	pgexit.setBackground(Color.getHSBColor(237, 98, 98));              // 红色退出
	            System.exit(0);
	        }else if (e.getSource() == personalrorb) {
	        	personalrorb.setBackground(Color.green);       // 绿色个人
	            dispose();
	            new personal().setBounds(750,50,576,650);
	        }else if (e.getSource() == grouprorb) {
	        	grouprorb.setBackground(Color.yellow);      // 黄色团队
	        	dispose();
	        	new group().setBounds(750,50,576,650);
	        	
	        	/*
		    	JDialog jd = new JDialog();
		    	jd.setBounds(800,250,250,100);
		    	jd.setTitle("团队乘客数");
		        jd.getContentPane().setLayout(new GridLayout(2,2));
		    	jd.add(new JLabel("请输入总人数"));
		    	jdt = new JTextField(80);
		    	jd.add(jdt);
		        
		    	jds = new JButton("提交");
		    	jd.add(jds);
		    	jdb = new JButton("返回");
		    	jd.add(jdb);
		    	jdb.addActionListener(this);
		    	
		    	jds.addActionListener(new ActionListener()//监听器
		    	{
					@Override
					public void actionPerformed(ActionEvent e) {
						int jdt_int = Integer.parseInt(jdt.getText());
						if(jdt_int > 1){
							// TODO 自动生成的方法存根
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
							// TODO 自动生成的方法存根

							jd.dispose();
							group groupit = new group();
							groupit.setBounds(750,50,576,650);
						}else {
							Object[] options ={"重新输入"};  //自定义按钮上的文字
							JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.NO_OPTION,0,null, options, null);
							jdt.setText("");
							}
						}
						
		    	});
		    	
		    	jdb.addActionListener(new ActionListener()//监听器
		    	{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jd.dispose();
						new porg().setBounds(750,50,576,650);
					}
		    	});
		    	
		    	jd.setModal(true);              //确保弹出的窗口在其他窗口前面
		    	jd.setVisible(true);
		    	
					*/
            }else if (e.getSource() == pgrefresh) {
	        	pgrefresh.setBackground(Color.blue);     // 蓝色刷新
	            dispose();
	        	new porg().setBounds(750,50,576,650);
	        }else if (e.getSource() == pgback) {
	        	pgback.setBackground(Color.getHSBColor(51, 72, 71));     // 灰色返回
	            dispose();
	        	new passenger().setBounds(750,50,576,650);
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
