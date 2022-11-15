package 课程设计;

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
		JComboBox<String> ccp;
		String[] ccp0 = new String[]{"车辆（Coach）","站点（City）","发车时间（Ctime）","车票（Ticket）","乘客（Passenger）","退票（Refund）","————  请选择  ————"};
		JButton ccrefresh,cchome,ccback,ccexit;
		
		//车辆
		JLabel jl0,jl01,jl02,jl03,jl011,jl022,jl033;
		JButton coacreate,coareset,coareset1,coareset2,coareset3;
		JTextField coacno,coaseat,coaholder,coacno1,coaseat1,coaholder1;

		//站点
		JLabel jl1,jl11,jl12,jl13,jl14,jl15,jl111,jl112,jl113,jl114,jl115;
		JButton citcreate,citreset,citreset1,citreset2,citreset3,citreset4,citreset5;
		JTextField citcname,citcno,citmileage,citstart,cittarget,citcname1,citcno1,citmileage1,citstart1,cittarget1;
		
		//发车时间
		JLabel jl2,jl21,jl22,jl23,jl221,jl222,jl223;
		JButton timcreate,timreset,timreset1,timreset2,timreset3;
		JTextField timtime,timcname,timcno,timtime1,timcname1,timcno1;
		
		//车票
		JLabel jl3,jl31,jl32,jl33,jl34,jl35,jl36,jl331,jl332,jl333,jl334,jl335,jl336;
		JButton ticcreate,ticreset,ticreset1,ticreset2,ticreset3,ticreset4,ticreset5,ticreset6;
		JTextField tictno,ticcname,ticcno,tictime,ticprice,ticlast,tictno1,ticcname1,ticcno1,tictime1,ticprice1,ticlast1;

		//乘客
		JLabel jl4,jl41,jl42,jl43,jl44,jl45,jl46,jl441,jl442,jl443,jl444,jl445,jl446;
		JButton pascreate,pasreset,pasreset1,pasreset2,pasreset3,pasreset4,pasreset6;
		JTextField pastno,pasname,pasid,pasnum,passeat,pastno1,pasname1,pasid1,pasnum1,passeat1;
		JComboBox<String> pasrorb,pasrorb1;
		String[] rorb = new String[]{"预定","购买"};

		//退票
		JLabel jl5,jl51,jl52,jl53,jl54,jl55,jl56,jl551,jl552,jl553,jl554,jl555,jl556;
		JButton refcreate,refreset,refreset1,refreset2,refreset3,refreset4,refreset5,refreset6;
		JTextField reftno,refname,refid,refnum,reftprice,refdate,reftno1,refname1,refid1,refnum1,reftprice1,refdate1;
		
		public cchpage() {
	    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\售票员修改数据.png");             // 背景图片
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
		void cchpage1() {
			
			//创建下拉列表框
			ccp = new JComboBox<String>(ccp0);
			
		    //下拉列表进行选择添加
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
			jl0.setBounds(0, 0, 576, 500);
		    
			//车次输入框
			jl01 = new JLabel("车       次：");
			jl01.setBounds(20, 160, 70, 20);
			coacno = new JTextField(10);
			coacno.setBounds(90, 160, 150, 20);
			//车次修改框
			jl011 = new JLabel("改  为：");
			jl011.setBounds(265, 160, 70, 20);
			coacno1 = new JTextField(10);
			coacno1.setBounds(325, 160, 150, 20);
			//车次清空按钮
			coareset1 = new JButton("清空");
			coareset1.setBounds(486, 160, 70, 20);
			coareset1.setForeground(Color.GREEN);
		    coareset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 车次清空
		        	coacno.setText("");
		        	coacno1.setText("");
				}
			});
			
			//座位数输入框
			jl02 = new JLabel("座 位 数：");
			jl02.setBounds(20, 190, 70, 20);
			coaseat = new JTextField(10);
			coaseat.setBounds(90, 190, 150, 20);
			//座位数修改框
			jl022 = new JLabel("改  为：");
			jl022.setBounds(265, 190, 70, 20);
			coaseat1 = new JTextField(10);
			coaseat1.setBounds(325, 190, 150, 20);
			//座位数清空按钮
			coareset2 = new JButton("清空");
			coareset2.setBounds(486, 190, 70, 20);
			coareset2.setForeground(Color.GREEN);
		    coareset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 座位数清空
		        	coaseat.setText("");
		        	coaseat1.setText("");
				}
			});

			//负责人输入框
			jl03 = new JLabel("负 责 人：");
			jl03.setBounds(20, 220, 70, 20);
			coaholder = new JTextField(10);
			coaholder.setBounds(90, 220, 150, 20);
			//负责人修改框
			jl033 = new JLabel("改  为：");
			jl033.setBounds(265, 220, 70, 20);
			coaholder1 = new JTextField(10);
			coaholder1.setBounds(325, 220, 150, 20);
			//清空按钮
			coareset3 = new JButton("清空");
			coareset3.setBounds(486, 220, 70, 20);
			coareset3.setForeground(Color.GREEN);
		    coareset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 负责人清空
		        	coaholder.setText("");
		        	coaholder1.setText("");
				}
			});
			
			//添加按钮
			coacreate = new JButton("修改");
			coacreate.setBounds(168, 280, 70, 30);
			//登录判断事件
			coacreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
					coacreate.setBackground(Color.blue);     // 黑色清空
		            coach1();
				}
			});
			
			//清空按钮
			coareset = new JButton("清空");
			coareset.setBounds(338, 280, 70, 30);
			coareset.setForeground(Color.GREEN);
		    coareset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
		            coareset.setBackground(Color.black);     // 黑色清空
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
			coacreate.setBackground(Color.blue);      // 蓝色提交
            if (coacno.getText().equals("") == true && coaseat.getText().equals("") == true && coaholder.getText().equals("") == true && coacno1.getText().equals("") == true && coaseat1.getText().equals("") == true && coaholder1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
			} else if (coacno.getText().equals("") == false && coaseat.getText().equals("") == false && coaholder.getText().equals("") == true && coacno1.getText().equals("") == false && coaseat1.getText().equals("") == false && coaholder1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "———— 负责人不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				coaholder.requestFocusInWindow();
			} else if (coacno.getText().equals("") == false && coaseat.getText().equals("") == true && coaholder.getText().equals("") == false  && coacno1.getText().equals("") == false && coaseat1.getText().equals("") == true && coaholder1.getText().equals("") ==  false) {
				JOptionPane.showMessageDialog(null, "———— 座位数不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				coaseat.requestFocusInWindow();
			}  else if (coacno.getText().equals("") == true && coaseat.getText().equals("") == false && coaholder.getText().equals("") == false  && coacno1.getText().equals("") == true && coaseat1.getText().equals("") == false && coaholder1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 车次不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				coacno.requestFocusInWindow();
			} else if (coacno.getText().equals("") == false && coaseat.getText().equals("") == false && coaholder.getText().equals("") == false && coacno1.getText().equals("") == false && coaseat1.getText().equals("") == false && coaholder1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int coa2 = sm.executeUpdate("use 郑烁彬_sj"+"\n"
							+"update Coach set "
							+"Ccno = \'"+coacno1.getText()+"\',"
							+"Cseat = \'"+coaseat1.getText()+"\',"
							+"Cholder = \'"+coaholder1.getText()+"\'"+"\n"
							+"where "
							+"Ccno = \'"+coacno.getText()+"\' and "
							+"Cseat = \'"+coaseat.getText()+"\' and "
							+"Cholder = \'"+coaholder.getText()+"\';"); 	
	           	if(coa2 == 1){
               	 Object[] options ={"确定"};  //自定义按钮上的文字
               	 JOptionPane.showOptionDialog(null,
               			 "———— "+ccp.getSelectedItem()+"修改成功 ————" +"\n\n\t车次："+coacno1.getText()+"\n\t座位数："+coaseat1.getText()+"\n\t负责人："+coaholder1.getText(),
               			 "操作结果",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"重新输入"};  //自定义按钮上的文字
               	 	JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
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
				System.out.println("数据库连接失败！____Coach！");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//站点组件
		void city0() {
			jl1 = new JLabel();
			jl1.setBounds(0, 0, 576, 500);
		    
			//站名输入框
			jl11 = new JLabel("站        名：");
			jl11.setBounds(20, 160, 70, 20);
			citcname = new JTextField(10);
			citcname.setBounds(90, 160, 150, 20);
			//站名修改框
			jl111 = new JLabel("改  为：");
			jl111.setBounds(265, 160, 70, 20);
			citcname1 = new JTextField(10);
			citcname1.setBounds(325, 160, 150, 20);
			//站名清空按钮
			citreset1 = new JButton("清空");
			citreset1.setBounds(486,160, 70, 20);
			citreset1.setForeground(Color.GREEN);
		    citreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 站名清空
		        	citcname.setText("");
		        	citcname1.setText("");
				}
			});
			
			//车次输入框
			jl12 = new JLabel("车        次：");
			jl12.setBounds(20, 190, 70, 20);
			citcno = new JTextField(10);
			citcno.setBounds(90, 190, 150, 20);
			//车次修改框
			jl112 = new JLabel("改  为：");
			jl112.setBounds(265, 190, 70, 20);
			citcno1 = new JTextField(10);
			citcno1.setBounds(325, 190, 150, 20);
			//车次清空按钮
			citreset2 = new JButton("清空");
			citreset2.setBounds(486,190, 70, 20);
			citreset2.setForeground(Color.GREEN);
		    citreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
		        	citcno.setText("");
		        	citcno1.setText("");
				}
			});

			//里程输入框
			jl13 = new JLabel("里        程：");
			jl13.setBounds(20, 220, 70, 20);
			citmileage = new JTextField(10);
			citmileage.setBounds(90, 220, 150, 20);
			//里程修改框
			jl113 = new JLabel("改  为：");
			jl113.setBounds(265, 220, 70, 20);
			citmileage1 = new JTextField(10);
			citmileage1.setBounds(325, 220, 150, 20);
			//里程清空按钮
			citreset3 = new JButton("清空");
			citreset3.setBounds(486,220, 70, 20);
			citreset3.setForeground(Color.GREEN);
		    citreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
		        	citmileage.setText("");
		        	citmileage1.setText("");
				}
			});

			//起始地点输入框
			jl14 = new JLabel("起始地点：");
			jl14.setBounds(20, 250, 70, 20);
			citstart = new JTextField(10);
			citstart.setBounds(90, 250, 150, 20);
			//修改框
			jl114 = new JLabel("改  为：");
			jl114.setBounds(265, 250, 70, 20);
			citstart1 = new JTextField(10);
			citstart1.setBounds(325, 250, 150, 20);
			//起始地点清空按钮
			citreset4 = new JButton("清空");
			citreset4.setBounds(486,250, 70, 20);
			citreset4.setForeground(Color.GREEN);
		    citreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
		        	citstart.setText("");
		        	citstart1.setText("");
				}
			});
			
			//目标地点输入框
			jl15 = new JLabel("目标地点：");
			jl15.setBounds(20, 280, 70, 20);
			cittarget = new JTextField(10);
			cittarget.setBounds(90, 280, 150, 20);
			//修改框
			jl115 = new JLabel("改  为：");
			jl115.setBounds(265, 280, 70, 20);
			cittarget1 = new JTextField(10);
			cittarget1.setBounds(325, 280, 150, 20);
			
			
			//目标地点清空按钮
			citreset5 = new JButton("清空");
			citreset5.setBounds(486,280, 70, 20);
			citreset5.setForeground(Color.GREEN);
		    citreset5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
		        	cittarget.setText("");
		        	cittarget1.setText("");
				}
			});
			
			//添加按钮
			citcreate = new JButton("修改");
			citcreate.setBounds(168, 340, 70, 30);
			//登录判断事件
			citcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					citcreate.setBackground(Color.blue);      // 蓝色提交
		        	city1();
				}
			});
			
			//清空按钮
			citreset = new JButton("清空");
			citreset.setBounds(338, 340, 70, 30);
			citreset.setForeground(Color.GREEN);
		    citreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 清空
					citreset.setBackground(Color.black);      // 蓝色提交
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
			citcreate.setBackground(Color.blue);      // 蓝色提交
            if (citcno.getText().equals("") == true && citcname.getText().equals("") == true && citmileage.getText().equals("") == true && citstart.getText().equals("") == true && cittarget.getText().equals("") == true && citcno1.getText().equals("") == true && citcname1.getText().equals("") == true && citmileage1.getText().equals("") == true && citstart1.getText().equals("") == true && cittarget1.getText().equals("") == true) {
            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == true && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "———— 目标地点不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				cittarget.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == true && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == true && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 起始地点不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				citstart.requestFocusInWindow();
			}  else if (citcno.getText().equals("") == true && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == true && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 车次不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				citcno.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == true && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == true && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 里程不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				citmileage.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == true && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == true && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 站名不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				citcname.requestFocusInWindow();
			} else if (citcno.getText().equals("") == false && citcname.getText().equals("") == false && citmileage.getText().equals("") == false && citstart.getText().equals("") == false && cittarget.getText().equals("") == false && citcno1.getText().equals("") == false && citcname1.getText().equals("") == false && citmileage1.getText().equals("") == false && citstart1.getText().equals("") == false && cittarget1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int cit2 = sm.executeUpdate("use 郑烁彬_sj"+"\n"
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
               	 Object[] options ={"确定"};  //自定义按钮上的文字
               	 JOptionPane.showOptionDialog(null,
               			 "———— "+ccp.getSelectedItem()+"修改成功 ————" +"\n\n\t站名："+citcname1.getText()+"\n\t车次："+citcno1.getText()+"\n\t里程："+citmileage.getText()+"\n\t起始地点："+citstart1.getText()+"\n\t目标地点："+cittarget1.getText(),
               			 "操作结果",JOptionPane.YES_OPTION, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"重新输入"};  //自定义按钮上的文字
               	 	JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
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
				System.out.println("数据库连接失败！____City！");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
		}
		}

		//发车时间组件
		void time0() {
			jl2 = new JLabel();
			jl2.setBounds(0, 0, 576, 500);
		    
			//车次输入框
			jl21 = new JLabel("发车时间：");
			jl21.setBounds(20, 220, 70, 20);
			timtime = new JTextField(10);
			timtime.setBounds(90, 220, 150, 20);
			//修改框
			jl221 = new JLabel("改  为：");
			jl221.setBounds(265, 220, 70, 20);
			timtime1 = new JTextField(10);
			timtime1.setBounds(325, 220, 150, 20);
			//清空按钮
			timreset1 = new JButton("清空");
			timreset1.setBounds(486, 220, 70, 20);
			timreset1.setForeground(Color.GREEN);
			timreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 车次清空
					timtime.setText("");
					timtime1.setText("");
				}
			});
			
			//站名输入框
			jl22 = new JLabel("站        名：");
			jl22.setBounds(20, 160, 70, 20);
			timcname = new JTextField(10);
			timcname.setBounds(90, 160, 150, 20);
			//修改框
			jl222 = new JLabel("改  为：");
			jl222.setBounds(265, 160, 70, 20);
			timcname1 = new JTextField(10);
			timcname1.setBounds(325, 160, 150, 20);
			//清空按钮
			timreset2 = new JButton("清空");
			timreset2.setBounds(486, 160, 70, 20);
			timreset2.setForeground(Color.GREEN);
			timreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 座位数清空
					timcname.setText("");
					timcname1.setText("");
				}
			});

			//车次输入框
			jl23 = new JLabel("车        次：");
			jl23.setBounds(20, 190, 70, 20);
			timcno = new JTextField(10);
			timcno.setBounds(90, 190, 150, 20);
			//修改框
			jl223 = new JLabel("改  为：");
			jl223.setBounds(265, 190, 70, 20);
			timcno1 = new JTextField(10);
			timcno1.setBounds(325, 190, 150, 20);
			//清空按钮
			timreset3 = new JButton("清空");
			timreset3.setBounds(486, 190, 70, 20);
			timreset3.setForeground(Color.GREEN);
			timreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 负责人清空
					timcno.setText("");
					timcno1.setText("");
				}
			});
			
			//添加按钮
			timcreate = new JButton("修改");
			timcreate.setBounds(168, 280, 70, 30);
			//登录判断事件
			timcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
					ticcreate.setBackground(Color.blue);     // 蓝色添加
		            time1();
				}
			});
			
			//清空按钮
			timreset = new JButton("清空");
			timreset.setBounds(338, 280, 70, 30);
			timreset.setForeground(Color.GREEN);
			timreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {    
					timreset.setBackground(Color.black);     // 黑色清空
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
			timcreate.setBackground(Color.blue);      // 蓝色提交
            if (timcno.getText().equals("") == true && timcname.getText().equals("") == true && timtime.getText().equals("") == true && timcno1.getText().equals("") == true && timcname1.getText().equals("") == true && timtime1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
			} else if (timcno.getText().equals("") == false && timcname.getText().equals("") == false && timtime.getText().equals("") == true && timcno1.getText().equals("") == false && timcname1.getText().equals("") == false && timtime1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "———— 发车时间不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				timtime.requestFocusInWindow();
			} else if (timcno.getText().equals("") == false && timcname.getText().equals("") == true && timtime.getText().equals("") == false && timcno1.getText().equals("") == false && timcname1.getText().equals("") == true && timtime1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 站名不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				timcname.requestFocusInWindow();
			}  else if (timcno.getText().equals("") == true && timcname.getText().equals("") == false && timtime.getText().equals("") == false && timcno1.getText().equals("") == true && timcname1.getText().equals("") == false && timtime1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 车次不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				timcno.requestFocusInWindow();
			} else if (timcno.getText().equals("") == false && timcname.getText().equals("") == false && timtime.getText().equals("") == false && timcno1.getText().equals("") == false && timcname1.getText().equals("") == false && timtime1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tim2 = sm.executeUpdate("use 郑烁彬_sj"+"\n"
						+"update CTime set "
						+"Ccno = \'"+timcno1.getText()+"\',"
						+"Cityname = \'"+timcname1.getText()+"\',"
						+"Ttime = \'"+timtime1.getText()+"\'"+"\n"
						+"where "
						+"Ccno = \'"+timcno.getText()+"\' and "
						+"Cityname = \'"+timcname.getText()+"\' and "
						+"Ttime = \'"+timtime.getText()+"\';"); 	
	           	if(tim2 == 1){
	           		Object[] options ={"确定"};  //自定义按钮上的文字
	           		JOptionPane.showOptionDialog(null,
               			 "———— "+ccp.getSelectedItem()+"修改成功 ————" +"\n\n\t站名："+timcname1.getText()+"\n\t车次："+timcno1.getText()+"\n\t发车时间："+timtime1.getText(),
               			 "操作结果",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
	           		}
                else{
               	 	Object[] options ={"重新输入"};  //自定义按钮上的文字
               	 	JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.ERROR_MESSAGE,0,null, options, null);
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
				System.out.println("数据库连接失败！____CTime！");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//车票组件
		void ticket0() {
			jl3 = new JLabel();
			jl3.setBounds(0, 0, 576, 500);
		    
			//票号输入框
			jl31 = new JLabel("票        号：");
			jl31.setBounds(20, 130, 70, 20);
			tictno = new JTextField(10);
			tictno.setBounds(90, 130, 150, 20);
			//修改框
			jl331 = new JLabel("改  为：");
			jl331.setBounds(265, 130, 70, 20);
			tictno1 = new JTextField(10);
			tictno1.setBounds(325, 130, 150, 20);
			//清空按钮
			ticreset1 = new JButton("清空");
			ticreset1.setBounds(486, 130, 70, 20);
			ticreset1.setForeground(Color.GREEN);
			ticreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 站名清空
					tictno.setText("");
					tictno1.setText("");
				}
			});
			
			//站名输入框
		    jl32 = new JLabel("站        名：");
		    jl32.setBounds(20, 160, 70, 20);
		    ticcname = new JTextField(10);
		    ticcname.setBounds(90, 160, 150, 20);
			//修改框
			jl332 = new JLabel("改  为：");
			jl332.setBounds(265, 160, 70, 20);
			ticcname1 = new JTextField(10);
			ticcname1.setBounds(325, 160, 150, 20);
			//清空按钮
			ticreset2 = new JButton("清空");
			ticreset2.setBounds(486, 160, 70, 20);
			ticreset2.setForeground(Color.GREEN);
			ticreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     
					ticcname.setText("");
					ticcname1.setText("");
				}
			});

			//车次输入框
		    jl33 = new JLabel("车        次：");
		    jl33.setBounds(20, 190, 70, 20);
			ticcno = new JTextField(10);
			ticcno.setBounds(90, 190, 150, 20);
			//修改框
			jl333 = new JLabel("改  为：");
			jl333.setBounds(265, 190, 70, 20);
			ticcno1 = new JTextField(10);
			ticcno1.setBounds(325, 190, 150, 20);
			//清空按钮
			ticreset3 = new JButton("清空");
			ticreset3.setBounds(486, 190, 70, 20);
			ticreset3.setForeground(Color.GREEN);
			ticreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					ticcno.setText("");
					ticcno1.setText("");
				}
			});

			//发车时间输入框
		    jl34 = new JLabel("发车时间：");
		    jl34.setBounds(20, 220, 70, 20);
			tictime = new JTextField(10);
			tictime.setBounds(90, 220, 150, 20);
			//负责人修改框
			jl334 = new JLabel("改  为：");
			jl334.setBounds(265, 220, 70, 20);
			tictime1 = new JTextField(10);
			tictime1.setBounds(325, 220, 150, 20);
			//起始地点清空按钮
		    ticreset4 = new JButton("清空");
		    ticreset4.setBounds(486, 220, 70, 20);
		    ticreset4.setForeground(Color.GREEN);
		    ticreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					tictime.setText("");
					tictime1.setText("");
				}
			});
			
			//票价输入框
		    jl35 = new JLabel("票        价：");
		    jl35.setBounds(20, 250, 70, 20);
		    ticprice = new JTextField(10);
		    ticprice.setBounds(90, 250, 150, 20);
			//负责人修改框
			jl335 = new JLabel("改  为：");
			jl335.setBounds(265, 250, 70, 20);
			ticprice1 = new JTextField(10);
			ticprice1.setBounds(325, 250, 150, 20);
			//目标地点清空按钮
		    ticreset5 = new JButton("清空");
		    ticreset5.setBounds(486, 250, 70, 20);
		    ticreset5.setForeground(Color.GREEN);
		    ticreset5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					ticprice.setText("");
					ticprice1.setText("");
				}
			});

			//剩余票数
		    jl36 = new JLabel("剩余票数：");
		    jl36.setBounds(20, 280, 70, 20);
			ticlast = new JTextField(10);
			ticlast.setBounds(90, 280, 150, 20);
			//修改框
			jl336 = new JLabel("改  为：");
			jl336.setBounds(265, 280, 70, 20);
			ticlast1 = new JTextField(10);
			ticlast1.setBounds(325, 280, 150, 20);
			//清空按钮
		    ticreset6 = new JButton("清空");
		    ticreset6.setBounds(486, 280, 70, 20);
		    ticreset6.setForeground(Color.GREEN);
		    ticreset6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					ticlast.setText("");
					ticlast1.setText("");
				}
			});
		    
			//添加按钮
		    ticcreate = new JButton("修改");
		    ticcreate.setBounds(168, 370, 70, 30);
			//登录判断事件
		    ticcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					ticcreate.setBackground(Color.blue);      // 蓝色提交
		        	ticket1();
				}
			});
			
			//清空按钮
		    ticreset = new JButton("清空");
		    ticreset.setBounds(338, 370, 70, 30);
		    ticreset.setForeground(Color.GREEN);
		    ticreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 清空
					ticreset.setBackground(Color.black);      // 蓝色提交
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
			ticcreate.setBackground(Color.blue);      // 蓝色提交
            if (tictno.getText().equals("") == true && ticcname.getText().equals("") == true && ticcno.getText().equals("") == true && tictime.getText().equals("") == true && ticprice.getText().equals("") == true && ticlast.getText().equals("") == true && tictno1.getText().equals("") == true && ticcname1.getText().equals("") == true && ticcno1.getText().equals("") == true && tictime1.getText().equals("") == true && ticprice1.getText().equals("") == true && ticlast1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
			} else if (tictno.getText().equals("") == true && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == true && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 票号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				tictno.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == true && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == true && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 站名不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				ticcname.requestFocusInWindow();
			}  else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == true && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == true && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 车次不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				ticcno.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == true && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == true && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 发车时间不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				tictime.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == true && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == true && ticlast1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 票价不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				ticprice.requestFocusInWindow();
			}  else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == true && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "———— 剩余票数不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				ticlast.requestFocusInWindow();
			} else if (tictno.getText().equals("") == false && ticcname.getText().equals("") == false && ticcno.getText().equals("") == false && tictime.getText().equals("") == false && ticprice.getText().equals("") == false && ticlast.getText().equals("") == false && tictno1.getText().equals("") == false && ticcname1.getText().equals("") == false && ticcno1.getText().equals("") == false && tictime1.getText().equals("") == false && ticprice1.getText().equals("") == false && ticlast1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tic2 = sm.executeUpdate("use 郑烁彬_sj"+"\n"
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
               	 Object[] options ={"确定"};  //自定义按钮上的文字
               	 JOptionPane.showOptionDialog(null,
               			 "———— "+ccp.getSelectedItem()+"修改成功 ————" +"\n\n\t票号："+tictno1.getText()+"\n\t站名："+ticcname1.getText()+"\n\t车次："+ticcno1.getText()+"\n\t发车时间："+tictime1.getText()+"\n\t票价："+ticprice1.getText()+"\n\t剩余票数："+ticlast1.getText(),
               			 "操作结果",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"重新输入"};  //自定义按钮上的文字
               	 	JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
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
				System.out.println("数据库连接失败！____Ticket！");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//乘客组件
		void passenger0() {
			jl4 = new JLabel();
			jl4.setBounds(0, 0, 576, 500);
		    
			//票号输入框
			jl41 = new JLabel("票        号：");
			jl41.setBounds(20, 130, 70, 20);
			pastno = new JTextField(10);
			pastno.setBounds(90, 130, 150, 20);
			//修改框
			jl441 = new JLabel("改  为：");
			jl441.setBounds(265, 130, 70, 20);
			pastno1 = new JTextField(10);
			pastno1.setBounds(325, 130, 150, 20);
			//清空按钮
			pasreset1 = new JButton("清空");
			pasreset1.setBounds(486, 130, 70, 20);
			pasreset1.setForeground(Color.GREEN);
			pasreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 站名清空
					pastno.setText("");
					pastno1.setText("");
				}
			});
			
			//站名输入框
			jl42 = new JLabel("乘客姓名：");
			jl42.setBounds(20, 160, 70, 20);
			pasname = new JTextField(10);
			pasname.setBounds(90, 160, 150, 20);
			//修改框
		    jl442 = new JLabel("改  为：");
		    jl442.setBounds(265, 160, 70, 20);
		    pasname1 = new JTextField(10);
		    pasname1.setBounds(325, 160, 150, 20);
			//清空按钮
		    pasreset2 = new JButton("清空");
		    pasreset2.setBounds(486, 160, 70, 20);
		    pasreset2.setForeground(Color.GREEN);
		    pasreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     
					pasname.setText("");
					pasname1.setText("");
				}
			});

			//车次输入框
			jl43 = new JLabel("身份证号：");
			jl43.setBounds(20, 190, 70, 20);
			pasid = new JTextField(10);
			pasid.setBounds(90, 190, 150, 20);
			//修改框
			jl443 = new JLabel("改  为：");
			jl443.setBounds(265, 190, 70, 20);
			pasid1 = new JTextField(10);
			pasid1.setBounds(325, 190, 150, 20);
			//清空按钮
			pasreset3 = new JButton("清空");
			pasreset3.setBounds(486, 190, 70, 20);
			pasreset3.setForeground(Color.GREEN);
			pasreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					pasid.setText("");
					pasid1.setText("");
				}
			});

			//发车时间输入框
			jl44 = new JLabel("手  机  号：");
			jl44.setBounds(20, 220, 70, 20);
			pasnum = new JTextField(10);
			pasnum.setBounds(90, 220, 150, 20);
			//负责人修改框
			jl444 = new JLabel("改  为：");
			jl444.setBounds(265, 220, 70, 20);
			pasnum1 = new JTextField(10);
			pasnum1.setBounds(325, 220, 150, 20);
			//起始地点清空按钮
		    pasreset4 = new JButton("清空");
		    pasreset4.setBounds(486, 220, 70, 20);
		    pasreset4.setForeground(Color.GREEN);
		    pasreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					pasnum.setText("");
					pasnum1.setText("");
				}
			});

			//创建下拉列表框
			pasrorb = new JComboBox<String>(rorb);
			pasrorb1 = new JComboBox<String>(rorb);
			
			//票价输入框
		    jl45 = new JLabel("预定或已购 ：");
		    jl45.setBounds(5, 250, 85, 20);
		    pasrorb.setBounds(90, 250, 150, 20);
			//负责人修改框
		    jl445 = new JLabel("改  为：");
		    jl445.setBounds(265, 250, 70, 20);
		    pasrorb1.setBounds(325, 250, 150, 20);

			//剩余票数
		    jl46 = new JLabel("座  位  号：");
		    jl46.setBounds(20, 280, 70, 20);
		    passeat = new JTextField(10);
		    passeat.setBounds(90, 280, 150, 20);
			//修改框
			jl446 = new JLabel("改  为：");
			jl446.setBounds(265, 280, 70, 20);
			passeat1 = new JTextField(10);
			passeat1.setBounds(325, 280, 150, 20);
			//清空按钮
			pasreset6 = new JButton("清空");
			pasreset6.setBounds(486, 280, 70, 20);
			pasreset6.setForeground(Color.GREEN);
			pasreset6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					passeat.setText("");
					passeat1.setText("");
				}
			});
		    
			//添加按钮
			pascreate = new JButton("修改");
			pascreate.setBounds(168, 370, 70, 30);
			//登录判断事件
			pascreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					pascreate.setBackground(Color.blue);      // 蓝色提交
		        	passenger1();
				}
			});
			
			//清空按钮
			pasreset = new JButton("清空");
			pasreset.setBounds(338, 370, 70, 30);
			pasreset.setForeground(Color.GREEN);
			pasreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 清空
					pasreset.setBackground(Color.black);      // 蓝色提交
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
			pascreate.setBackground(Color.blue);      // 蓝色提交
            if (pastno.getText().equals("") == true && pasname.getText().equals("") == true && pasid.getText().equals("") == true && pasnum.getText().equals("") == true  && passeat.getText().equals("") == true && pastno1.getText().equals("") == true && pasname1.getText().equals("") == true && pasid1.getText().equals("") == true && pasnum1.getText().equals("") == true  && passeat1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
			} else if (pastno.getText().equals("") == true && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == true && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false  && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 票号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				pastno.requestFocusInWindow();
			} else if (pastno.getText().equals("") == false && pasname.getText().equals("") == true && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == true && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false  && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 乘客姓名不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				pasname.requestFocusInWindow();
			}  else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == true && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == true && pasnum1.getText().equals("") == false && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 身份证号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				pasid.requestFocusInWindow();
			} else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == true  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == true  && passeat1.getText().equals("") == false ) {
				JOptionPane.showMessageDialog(null, "———— 手机号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				pasnum.requestFocusInWindow();
			}  else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == true && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false && passeat1.getText().equals("") == true ) {
				JOptionPane.showMessageDialog(null, "———— 座位号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				passeat.requestFocusInWindow();
			} else if (pastno.getText().equals("") == false && pasname.getText().equals("") == false && pasid.getText().equals("") == false && pasnum.getText().equals("") == false  && passeat.getText().equals("") == false && pastno1.getText().equals("") == false && pasname1.getText().equals("") == false && pasid1.getText().equals("") == false && pasnum1.getText().equals("") == false && passeat1.getText().equals("") == false ) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tic2 = sm.executeUpdate("use 郑烁彬_sj"+"\n"
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
               	 Object[] options ={"确定"};  //自定义按钮上的文字
               	 JOptionPane.showOptionDialog(null,
               			 "———— "+ccp.getSelectedItem()+"修改成功 ————" +"\n\n\t票号："+pastno1.getText()+"\n\t乘客姓名："+pasname1.getText()+"\n\t身份证号："+pasid1.getText()+"\n\t手机号："+pasnum1.getText()+"\n\t预定或已购："+pasrorb1.getSelectedItem()+"\n\t座位号："+passeat1.getText(),
               			 "操作结果",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"重新输入"};  //自定义按钮上的文字
               	 	JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
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
				System.out.println("数据库连接失败！____passenger！");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
		}
		}
		
		//退票组件
		void refund0() {
			jl5 = new JLabel();
			jl5.setBounds(0, 0, 576, 500);
		    
			//票号输入框
			jl51 = new JLabel("票        号：");
			jl51.setBounds(20, 130, 70, 20);
			reftno = new JTextField(10);
			reftno.setBounds(90, 130, 150, 20);
			//修改框
			jl551 = new JLabel("改  为：");
			jl551.setBounds(265, 130, 70, 20);
			reftno1 = new JTextField(10);
			reftno1.setBounds(325, 130, 150, 20);
			//清空按钮
			refreset1 = new JButton("清空");
			refreset1.setBounds(486, 130, 70, 20);
			refreset1.setForeground(Color.GREEN);
			refreset1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     // 站名清空
					reftno.setText("");
					reftno1.setText("");
				}
			});
			
			//站名输入框
			jl52 = new JLabel("乘客姓名：");
			jl52.setBounds(20, 160, 70, 20);
			refname = new JTextField(10);
			refname.setBounds(90, 160, 150, 20);
			//修改框
			jl552 = new JLabel("改  为：");
			jl552.setBounds(265, 160, 70, 20);
			refname1 = new JTextField(10);
			refname1.setBounds(325, 160, 150, 20);
			//清空按钮
			refreset2 = new JButton("清空");
			refreset2.setBounds(486, 160, 70, 20);
			refreset2.setForeground(Color.GREEN);
			refreset2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {     
					refname.setText("");
					refname1.setText("");
				}
			});

			//车次输入框
		    jl53 = new JLabel("身份证号：");
		    jl53.setBounds(20, 190, 70, 20);
		    refid = new JTextField(10);
		    refid.setBounds(90, 190, 150, 20);
			//修改框
			jl553 = new JLabel("改  为：");
			jl553.setBounds(265, 190, 70, 20);
			refid1 = new JTextField(10);
			refid1.setBounds(325, 190, 150, 20);
			//清空按钮
			refreset3 = new JButton("清空");
			refreset3.setBounds(486, 190, 70, 20);
			refreset3.setForeground(Color.GREEN);
			refreset3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					refid.setText("");
					refid1.setText("");
				}
			});

			//发车时间输入框
			jl54 = new JLabel("手  机  号：");
			jl54.setBounds(20, 220, 70, 20);
			refnum = new JTextField(10);
			refnum.setBounds(90, 220, 150, 20);
			//负责人修改框
			jl554 = new JLabel("改  为：");
			jl554.setBounds(265, 220, 70, 20);
			refnum1 = new JTextField(10);
			refnum1.setBounds(325, 220, 150, 20);
			//起始地点清空按钮
			refreset4 = new JButton("清空");
			refreset4.setBounds(486, 220, 70, 20);
			refreset4.setForeground(Color.GREEN);
			refreset4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					refnum.setText("");
					refnum1.setText("");
				}
			});
			
			//票价输入框
			jl55 = new JLabel("应  退  款：");
			jl55.setBounds(20, 250, 70, 20);
			reftprice = new JTextField(10);
			reftprice.setBounds(90, 250, 150, 20);
			//负责人修改框
		    jl555 = new JLabel("改  为：");
		    jl555.setBounds(265, 250, 70, 20);
		    reftprice1 = new JTextField(10);
		    reftprice1.setBounds(325, 250, 150, 20);
		    //清空按钮
		    refreset5 = new JButton("清空");
		    refreset5.setBounds(486, 250, 70, 20);
		    refreset5.setForeground(Color.GREEN);
		    refreset5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					reftprice.setText("");
					reftprice1.setText("");
				}
			});
		    
			//剩余票数
		    jl56 = new JLabel("退票时间：");
		    jl56.setBounds(20, 280, 70, 20);
		    refdate = new JTextField(10);
		    refdate.setBounds(90, 280, 150, 20);
			//修改框
		    jl556 = new JLabel("改  为：");
		    jl556.setBounds(265, 280, 70, 20);
		    refdate1 = new JTextField(10);
		    refdate1.setBounds(325, 280, 150, 20);
			//清空按钮
		    refreset6 = new JButton("清空");
		    refreset6.setBounds(486, 280, 70, 20);
		    refreset6.setForeground(Color.GREEN);
		    refreset6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 车次清空
					refdate.setText("");
					refdate1.setText("");
				}
			});
		    
			//添加按钮
		    refcreate = new JButton("修改");
		    refcreate.setBounds(168, 370, 70, 30);
			//登录判断事件
		    refcreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       
					refcreate.setBackground(Color.blue);      // 蓝色提交
					refund1();
				}
			});
			
			//清空按钮
		    refreset = new JButton("清空");
		    refreset.setBounds(338, 370, 70, 30);
		    refreset.setForeground(Color.GREEN);
		    refreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {       // 清空
					refreset.setBackground(Color.black);      // 蓝色提交
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
			refcreate.setBackground(Color.blue);      // 蓝色提交
            if (reftno.getText().equals("") == true && refname.getText().equals("") == true && refid.getText().equals("") == true && refnum.getText().equals("") == true  && reftprice.getText().equals("") == true && refdate.getText().equals("") == true && reftno1.getText().equals("") == true && refname1.getText().equals("") == true && refid1.getText().equals("") == true && refnum1.getText().equals("") == true  && reftprice1.getText().equals("") == true && refdate1.getText().equals("") == true ) {
            	JOptionPane.showMessageDialog(null, "———— 必填项不可为空 ————", "操作有误", JOptionPane.WARNING_MESSAGE);
			} else if (reftno.getText().equals("") == true && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == true && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 票号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				reftno.requestFocusInWindow();
			} else if (reftno.getText().equals("") == false && refname.getText().equals("") == true && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == true && refid1.getText().equals("") == false && refnum1.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 乘客姓名不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				refname.requestFocusInWindow();
			}  else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == true && refnum.getText().equals("") == false  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == true && refnum1.getText().equals("") == false && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 身份证号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				refid.requestFocusInWindow();
			} else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == true  && reftprice.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == true  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 手机号不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				refnum.requestFocusInWindow();
			}  else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice1.getText().equals("") == true && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false && reftprice1.getText().equals("") == true && refdate1.getText().equals("") == false) {
				JOptionPane.showMessageDialog(null, "———— 应退款不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				reftprice.requestFocusInWindow();
			} else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == true  && reftprice.getText().equals("") == false && refdate.getText().equals("") == true && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == true) {
				JOptionPane.showMessageDialog(null, "———— 退款时间不可为空 ————", "操作有误", JOptionPane.ERROR_MESSAGE);
				refdate.requestFocusInWindow();
			}  else if (reftno.getText().equals("") == false && refname.getText().equals("") == false && refid.getText().equals("") == false && refnum.getText().equals("") == false  && reftprice1.getText().equals("") == false && refdate.getText().equals("") == false && reftno1.getText().equals("") == false && refname1.getText().equals("") == false && refid1.getText().equals("") == false && refnum1.getText().equals("") == false && reftprice1.getText().equals("") == false && refdate1.getText().equals("") == false) {
			Statement sm = null;
	        try{ 
	           	Connection con = DriverManager.getConnection(RL,"sa","5436.......");
	           	sm = con.createStatement();
	           	int tic2 = sm.executeUpdate("use 郑烁彬_sj"+"\n"
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
               	 Object[] options ={"确定"};  //自定义按钮上的文字
               	 JOptionPane.showOptionDialog(null,
               			 "———— "+ccp.getSelectedItem()+"修改成功 ————" +"\n\n\t票号："+reftno1.getText()+"\n\t乘客姓名："+refname1.getText()+"\n\t身份证号："+refid1.getText()+"\n\t手机号："+refnum1.getText()+"\n\t应退款："+reftprice1.getText()+"\n\t退款时间："+refdate1.getText(),
               			 "操作结果",JOptionPane.INFORMATION_MESSAGE, 
               			 1, null, options, null); 
    			 }
                else{
               	 	Object[] options ={"重新输入"};  //自定义按钮上的文字
               	 	JOptionPane.showOptionDialog(null, "———— 输入有误 ————","操作结果",JOptionPane.ERROR_MESSAGE,0,null, options, null); 
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
				System.out.println("数据库连接失败！____Refund！");
	        	}
		} else {
			JOptionPane.showMessageDialog(null, "———— 多处输入有误 ————", "操作结果", JOptionPane.ERROR_MESSAGE);
		}			
		}
		
		//按钮点击后触发事件
        String RL = "jdbc:sqlserver://localhost:1433;";
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
		        	new cfunctionpage().setBounds(750,50,592,660);
		        }else if(e.getSource() == ccrefresh) {
		        	dispose();
			        new cchpage().setBounds(750,50,592,660);      // 刷新
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
