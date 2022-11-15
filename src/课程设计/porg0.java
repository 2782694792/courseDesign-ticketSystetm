package 课程设计;

import java.awt.Color;
import java.awt.Container;

public class porg0 {
	public static void main(String args[]) {
    // JFrame window = new JFrame("practice");   //窗口标题
	porg win = new porg();
	Container win1 = win.getContentPane();       //初始化容器,使得便于添加控件 
	win.setTitle("小生的车站售票系统");                //函数设立标题
	win.setBounds(750,50,592,660);              //距左,距顶,窗口宽度,高度 
	win1.setBackground(Color.LIGHT_GRAY);        //窗口背景颜色
	}
}
