package �γ����;

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

	//��ҳ���
	JLabel jl;
	JFrame jf;
	Container con;
	
	//�˵���
	private JMenuBar menubar;
	private JMenu menu,submenu,settings,jfstyle;
	private JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	String SQL = "use ֣˸��_sj "+"\n"+" select * from City";
	String [] columnName;
	String [][] record;
	String head[] = {"վ��","����","��̣����","��ʼ�ص�","Ŀ��ص�"};
	
	String [] tableHead;
	String [][] content;
	JTable table;
	JScrollPane citytable ;

	public pcityquery() {

		this.setTitle("���г�����Ϣ");
		this.setVisible(true);
		
        try{ 
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("�����������ӳɹ���");
        }
        catch(Exception e) {
        	e.printStackTrace(System.out);
        }
        
        init();
        start();
        
	}
	void init() {
			//����
			menubar = new JMenuBar();
			//�˵�
			menu = new JMenu("�˵�");
			submenu = new JMenu("�˵���Ŀ");
			menu.add(submenu);
			submenu.add(sub1 = new JMenuItem("��վ��Ʊ����ϵͳ"));
			sub1.addActionListener(this);
			submenu.addSeparator();
			submenu.add(sub2 = new JMenuItem("���ݹ���ϵͳ"));
			sub2.addActionListener(this);
			//����
			settings = new JMenu("����");
			jfstyle = new JMenu("���");
			jfstyle.add(jfstyle1 = new JMenuItem("Windows ����"));
			jfstyle.addSeparator();
			jfstyle1.addActionListener(this);
			jfstyle.add(jfstyle2 = new JMenuItem("Unix ����"));
			jfstyle.addSeparator();
			jfstyle2.addActionListener(this);
			jfstyle.add(jfstyle3 = new JMenuItem("Java ����"));
			jfstyle3.addActionListener(this);
			settings.add(jfstyle);
			//���
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
            System.out.println("���ݿ����ӳɹ�����");
            
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
			System.out.println("����" + e + "������������ȷ�ı�������");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String look = "javax.swing.plaf.metal.MetalLookAndFeel";
		if (e.getSource() == jfstyle1) {
			look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";   // window���
		}else if(e.getSource()== jfstyle2) {
			look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";       // Linux���
		}else if(e.getSource()== jfstyle3) {
			look = "javax.swing.plaf.metal.MetalLookAndFeel";              // java���
		}else if(e.getSource()== sub1) {
			JOptionPane.showConfirmDialog(null, "������ϵͳѡ��ɹ�������", null, JOptionPane.OK_OPTION);
			dispose();
			new homepage().setBounds(750,50,592,660);
		}else if (e.getSource()== sub2) {
			JOptionPane.showConfirmDialog(null, "��������ϵͳ�����ڣ�����", null, JOptionPane.OK_OPTION);
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
