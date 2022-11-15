package �γ����;

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
	//�˵���
	private JMenuBar menubar;
	private JMenu menu,submenu,settings,jfstyle;
	private JMenuItem sub1,sub2,jfstyle1,jfstyle2,jfstyle3;
	
	//��ǩ����
	private JPanel imagePanel;
	private ImageIcon background;
	
	String databaseName;
	String SQL;
	String [] columnName;
	String [][] record;
	
	public ticketquery() {
		
    	background = new ImageIcon("D:\\eclipse\\�γ����\\bin\\img\\��Ʊ��.png");             // ����ͼƬ
        JLabel label = new JLabel(background);       //�ѱ���ͼƬ��ʾ��һ����ǩ����
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
       
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
        imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().setLayout(null);

        
        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.setSize(background.getIconWidth(), background.getIconHeight());
        
		this.setTitle("���г�Ʊ��Ϣ");
		this.setVisible(true);

		String [] tableHead;
		String [][] content;
		String a = "Ticket";
		JTable table;
		this.setDatabaseName("֣˸��_sj");
		this.setSQL("select * from " + a);
		content = this.getRecord();
		tableHead = this.getcolumnName();
		table = new JTable(content,tableHead);
		table.setEnabled(false);
		table.setBounds(0,100,578,250);
		
		this.add(new JScrollPane(table));
		
        try{ 
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("���ڼ�����");
             System.out.println("�����������ӳɹ���");
        }
        catch(Exception e) {
        	e.printStackTrace(System.out);
        }
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
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
	
	public void setDatabaseName(String s) {
		databaseName = s.trim();
	}
	
	public void setSQL(String SQL) {
		this.SQL = SQL.trim();
	}
	
	public String[] getcolumnName() {
		if(columnName == null) {
			System.out.println("�Ȳ�ѯ��¼");
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
    	String RL = "jdbc:sqlserver://localhost:1433; databaseName = ֣˸��_sj";
    	String head[] = {"Ʊ��","վ��","����","����ʱ��","����","Ʊ��","ʣ��Ʊ��"};
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
