package 课程设计;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
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

public class ticketquery extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//菜单栏
	private JMenuBar menubar;
	private JMenu menu,submenu,settings,jfstyle;
	private JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//标签背景
	private JPanel imagePanel;
	private ImageIcon background;
	
	String databaseName;
	String SQL;
	String [] columnName;
	String [][] record;
	
	public ticketquery() {
		
    	background = new ImageIcon("D:\\eclipse\\课程设计\\bin\\img\\车票表.png");             // 背景图片
        JLabel label = new JLabel(background);       //把背景图片显示在一个标签里面
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());        // 把标签的大小位置设置为图片刚好填充整个面板
       
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().setLayout(null);

        
        // 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.setSize(background.getIconWidth(), background.getIconHeight());
        
		this.setTitle("所有车票信息");
		this.setVisible(true);

		String [] tableHead;
		String [][] content;
		String a = "Ticket";
		JTable table;
		this.setDatabaseName("郑烁彬_sj");
		this.setSQL("select * from " + a);
		content = this.getRecord();
		tableHead = this.getcolumnName();
		table = new JTable(content,tableHead);
		table.setEnabled(false);
		table.setBounds(0,100,578,250);
		
		this.add(new JScrollPane(table));
		
        try{ 
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("正在加载中");
             System.out.println("驱动程序连接成功！");
        }
        catch(Exception e) {
        	e.printStackTrace(System.out);
        }
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
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
	
	public void setDatabaseName(String s) {
		databaseName = s.trim();
	}
	
	public void setSQL(String SQL) {
		this.SQL = SQL.trim();
	}
	
	public String[] getcolumnName() {
		if(columnName == null) {
			System.out.println("先查询记录");
			return null;
		}
		return columnName;
	}
	
	public String[][] getRecord(){
		startQuery();
		return record;
	}
	
	private void startQuery() {
		Statement sql;
		ResultSet rs;
    	String RL = "jdbc:sqlserver://localhost:1433; databaseName = 郑烁彬_sj";
    	String head[] = {"票号","站名","车次","发车时间","工号","票价","剩余票数"};
		try {
			Connection con = DriverManager.getConnection(RL,"sa","5436.......");
            System.out.println("数据库连接成功！！");
            
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            columnName = new String[columnCount];
            for(int i = 1;i <= columnCount;i ++)
            {
            	columnName[i - 1] = head[i - 1];
            }
            
            rs.last();
            int recordAmount = rs.getRow();
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while(rs.next()) {
            	for(int j = 1;j <= columnCount;j ++) {
            		record[i][j -1] = rs.getString(j);
            	}
            	i ++;
            }
            
            rs.close();
            con.close();
   
		}
		catch(SQLException e) {
			System.out.println("表名" + e + "有误！请输入正确的表名！！");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
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
