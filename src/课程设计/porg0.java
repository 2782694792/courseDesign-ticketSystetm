package �γ����;

import java.awt.Color;
import java.awt.Container;

public class porg0 {
	public static void main(String args[]) {
    // JFrame window = new JFrame("practice");   //���ڱ���
	porg win = new porg();
	Container win1 = win.getContentPane();       //��ʼ������,ʹ�ñ�����ӿؼ� 
	win.setTitle("С���ĳ�վ��Ʊϵͳ");                //������������
	win.setBounds(750,50,592,660);              //����,�ඥ,���ڿ��,�߶� 
	win1.setBackground(Color.LIGHT_GRAY);        //���ڱ�����ɫ
	}
}
