package 课程设计;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class pcityquery extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	//主页组件
	JLabel jl;
	JFrame jf;
	Container con;
	
	//菜单栏
	private JMenuBar menubar;
	private JMenu menu,submenu,settings,jfstyle;
	private JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	String SQL = "use 郑烁彬_sj "+"\n"+" select * from City";
	String [] columnName;
	String [][] record;
	String head[] = {"站名","车次","里程（公里）","起始地点","目标地点"};
	
	String [] tableHead;
	String [][] content;
	JTable table;
	JScrollPane citytable ;

	public pcityquery() {

		this.setTitle("所有车辆信息");
		this.setVisible(true);
		
        try{ 
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("驱动程序连接成功！");
        }
        catch(Exception e) {
        	e.printStackTrace(System.out);
        }
        
        init();
        start();
        
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
	
	void start() {

		startQuery();
		
		jf = this;
		con = jf.getContentPane();
		jl = new JLabel();
		jl.setBounds(0, 50, 576, 500);
		
		content = record;
		tableHead = columnName;
		
		table = new JTable(content,tableHead);
		table.setBounds(0,0,0,0);
		citytable = new JScrollPane(table);
		citytable.setBounds(0,0,576,200);

		jl.add(citytable);
		con.add(jl);
		
	}
	
	void startQuery() {
		
		Statement sql;
		ResultSet rs;
    	String RL = "jdbc:sqlserver://localhost:1433;";
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
