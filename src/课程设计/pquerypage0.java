package �γ����;

import java.awt.*;

public class pquerypage0 {
    public static void main(String args[]) {
	    // JFrame window = new JFrame("practice");   //���ڱ���
    	pquerypage win = new pquerypage();
    	Container win1 = win.getContentPane();       //��ʼ������,ʹ�ñ�����ӿؼ� 
		win.setTitle("С���ĳ�վ��Ʊϵͳ");                //������������
		win.setBounds(750,50,592,660);              //����,�ඥ,���ڿ��,�߶� 
    	win1.setBackground(Color.LIGHT_GRAY);        //���ڱ�����ɫ
    	
        
    	/*��ѯ
		String [] tableHead;
		String [][] content;
		String a = "Coach";
		JTable table;
		JFrame wi = new JFrame();
		query findRecord = new query();
		findRecord.setDatabaseName("֣˸��_sj");
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
