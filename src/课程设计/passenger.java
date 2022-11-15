package 课程设计;
import javax.swing.*;  //提供组件类

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
public class passenger extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//菜单栏
	JMenuBar menubar;
	JMenu menu,submenu,settings,jfstyle;
	JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//标签背景
	private JPanel imagePanel;
    private ImageIcon background;
    
	//主页选项页面
    private JLabel jl;
	JButton srorb,squery,srefund;
	
	//主页、退出程序、返回、刷新按钮
	JButton shome,sexit,sback,srefresh;
	
	personal pe;
	homepage he;
	
	public passenger() {
    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\乘客.png");             // 背景图片
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
		select1();
		
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

	
	void select1() {
		
		// 创建一个容器
		JFrame jf = this;
		Container con = jf.getContentPane();
		
		// 设置总体标签容器
		jl = new JLabel();
	    jl.setBounds(0, 0, 576, 500);
		
		//预购按钮
		srorb = new JButton("预定或购买");
		srorb.setBounds(235, 150, 100, 50);
		srorb.addActionListener(this);
		
		//查询按钮
		squery = new JButton("查    询");
		squery.setBounds(235, 220, 100,50);
		squery.addActionListener(this);
		
		//退票按钮
		srefund = new JButton("退    票");
		srefund.setBounds(235, 290, 100,50);
		srefund.addActionListener(this);

		//主页按钮
		shome = new JButton("主页");
		shome.setBounds(50, 100, 70, 30);
		shome.addActionListener(this);
		shome.setForeground(Color.blue);
		
		//退出程序按钮
		sexit = new JButton("退出");
		sexit.setBounds(450, 100, 70, 30);
		sexit.addActionListener(this);
		sexit.setForeground(Color.red);
		
		//主页按钮
		srefresh = new JButton("刷新");
		srefresh.setBounds(150, 350, 70, 30);
		srefresh.addActionListener(this);
				
		//退出程序按钮
		sback = new JButton("返回");
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
			//按钮事件
	        if (e.getSource() == shome) {
	        	shome.setBackground(Color.getHSBColor(209, 224, 239));             // 蓝色主页
	        	dispose();
	        	new homepage().setBounds(750,50,592,660);
	        } else if (e.getSource() == sexit) {
	            sexit.setBackground(Color.getHSBColor(237, 98, 98));              // 红色退出
	            System.exit(0);
	        }else if (e.getSource() == srorb) {
	            srorb.setBackground(Color.green);       // 绿色预购
	            dispose();
	            new porg().setBounds(750,50,576,650);
	        }else if (e.getSource() == squery) {
	            squery.setBackground(Color.yellow);     // 黄色查询
	            dispose();
	            new pquerypage().setBounds(750,50,576,650);
	        }else if (e.getSource() == srefund) {
	            srefund.setBackground(Color.getHSBColor(51, 72, 71));     // 灰色退票
	            dispose();
	            new porgr().setBounds(750,50,576,650);
	        }else if (e.getSource() == srefresh) {
	            srefresh.setBackground(Color.blue);     // 蓝色刷新
	            dispose();
	        	new passenger().setBounds(750,50,576,650);
	        }else if (e.getSource() == sback) {
	            sback.setBackground(Color.getHSBColor(51, 72, 71));     // 灰色返回
	            dispose();
	        	new homepage().setBounds(750,50,592,660);
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
