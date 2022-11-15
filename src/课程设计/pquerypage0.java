package 课程设计;

import java.awt.*;

public class pquerypage0 {
    public static void main(String args[]) {
	    // JFrame window = new JFrame("practice");   //窗口标题
    	pquerypage win = new pquerypage();
    	Container win1 = win.getContentPane();       //初始化容器,使得便于添加控件 
		win.setTitle("小生的车站售票系统");                //函数设立标题
		win.setBounds(750,50,592,660);              //距左,距顶,窗口宽度,高度 
    	win1.setBackground(Color.LIGHT_GRAY);        //窗口背景颜色
    	
        
    	/*查询
		String [] tableHead;
		String [][] content;
		String a = "Coach";
		JTable table;
		JFrame wi = new JFrame();
		query findRecord = new query();
		findRecord.setDatabaseName("郑烁彬_sj");
		findRecord.setSQL("select * from " + a);
		content = findRecord.getRecord();
		tableHead = findRecord.getcolumnName();
		table = new JTable(content,tableHead);
		wi.add(new JScrollPane(table));
		wi.setBounds(12,100,400,200);
		wi.setVisible(true);
		wi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
} 
